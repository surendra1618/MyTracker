package com.cubic.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTE")
@NamedQueries({ @NamedQuery(name = "RouteEntity.SearchAll", query = "select r from RouteEntity r"),
		@NamedQuery(name = "RouteEntity.SearchRouteByName", query = "select r from RouteEntity r where "
				+ "UPPER(r.routeName) like UPPER(:name)") })
public class RouteEntity {

	@Id
	@Column(name = "ROUTE_ID")
	@SequenceGenerator(name = "routeSeq", sequenceName = "ROUTE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "routeSeq")
	private Long routeId;

	@Column(name = "ROUTE_NAME")
	private String routeName;

	@Column(name = "START_LOCATION")
	private String startLocation;

	@Column(name = "END_LOCATION")
	private String endLocation;

	@Column(name = "ROUTE_LENGTH")
	private Long routeLength;

	@Column(name = "ROUTE_DURATION")
	private Long routeDuration;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
	private List<ScheduleEntity> schedules;

	public List<ScheduleEntity> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleEntity> schedules) {
		this.schedules = schedules;
	}

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
		return "RouteEntity [routeId=" + routeId + ", routeName=" + routeName + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", routeLength=" + routeLength + ", routeDuration=" + routeDuration
				+ ", schedules=" + schedules + "]";
	}

}
