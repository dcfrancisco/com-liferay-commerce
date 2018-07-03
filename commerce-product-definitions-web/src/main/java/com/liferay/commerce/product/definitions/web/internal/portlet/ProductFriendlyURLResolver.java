/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.definitions.web.internal.portlet;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetTagLocalService;
import com.liferay.commerce.organization.util.CommerceOrganizationHelper;
import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.constants.CPConstants;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.constants.CPWebKeys;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPFriendlyURLEntry;
import com.liferay.commerce.product.model.CPRule;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CPFriendlyURLEntryLocalService;
import com.liferay.commerce.product.service.CPRuleLocalService;
import com.liferay.commerce.product.util.CPDefinitionHelper;
import com.liferay.commerce.product.util.CPRulesThreadLocal;
import com.liferay.commerce.user.segment.util.CommerceUserSegmentHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutFriendlyURLComposite;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.FriendlyURLResolver;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.InheritableMap;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(service = FriendlyURLResolver.class)
public class ProductFriendlyURLResolver implements FriendlyURLResolver {

	@Override
	public String getActualURL(
			long companyId, long groupId, boolean privateLayout,
			String mainPath, String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException {

		HttpServletRequest httpServletRequest =
			(HttpServletRequest)requestContext.get("request");

		Locale locale = _portal.getLocale(httpServletRequest);

		String languageId = LanguageUtil.getLanguageId(locale);

		String urlTitle = friendlyURL.substring(
			CPConstants.SEPARATOR_PRODUCT_URL.length());

		long classNameId = _portal.getClassNameId(CPDefinition.class);

		CPFriendlyURLEntry cpFriendlyURLEntry =
			_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
				groupId, classNameId, languageId, urlTitle);

		if (cpFriendlyURLEntry == null) {
			Locale siteDefaultLocale = _portal.getSiteDefaultLocale(groupId);

			String siteDefaultLanguageId = LanguageUtil.getLanguageId(
				siteDefaultLocale);

			cpFriendlyURLEntry =
				_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
					groupId, classNameId, siteDefaultLanguageId, urlTitle);
		}

		if (cpFriendlyURLEntry == null) {
			return null;
		}

		if (!cpFriendlyURLEntry.isMain()) {
			cpFriendlyURLEntry =
				_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
					groupId, classNameId, cpFriendlyURLEntry.getPrimaryKey(),
					languageId, true);
		}

		_initCPRulesThreadLocal(groupId, httpServletRequest);

		CPCatalogEntry cpCatalogEntry = _cpDefinitionHelper.getCPCatalogEntry(
			cpFriendlyURLEntry.getClassPK(), locale);

		Layout layout = getProductLayout(
			groupId, privateLayout, cpCatalogEntry.getCPDefinitionId());

		String layoutActualURL = _portal.getLayoutActualURL(layout, mainPath);

		InheritableMap<String, String[]> actualParams = new InheritableMap<>();

		if (params != null) {
			actualParams.setParentMap(params);
		}

		actualParams.put("p_p_lifecycle", new String[] {"0"});
		actualParams.put("p_p_mode", new String[] {"view"});

		httpServletRequest.setAttribute(
			CPWebKeys.CP_CATALOG_ENTRY, cpCatalogEntry);

		String queryString = _http.parameterMapToString(actualParams, false);

		if (layoutActualURL.contains(StringPool.QUESTION)) {
			layoutActualURL =
				layoutActualURL + StringPool.AMPERSAND + queryString;
		}
		else {
			layoutActualURL =
				layoutActualURL + StringPool.QUESTION + queryString;
		}

		String description = cpCatalogEntry.getMetaDescription(languageId);

		if (Validator.isNull(description)) {
			description = cpCatalogEntry.getShortDescription();
		}

		if (Validator.isNotNull(description)) {
			_portal.addPageDescription(description, httpServletRequest);
		}

		String keywords = cpCatalogEntry.getMetaKeywords(languageId);

		if (Validator.isNull(keywords)) {
			List<AssetTag> assetTags = _assetTagLocalService.getTags(
				CPDefinition.class.getName(),
				cpCatalogEntry.getCPDefinitionId());

			if (ListUtil.isNotEmpty(assetTags)) {
				keywords = ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR);
			}
		}

		if (Validator.isNotNull(keywords)) {
			_portal.addPageKeywords(keywords, httpServletRequest);
		}

		String subtitle = cpCatalogEntry.getMetaTitle(languageId);

		if (Validator.isNull(subtitle)) {
			subtitle = cpCatalogEntry.getName();
		}

		_portal.addPageSubtitle(subtitle, httpServletRequest);

		return layoutActualURL;
	}

	@Override
	public LayoutFriendlyURLComposite getLayoutFriendlyURLComposite(
			long companyId, long groupId, boolean privateLayout,
			String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException {

		HttpServletRequest httpServletRequest =
			(HttpServletRequest)requestContext.get("request");

		Locale locale = _portal.getLocale(httpServletRequest);

		String languageId = LanguageUtil.getLanguageId(locale);

		String urlTitle = friendlyURL.substring(
			CPConstants.SEPARATOR_PRODUCT_URL.length());
		long classNameId = _portal.getClassNameId(CPDefinition.class);

		CPFriendlyURLEntry cpFriendlyURLEntry =
			_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
				groupId, classNameId, languageId, urlTitle);

		if (cpFriendlyURLEntry == null) {
			Locale siteDefaultLocale = _portal.getSiteDefaultLocale(groupId);

			String siteDefaultLanguageId = LanguageUtil.getLanguageId(
				siteDefaultLocale);

			cpFriendlyURLEntry =
				_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
					groupId, classNameId, siteDefaultLanguageId, urlTitle);
		}

		if (cpFriendlyURLEntry == null) {
			return null;
		}

		if (!cpFriendlyURLEntry.isMain()) {
			cpFriendlyURLEntry =
				_cpFriendlyURLEntryLocalService.fetchCPFriendlyURLEntry(
					groupId, classNameId, cpFriendlyURLEntry.getClassPK(),
					languageId, true);
		}

		_initCPRulesThreadLocal(groupId, httpServletRequest);

		Layout layout = getProductLayout(
			groupId, privateLayout, cpFriendlyURLEntry.getClassPK());

		return new LayoutFriendlyURLComposite(
			layout, getURLSeparator() + cpFriendlyURLEntry.getUrlTitle());
	}

	@Override
	public String getURLSeparator() {
		return CPConstants.SEPARATOR_PRODUCT_URL;
	}

	protected Layout getProductLayout(
			long groupId, boolean privateLayout, long cpDefinitionId)
		throws PortalException {

		String layoutUuid = _cpDefinitionService.getLayoutUuid(cpDefinitionId);

		if (Validator.isNotNull(layoutUuid)) {
			return _layoutLocalService.getLayoutByUuidAndGroupId(
				layoutUuid, groupId, privateLayout);
		}

		long plid = _portal.getPlidFromPortletId(
			groupId, privateLayout, CPPortletKeys.CP_CONTENT_WEB);

		return _layoutLocalService.getLayout(plid);
	}

	private void _initCPRulesThreadLocal(
			long groupId, HttpServletRequest httpServletRequest)
		throws PortalException {

		if (ListUtil.isNotEmpty(CPRulesThreadLocal.getCPRules())) {
			return;
		}

		User user = _portal.getUser(httpServletRequest);

		if (user == null) {
			user = _userLocalService.getDefaultUser(
				_portal.getCompanyId(httpServletRequest));
		}

		Organization organization =
			_commerceOrganizationHelper.getCurrentOrganization(
				httpServletRequest);

		long organizationId = 0;

		if (organization != null) {
			organizationId = organization.getOrganizationId();
		}

		long[] commerceUserSegmentEntryIds =
			_commerceUserSegmentHelper.getCommerceUserSegmentIds(
				groupId, organizationId, user.getUserId());

		List<CPRule> cpRules = _cpRuleLocalService.getCPRules(
			groupId, commerceUserSegmentEntryIds);

		CPRulesThreadLocal.setCPRules(cpRules);
	}

	@Reference
	private AssetTagLocalService _assetTagLocalService;

	@Reference
	private CommerceOrganizationHelper _commerceOrganizationHelper;

	@Reference
	private CommerceUserSegmentHelper _commerceUserSegmentHelper;

	@Reference
	private CPDefinitionHelper _cpDefinitionHelper;

	@Reference
	private CPDefinitionService _cpDefinitionService;

	@Reference
	private CPFriendlyURLEntryLocalService _cpFriendlyURLEntryLocalService;

	@Reference
	private CPRuleLocalService _cpRuleLocalService;

	@Reference
	private Http _http;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}