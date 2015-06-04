package com.sample.io;

import java.util.List;
import java.util.Map;

public class Main {
	
	private static final String URL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";

	public static void main(String[] args){
		Service service = new Service();
		List<WaterPoint> waterPoints = service.readInputStream(URL);
		System.out.println(waterPoints.size());
		Map<String, CommunityWaterPoints> waterPointsMap = service.getInfrastructureResources(waterPoints);
		service.getWaterPointsStatistics(waterPointsMap);
	}
}
