package com.cubic.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteSearchResults {

	private List<RouteVO> routes;

	public List<RouteVO> getRoutes() {
		if (routes == null) {
			routes = new ArrayList<RouteVO>();
		}
		return routes;
	}

	public void setRoutes(List<RouteVO> routes) {
		this.routes = routes;
	}

}
