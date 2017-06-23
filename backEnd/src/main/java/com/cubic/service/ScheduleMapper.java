package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cubic.dao.RouteDao;
import com.cubic.dao.VehicleDao;
import com.cubic.entity.ScheduleEntity;
import com.cubic.vo.ScheduleVO;

@Component
public class ScheduleMapper {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private VehicleDao vehicleDao;

	public ScheduleVO mapToScheduleVO(ScheduleEntity scheduleEntity) {
		ScheduleVO scheduleVo = new ScheduleVO();

		scheduleVo.setScheduleId(scheduleEntity.getScheduleId());
		scheduleVo.setRouteId(scheduleEntity.getRoute().getRouteId());
		scheduleVo.setVehicleId(scheduleEntity.getVehicle().getVehicleId());
		scheduleVo.setScheduleStatus(scheduleEntity.getScheduleStatus());

		return scheduleVo;
	}

	public ScheduleEntity mapToScheduleVO(ScheduleVO scheduleVo, ScheduleEntity scheduleEntity) {
		scheduleEntity.setScheduleId(scheduleVo.getScheduleId());
		scheduleEntity.setRoute(routeDao.findRoute(scheduleVo.getRouteId()));
		scheduleEntity.setVehicle(vehicleDao.findVehicle(scheduleVo.getVehicleId()));
		scheduleEntity.setScheduleStatus(scheduleVo.getScheduleStatus());

		return scheduleEntity;
	}

	public ScheduleEntity mapToScheduleEntity(ScheduleVO scheduleVo) {
		ScheduleEntity scheduleEntity = new ScheduleEntity();

		return mapToScheduleVO(scheduleVo, scheduleEntity);
	}
}
