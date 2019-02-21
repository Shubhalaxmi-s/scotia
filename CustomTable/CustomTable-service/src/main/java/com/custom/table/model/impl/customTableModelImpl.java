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

package com.custom.table.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.custom.table.model.customTable;
import com.custom.table.model.customTableModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the customTable service. Represents a row in the &quot;CT_customTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link customTableModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link customTableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customTableImpl
 * @see customTable
 * @see customTableModel
 * @generated
 */
@ProviderType
public class customTableModelImpl extends BaseModelImpl<customTable>
	implements customTableModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a custom table model instance should use the {@link customTable} interface instead.
	 */
	public static final String TABLE_NAME = "CT_customTable";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "customTableId", Types.BIGINT },
			{ "data_", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customTableId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("data_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table CT_customTable (uuid_ VARCHAR(75) null,customTableId LONG not null primary key,data_ VARCHAR(1000) null)";
	public static final String TABLE_SQL_DROP = "drop table CT_customTable";
	public static final String ORDER_BY_JPQL = " ORDER BY customTable.customTableId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_customTable.customTableId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.custom.table.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.custom.table.model.customTable"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.custom.table.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.custom.table.model.customTable"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.custom.table.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.custom.table.model.customTable"),
			true);
	public static final long CUSTOMTABLEID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.custom.table.service.util.ServiceProps.get(
				"lock.expiration.time.com.custom.table.model.customTable"));

	public customTableModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _customTableId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomTableId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customTableId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return customTable.class;
	}

	@Override
	public String getModelClassName() {
		return customTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("customTableId", getCustomTableId());
		attributes.put("data", getData());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long customTableId = (Long)attributes.get("customTableId");

		if (customTableId != null) {
			setCustomTableId(customTableId);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getCustomTableId() {
		return _customTableId;
	}

	@Override
	public void setCustomTableId(long customTableId) {
		_columnBitmask = -1L;

		if (!_setOriginalCustomTableId) {
			_setOriginalCustomTableId = true;

			_originalCustomTableId = _customTableId;
		}

		_customTableId = customTableId;
	}

	public long getOriginalCustomTableId() {
		return _originalCustomTableId;
	}

	@Override
	public String getData() {
		if (_data == null) {
			return StringPool.BLANK;
		}
		else {
			return _data;
		}
	}

	@Override
	public void setData(String data) {
		_data = data;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			customTable.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public customTable toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (customTable)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		customTableImpl customTableImpl = new customTableImpl();

		customTableImpl.setUuid(getUuid());
		customTableImpl.setCustomTableId(getCustomTableId());
		customTableImpl.setData(getData());

		customTableImpl.resetOriginalValues();

		return customTableImpl;
	}

	@Override
	public int compareTo(customTable customTable) {
		int value = 0;

		if (getCustomTableId() < customTable.getCustomTableId()) {
			value = -1;
		}
		else if (getCustomTableId() > customTable.getCustomTableId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof customTable)) {
			return false;
		}

		customTable customTable = (customTable)obj;

		long primaryKey = customTable.getPrimaryKey();

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
		customTableModelImpl customTableModelImpl = this;

		customTableModelImpl._originalUuid = customTableModelImpl._uuid;

		customTableModelImpl._originalCustomTableId = customTableModelImpl._customTableId;

		customTableModelImpl._setOriginalCustomTableId = false;

		customTableModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<customTable> toCacheModel() {
		customTableCacheModel customTableCacheModel = new customTableCacheModel();

		customTableCacheModel.uuid = getUuid();

		String uuid = customTableCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			customTableCacheModel.uuid = null;
		}

		customTableCacheModel.customTableId = getCustomTableId();

		customTableCacheModel.data = getData();

		String data = customTableCacheModel.data;

		if ((data != null) && (data.length() == 0)) {
			customTableCacheModel.data = null;
		}

		return customTableCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", customTableId=");
		sb.append(getCustomTableId());
		sb.append(", data=");
		sb.append(getData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.custom.table.model.customTable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customTableId</column-name><column-value><![CDATA[");
		sb.append(getCustomTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = customTable.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			customTable.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _customTableId;
	private long _originalCustomTableId;
	private boolean _setOriginalCustomTableId;
	private String _data;
	private long _columnBitmask;
	private customTable _escapedModel;
}