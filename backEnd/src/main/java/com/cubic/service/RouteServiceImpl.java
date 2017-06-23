package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.dao.RouteDao;
import com.cubic.entity.RouteEntity;
import com.cubic.vo.RouteVO;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private RouteMapper routeMapper;

	@Autowired
	private RouteValidator routeValidator;

	public RouteVO findRoute(final Long id) {
		RouteEntity routeEntity = routeDao.findRoute(id);
		routeValidator.validate(routeEntity);

		return routeMapper.mapToRouteVO(routeEntity);
	}

	public RouteVO createRoute(final RouteVO routeVo) {
		RouteEntity routeEntity = null;

		routeEntity = routeMapper.mapToRouteEntity(routeVo);

		routeDao.saveRoute(routeEntity);
		routeVo.setRouteId(routeEntity.getRouteId());
		routeVo.setRouteName(routeEntity.getRouteName());

		return routeVo;
	}

	public RouteVO updateRoute(final RouteVO routeVo) {
		RouteEntity routeEntity = null;

		routeEntity = routeDao.findRoute(routeVo.getRouteId());
		routeValidator.validate(routeEntity);

		routeEntity = routeMapper.mapToRouteEntity(routeVo, routeEntity);
		
		routeDao.saveRoute(routeEntity);
		routeVo.setRouteId(routeEntity.getRouteId());
		routeVo.setRouteName(routeEntity.getRouteName());

		return routeVo;
	}

	public void removeRoute(final Long id) {
		RouteEntity routeEntity = routeDao.findRoute(id);
		routeValidator.validate(routeEntity);
		routeValidator.checkRouteSchedule(routeEntity);

		routeDao.removeRoute(routeEntity);
	}

	public List<RouteVO> findAllRoutes() {
		List<RouteEntity> routeEntities = routeDao.findAllRoutes();
		
		return routeMapper.mapToRouteVOList(routeEntities);
	}

	public List<RouteVO> findRouteByName(String name) {
		List<RouteEntity> routeEntities = routeDao.findRouteByName(name);
		return routeMapper.mapToRouteVOList(routeEntities);
	}

}
