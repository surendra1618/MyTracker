package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cubic.dao.RouteDao;
import com.cubic.dao.VehicleDao;
import com.cubic.entity.ScheduleEntity;
import com.cubic.exception.DataNotFoundException;
import com.cubic.vo.ScheduleVO;

@Component
public class ScheduleValidator {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private VehicleDao vehicleDao;

	public void validate(final ScheduleEntity scheduleEntity) {
		if (scheduleEntity == null) {
			throw new DataNotFoundException("The Schedule does not exist in the system.");
		}
	}

	public void validate(final ScheduleVO scheduleVo) {
		if (routeDao.findRoute(scheduleVo.getRouteId()) == null) {
			throw new DataNotFoundException("The Route you are trying to schedule does not exist in the system.");
		}

		if (vehicleDao.findVehicle(scheduleVo.getVehicleId()) == null) {
			throw new DataNotFoundException("The Vehicle you are trying to schedule does not exist in the system.");
		}
	}
}
