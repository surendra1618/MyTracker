package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RouteVO {

	private Long routeId;

	private String routeName;

	private String startLocation;

	private String endLocation;

	private Long routeLength;

	private Long routeDuration;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Long getRouteLength() {
		return routeLength;
	}

	public void setRouteLength(Long routeLength) {
		this.routeLength = routeLength;
	}

	public Long getRouteDuration() {
		return routeDuration;
	}

	public void setRouteDuration(Long routeDuration) {
		this.routeDuration = routeDuration;
	}

	@Override
	public String toString() {
		return "RouteVO [routeId=" + routeId + ", routeName=" + routeName + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", routeLength=" + routeLength + ", routeDuration=" + routeDuration
				+ "]";
	}

}
