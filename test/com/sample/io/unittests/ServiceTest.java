package com.sample.io.unittests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sample.io.Service;
import com.sample.io.WaterPoint;

public class ServiceTest {

	@Test
	public void testWaterPointIsBrokenTrue() {
		Service service = new Service();
		
		WaterPoint waterPoint = new WaterPoint();
		waterPoint.setWaterFunctioning("no");
		
		assertTrue(service.waterPointIsBroken(waterPoint));
	}
	
	@Test
	public void testWaterPointIsBrokenFalse() {
		Service service = new Service();
		
		WaterPoint waterPoint = new WaterPoint();
		waterPoint.setWaterFunctioning("yes");
		
		assertFalse(service.waterPointIsBroken(waterPoint));
	}
}
