package com.sample.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterPointStatistics {
	
	private int functionalWaterPoints;
	private Map<String, Integer> numberOfWaterPointsPerCommunity = new HashMap<String, Integer>();
	private List<Community> communityRanking = new ArrayList<Community>();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The number of water points that are functional : " + functionalWaterPoints + "\n");
		sb.append("The number of water points per community : \n");
		
		for (Map.Entry<String, Integer> entry : numberOfWaterPointsPerCommunity.entrySet()) {
			String community = entry.getKey();
			Integer numberOfWaterPoints = entry.getValue();
			sb.append("\t" + community +" : " + String.valueOf(numberOfWaterPoints) + "\n");
		}
		
		sb.append("The rank for each community by the percentage of broken water points: \n");
		for (Community community : communityRanking) {
			String percentageOfBrokenWaterPoints = community.getBrokenWaterPointsPercentage().toString();
			sb.append("\t" + community.getName() +" : " + percentageOfBrokenWaterPoints + "\n");
		}
		
		return sb.toString();
	}
	
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
	
	public List<Community> getCommunityRanking() {
		return communityRanking;
	}
	
	public void setCommunityRanking(List<Community> communityRanking) {
		this.communityRanking = communityRanking;
	}
	
}
