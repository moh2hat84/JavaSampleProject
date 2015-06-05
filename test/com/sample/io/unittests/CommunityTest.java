package com.sample.io.unittests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sample.io.Community;
import com.sample.io.WaterPoint;

public class CommunityTest {

	@Test
	public void testGetFunctionalPoints(){
		Community community = new Community();
		community.setName("Test Commuity");
		
		WaterPoint waterPoint1 = new WaterPoint();
		waterPoint1.setWaterFunctioning("yes");
		WaterPoint waterPoint2 = new WaterPoint();
		waterPoint2.setWaterFunctioning("yes");
		WaterPoint waterPoint3 = new WaterPoint();
		waterPoint3.setWaterFunctioning("yes");
		WaterPoint waterPoint4 = new WaterPoint();
		waterPoint4.setWaterFunctioning("no");
		
		List<WaterPoint> waterPoints = new ArrayList<WaterPoint>();
		waterPoints.add(waterPoint1);
		waterPoints.add(waterPoint2);
		waterPoints.add(waterPoint3);
		waterPoints.add(waterPoint4);
		
		community.setWaterPoints(waterPoints);
		community.setBrokenWaterPoints(1);
		
		assertEquals(community.getFunctionalPoints(), 3);
	}

	@Test
	public void testGetBrokenWaterPointsPercentage(){
		Community community = new Community();
		community.setName("Test Commuity");
		
		WaterPoint waterPoint1 = new WaterPoint();
		waterPoint1.setWaterFunctioning("yes");
		WaterPoint waterPoint2 = new WaterPoint();
		waterPoint2.setWaterFunctioning("yes");
		WaterPoint waterPoint3 = new WaterPoint();
		waterPoint3.setWaterFunctioning("yes");
		WaterPoint waterPoint4 = new WaterPoint();
		waterPoint4.setWaterFunctioning("no");
		
		List<WaterPoint> waterPoints = new ArrayList<WaterPoint>();
		waterPoints.add(waterPoint1);
		waterPoints.add(waterPoint2);
		waterPoints.add(waterPoint3);
		waterPoints.add(waterPoint4);
		
		community.setWaterPoints(waterPoints);
		community.setBrokenWaterPoints(1);
		
		assertEquals(community.getBrokenWaterPointsPercentage(), Float.valueOf(25));
	}

}
