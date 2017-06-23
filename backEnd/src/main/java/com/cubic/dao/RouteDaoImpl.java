package com.cubic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.cubic.entity.RouteEntity;

@Component
public class RouteDaoImpl implements RouteDao {

	@PersistenceContext
	private EntityManager em;

	public RouteEntity findRoute(Long routeId) {
		return em.find(RouteEntity.class, routeId);
	}

	public void saveRoute(RouteEntity routeEntity) {
		em.persist(routeEntity);
	}

	public void removeRoute(RouteEntity routeEntity) {
		em.remove(routeEntity);
	}

	public List<RouteEntity> findAllRoutes() {
		TypedQuery<RouteEntity> query = em.createNamedQuery("RouteEntity.SearchAll", RouteEntity.class);
		return query.getResultList();
	}

	public List<RouteEntity> findRouteByName(String name) {
		String queryParam = name.trim() + "%";
		TypedQuery<RouteEntity> query = em.createNamedQuery("RouteEntity.SearchRouteByName", RouteEntity.class);
		query.setParameter("name", queryParam);
		return query.getResultList();
	}

}
