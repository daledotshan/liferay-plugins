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

package com.liferay.mail.model.impl;

import com.liferay.mail.model.Message;
import com.liferay.mail.model.MessageModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Message service. Represents a row in the &quot;Mail_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.mail.model.MessageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageImpl
 * @see com.liferay.mail.model.Message
 * @see com.liferay.mail.model.MessageModel
 * @generated
 */
public class MessageModelImpl extends BaseModelImpl<Message>
	implements MessageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message model instance should use the {@link com.liferay.mail.model.Message} interface instead.
	 */
	public static final String TABLE_NAME = "Mail_Message";
	public static final Object[][] TABLE_COLUMNS = {
			{ "messageId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "accountId", Types.BIGINT },
			{ "folderId", Types.BIGINT },
			{ "sender", Types.VARCHAR },
			{ "to_", Types.CLOB },
			{ "cc", Types.CLOB },
			{ "bcc", Types.CLOB },
			{ "sentDate", Types.TIMESTAMP },
			{ "subject", Types.VARCHAR },
			{ "preview", Types.VARCHAR },
			{ "body", Types.CLOB },
			{ "flags", Types.VARCHAR },
			{ "size_", Types.BIGINT },
			{ "remoteMessageId", Types.BIGINT },
			{ "attachment", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Mail_Message (messageId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,accountId LONG,folderId LONG,sender STRING null,to_ TEXT null,cc TEXT null,bcc TEXT null,sentDate DATE null,subject STRING null,preview VARCHAR(75) null,body TEXT null,flags VARCHAR(75) null,size_ LONG,remoteMessageId LONG,attachment BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Mail_Message";
	public static final String ORDER_BY_JPQL = " ORDER BY message.sentDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Mail_Message.sentDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.mail.model.Message"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.mail.model.Message"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.mail.model.Message"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FOLDERID_COLUMN_BITMASK = 2L;
	public static long REMOTEMESSAGEID_COLUMN_BITMASK = 4L;
	public static long SENTDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.mail.model.Message"));

	public MessageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Message.class;
	}

	@Override
	public String getModelClassName() {
		return Message.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountId", getAccountId());
		attributes.put("folderId", getFolderId());
		attributes.put("sender", getSender());
		attributes.put("to", getTo());
		attributes.put("cc", getCc());
		attributes.put("bcc", getBcc());
		attributes.put("sentDate", getSentDate());
		attributes.put("subject", getSubject());
		attributes.put("preview", getPreview());
		attributes.put("body", getBody());
		attributes.put("flags", getFlags());
		attributes.put("size", getSize());
		attributes.put("remoteMessageId", getRemoteMessageId());
		attributes.put("attachment", getAttachment());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String to = (String)attributes.get("to");

		if (to != null) {
			setTo(to);
		}

		String cc = (String)attributes.get("cc");

		if (cc != null) {
			setCc(cc);
		}

		String bcc = (String)attributes.get("bcc");

		if (bcc != null) {
			setBcc(bcc);
		}

		Date sentDate = (Date)attributes.get("sentDate");

		if (sentDate != null) {
			setSentDate(sentDate);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String preview = (String)attributes.get("preview");

		if (preview != null) {
			setPreview(preview);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String flags = (String)attributes.get("flags");

		if (flags != null) {
			setFlags(flags);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Long remoteMessageId = (Long)attributes.get("remoteMessageId");

		if (remoteMessageId != null) {
			setRemoteMessageId(remoteMessageId);
		}

		Boolean attachment = (Boolean)attributes.get("attachment");

		if (attachment != null) {
			setAttachment(attachment);
		}
	}

	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	@Override
	public long getFolderId() {
		return _folderId;
	}

	@Override
	public void setFolderId(long folderId) {
		_columnBitmask |= FOLDERID_COLUMN_BITMASK;

		if (!_setOriginalFolderId) {
			_setOriginalFolderId = true;

			_originalFolderId = _folderId;
		}

		_folderId = folderId;
	}

	public long getOriginalFolderId() {
		return _originalFolderId;
	}

	@Override
	public String getSender() {
		if (_sender == null) {
			return StringPool.BLANK;
		}
		else {
			return _sender;
		}
	}

	@Override
	public void setSender(String sender) {
		_sender = sender;
	}

	@Override
	public String getTo() {
		if (_to == null) {
			return StringPool.BLANK;
		}
		else {
			return _to;
		}
	}

	@Override
	public void setTo(String to) {
		_to = to;
	}

	@Override
	public String getCc() {
		if (_cc == null) {
			return StringPool.BLANK;
		}
		else {
			return _cc;
		}
	}

	@Override
	public void setCc(String cc) {
		_cc = cc;
	}

	@Override
	public String getBcc() {
		if (_bcc == null) {
			return StringPool.BLANK;
		}
		else {
			return _bcc;
		}
	}

	@Override
	public void setBcc(String bcc) {
		_bcc = bcc;
	}

	@Override
	public Date getSentDate() {
		return _sentDate;
	}

	@Override
	public void setSentDate(Date sentDate) {
		_columnBitmask = -1L;

		_sentDate = sentDate;
	}

	@Override
	public String getSubject() {
		if (_subject == null) {
			return StringPool.BLANK;
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@Override
	public String getPreview() {
		if (_preview == null) {
			return StringPool.BLANK;
		}
		else {
			return _preview;
		}
	}

	@Override
	public void setPreview(String preview) {
		_preview = preview;
	}

	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@Override
	public String getFlags() {
		if (_flags == null) {
			return StringPool.BLANK;
		}
		else {
			return _flags;
		}
	}

	@Override
	public void setFlags(String flags) {
		_flags = flags;
	}

	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		_size = size;
	}

	@Override
	public long getRemoteMessageId() {
		return _remoteMessageId;
	}

	@Override
	public void setRemoteMessageId(long remoteMessageId) {
		_columnBitmask |= REMOTEMESSAGEID_COLUMN_BITMASK;

		if (!_setOriginalRemoteMessageId) {
			_setOriginalRemoteMessageId = true;

			_originalRemoteMessageId = _remoteMessageId;
		}

		_remoteMessageId = remoteMessageId;
	}

	public long getOriginalRemoteMessageId() {
		return _originalRemoteMessageId;
	}

	@Override
	public boolean getAttachment() {
		return _attachment;
	}

	@Override
	public boolean isAttachment() {
		return _attachment;
	}

	@Override
	public void setAttachment(boolean attachment) {
		_attachment = attachment;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Message.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Message toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Message)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MessageImpl messageImpl = new MessageImpl();

		messageImpl.setMessageId(getMessageId());
		messageImpl.setCompanyId(getCompanyId());
		messageImpl.setUserId(getUserId());
		messageImpl.setUserName(getUserName());
		messageImpl.setCreateDate(getCreateDate());
		messageImpl.setModifiedDate(getModifiedDate());
		messageImpl.setAccountId(getAccountId());
		messageImpl.setFolderId(getFolderId());
		messageImpl.setSender(getSender());
		messageImpl.setTo(getTo());
		messageImpl.setCc(getCc());
		messageImpl.setBcc(getBcc());
		messageImpl.setSentDate(getSentDate());
		messageImpl.setSubject(getSubject());
		messageImpl.setPreview(getPreview());
		messageImpl.setBody(getBody());
		messageImpl.setFlags(getFlags());
		messageImpl.setSize(getSize());
		messageImpl.setRemoteMessageId(getRemoteMessageId());
		messageImpl.setAttachment(getAttachment());

		messageImpl.resetOriginalValues();

		return messageImpl;
	}

	@Override
	public int compareTo(Message message) {
		int value = 0;

		value = DateUtil.compareTo(getSentDate(), message.getSentDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Message)) {
			return false;
		}

		Message message = (Message)obj;

		long primaryKey = message.getPrimaryKey();

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
		MessageModelImpl messageModelImpl = this;

		messageModelImpl._originalCompanyId = messageModelImpl._companyId;

		messageModelImpl._setOriginalCompanyId = false;

		messageModelImpl._originalFolderId = messageModelImpl._folderId;

		messageModelImpl._setOriginalFolderId = false;

		messageModelImpl._originalRemoteMessageId = messageModelImpl._remoteMessageId;

		messageModelImpl._setOriginalRemoteMessageId = false;

		messageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Message> toCacheModel() {
		MessageCacheModel messageCacheModel = new MessageCacheModel();

		messageCacheModel.messageId = getMessageId();

		messageCacheModel.companyId = getCompanyId();

		messageCacheModel.userId = getUserId();

		messageCacheModel.userName = getUserName();

		String userName = messageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			messageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			messageCacheModel.createDate = createDate.getTime();
		}
		else {
			messageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			messageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			messageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		messageCacheModel.accountId = getAccountId();

		messageCacheModel.folderId = getFolderId();

		messageCacheModel.sender = getSender();

		String sender = messageCacheModel.sender;

		if ((sender != null) && (sender.length() == 0)) {
			messageCacheModel.sender = null;
		}

		messageCacheModel.to = getTo();

		String to = messageCacheModel.to;

		if ((to != null) && (to.length() == 0)) {
			messageCacheModel.to = null;
		}

		messageCacheModel.cc = getCc();

		String cc = messageCacheModel.cc;

		if ((cc != null) && (cc.length() == 0)) {
			messageCacheModel.cc = null;
		}

		messageCacheModel.bcc = getBcc();

		String bcc = messageCacheModel.bcc;

		if ((bcc != null) && (bcc.length() == 0)) {
			messageCacheModel.bcc = null;
		}

		Date sentDate = getSentDate();

		if (sentDate != null) {
			messageCacheModel.sentDate = sentDate.getTime();
		}
		else {
			messageCacheModel.sentDate = Long.MIN_VALUE;
		}

		messageCacheModel.subject = getSubject();

		String subject = messageCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			messageCacheModel.subject = null;
		}

		messageCacheModel.preview = getPreview();

		String preview = messageCacheModel.preview;

		if ((preview != null) && (preview.length() == 0)) {
			messageCacheModel.preview = null;
		}

		messageCacheModel.body = getBody();

		String body = messageCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			messageCacheModel.body = null;
		}

		messageCacheModel.flags = getFlags();

		String flags = messageCacheModel.flags;

		if ((flags != null) && (flags.length() == 0)) {
			messageCacheModel.flags = null;
		}

		messageCacheModel.size = getSize();

		messageCacheModel.remoteMessageId = getRemoteMessageId();

		messageCacheModel.attachment = getAttachment();

		return messageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", sender=");
		sb.append(getSender());
		sb.append(", to=");
		sb.append(getTo());
		sb.append(", cc=");
		sb.append(getCc());
		sb.append(", bcc=");
		sb.append(getBcc());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", preview=");
		sb.append(getPreview());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", flags=");
		sb.append(getFlags());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", remoteMessageId=");
		sb.append(getRemoteMessageId());
		sb.append(", attachment=");
		sb.append(getAttachment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.liferay.mail.model.Message");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sender</column-name><column-value><![CDATA[");
		sb.append(getSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>to</column-name><column-value><![CDATA[");
		sb.append(getTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cc</column-name><column-value><![CDATA[");
		sb.append(getCc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bcc</column-name><column-value><![CDATA[");
		sb.append(getBcc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preview</column-name><column-value><![CDATA[");
		sb.append(getPreview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flags</column-name><column-value><![CDATA[");
		sb.append(getFlags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteMessageId</column-name><column-value><![CDATA[");
		sb.append(getRemoteMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachment</column-name><column-value><![CDATA[");
		sb.append(getAttachment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Message.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Message.class
		};
	private long _messageId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _accountId;
	private long _folderId;
	private long _originalFolderId;
	private boolean _setOriginalFolderId;
	private String _sender;
	private String _to;
	private String _cc;
	private String _bcc;
	private Date _sentDate;
	private String _subject;
	private String _preview;
	private String _body;
	private String _flags;
	private long _size;
	private long _remoteMessageId;
	private long _originalRemoteMessageId;
	private boolean _setOriginalRemoteMessageId;
	private boolean _attachment;
	private long _columnBitmask;
	private Message _escapedModel;
}