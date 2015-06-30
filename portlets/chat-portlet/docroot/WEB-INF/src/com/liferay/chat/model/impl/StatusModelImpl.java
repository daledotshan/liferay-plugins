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

package com.liferay.chat.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.chat.model.Status;
import com.liferay.chat.model.StatusModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Status service. Represents a row in the &quot;Chat_Status&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StatusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatusImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatusImpl
 * @see Status
 * @see StatusModel
 * @generated
 */
@ProviderType
public class StatusModelImpl extends BaseModelImpl<Status>
	implements StatusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a status model instance should use the {@link Status} interface instead.
	 */
	public static final String TABLE_NAME = "Chat_Status";
	public static final Object[][] TABLE_COLUMNS = {
			{ "statusId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "modifiedDate", Types.BIGINT },
			{ "online_", Types.BOOLEAN },
			{ "awake", Types.BOOLEAN },
			{ "activePanelIds", Types.VARCHAR },
			{ "message", Types.VARCHAR },
			{ "playSound", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Chat_Status (statusId LONG not null primary key,userId LONG,modifiedDate LONG,online_ BOOLEAN,awake BOOLEAN,activePanelIds STRING null,message STRING null,playSound BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Chat_Status";
	public static final String ORDER_BY_JPQL = " ORDER BY status.statusId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Chat_Status.statusId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.chat.model.Status"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.chat.model.Status"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.chat.model.Status"),
			true);
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 1L;
	public static final long ONLINE_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long STATUSID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.chat.model.Status"));

	public StatusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Status.class;
	}

	@Override
	public String getModelClassName() {
		return Status.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statusId", getStatusId());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("online", getOnline());
		attributes.put("awake", getAwake());
		attributes.put("activePanelIds", getActivePanelIds());
		attributes.put("message", getMessage());
		attributes.put("playSound", getPlaySound());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long statusId = (Long)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean online = (Boolean)attributes.get("online");

		if (online != null) {
			setOnline(online);
		}

		Boolean awake = (Boolean)attributes.get("awake");

		if (awake != null) {
			setAwake(awake);
		}

		String activePanelIds = (String)attributes.get("activePanelIds");

		if (activePanelIds != null) {
			setActivePanelIds(activePanelIds);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean playSound = (Boolean)attributes.get("playSound");

		if (playSound != null) {
			setPlaySound(playSound);
		}
	}

	@Override
	public long getStatusId() {
		return _statusId;
	}

	@Override
	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(long modifiedDate) {
		_columnBitmask |= MODIFIEDDATE_COLUMN_BITMASK;

		if (!_setOriginalModifiedDate) {
			_setOriginalModifiedDate = true;

			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public long getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@Override
	public boolean getOnline() {
		return _online;
	}

	@Override
	public boolean isOnline() {
		return _online;
	}

	@Override
	public void setOnline(boolean online) {
		_columnBitmask |= ONLINE_COLUMN_BITMASK;

		if (!_setOriginalOnline) {
			_setOriginalOnline = true;

			_originalOnline = _online;
		}

		_online = online;
	}

	public boolean getOriginalOnline() {
		return _originalOnline;
	}

	@Override
	public boolean getAwake() {
		return _awake;
	}

	@Override
	public boolean isAwake() {
		return _awake;
	}

	@Override
	public void setAwake(boolean awake) {
		_awake = awake;
	}

	@Override
	public String getActivePanelIds() {
		if (_activePanelIds == null) {
			return StringPool.BLANK;
		}
		else {
			return _activePanelIds;
		}
	}

	@Override
	public void setActivePanelIds(String activePanelIds) {
		_activePanelIds = activePanelIds;
	}

	@Override
	public String getMessage() {
		if (_message == null) {
			return StringPool.BLANK;
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@Override
	public boolean getPlaySound() {
		return _playSound;
	}

	@Override
	public boolean isPlaySound() {
		return _playSound;
	}

	@Override
	public void setPlaySound(boolean playSound) {
		_playSound = playSound;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Status.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Status toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Status)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatusImpl statusImpl = new StatusImpl();

		statusImpl.setStatusId(getStatusId());
		statusImpl.setUserId(getUserId());
		statusImpl.setModifiedDate(getModifiedDate());
		statusImpl.setOnline(getOnline());
		statusImpl.setAwake(getAwake());
		statusImpl.setActivePanelIds(getActivePanelIds());
		statusImpl.setMessage(getMessage());
		statusImpl.setPlaySound(getPlaySound());

		statusImpl.resetOriginalValues();

		return statusImpl;
	}

	@Override
	public int compareTo(Status status) {
		long primaryKey = status.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Status)) {
			return false;
		}

		Status status = (Status)obj;

		long primaryKey = status.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		StatusModelImpl statusModelImpl = this;

		statusModelImpl._originalUserId = statusModelImpl._userId;

		statusModelImpl._setOriginalUserId = false;

		statusModelImpl._originalModifiedDate = statusModelImpl._modifiedDate;

		statusModelImpl._setOriginalModifiedDate = false;

		statusModelImpl._originalOnline = statusModelImpl._online;

		statusModelImpl._setOriginalOnline = false;

		statusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Status> toCacheModel() {
		StatusCacheModel statusCacheModel = new StatusCacheModel();

		statusCacheModel.statusId = getStatusId();

		statusCacheModel.userId = getUserId();

		statusCacheModel.modifiedDate = getModifiedDate();

		statusCacheModel.online = getOnline();

		statusCacheModel.awake = getAwake();

		statusCacheModel.activePanelIds = getActivePanelIds();

		String activePanelIds = statusCacheModel.activePanelIds;

		if ((activePanelIds != null) && (activePanelIds.length() == 0)) {
			statusCacheModel.activePanelIds = null;
		}

		statusCacheModel.message = getMessage();

		String message = statusCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			statusCacheModel.message = null;
		}

		statusCacheModel.playSound = getPlaySound();

		return statusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{statusId=");
		sb.append(getStatusId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", online=");
		sb.append(getOnline());
		sb.append(", awake=");
		sb.append(getAwake());
		sb.append(", activePanelIds=");
		sb.append(getActivePanelIds());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", playSound=");
		sb.append(getPlaySound());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.chat.model.Status");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>online</column-name><column-value><![CDATA[");
		sb.append(getOnline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>awake</column-name><column-value><![CDATA[");
		sb.append(getAwake());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activePanelIds</column-name><column-value><![CDATA[");
		sb.append(getActivePanelIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>playSound</column-name><column-value><![CDATA[");
		sb.append(getPlaySound());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Status.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Status.class
		};
	private long _statusId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _modifiedDate;
	private long _originalModifiedDate;
	private boolean _setOriginalModifiedDate;
	private boolean _online;
	private boolean _originalOnline;
	private boolean _setOriginalOnline;
	private boolean _awake;
	private String _activePanelIds;
	private String _message;
	private boolean _playSound;
	private long _columnBitmask;
	private Status _escapedModel;
}