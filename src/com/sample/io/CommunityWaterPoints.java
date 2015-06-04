package com.sample.io;

import java.util.ArrayList;
import java.util.List;

public class CommunityWaterPoints implements Comparable<CommunityWaterPoints>{

	private String cumunityName;
	private List<WaterPoint> waterPoints = new ArrayList<WaterPoint>();
	private int brokenWaterPoints = 0;
	
	public String getCumunityName() {
		return cumunityName;
	}
	
	public void setCumunityName(String cumunityName) {
		this.cumunityName = cumunityName;
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
	public int compareTo(CommunityWaterPoints comunityWaterPoints) {
		return Float.valueOf(comunityWaterPoints.getBrokenWaterPointsPercentage()).compareTo(Float.valueOf(this.getBrokenWaterPointsPercentage()));
	}

	public int getFunctionalPoints() {
		return getWaterPoints().size() - getBrokenWaterPoints();
	}

	public Float getBrokenWaterPointsPercentage() {
		float value =  ((float)getBrokenWaterPoints() * 100) / getWaterPoints().size();
		return Float.valueOf(String.format("%.2f", value)); // round up to 2 dp
	}
	
}
