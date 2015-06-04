package com.sample.io;

import java.util.HashMap;
import java.util.Map;

public class WaterPointStatistics {
	
	private int functionalWaterPoints;
	private Map<String, Integer> numberOfWaterPointsPerCommunity = new HashMap<String, Integer>();
	private Map<String, String> communityRanking = new HashMap<String, String>();
	
	public int getFunctionalWaterPoints() {
		return functionalWaterPoints;
	}
	
	public void setFunctionalWaterPoints(int functionalWaterPoints) {
		this.functionalWaterPoints = functionalWaterPoints;
	}
	
	public Map<String, Integer> getNumberOfWaterPointsPerCommunity() {
		return numberOfWaterPointsPerCommunity;
	}
	
	public void setNumberOfWaterPointsPerCommunity(
			Map<String, Integer> numberOfWaterPointsPerCommunity) {
		this.numberOfWaterPointsPerCommunity = numberOfWaterPointsPerCommunity;
	}
	
	public Map<String, String> getCommunityRanking() {
		return communityRanking;
	}
	
	public void setCommunityRanking(Map<String, String> communityRanking) {
		this.communityRanking = communityRanking;
	}
	
}
