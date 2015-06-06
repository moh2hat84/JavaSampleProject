package com.sample.io;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {
	
	public List<WaterPoint> readInputStream(String urlString){
		List<WaterPoint> response = null;
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();    
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false); 
			
			URL url = new URL(urlString);
			response = mapper.readValue(url, mapper.getTypeFactory().constructCollectionType(List.class, WaterPoint.class));
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public List<Community> getInfrastructureResources(List<WaterPoint> waterPoints){
		List<Community> communities = new ArrayList<Community>();
		Map<String, Community> communityWaterPointsMap = new HashMap<String, Community>();
		
		for(WaterPoint waterPoint : waterPoints) {
			String key = waterPoint.getCommunitiesVillages();
			
			if (communityWaterPointsMap.containsKey(key)) {
				
				Community community = communityWaterPointsMap.get(key);
				community.addWaterPoint(waterPoint);
				
			}else {
				
				Community community = new Community();
				community.setName(key);
				community.addWaterPoint(waterPoint);
				communityWaterPointsMap.put(key, community);
				
			}
		}
		
		communities.addAll(communityWaterPointsMap.values());
		// sort the communities based on broken water points
		Collections.sort(communities);
		
		return communities;
	}
	
	public WaterPointStatistics getWaterPointsStatistics(List<Community> waterPointsList){
		
		WaterPointStatistics waterPointStatistics = new WaterPointStatistics();
		
		int functionalWaterPoints = 0;
		Map<String, Integer> numberOfWaterPointsPerCommunity = new HashMap<String, Integer>();
		List<Community> communityRanking = new ArrayList<Community>();
		
		for (Community community : waterPointsList) {
			functionalWaterPoints += community.getFunctionalPoints();
			numberOfWaterPointsPerCommunity.put(community.getName(), community.getWaterPoints().size());
			communityRanking.add(community);
			
			//System.out.println(community.getName() + " : " + community.getBrokenWaterPointsPercentage() + "%" );
		}
		
		waterPointStatistics.setFunctionalWaterPoints(functionalWaterPoints);
		waterPointStatistics.setNumberOfWaterPointsPerCommunity(numberOfWaterPointsPerCommunity);
		waterPointStatistics.setCommunityRanking(communityRanking);
		
		return waterPointStatistics;
	}
	
	public static boolean waterPointIsBroken(WaterPoint waterPoint){
		return !waterPoint.getWaterFunctioning().equalsIgnoreCase("yes"); // Yes / No values expected
	}
	
}
