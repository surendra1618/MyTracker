package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleVO {

	private Long scheduleId;

	private Long vehicleId;

	private Long routeId;

	private String scheduleStatus;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	@Override
	public String toString() {
		return "ScheduleVO [scheduleId=" + scheduleId + ", vehicleId=" + vehicleId + ", routeId=" + routeId
				+ ", scheduleStatus=" + scheduleStatus + "]";
	}

}
