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

package com.liferay.commerce.tax.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the CommerceTaxMethod service. Represents a row in the &quot;CommerceTaxMethod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.tax.model.impl.CommerceTaxMethodModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.tax.model.impl.CommerceTaxMethodImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceTaxMethod
 * @see com.liferay.commerce.tax.model.impl.CommerceTaxMethodImpl
 * @see com.liferay.commerce.tax.model.impl.CommerceTaxMethodModelImpl
 * @generated
 */
@ProviderType
public interface CommerceTaxMethodModel extends BaseModel<CommerceTaxMethod>,
	GroupedModel, LocalizedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce tax method model instance should use the {@link CommerceTaxMethod} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce tax method.
	 *
	 * @return the primary key of this commerce tax method
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce tax method.
	 *
	 * @param primaryKey the primary key of this commerce tax method
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce tax method ID of this commerce tax method.
	 *
	 * @return the commerce tax method ID of this commerce tax method
	 */
	public long getCommerceTaxMethodId();

	/**
	 * Sets the commerce tax method ID of this commerce tax method.
	 *
	 * @param commerceTaxMethodId the commerce tax method ID of this commerce tax method
	 */
	public void setCommerceTaxMethodId(long commerceTaxMethodId);

	/**
	 * Returns the group ID of this commerce tax method.
	 *
	 * @return the group ID of this commerce tax method
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce tax method.
	 *
	 * @param groupId the group ID of this commerce tax method
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce tax method.
	 *
	 * @return the company ID of this commerce tax method
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce tax method.
	 *
	 * @param companyId the company ID of this commerce tax method
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce tax method.
	 *
	 * @return the user ID of this commerce tax method
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce tax method.
	 *
	 * @param userId the user ID of this commerce tax method
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce tax method.
	 *
	 * @return the user uuid of this commerce tax method
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce tax method.
	 *
	 * @param userUuid the user uuid of this commerce tax method
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce tax method.
	 *
	 * @return the user name of this commerce tax method
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce tax method.
	 *
	 * @param userName the user name of this commerce tax method
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce tax method.
	 *
	 * @return the create date of this commerce tax method
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce tax method.
	 *
	 * @param createDate the create date of this commerce tax method
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce tax method.
	 *
	 * @return the modified date of this commerce tax method
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce tax method.
	 *
	 * @param modifiedDate the modified date of this commerce tax method
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this commerce tax method.
	 *
	 * @return the name of this commerce tax method
	 */
	public String getName();

	/**
	 * Returns the localized name of this commerce tax method in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this commerce tax method
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this commerce tax method in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this commerce tax method. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this commerce tax method in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this commerce tax method
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this commerce tax method in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this commerce tax method
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this commerce tax method.
	 *
	 * @return the locales and localized names of this commerce tax method
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this commerce tax method.
	 *
	 * @param name the name of this commerce tax method
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this commerce tax method in the language.
	 *
	 * @param name the localized name of this commerce tax method
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this commerce tax method in the language, and sets the default locale.
	 *
	 * @param name the localized name of this commerce tax method
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this commerce tax method from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this commerce tax method
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this commerce tax method from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this commerce tax method
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this commerce tax method.
	 *
	 * @return the description of this commerce tax method
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this commerce tax method in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this commerce tax method
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this commerce tax method in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this commerce tax method. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this commerce tax method in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this commerce tax method
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this commerce tax method in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this commerce tax method
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this commerce tax method.
	 *
	 * @return the locales and localized descriptions of this commerce tax method
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this commerce tax method.
	 *
	 * @param description the description of this commerce tax method
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this commerce tax method in the language.
	 *
	 * @param description the localized description of this commerce tax method
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this commerce tax method in the language, and sets the default locale.
	 *
	 * @param description the localized description of this commerce tax method
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this commerce tax method from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this commerce tax method
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this commerce tax method from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this commerce tax method
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the engine key of this commerce tax method.
	 *
	 * @return the engine key of this commerce tax method
	 */
	@AutoEscape
	public String getEngineKey();

	/**
	 * Sets the engine key of this commerce tax method.
	 *
	 * @param engineKey the engine key of this commerce tax method
	 */
	public void setEngineKey(String engineKey);

	/**
	 * Returns the percentage of this commerce tax method.
	 *
	 * @return the percentage of this commerce tax method
	 */
	public boolean getPercentage();

	/**
	 * Returns <code>true</code> if this commerce tax method is percentage.
	 *
	 * @return <code>true</code> if this commerce tax method is percentage; <code>false</code> otherwise
	 */
	public boolean isPercentage();

	/**
	 * Sets whether this commerce tax method is percentage.
	 *
	 * @param percentage the percentage of this commerce tax method
	 */
	public void setPercentage(boolean percentage);

	/**
	 * Returns the active of this commerce tax method.
	 *
	 * @return the active of this commerce tax method
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this commerce tax method is active.
	 *
	 * @return <code>true</code> if this commerce tax method is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this commerce tax method is active.
	 *
	 * @param active the active of this commerce tax method
	 */
	public void setActive(boolean active);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceTaxMethod commerceTaxMethod);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceTaxMethod> toCacheModel();

	@Override
	public CommerceTaxMethod toEscapedModel();

	@Override
	public CommerceTaxMethod toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}