package com.cubic.service;

import com.cubic.vo.ScheduleVO;

public interface ScheduleService {

	ScheduleVO findSchedule(final Long scheduleId);

	ScheduleVO createSchedule(final ScheduleVO scheduleVo);

	ScheduleVO updateSchedule(final ScheduleVO scheduleVo);

	void removeSchedule(final Long scheduleId);
}
