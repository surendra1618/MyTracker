package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.RouteEntity;
import com.cubic.vo.RouteVO;

@Component
public class RouteMapper {

	public RouteVO mapToRouteVO(RouteEntity routeEntity) {
		RouteVO routeVo = new RouteVO();

		routeVo.setRouteId(routeEntity.getRouteId());
		routeVo.setRouteName(routeEntity.getRouteName());
		routeVo.setStartLocation(routeEntity.getStartLocation());
		routeVo.setEndLocation(routeEntity.getEndLocation());
		routeVo.setRouteLength(routeEntity.getRouteLength());
		routeVo.setRouteDuration(routeEntity.getRouteDuration());

		return routeVo;
	}

	public RouteEntity mapToRouteEntity(RouteVO routeVo, RouteEntity routeEntity) {
		routeEntity.setRouteId(routeVo.getRouteId());
		routeEntity.setRouteName(routeVo.getStartLocation() + "_" + routeVo.getEndLocation());
		routeEntity.setStartLocation(routeVo.getStartLocation());
		routeEntity.setEndLocation(routeVo.getEndLocation());
		routeEntity.setRouteLength(routeVo.getRouteLength());
		routeEntity.setRouteDuration(routeVo.getRouteDuration());

		return routeEntity;
	}

	public RouteEntity mapToRouteEntity(RouteVO routeVo) {
		RouteEntity routeEntity = new RouteEntity();

		return mapToRouteEntity(routeVo, routeEntity);
	}

	public List<RouteVO> mapToRouteVOList(List<RouteEntity> routeEntities) {
		List<RouteVO> routeVoList = new ArrayList<RouteVO>();

		for (RouteEntity routeEntity : routeEntities) {
			routeVoList.add(mapToRouteVO(routeEntity));
		}

		return routeVoList;
	}

}
