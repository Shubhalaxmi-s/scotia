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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class customTableSoap implements Serializable {
	public static customTableSoap toSoapModel(customTable model) {
		customTableSoap soapModel = new customTableSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCustomTableId(model.getCustomTableId());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static customTableSoap[] toSoapModels(customTable[] models) {
		customTableSoap[] soapModels = new customTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static customTableSoap[][] toSoapModels(customTable[][] models) {
		customTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new customTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new customTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static customTableSoap[] toSoapModels(List<customTable> models) {
		List<customTableSoap> soapModels = new ArrayList<customTableSoap>(models.size());

		for (customTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new customTableSoap[soapModels.size()]);
	}

	public customTableSoap() {
	}

	public long getPrimaryKey() {
		return _customTableId;
	}

	public void setPrimaryKey(long pk) {
		setCustomTableId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCustomTableId() {
		return _customTableId;
	}

	public void setCustomTableId(long customTableId) {
		_customTableId = customTableId;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private String _uuid;
	private long _customTableId;
	private String _data;
}