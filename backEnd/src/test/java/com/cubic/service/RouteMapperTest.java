package com.cubic.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.cubic.entity.RouteEntity;
import com.cubic.vo.RouteVO;

public class RouteMapperTest {

	RouteMapper iRouteMapper = new RouteMapper();

	@Test
	public void mapToRouteVoTest() {
		RouteVO iRouteVo = new RouteVO();
		RouteEntity iRouteEntity = mock(RouteEntity.class);

		// iRouteMapper.mapToRouteVO(iRouteEntity);
		Long id = 10L;
		when(iRouteEntity.getRouteId()).thenReturn(id);
		when(iRouteEntity.getStartLocation()).thenReturn("Irving");
		when(iRouteEntity.getEndLocation()).thenReturn("Dallas");

		iRouteVo = iRouteMapper.mapToRouteVO(iRouteEntity);

		assertEquals(id, iRouteVo.getRouteId());
		assertEquals("Irving", iRouteVo.getStartLocation());
		assertEquals("Dallas", iRouteVo.getEndLocation());
		verify(iRouteEntity, times(1)).getRouteId();
	}

	@Test
	public void mapToRouteEntityTest() {
		RouteEntity iRouteEntity = new RouteEntity();
		RouteVO iRouteVo = mock(RouteVO.class);

		// iRouteMapper.mapToRouteEntity(iRouteVo, iRouteEntity);

		Long id = 11L;
		when(iRouteVo.getRouteId()).thenReturn(id);
		when(iRouteVo.getStartLocation()).thenReturn("Irving");
		when(iRouteVo.getEndLocation()).thenReturn("Dallas");

		iRouteEntity = iRouteMapper.mapToRouteEntity(iRouteVo, iRouteEntity);

		assertEquals(id, iRouteEntity.getRouteId());
		assertEquals("Irving", iRouteEntity.getStartLocation());
		assertEquals("Dallas", iRouteEntity.getEndLocation());
	}

	@Test
	public void mapToRouteEntityTest2() {
		RouteEntity iRouteEntity = new RouteEntity();
		RouteVO iRouteVo = mock(RouteVO.class);

		Long id = 10L;
		when(iRouteVo.getRouteId()).thenReturn(id);
		when(iRouteVo.getStartLocation()).thenReturn("Irving");
		when(iRouteVo.getEndLocation()).thenReturn("Dallas");

		iRouteEntity = iRouteMapper.mapToRouteEntity(iRouteVo);

		assertEquals(id, iRouteEntity.getRouteId());
		assertEquals("Irving", iRouteEntity.getStartLocation());
		assertEquals("Dallas", iRouteEntity.getEndLocation());
	}

}
