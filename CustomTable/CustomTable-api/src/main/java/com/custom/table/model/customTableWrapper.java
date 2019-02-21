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

package com.custom.table.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link customTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customTable
 * @generated
 */
@ProviderType
public class customTableWrapper implements customTable,
	ModelWrapper<customTable> {
	public customTableWrapper(customTable customTable) {
		_customTable = customTable;
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
	public boolean isCachedModel() {
		return _customTable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _customTable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _customTable.isNew();
	}

	@Override
	public com.custom.table.model.customTable toEscapedModel() {
		return new customTableWrapper(_customTable.toEscapedModel());
	}

	@Override
	public com.custom.table.model.customTable toUnescapedModel() {
		return new customTableWrapper(_customTable.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _customTable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.custom.table.model.customTable> toCacheModel() {
		return _customTable.toCacheModel();
	}

	@Override
	public int compareTo(com.custom.table.model.customTable customTable) {
		return _customTable.compareTo(customTable);
	}

	@Override
	public int hashCode() {
		return _customTable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customTable.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new customTableWrapper((customTable)_customTable.clone());
	}

	/**
	* Returns the data of this custom table.
	*
	* @return the data of this custom table
	*/
	@Override
	public java.lang.String getData() {
		return _customTable.getData();
	}

	/**
	* Returns the uuid of this custom table.
	*
	* @return the uuid of this custom table
	*/
	@Override
	public java.lang.String getUuid() {
		return _customTable.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _customTable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customTable.toXmlString();
	}

	/**
	* Returns the custom table ID of this custom table.
	*
	* @return the custom table ID of this custom table
	*/
	@Override
	public long getCustomTableId() {
		return _customTable.getCustomTableId();
	}

	/**
	* Returns the primary key of this custom table.
	*
	* @return the primary key of this custom table
	*/
	@Override
	public long getPrimaryKey() {
		return _customTable.getPrimaryKey();
	}

	@Override
	public void persist() {
		_customTable.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customTable.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom table ID of this custom table.
	*
	* @param customTableId the custom table ID of this custom table
	*/
	@Override
	public void setCustomTableId(long customTableId) {
		_customTable.setCustomTableId(customTableId);
	}

	/**
	* Sets the data of this custom table.
	*
	* @param data the data of this custom table
	*/
	@Override
	public void setData(java.lang.String data) {
		_customTable.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_customTable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_customTable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_customTable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_customTable.setNew(n);
	}

	/**
	* Sets the primary key of this custom table.
	*
	* @param primaryKey the primary key of this custom table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customTable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_customTable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this custom table.
	*
	* @param uuid the uuid of this custom table
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_customTable.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof customTableWrapper)) {
			return false;
		}

		customTableWrapper customTableWrapper = (customTableWrapper)obj;

		if (Objects.equals(_customTable, customTableWrapper._customTable)) {
			return true;
		}

		return false;
	}

	@Override
	public customTable getWrappedModel() {
		return _customTable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _customTable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _customTable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_customTable.resetOriginalValues();
	}

	private final customTable _customTable;
}