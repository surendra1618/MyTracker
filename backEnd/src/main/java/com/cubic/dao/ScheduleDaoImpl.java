package com.cubic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cubic.entity.ScheduleEntity;

@Component
public class ScheduleDaoImpl implements ScheduleDao {

	@PersistenceContext
	private EntityManager em;

	public ScheduleEntity findSchedule(Long scheduleId) {
		return em.find(ScheduleEntity.class, scheduleId);
	}

	public void saveSchedule(ScheduleEntity scheduleEntity) {
		em.persist(scheduleEntity);
	}

	public void removeSchedule(ScheduleEntity scheduleEntity) {
		em.remove(scheduleEntity);
	}

}
