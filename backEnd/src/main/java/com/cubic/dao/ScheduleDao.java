package com.cubic.dao;

import com.cubic.entity.ScheduleEntity;

public interface ScheduleDao {

	ScheduleEntity findSchedule(final Long scheduleId);

	void saveSchedule(final ScheduleEntity scheduleEntity);

	void removeSchedule(final ScheduleEntity scheduleEntity);

}
