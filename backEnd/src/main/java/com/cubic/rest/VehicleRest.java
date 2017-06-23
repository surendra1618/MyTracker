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

import com.cubic.service.VehicleService;
import com.cubic.vo.VehicleVO;

@Service
@Path("/vehicle")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleRest {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleInputValidator vehicleInputValidator;

	@GET
	@Path("/{vehicleId}")
	public Response findVehicle(@PathParam("vehicleId") final Long vehicleId) {
		VehicleVO result = vehicleService.findVehicle(vehicleId);
		return Response.ok().entity(result).build();

	}

	@POST
	public Response addVehicle(final VehicleVO vehicleVo) {
		vehicleInputValidator.validate(vehicleVo);
		VehicleVO result = vehicleService.createVehicle(vehicleVo);
		return Response.ok().entity(result).build();
	}

	@PUT
	public Response updateVehicle(final VehicleVO vehicleVo) {
		vehicleInputValidator.validate(vehicleVo);
		VehicleVO result = vehicleService.updateVehicle(vehicleVo);
		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/{vehicleId}")
	public Response deleteVehicle(@PathParam("vehicleId") final Long vehicleId) {
		vehicleService.removeVehicle(vehicleId);
		return Response.noContent().build();
	}
}
