package com.sample.io;

import java.util.ArrayList;
import java.util.List;

public class Community implements Comparable<Community>{

	private String name;
	private List<WaterPoint> waterPoints = new ArrayList<WaterPoint>();
	private int brokenWaterPoints = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WaterPoint> getWaterPoints() {
		return waterPoints;
	}

	public void setWaterPoints(List<WaterPoint> waterPoints) {
		this.waterPoints = waterPoints;
	}

	public int getBrokenWaterPoints() {
		return brokenWaterPoints;
	}

	public void setBrokenWaterPoints(int brokenWaterPoints) {
		this.brokenWaterPoints = brokenWaterPoints;
	}

	@Override
	public int compareTo(Community community) {
		return Float.valueOf(community.getBrokenWaterPointsPercentage()).compareTo(Float.valueOf(this.getBrokenWaterPointsPercentage()));
	}

	public int getFunctionalPoints() {
		return getWaterPoints().size() - getBrokenWaterPoints();
	}

	public Float getBrokenWaterPointsPercentage() {
		float value =  ((float)getBrokenWaterPoints() * 100) / getWaterPoints().size();
		return Float.valueOf(String.format("%.2f", value)); // round up to 2 dp
	}
	
}
