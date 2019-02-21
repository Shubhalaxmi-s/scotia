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

package com.custom.table.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link customTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see customTableLocalService
 * @generated
 */
@ProviderType
public class customTableLocalServiceWrapper implements customTableLocalService,
	ServiceWrapper<customTableLocalService> {
	public customTableLocalServiceWrapper(
		customTableLocalService customTableLocalService) {
		_customTableLocalService = customTableLocalService;
	}

	/**
	* Adds the custom table to the database. Also notifies the appropriate model listeners.
	*
	* @param customTable the custom table
	* @return the custom table that was added
	*/
	@Override
	public com.custom.table.model.customTable addcustomTable(
		com.custom.table.model.customTable customTable) {
		return _customTableLocalService.addcustomTable(customTable);
	}

	/**
	* Creates a new custom table with the primary key. Does not add the custom table to the database.
	*
	* @param customTableId the primary key for the new custom table
	* @return the new custom table
	*/
	@Override
	public com.custom.table.model.customTable createcustomTable(
		long customTableId) {
		return _customTableLocalService.createcustomTable(customTableId);
	}

	/**
	* Deletes the custom table from the database. Also notifies the appropriate model listeners.
	*
	* @param customTable the custom table
	* @return the custom table that was removed
	*/
	@Override
	public com.custom.table.model.customTable deletecustomTable(
		com.custom.table.model.customTable customTable) {
		return _customTableLocalService.deletecustomTable(customTable);
	}

	/**
	* Deletes the custom table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table that was removed
	* @throws PortalException if a custom table with the primary key could not be found
	*/
	@Override
	public com.custom.table.model.customTable deletecustomTable(
		long customTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customTableLocalService.deletecustomTable(customTableId);
	}

	@Override
	public com.custom.table.model.customTable fetchcustomTable(
		long customTableId) {
		return _customTableLocalService.fetchcustomTable(customTableId);
	}

	/**
	* Returns the custom table with the primary key.
	*
	* @param customTableId the primary key of the custom table
	* @return the custom table
	* @throws PortalException if a custom table with the primary key could not be found
	*/
	@Override
	public com.custom.table.model.customTable getcustomTable(long customTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customTableLocalService.getcustomTable(customTableId);
	}

	/**
	* Updates the custom table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param customTable the custom table
	* @return the custom table that was updated
	*/
	@Override
	public com.custom.table.model.customTable updatecustomTable(
		com.custom.table.model.customTable customTable) {
		return _customTableLocalService.updatecustomTable(customTable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _customTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customTableLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _customTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom tables.
	*
	* @return the number of custom tables
	*/
	@Override
	public int getcustomTablesCount() {
		return _customTableLocalService.getcustomTablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _customTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _customTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.custom.table.model.impl.customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _customTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.custom.table.model.impl.customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _customTableLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the custom tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.custom.table.model.impl.customTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom tables
	* @param end the upper bound of the range of custom tables (not inclusive)
	* @return the range of custom tables
	*/
	@Override
	public java.util.List<com.custom.table.model.customTable> getcustomTables(
		int start, int end) {
		return _customTableLocalService.getcustomTables(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _customTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _customTableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public customTableLocalService getWrappedService() {
		return _customTableLocalService;
	}

	@Override
	public void setWrappedService(
		customTableLocalService customTableLocalService) {
		_customTableLocalService = customTableLocalService;
	}

	private customTableLocalService _customTableLocalService;
}