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

package com.custom.table.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.custom.table.exception.NoSuchcustomTableException;
import com.custom.table.model.customTable;
import com.custom.table.model.impl.customTableImpl;
import com.custom.table.model.impl.customTableModelImpl;
import com.custom.table.service.persistence.customTablePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the custom table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customTablePersistence
 * @see com.custom.table.service.persistence.customTableUtil
 * @generated
 */
@ProviderType
public class customTablePersistenceImpl extends BasePersistenceImpl<customTable>
	implements customTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link customTableUtil} to access the custom table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = customTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			customTableModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the custom tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom tables
	 */
	@Override
	public List<customTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<customTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<customTable> findByUuid(String uuid, int start, int end,
		OrderByComparator<customTable> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<customTable> findByUuid(String uuid, int start, int end,
		OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<customTable> list = null;

		if (retrieveFromCache) {
			list = (List<customTable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (customTable customTable : list) {
					if (!Objects.equals(uuid, customTable.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CUSTOMTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(customTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom table
	 * @throws NoSuchcustomTableException if a matching custom table could not be found
	 */
	@Override
	public customTable findByUuid_First(String uuid,
		OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException {
		customTable customTable = fetchByUuid_First(uuid, orderByComparator);

		if (customTable != null) {
			return customTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcustomTableException(msg.toString());
	}

	/**
	 * Returns the first custom table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	 */
	@Override
	public customTable fetchByUuid_First(String uuid,
		OrderByComparator<customTable> orderByComparator) {
		List<customTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom table
	 * @throws NoSuchcustomTableException if a matching custom table could not be found
	 */
	@Override
	public customTable findByUuid_Last(String uuid,
		OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException {
		customTable customTable = fetchByUuid_Last(uuid, orderByComparator);

		if (customTable != null) {
			return customTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcustomTableException(msg.toString());
	}

	/**
	 * Returns the last custom table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	 */
	@Override
	public customTable fetchByUuid_Last(String uuid,
		OrderByComparator<customTable> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<customTable> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public customTable[] findByUuid_PrevAndNext(long customTableId,
		String uuid, OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException {
		customTable customTable = findByPrimaryKey(customTableId);

		Session session = null;

		try {
			session = openSession();

			customTable[] array = new customTableImpl[3];

			array[0] = getByUuid_PrevAndNext(session, customTable, uuid,
					orderByComparator, true);

			array[1] = customTable;

			array[2] = getByUuid_PrevAndNext(session, customTable, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected customTable getByUuid_PrevAndNext(Session session,
		customTable customTable, String uuid,
		OrderByComparator<customTable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CUSTOMTABLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(customTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(customTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<customTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (customTable customTable : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(customTable);
		}
	}

	/**
	 * Returns the number of custom tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom tables
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "customTable.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "customTable.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(customTable.uuid IS NULL OR customTable.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMTABLEID =
		new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycustomTableId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID =
		new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, customTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycustomTableId",
			new String[] { Long.class.getName() },
			customTableModelImpl.CUSTOMTABLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMTABLEID = new FinderPath(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycustomTableId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the custom tables where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @return the matching custom tables
	 */
	@Override
	public List<customTable> findBycustomTableId(long customTableId) {
		return findBycustomTableId(customTableId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<customTable> findBycustomTableId(long customTableId, int start,
		int end) {
		return findBycustomTableId(customTableId, start, end, null);
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
	@Override
	public List<customTable> findBycustomTableId(long customTableId, int start,
		int end, OrderByComparator<customTable> orderByComparator) {
		return findBycustomTableId(customTableId, start, end,
			orderByComparator, true);
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
	@Override
	public List<customTable> findBycustomTableId(long customTableId, int start,
		int end, OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID;
			finderArgs = new Object[] { customTableId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMTABLEID;
			finderArgs = new Object[] {
					customTableId,
					
					start, end, orderByComparator
				};
		}

		List<customTable> list = null;

		if (retrieveFromCache) {
			list = (List<customTable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (customTable customTable : list) {
					if ((customTableId != customTable.getCustomTableId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CUSTOMTABLE_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMTABLEID_CUSTOMTABLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(customTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customTableId);

				if (!pagination) {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom table in the ordered set where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom table
	 * @throws NoSuchcustomTableException if a matching custom table could not be found
	 */
	@Override
	public customTable findBycustomTableId_First(long customTableId,
		OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException {
		customTable customTable = fetchBycustomTableId_First(customTableId,
				orderByComparator);

		if (customTable != null) {
			return customTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customTableId=");
		msg.append(customTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcustomTableException(msg.toString());
	}

	/**
	 * Returns the first custom table in the ordered set where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom table, or <code>null</code> if a matching custom table could not be found
	 */
	@Override
	public customTable fetchBycustomTableId_First(long customTableId,
		OrderByComparator<customTable> orderByComparator) {
		List<customTable> list = findBycustomTableId(customTableId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom table in the ordered set where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom table
	 * @throws NoSuchcustomTableException if a matching custom table could not be found
	 */
	@Override
	public customTable findBycustomTableId_Last(long customTableId,
		OrderByComparator<customTable> orderByComparator)
		throws NoSuchcustomTableException {
		customTable customTable = fetchBycustomTableId_Last(customTableId,
				orderByComparator);

		if (customTable != null) {
			return customTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customTableId=");
		msg.append(customTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcustomTableException(msg.toString());
	}

	/**
	 * Returns the last custom table in the ordered set where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom table, or <code>null</code> if a matching custom table could not be found
	 */
	@Override
	public customTable fetchBycustomTableId_Last(long customTableId,
		OrderByComparator<customTable> orderByComparator) {
		int count = countBycustomTableId(customTableId);

		if (count == 0) {
			return null;
		}

		List<customTable> list = findBycustomTableId(customTableId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the custom tables where customTableId = &#63; from the database.
	 *
	 * @param customTableId the custom table ID
	 */
	@Override
	public void removeBycustomTableId(long customTableId) {
		for (customTable customTable : findBycustomTableId(customTableId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(customTable);
		}
	}

	/**
	 * Returns the number of custom tables where customTableId = &#63;.
	 *
	 * @param customTableId the custom table ID
	 * @return the number of matching custom tables
	 */
	@Override
	public int countBycustomTableId(long customTableId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMTABLEID;

		Object[] finderArgs = new Object[] { customTableId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMTABLE_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMTABLEID_CUSTOMTABLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customTableId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CUSTOMTABLEID_CUSTOMTABLEID_2 = "customTable.customTableId = ?";

	public customTablePersistenceImpl() {
		setModelClass(customTable.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("data", "data_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the custom table in the entity cache if it is enabled.
	 *
	 * @param customTable the custom table
	 */
	@Override
	public void cacheResult(customTable customTable) {
		entityCache.putResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableImpl.class, customTable.getPrimaryKey(), customTable);

		customTable.resetOriginalValues();
	}

	/**
	 * Caches the custom tables in the entity cache if it is enabled.
	 *
	 * @param customTables the custom tables
	 */
	@Override
	public void cacheResult(List<customTable> customTables) {
		for (customTable customTable : customTables) {
			if (entityCache.getResult(
						customTableModelImpl.ENTITY_CACHE_ENABLED,
						customTableImpl.class, customTable.getPrimaryKey()) == null) {
				cacheResult(customTable);
			}
			else {
				customTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom tables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(customTableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom table.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(customTable customTable) {
		entityCache.removeResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableImpl.class, customTable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<customTable> customTables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (customTable customTable : customTables) {
			entityCache.removeResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
				customTableImpl.class, customTable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom table with the primary key. Does not add the custom table to the database.
	 *
	 * @param customTableId the primary key for the new custom table
	 * @return the new custom table
	 */
	@Override
	public customTable create(long customTableId) {
		customTable customTable = new customTableImpl();

		customTable.setNew(true);
		customTable.setPrimaryKey(customTableId);

		String uuid = PortalUUIDUtil.generate();

		customTable.setUuid(uuid);

		return customTable;
	}

	/**
	 * Removes the custom table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customTableId the primary key of the custom table
	 * @return the custom table that was removed
	 * @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	 */
	@Override
	public customTable remove(long customTableId)
		throws NoSuchcustomTableException {
		return remove((Serializable)customTableId);
	}

	/**
	 * Removes the custom table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom table
	 * @return the custom table that was removed
	 * @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	 */
	@Override
	public customTable remove(Serializable primaryKey)
		throws NoSuchcustomTableException {
		Session session = null;

		try {
			session = openSession();

			customTable customTable = (customTable)session.get(customTableImpl.class,
					primaryKey);

			if (customTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcustomTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customTable);
		}
		catch (NoSuchcustomTableException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected customTable removeImpl(customTable customTable) {
		customTable = toUnwrappedModel(customTable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customTable)) {
				customTable = (customTable)session.get(customTableImpl.class,
						customTable.getPrimaryKeyObj());
			}

			if (customTable != null) {
				session.delete(customTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (customTable != null) {
			clearCache(customTable);
		}

		return customTable;
	}

	@Override
	public customTable updateImpl(customTable customTable) {
		customTable = toUnwrappedModel(customTable);

		boolean isNew = customTable.isNew();

		customTableModelImpl customTableModelImpl = (customTableModelImpl)customTable;

		if (Validator.isNull(customTable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			customTable.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (customTable.isNew()) {
				session.save(customTable);

				customTable.setNew(false);
			}
			else {
				customTable = (customTable)session.merge(customTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!customTableModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { customTableModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { customTableModelImpl.getCustomTableId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CUSTOMTABLEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((customTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						customTableModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { customTableModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((customTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						customTableModelImpl.getOriginalCustomTableId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CUSTOMTABLEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID,
					args);

				args = new Object[] { customTableModelImpl.getCustomTableId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CUSTOMTABLEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMTABLEID,
					args);
			}
		}

		entityCache.putResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
			customTableImpl.class, customTable.getPrimaryKey(), customTable,
			false);

		customTable.resetOriginalValues();

		return customTable;
	}

	protected customTable toUnwrappedModel(customTable customTable) {
		if (customTable instanceof customTableImpl) {
			return customTable;
		}

		customTableImpl customTableImpl = new customTableImpl();

		customTableImpl.setNew(customTable.isNew());
		customTableImpl.setPrimaryKey(customTable.getPrimaryKey());

		customTableImpl.setUuid(customTable.getUuid());
		customTableImpl.setCustomTableId(customTable.getCustomTableId());
		customTableImpl.setData(customTable.getData());

		return customTableImpl;
	}

	/**
	 * Returns the custom table with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom table
	 * @return the custom table
	 * @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	 */
	@Override
	public customTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcustomTableException {
		customTable customTable = fetchByPrimaryKey(primaryKey);

		if (customTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcustomTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return customTable;
	}

	/**
	 * Returns the custom table with the primary key or throws a {@link NoSuchcustomTableException} if it could not be found.
	 *
	 * @param customTableId the primary key of the custom table
	 * @return the custom table
	 * @throws NoSuchcustomTableException if a custom table with the primary key could not be found
	 */
	@Override
	public customTable findByPrimaryKey(long customTableId)
		throws NoSuchcustomTableException {
		return findByPrimaryKey((Serializable)customTableId);
	}

	/**
	 * Returns the custom table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom table
	 * @return the custom table, or <code>null</code> if a custom table with the primary key could not be found
	 */
	@Override
	public customTable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
				customTableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		customTable customTable = (customTable)serializable;

		if (customTable == null) {
			Session session = null;

			try {
				session = openSession();

				customTable = (customTable)session.get(customTableImpl.class,
						primaryKey);

				if (customTable != null) {
					cacheResult(customTable);
				}
				else {
					entityCache.putResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
						customTableImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
					customTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return customTable;
	}

	/**
	 * Returns the custom table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customTableId the primary key of the custom table
	 * @return the custom table, or <code>null</code> if a custom table with the primary key could not be found
	 */
	@Override
	public customTable fetchByPrimaryKey(long customTableId) {
		return fetchByPrimaryKey((Serializable)customTableId);
	}

	@Override
	public Map<Serializable, customTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, customTable> map = new HashMap<Serializable, customTable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			customTable customTable = fetchByPrimaryKey(primaryKey);

			if (customTable != null) {
				map.put(primaryKey, customTable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
					customTableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (customTable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOMTABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (customTable customTable : (List<customTable>)q.list()) {
				map.put(customTable.getPrimaryKeyObj(), customTable);

				cacheResult(customTable);

				uncachedPrimaryKeys.remove(customTable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(customTableModelImpl.ENTITY_CACHE_ENABLED,
					customTableImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the custom tables.
	 *
	 * @return the custom tables
	 */
	@Override
	public List<customTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<customTable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<customTable> findAll(int start, int end,
		OrderByComparator<customTable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<customTable> findAll(int start, int end,
		OrderByComparator<customTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<customTable> list = null;

		if (retrieveFromCache) {
			list = (List<customTable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOMTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMTABLE;

				if (pagination) {
					sql = sql.concat(customTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<customTable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the custom tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (customTable customTable : findAll()) {
			remove(customTable);
		}
	}

	/**
	 * Returns the number of custom tables.
	 *
	 * @return the number of custom tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMTABLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return customTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom table persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(customTableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOMTABLE = "SELECT customTable FROM customTable customTable";
	private static final String _SQL_SELECT_CUSTOMTABLE_WHERE_PKS_IN = "SELECT customTable FROM customTable customTable WHERE customTableId IN (";
	private static final String _SQL_SELECT_CUSTOMTABLE_WHERE = "SELECT customTable FROM customTable customTable WHERE ";
	private static final String _SQL_COUNT_CUSTOMTABLE = "SELECT COUNT(customTable) FROM customTable customTable";
	private static final String _SQL_COUNT_CUSTOMTABLE_WHERE = "SELECT COUNT(customTable) FROM customTable customTable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No customTable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No customTable exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(customTablePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "data"
			});
}