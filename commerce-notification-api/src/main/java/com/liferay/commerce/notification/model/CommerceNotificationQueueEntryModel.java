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

package com.liferay.commerce.notification.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceNotificationQueueEntry service. Represents a row in the &quot;CommerceNotificationQueueEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceNotificationQueueEntry
 * @see com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryImpl
 * @see com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryModelImpl
 * @generated
 */
@ProviderType
public interface CommerceNotificationQueueEntryModel extends BaseModel<CommerceNotificationQueueEntry>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce notification queue entry model instance should use the {@link CommerceNotificationQueueEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce notification queue entry.
	 *
	 * @return the primary key of this commerce notification queue entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce notification queue entry.
	 *
	 * @param primaryKey the primary key of this commerce notification queue entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce notification queue entry ID of this commerce notification queue entry.
	 *
	 * @return the commerce notification queue entry ID of this commerce notification queue entry
	 */
	public long getCommerceNotificationQueueEntryId();

	/**
	 * Sets the commerce notification queue entry ID of this commerce notification queue entry.
	 *
	 * @param commerceNotificationQueueEntryId the commerce notification queue entry ID of this commerce notification queue entry
	 */
	public void setCommerceNotificationQueueEntryId(
		long commerceNotificationQueueEntryId);

	/**
	 * Returns the group ID of this commerce notification queue entry.
	 *
	 * @return the group ID of this commerce notification queue entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce notification queue entry.
	 *
	 * @param groupId the group ID of this commerce notification queue entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce notification queue entry.
	 *
	 * @return the company ID of this commerce notification queue entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce notification queue entry.
	 *
	 * @param companyId the company ID of this commerce notification queue entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce notification queue entry.
	 *
	 * @return the user ID of this commerce notification queue entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce notification queue entry.
	 *
	 * @param userId the user ID of this commerce notification queue entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce notification queue entry.
	 *
	 * @return the user uuid of this commerce notification queue entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce notification queue entry.
	 *
	 * @param userUuid the user uuid of this commerce notification queue entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce notification queue entry.
	 *
	 * @return the user name of this commerce notification queue entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce notification queue entry.
	 *
	 * @param userName the user name of this commerce notification queue entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce notification queue entry.
	 *
	 * @return the create date of this commerce notification queue entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce notification queue entry.
	 *
	 * @param createDate the create date of this commerce notification queue entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce notification queue entry.
	 *
	 * @return the modified date of this commerce notification queue entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce notification queue entry.
	 *
	 * @param modifiedDate the modified date of this commerce notification queue entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce notification template ID of this commerce notification queue entry.
	 *
	 * @return the commerce notification template ID of this commerce notification queue entry
	 */
	public long getCommerceNotificationTemplateId();

	/**
	 * Sets the commerce notification template ID of this commerce notification queue entry.
	 *
	 * @param commerceNotificationTemplateId the commerce notification template ID of this commerce notification queue entry
	 */
	public void setCommerceNotificationTemplateId(
		long commerceNotificationTemplateId);

	/**
	 * Returns the from of this commerce notification queue entry.
	 *
	 * @return the from of this commerce notification queue entry
	 */
	@AutoEscape
	public String getFrom();

	/**
	 * Sets the from of this commerce notification queue entry.
	 *
	 * @param from the from of this commerce notification queue entry
	 */
	public void setFrom(String from);

	/**
	 * Returns the from name of this commerce notification queue entry.
	 *
	 * @return the from name of this commerce notification queue entry
	 */
	@AutoEscape
	public String getFromName();

	/**
	 * Sets the from name of this commerce notification queue entry.
	 *
	 * @param fromName the from name of this commerce notification queue entry
	 */
	public void setFromName(String fromName);

	/**
	 * Returns the to of this commerce notification queue entry.
	 *
	 * @return the to of this commerce notification queue entry
	 */
	@AutoEscape
	public String getTo();

	/**
	 * Sets the to of this commerce notification queue entry.
	 *
	 * @param to the to of this commerce notification queue entry
	 */
	public void setTo(String to);

	/**
	 * Returns the to name of this commerce notification queue entry.
	 *
	 * @return the to name of this commerce notification queue entry
	 */
	@AutoEscape
	public String getToName();

	/**
	 * Sets the to name of this commerce notification queue entry.
	 *
	 * @param toName the to name of this commerce notification queue entry
	 */
	public void setToName(String toName);

	/**
	 * Returns the cc of this commerce notification queue entry.
	 *
	 * @return the cc of this commerce notification queue entry
	 */
	@AutoEscape
	public String getCc();

	/**
	 * Sets the cc of this commerce notification queue entry.
	 *
	 * @param cc the cc of this commerce notification queue entry
	 */
	public void setCc(String cc);

	/**
	 * Returns the bcc of this commerce notification queue entry.
	 *
	 * @return the bcc of this commerce notification queue entry
	 */
	@AutoEscape
	public String getBcc();

	/**
	 * Sets the bcc of this commerce notification queue entry.
	 *
	 * @param bcc the bcc of this commerce notification queue entry
	 */
	public void setBcc(String bcc);

	/**
	 * Returns the subject of this commerce notification queue entry.
	 *
	 * @return the subject of this commerce notification queue entry
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this commerce notification queue entry.
	 *
	 * @param subject the subject of this commerce notification queue entry
	 */
	public void setSubject(String subject);

	/**
	 * Returns the body of this commerce notification queue entry.
	 *
	 * @return the body of this commerce notification queue entry
	 */
	@AutoEscape
	public String getBody();

	/**
	 * Sets the body of this commerce notification queue entry.
	 *
	 * @param body the body of this commerce notification queue entry
	 */
	public void setBody(String body);

	/**
	 * Returns the priority of this commerce notification queue entry.
	 *
	 * @return the priority of this commerce notification queue entry
	 */
	public double getPriority();

	/**
	 * Sets the priority of this commerce notification queue entry.
	 *
	 * @param priority the priority of this commerce notification queue entry
	 */
	public void setPriority(double priority);

	/**
	 * Returns the sent of this commerce notification queue entry.
	 *
	 * @return the sent of this commerce notification queue entry
	 */
	public boolean getSent();

	/**
	 * Returns <code>true</code> if this commerce notification queue entry is sent.
	 *
	 * @return <code>true</code> if this commerce notification queue entry is sent; <code>false</code> otherwise
	 */
	public boolean isSent();

	/**
	 * Sets whether this commerce notification queue entry is sent.
	 *
	 * @param sent the sent of this commerce notification queue entry
	 */
	public void setSent(boolean sent);

	/**
	 * Returns the sent date of this commerce notification queue entry.
	 *
	 * @return the sent date of this commerce notification queue entry
	 */
	public Date getSentDate();

	/**
	 * Sets the sent date of this commerce notification queue entry.
	 *
	 * @param sentDate the sent date of this commerce notification queue entry
	 */
	public void setSentDate(Date sentDate);

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
	public int compareTo(
		CommerceNotificationQueueEntry commerceNotificationQueueEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceNotificationQueueEntry> toCacheModel();

	@Override
	public CommerceNotificationQueueEntry toEscapedModel();

	@Override
	public CommerceNotificationQueueEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}