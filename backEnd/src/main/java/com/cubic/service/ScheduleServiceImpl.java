package com.cubic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.dao.ScheduleDao;
import com.cubic.entity.ScheduleEntity;
import com.cubic.vo.ScheduleVO;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Autowired
	private ScheduleValidator scheduleValidator;

	public ScheduleVO findSchedule(final Long scheduleId) {
		ScheduleEntity scheduleEntity = scheduleDao.findSchedule(scheduleId);
		scheduleValidator.validate(scheduleEntity);

		return scheduleMapper.mapToScheduleVO(scheduleEntity);
	}

	public ScheduleVO createSchedule(final ScheduleVO scheduleVo) {
		scheduleValidator.validate(scheduleVo);
		
		ScheduleEntity scheduleEntity = null;
		scheduleEntity = scheduleMapper.mapToScheduleEntity(scheduleVo);

		scheduleDao.saveSchedule(scheduleEntity);
		scheduleVo.setScheduleId(scheduleEntity.getScheduleId());

		return scheduleVo;
	}

	public ScheduleVO updateSchedule(final ScheduleVO scheduleVo) {
		scheduleValidator.validate(scheduleVo);
		
		ScheduleEntity scheduleEntity = new ScheduleEntity();
		scheduleEntity = scheduleDao.findSchedule(scheduleVo.getScheduleId());
		scheduleValidator.validate(scheduleEntity);

		scheduleEntity = scheduleMapper.mapToScheduleVO(scheduleVo, scheduleEntity);

		scheduleDao.saveSchedule(scheduleEntity);
		scheduleVo.setScheduleId(scheduleEntity.getScheduleId());

		return scheduleVo;
	}

	public void removeSchedule(final Long scheduleId) {
		ScheduleEntity scheduleEntity = scheduleDao.findSchedule(scheduleId);
		scheduleValidator.validate(scheduleEntity);

		scheduleDao.removeSchedule(scheduleEntity);
	}

}
