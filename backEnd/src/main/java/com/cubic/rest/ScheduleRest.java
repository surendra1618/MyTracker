package com.cubic.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.ScheduleService;
import com.cubic.vo.ScheduleVO;

@Service
@Path("/schedule")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScheduleRest {

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ScheduleInputValidator scheduletInputValidator;

	@GET
	@Path("/{scheduleId}")
	public Response findSchedule(@PathParam("scheduleId") final Long scheduleId) {
		ScheduleVO result = scheduleService.findSchedule(scheduleId);
		return Response.ok().entity(result).build();
	}

	@POST
	public Response addSchedule(final ScheduleVO scheduleVo) {
		scheduletInputValidator.validate(scheduleVo);
		ScheduleVO result = scheduleService.createSchedule(scheduleVo);
		return Response.ok().entity(result).build();
	}

	@PUT
	public Response updateSchedule(final ScheduleVO scheduleVo) {
		scheduletInputValidator.validate(scheduleVo);
		ScheduleVO result = scheduleService.updateSchedule(scheduleVo);
		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/{scheduleId}")
	public Response deleteSchedule(@PathParam("scheduleId") final Long scheduleId) {
		scheduleService.removeSchedule(scheduleId);
		return Response.noContent().build();
	}

}
