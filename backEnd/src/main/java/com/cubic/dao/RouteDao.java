package com.cubic.dao;

import java.util.List;

import com.cubic.entity.RouteEntity;

public interface RouteDao {

	RouteEntity findRoute(final Long routeId);

	void saveRoute(final RouteEntity routeEntity);

	void removeRoute(final RouteEntity routeEntity);

	List<RouteEntity> findAllRoutes();

	List<RouteEntity> findRouteByName(final String name);

}
