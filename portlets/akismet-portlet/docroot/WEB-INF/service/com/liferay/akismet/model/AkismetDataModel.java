/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.akismet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AkismetData service. Represents a row in the &quot;Akismet_AkismetData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.akismet.model.impl.AkismetDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.akismet.model.impl.AkismetDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AkismetData
 * @see com.liferay.akismet.model.impl.AkismetDataImpl
 * @see com.liferay.akismet.model.impl.AkismetDataModelImpl
 * @generated
 */
public interface AkismetDataModel extends AttachedModel, BaseModel<AkismetData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a akismet data model instance should use the {@link AkismetData} interface instead.
	 */

	/**
	 * Returns the primary key of this akismet data.
	 *
	 * @return the primary key of this akismet data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this akismet data.
	 *
	 * @param primaryKey the primary key of this akismet data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the akismet data ID of this akismet data.
	 *
	 * @return the akismet data ID of this akismet data
	 */
	public long getAkismetDataId();

	/**
	 * Sets the akismet data ID of this akismet data.
	 *
	 * @param akismetDataId the akismet data ID of this akismet data
	 */
	public void setAkismetDataId(long akismetDataId);

	/**
	 * Returns the modified date of this akismet data.
	 *
	 * @return the modified date of this akismet data
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this akismet data.
	 *
	 * @param modifiedDate the modified date of this akismet data
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this akismet data.
	 *
	 * @return the fully qualified class name of this akismet data
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this akismet data.
	 *
	 * @return the class name ID of this akismet data
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this akismet data.
	 *
	 * @param classNameId the class name ID of this akismet data
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this akismet data.
	 *
	 * @return the class p k of this akismet data
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this akismet data.
	 *
	 * @param classPK the class p k of this akismet data
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the type of this akismet data.
	 *
	 * @return the type of this akismet data
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this akismet data.
	 *
	 * @param type the type of this akismet data
	 */
	public void setType(String type);

	/**
	 * Returns the permalink of this akismet data.
	 *
	 * @return the permalink of this akismet data
	 */
	@AutoEscape
	public String getPermalink();

	/**
	 * Sets the permalink of this akismet data.
	 *
	 * @param permalink the permalink of this akismet data
	 */
	public void setPermalink(String permalink);

	/**
	 * Returns the referrer of this akismet data.
	 *
	 * @return the referrer of this akismet data
	 */
	@AutoEscape
	public String getReferrer();

	/**
	 * Sets the referrer of this akismet data.
	 *
	 * @param referrer the referrer of this akismet data
	 */
	public void setReferrer(String referrer);

	/**
	 * Returns the user agent of this akismet data.
	 *
	 * @return the user agent of this akismet data
	 */
	@AutoEscape
	public String getUserAgent();

	/**
	 * Sets the user agent of this akismet data.
	 *
	 * @param userAgent the user agent of this akismet data
	 */
	public void setUserAgent(String userAgent);

	/**
	 * Returns the user i p of this akismet data.
	 *
	 * @return the user i p of this akismet data
	 */
	@AutoEscape
	public String getUserIP();

	/**
	 * Sets the user i p of this akismet data.
	 *
	 * @param userIP the user i p of this akismet data
	 */
	public void setUserIP(String userIP);

	/**
	 * Returns the user u r l of this akismet data.
	 *
	 * @return the user u r l of this akismet data
	 */
	@AutoEscape
	public String getUserURL();

	/**
	 * Sets the user u r l of this akismet data.
	 *
	 * @param userURL the user u r l of this akismet data
	 */
	public void setUserURL(String userURL);

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
	public int compareTo(AkismetData akismetData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AkismetData> toCacheModel();

	@Override
	public AkismetData toEscapedModel();

	@Override
	public AkismetData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}