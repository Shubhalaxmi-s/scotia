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

import com.custom.table.model.customTable;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom table service. This utility wraps {@link com.custom.table.service.persistence.impl.customTablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customTablePersistence
 * @see com.custom.table.service.persistence.impl.customTablePersistenceImpl
 * @generated
 */
@ProviderType
public class customTableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(customTable customTable) {
		getPersistence().clearCache(customTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<customTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<customTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<customTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static customTable update(customTable customTable) {
		return getPersistence().update(customTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static customTable update(customTable customTable,
		ServiceContext serviceContext) {
		return getPersistence().update(customTable, serviceContext);
	}

	/**
	* Returns all the custom tables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching custom tables
	*/
	public static List<customTable> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<customTable> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<customTable> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<customTable> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<customTable> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public static customTable findByUuid_First(java.lang.String uuid,
		OrderByComparator<customTable> orderByComparator)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public static customTable fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public static customTable findByUuid_Last(java.lang.String uuid,
		OrderByComparator<customTable> orderByComparator)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last custom table in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public static customTable fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the custom tables before and after the current custom table in the ordered set where uuid = &#63;.
	*
	* @param customTableId the primary key of the current custom table
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next custom table
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public static customTable[] findByUuid_PrevAndNext(long customTableId,
		java.lang.String uuid, OrderByComparator<customTable> orderByComparator)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence()
				   .findByUuid_PrevAndNext(customTableId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the custom tables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of custom tables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching custom tables
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the custom tables where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @return the matching custom tables
	*/
	public static List<customTable> findBycustomTableId(long customTableId) {
		return getPersistence().findBycustomTableId(customTableId);
	}

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
	public static List<customTable> findBycustomTableId(long customTableId,
		int start, int end) {
		return getPersistence().findBycustomTableId(customTableId, start, end);
	}

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
	public static List<customTable> findBycustomTableId(long customTableId,
		int start, int end, OrderByComparator<customTable> orderByComparator) {
		return getPersistence()
				   .findBycustomTableId(customTableId, start, end,
			orderByComparator);
	}

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
	public static List<customTable> findBycustomTableId(long customTableId,
		int start, int end, OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycustomTableId(customTableId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public static customTable findBycustomTableId_First(long customTableId,
		OrderByComparator<customTable> orderByComparator)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence()
				   .findBycustomTableId_First(customTableId, orderByComparator);
	}

	/**
	* Returns the first custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public static customTable fetchBycustomTableId_First(long customTableId,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence()
				   .fetchBycustomTableId_First(customTableId, orderByComparator);
	}

	/**
	* Returns the last custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table
	* @throws NoSuchcustomTableException if a matching custom table could not be found
	*/
	public static customTable findBycustomTableId_Last(long customTableId,
		OrderByComparator<customTable> orderByComparator)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence()
				   .findBycustomTableId_Last(customTableId, orderByComparator);
	}

	/**
	* Returns the last custom table in the ordered set where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	*/
	public static customTable fetchBycustomTableId_Last(long customTableId,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence()
				   .fetchBycustomTableId_Last(customTableId, orderByComparator);
	}

	/**
	* Removes all the custom tables where customTableId = &#63; from the database.
	*
	* @param customTableId the custom table ID
	*/
	public static void removeBycustomTableId(long customTableId) {
		getPersistence().removeBycustomTableId(customTableId);
	}

	/**
	* Returns the number of custom tables where customTableId = &#63;.
	*
	* @param customTableId the custom table ID
	* @return the number of matching custom tables
	*/
	public static int countBycustomTableId(long customTableId) {
		return getPersistence().countBycustomTableId(customTableId);
	}

	/**
	* Caches the custom table in the entity cache if it is enabled.
	*
	* @param customTable the custom table
	*/
	public static void cacheResult(customTable customTable) {
		getPersistence().cacheResult(customTable);
	}

	/**
	* Caches the custom tables in the entity cache if it is enabled.
	*
	* @param customTables the custom tables
	*/
	public static void cacheResult(List<customTable> customTables) {
		getPersistence().cacheResult(customTables);
	}

	/**
	* Creates a new custom table with the primary key. Does not add the custom table to the database.
	*
	* @param customTableId the primary key for the new custom table
	* @return the new custom table
	*/
	public static customTable create(long customTableId) {
		return getPersistence().create(customTableId);
	}

	/**
	* Removes the custom table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table that was removed
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public static customTable remove(long customTableId)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence().remove(customTableId);
	}

	public static customTable updateImpl(customTable customTable) {
		return getPersistence().updateImpl(customTable);
	}

	/**
	* Returns the custom table with the primary key or throws a {@link NoSuchcustomTableException} if it could not be found.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table
	* @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	*/
	public static customTable findByPrimaryKey(long customTableId)
		throws com.custom.table.exception.NoSuchcustomTableException {
		return getPersistence().findByPrimaryKey(customTableId);
	}

	/**
	* Returns the custom table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table, or <code>null</code> if a custom table with the primary key could not be found
	*/
	public static customTable fetchByPrimaryKey(long customTableId) {
		return getPersistence().fetchByPrimaryKey(customTableId);
	}

	public static java.util.Map<java.io.Serializable, customTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom tables.
	*
	* @return the custom tables
	*/
	public static List<customTable> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<customTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<customTable> findAll(int start, int end,
		OrderByComparator<customTable> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<customTable> findAll(int start, int end,
		OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom tables from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom tables.
	*
	* @return the number of custom tables
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static customTablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<customTablePersistence, customTablePersistence> _serviceTracker =
		ServiceTrackerFactory.open(customTablePersistence.class);
}