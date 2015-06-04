package com.sample.io;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {

	private Map<String, CommunityWaterPoints> communityWaterPointsMap = new HashMap<String, CommunityWaterPoints>();
	
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
	
	public Map<String, CommunityWaterPoints> getInfrastructureResources(List<WaterPoint> waterPoints){
		
		for(WaterPoint waterPoint : waterPoints) {
			String key = waterPoint.getCommunitiesVillages();
			
			if (communityWaterPointsMap.containsKey(key)) {
				
				CommunityWaterPoints communityWaterPoints = communityWaterPointsMap.get(key);
				communityWaterPoints.getWaterPoints().add(waterPoint);
				boolean waterPointIsFunctional = waterPointIsFunctional(waterPoint);
				communityWaterPoints.setFunctionalWaterPoints(communityWaterPoints.getFunctionalWaterPoints() + (waterPointIsFunctional ? 1 : 0));
				
			}else {
				CommunityWaterPoints communityWaterPoints = new CommunityWaterPoints();
				communityWaterPoints.setCumunityName(key);
				communityWaterPoints.getWaterPoints().add(waterPoint);
				boolean waterPointIsFunctional = waterPointIsFunctional(waterPoint);
				communityWaterPoints.setFunctionalWaterPoints(communityWaterPoints.getFunctionalWaterPoints() + (waterPointIsFunctional ? 1 : 0));
				communityWaterPointsMap.put(key, communityWaterPoints);
				
			}
		}
		
		return communityWaterPointsMap;
	}
	
	public boolean waterPointIsFunctional(WaterPoint waterPoint){
		return waterPoint.getWaterFunctioning().equalsIgnoreCase("yes"); // Yes / No values expected
	}
	
	public Map<String, CommunityWaterPoints> getCommunityWaterPointsMap() {
		return communityWaterPointsMap;
	}

	public void setCommunityWaterPointsMap(Map<String, CommunityWaterPoints> communityWaterPointsMap) {
		this.communityWaterPointsMap = communityWaterPointsMap;
	}
	
}
