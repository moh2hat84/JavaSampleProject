package com.sample.io;

import java.util.ArrayList;
import java.util.List;

public class CommunityWaterPoints{

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
	
}
