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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the customTable service. Represents a row in the &quot;CT_customTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see customTableModel
 * @see com.custom.table.model.impl.customTableImpl
 * @see com.custom.table.model.impl.customTableModelImpl
 * @generated
 */
@ImplementationClassName("com.custom.table.model.impl.customTableImpl")
@ProviderType
public interface customTable extends customTableModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.custom.table.model.impl.customTableImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<customTable, Long> CUSTOM_TABLE_ID_ACCESSOR = new Accessor<customTable, Long>() {
			@Override
			public Long get(customTable customTable) {
				return customTable.getCustomTableId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<customTable> getTypeClass() {
				return customTable.class;
			}
		};
}