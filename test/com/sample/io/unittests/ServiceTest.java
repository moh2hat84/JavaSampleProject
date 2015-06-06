package com.sample.io.unittests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sample.io.Service;
import com.sample.io.WaterPoint;

public class ServiceTest {

	@Test
	public void testWaterPointIsBrokenTrue() {
		WaterPoint waterPoint = new WaterPoint();
		waterPoint.setWaterFunctioning("no");
		assertTrue(Service.waterPointIsBroken(waterPoint));
	}
	
	@Test
	public void testWaterPointIsBrokenFalse() {
		WaterPoint waterPoint = new WaterPoint();
		waterPoint.setWaterFunctioning("yes");
		assertFalse(Service.waterPointIsBroken(waterPoint));
	}
}
