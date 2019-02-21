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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing customTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see customTable
 * @generated
 */
@ProviderType
public class customTableCacheModel implements CacheModel<customTable>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof customTableCacheModel)) {
			return false;
		}

		customTableCacheModel customTableCacheModel = (customTableCacheModel)obj;

		if (customTableId == customTableCacheModel.customTableId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customTableId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", customTableId=");
		sb.append(customTableId);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public customTable toEntityModel() {
		customTableImpl customTableImpl = new customTableImpl();

		if (uuid == null) {
			customTableImpl.setUuid(StringPool.BLANK);
		}
		else {
			customTableImpl.setUuid(uuid);
		}

		customTableImpl.setCustomTableId(customTableId);

		if (data == null) {
			customTableImpl.setData(StringPool.BLANK);
		}
		else {
			customTableImpl.setData(data);
		}

		customTableImpl.resetOriginalValues();

		return customTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		customTableId = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(customTableId);

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public String uuid;
	public long customTableId;
	public String data;
}