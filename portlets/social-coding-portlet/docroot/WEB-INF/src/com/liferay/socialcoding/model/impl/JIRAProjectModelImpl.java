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

package com.liferay.socialcoding.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.socialcoding.model.JIRAProject;
import com.liferay.socialcoding.model.JIRAProjectModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JIRAProject service. Represents a row in the &quot;project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.socialcoding.model.JIRAProjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JIRAProjectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JIRAProjectImpl
 * @see com.liferay.socialcoding.model.JIRAProject
 * @see com.liferay.socialcoding.model.JIRAProjectModel
 * @generated
 */
@ProviderType
public class JIRAProjectModelImpl extends BaseModelImpl<JIRAProject>
	implements JIRAProjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a j i r a project model instance should use the {@link com.liferay.socialcoding.model.JIRAProject} interface instead.
	 */
	public static final String TABLE_NAME = "project";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "pkey", Types.VARCHAR },
			{ "pname", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table project (id LONG not null primary key,pkey VARCHAR(75) null,pname VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table project";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraProject.jiraProjectId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY project.id ASC";
	public static final String DATA_SOURCE = "jiraDataSource";
	public static final String SESSION_FACTORY = "jiraSessionFactory";
	public static final String TX_MANAGER = "jiraTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.socialcoding.model.JIRAProject"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.socialcoding.model.JIRAProject"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.socialcoding.model.JIRAProject"),
			true);
	public static final long KEY_COLUMN_BITMASK = 1L;
	public static final long JIRAPROJECTID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.socialcoding.model.JIRAProject"));

	public JIRAProjectModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jiraProjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraProjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JIRAProject.class;
	}

	@Override
	public String getModelClassName() {
		return JIRAProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("key", getKey());
		attributes.put("name", getName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_jiraProjectId = jiraProjectId;
	}

	@Override
	public String getKey() {
		if (_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JIRAProject.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JIRAProject toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JIRAProject)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JIRAProjectImpl jiraProjectImpl = new JIRAProjectImpl();

		jiraProjectImpl.setJiraProjectId(getJiraProjectId());
		jiraProjectImpl.setKey(getKey());
		jiraProjectImpl.setName(getName());

		jiraProjectImpl.resetOriginalValues();

		return jiraProjectImpl;
	}

	@Override
	public int compareTo(JIRAProject jiraProject) {
		long primaryKey = jiraProject.getPrimaryKey();

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

		if (!(obj instanceof JIRAProject)) {
			return false;
		}

		JIRAProject jiraProject = (JIRAProject)obj;

		long primaryKey = jiraProject.getPrimaryKey();

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
		JIRAProjectModelImpl jiraProjectModelImpl = this;

		jiraProjectModelImpl._originalKey = jiraProjectModelImpl._key;

		jiraProjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JIRAProject> toCacheModel() {
		JIRAProjectCacheModel jiraProjectCacheModel = new JIRAProjectCacheModel();

		jiraProjectCacheModel.jiraProjectId = getJiraProjectId();

		jiraProjectCacheModel.key = getKey();

		String key = jiraProjectCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			jiraProjectCacheModel.key = null;
		}

		jiraProjectCacheModel.name = getName();

		String name = jiraProjectCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			jiraProjectCacheModel.name = null;
		}

		return jiraProjectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{jiraProjectId=");
		sb.append(getJiraProjectId());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.socialcoding.model.JIRAProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraProjectId</column-name><column-value><![CDATA[");
		sb.append(getJiraProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JIRAProject.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JIRAProject.class
		};
	private long _jiraProjectId;
	private String _key;
	private String _originalKey;
	private String _name;
	private long _columnBitmask;
	private JIRAProject _escapedModel;
}