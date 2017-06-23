package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity {

	@Id
	@Column(name = "SCHEDULE_ID")
	@SequenceGenerator(name = "scheduleSeq", sequenceName = "SCHEDULE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "scheduleSeq")
	private Long scheduleId;

	@Column(name = "SCHEDULE_STATUS")
	private String scheduleStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID")
	private VehicleEntity vehicle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTE_ID")
	private RouteEntity route;

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	public RouteEntity getRoute() {
		return route;
	}

	public void setRoute(RouteEntity route) {
		this.route = route;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [scheduleId=" + scheduleId + ", scheduleStatus=" + scheduleStatus + ", vehicle="
				+ vehicle + ", route=" + route + "]";
	}

}
