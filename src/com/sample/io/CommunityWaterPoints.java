package com.sample.io;

import java.util.ArrayList;
import java.util.List;

public class CommunityWaterPoints implements Comparable<CommunityWaterPoints>{

	private String cumunityName;
	private List<WaterPoint> waterPoints = new ArrayList<WaterPoint>();
	private int functionalWaterPoints = 0;
	
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

	public int getFunctionalWaterPoints() {
		return functionalWaterPoints;
	}
	
	public void setFunctionalWaterPoints(int functionalWaterPoints) {
		this.functionalWaterPoints = functionalWaterPoints;
	}
	
	@Override
	public int compareTo(CommunityWaterPoints comunityWaterPoints) {
		return Integer.valueOf(comunityWaterPoints.getFunctionalWaterPoints()).compareTo(Integer.valueOf(this.getFunctionalWaterPoints()));
	}
	
}
