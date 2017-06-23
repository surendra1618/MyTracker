package com.cubic.service;

import java.util.List;

import com.cubic.vo.RouteVO;

public interface RouteService {

	RouteVO findRoute(final Long routeId);

	RouteVO createRoute(final RouteVO routeVo);

	RouteVO updateRoute(final RouteVO routeVo);

	void removeRoute(final Long routeId);
	
	List<RouteVO> findAllRoutes();
	
	List<RouteVO> findRouteByName(final String name);

}
