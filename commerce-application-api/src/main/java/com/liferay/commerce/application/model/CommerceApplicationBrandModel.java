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

package com.liferay.commerce.application.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceApplicationBrand service. Represents a row in the &quot;CommerceApplicationBrand&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.application.model.impl.CommerceApplicationBrandModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.application.model.impl.CommerceApplicationBrandImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceApplicationBrand
 * @see com.liferay.commerce.application.model.impl.CommerceApplicationBrandImpl
 * @see com.liferay.commerce.application.model.impl.CommerceApplicationBrandModelImpl
 * @generated
 */
@ProviderType
public interface CommerceApplicationBrandModel extends AuditedModel,
	BaseModel<CommerceApplicationBrand>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce application brand model instance should use the {@link CommerceApplicationBrand} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce application brand.
	 *
	 * @return the primary key of this commerce application brand
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce application brand.
	 *
	 * @param primaryKey the primary key of this commerce application brand
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce application brand ID of this commerce application brand.
	 *
	 * @return the commerce application brand ID of this commerce application brand
	 */
	public long getCommerceApplicationBrandId();

	/**
	 * Sets the commerce application brand ID of this commerce application brand.
	 *
	 * @param commerceApplicationBrandId the commerce application brand ID of this commerce application brand
	 */
	public void setCommerceApplicationBrandId(long commerceApplicationBrandId);

	/**
	 * Returns the company ID of this commerce application brand.
	 *
	 * @return the company ID of this commerce application brand
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce application brand.
	 *
	 * @param companyId the company ID of this commerce application brand
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce application brand.
	 *
	 * @return the user ID of this commerce application brand
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce application brand.
	 *
	 * @param userId the user ID of this commerce application brand
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce application brand.
	 *
	 * @return the user uuid of this commerce application brand
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce application brand.
	 *
	 * @param userUuid the user uuid of this commerce application brand
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce application brand.
	 *
	 * @return the user name of this commerce application brand
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce application brand.
	 *
	 * @param userName the user name of this commerce application brand
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce application brand.
	 *
	 * @return the create date of this commerce application brand
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce application brand.
	 *
	 * @param createDate the create date of this commerce application brand
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce application brand.
	 *
	 * @return the modified date of this commerce application brand
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce application brand.
	 *
	 * @param modifiedDate the modified date of this commerce application brand
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this commerce application brand.
	 *
	 * @return the name of this commerce application brand
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this commerce application brand.
	 *
	 * @param name the name of this commerce application brand
	 */
	public void setName(String name);

	/**
	 * Returns the logo ID of this commerce application brand.
	 *
	 * @return the logo ID of this commerce application brand
	 */
	public long getLogoId();

	/**
	 * Sets the logo ID of this commerce application brand.
	 *
	 * @param logoId the logo ID of this commerce application brand
	 */
	public void setLogoId(long logoId);

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
	public Object clone();

	@Override
	public int compareTo(CommerceApplicationBrand commerceApplicationBrand);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceApplicationBrand> toCacheModel();

	@Override
	public CommerceApplicationBrand toEscapedModel();

	@Override
	public CommerceApplicationBrand toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}