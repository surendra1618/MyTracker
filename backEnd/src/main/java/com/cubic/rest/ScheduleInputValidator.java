package com.cubic.rest;

import org.springframework.stereotype.Component;

import com.cubic.exception.InvalidInputException;
import com.cubic.vo.ScheduleVO;

@Component
public class ScheduleInputValidator {

	public void validate(final ScheduleVO scheduleVo) {
		if (scheduleVo.getVehicleId() == null || scheduleVo.getRouteId() == null) {
			throw new InvalidInputException("Schedule must have a Route and a Vehicle assigned.");
		}

		if (!scheduleVo.getScheduleStatus().equals("PLANNED") && !scheduleVo.getScheduleStatus().equals("ENROUTE")
				&& !scheduleVo.getScheduleStatus().equals("COMPLETE")) {
			throw new InvalidInputException("Schedule Status must be one of these: PLANNED, ENROUTE or COMPLETE");
		}
	}
}
