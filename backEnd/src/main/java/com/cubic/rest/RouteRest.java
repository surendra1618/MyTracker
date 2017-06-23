package com.cubic.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.RouteService;
import com.cubic.vo.RouteSearchResults;
import com.cubic.vo.RouteVO;

@Service
@Path("/route")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RouteRest {

	@Autowired
	private RouteService routeService;

	@Autowired
	private RouteInputValidator routeInputValidator;

	@GET
	@Path("/{routeId}")
	public Response findRoute(@PathParam("routeId") final Long routeId) {
		RouteVO result = routeService.findRoute(routeId);
		RouteSearchResults results = new RouteSearchResults();
		List<RouteVO> routeVos = new ArrayList<RouteVO>();
		routeVos.add(result);
		results.setRoutes(routeVos);
		return Response.ok().entity(results).build();
	}

	@GET
	public Response findAllRoutes() {
		List<RouteVO> routeVos = routeService.findAllRoutes();
		RouteSearchResults results = new RouteSearchResults();
		results.setRoutes(routeVos);
		return Response.ok().entity(results).build();
	}
	
	@GET
	@Path("/name")
	public Response findRouteByName(@QueryParam("searchByName") final String name){
		List<RouteVO> routeVos = routeService.findRouteByName(name);
		RouteSearchResults results = new RouteSearchResults();
		results.setRoutes(routeVos);
		return Response.ok().entity(results).build();
	}
	
	@POST
	public Response addRoute(final RouteVO routeVo) {
		routeInputValidator.validate(routeVo);
		RouteVO result = routeService.createRoute(routeVo);
		return Response.ok().entity(result).build();
	}

	@PUT
	public Response updateRoute(final RouteVO routeVo) {
		routeInputValidator.validate(routeVo);
		RouteVO result = routeService.updateRoute(routeVo);
		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/{routeId}")
	public Response deleteRoute(@PathParam("routeId") final Long routeId) {
		routeService.removeRoute(routeId);
		return Response.noContent().build();
	}

}
