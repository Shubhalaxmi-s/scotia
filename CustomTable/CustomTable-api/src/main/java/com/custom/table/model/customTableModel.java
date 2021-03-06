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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the customTable service. Represents a row in the &quot;CT_customTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.custom.table.model.impl.customTableModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.custom.table.model.impl.customTableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customTable
 * @see com.custom.table.model.impl.customTableImpl
 * @see com.custom.table.model.impl.customTableModelImpl
 * @generated
 */
@ProviderType
public interface customTableModel extends BaseModel<customTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a custom table model instance should use the {@link customTable} interface instead.
	 */

	/**
	 * Returns the primary key of this custom table.
	 *
	 * @return the primary key of this custom table
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this custom table.
	 *
	 * @param primaryKey the primary key of this custom table
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this custom table.
	 *
	 * @return the uuid of this custom table
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this custom table.
	 *
	 * @param uuid the uuid of this custom table
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the custom table ID of this custom table.
	 *
	 * @return the custom table ID of this custom table
	 */
	public long getCustomTableId();

	/**
	 * Sets the custom table ID of this custom table.
	 *
	 * @param customTableId the custom table ID of this custom table
	 */
	public void setCustomTableId(long customTableId);

	/**
	 * Returns the data of this custom table.
	 *
	 * @return the data of this custom table
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this custom table.
	 *
	 * @param data the data of this custom table
	 */
	public void setData(String data);

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
	public int compareTo(com.custom.table.model.customTable customTable);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.custom.table.model.customTable> toCacheModel();

	@Override
	public com.custom.table.model.customTable toEscapedModel();

	@Override
	public com.custom.table.model.customTable toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}