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

package com.custom.table.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.custom.table.exception.NoSuchcustomTableException;
import com.custom.table.model.customTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.custom.table.service.persistence.impl.customTablePersistenceImpl
 * @see customTableUtil
 * @generated
 */
@ProviderType
public interface customTablePersistence extends BasePersistence<customTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link customTableUtil} to access the custom table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the custom tables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching custom tables
	*/
	public java.util.List<customTable> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the custom tables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @return the range of matching custom tables
	*/
	public java.util.List<customTable> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the custom tables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching custom tables
	*/
	public java.util.List<customTable> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns an ordered range of all the custom tables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching custom tables
	*/
	public java.util.List<customTable> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public customTable findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException;

	/**
	* Returns the first custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public customTable fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns the last custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public customTable findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException;

	/**
	* Returns the last custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public customTable fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns the custom tables before and after the current custom table in the ordered set where uuid = &#63;.
	*
	* @param customTableId the primary key of the current custom table
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next custom table
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public customTable[] findByUuid_PrevAndNext(long customTableId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException;

	/**
	* Removes all the custom tables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of custom tables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching custom tables
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the custom tables where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @return the matching custom tables
	*/
	public java.util.List<customTable> findBycustomTableId(long customTableId);

	/**
	* Returns a range of all the custom tables where customTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customTableId the custom table ID
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @return the range of matching custom tables
	*/
	public java.util.List<customTable> findBycustomTableId(long customTableId,
		int start, int end);

	/**
	* Returns an ordered range of all the custom tables where customTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customTableId the custom table ID
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching custom tables
	*/
	public java.util.List<customTable> findBycustomTableId(long customTableId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns an ordered range of all the custom tables where customTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customTableId the custom table ID
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching custom tables
	*/
	public java.util.List<customTable> findBycustomTableId(long customTableId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public customTable findBycustomTableId_First(long customTableId,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException;

	/**
	* Returns the first custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public customTable fetchBycustomTableId_First(long customTableId,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns the last custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public customTable findBycustomTableId_Last(long customTableId,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException;

	/**
	* Returns the last custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public customTable fetchBycustomTableId_Last(long customTableId,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Removes all the custom tables where customTableId = &#63; from the database.
	*
	* @param customTableId the custom table ID
	*/
	public void removeBycustomTableId(long customTableId);

	/**
	* Returns the number of custom tables where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @return the number of matching custom tables
	*/
	public int countBycustomTableId(long customTableId);

	/**
	* Caches the custom table in the entity cache if it is enabled.
	*
	* @param customTable the custom table
	*/
	public void cacheResult(customTable customTable);

	/**
	* Caches the custom tables in the entity cache if it is enabled.
	*
	* @param customTables the custom tables
	*/
	public void cacheResult(java.util.List<customTable> customTables);

	/**
	* Creates a new custom table with the primary key. Does not add the custom table to the database.
	*
	* @param customTableId the primary key for the new custom table
	* @return the new custom table
	*/
	public customTable create(long customTableId);

	/**
	* Removes the custom table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table that was removed
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public customTable remove(long customTableId)
		throws NoSuchcustomTableException;

	public customTable updateImpl(customTable customTable);

	/**
	* Returns the custom table with the primary key or throws a {@link NoSuchcustomTableException} if it could not be found.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public customTable findByPrimaryKey(long customTableId)
		throws NoSuchcustomTableException;

	/**
	* Returns the custom table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table, or <code>null</code> if a custom table with the primary key could not be found
	*/
	public customTable fetchByPrimaryKey(long customTableId);

	@Override
	public java.util.Map<java.io.Serializable, customTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom tables.
	*
	* @return the custom tables
	*/
	public java.util.List<customTable> findAll();

	/**
	* Returns a range of all the custom tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @return the range of custom tables
	*/
	public java.util.List<customTable> findAll(int start, int end);

	/**
	* Returns an ordered range of all the custom tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom tables
	*/
	public java.util.List<customTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator);

	/**
	* Returns an ordered range of all the custom tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom tables
	*/
	public java.util.List<customTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom tables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom tables.
	*
	* @return the number of custom tables
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}