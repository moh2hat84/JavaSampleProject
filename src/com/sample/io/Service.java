package com.sample.io;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
				boolean waterPointIsBroken = waterPointIsBroken(waterPoint);
				communityWaterPoints.setBrokenWaterPoints(communityWaterPoints.getBrokenWaterPoints() + (waterPointIsBroken ? 1 : 0));
				
			}else {
				
				CommunityWaterPoints communityWaterPoints = new CommunityWaterPoints();
				communityWaterPoints.setCumunityName(key);
				communityWaterPoints.getWaterPoints().add(waterPoint);
				boolean waterPointIsBroken = waterPointIsBroken(waterPoint);
				communityWaterPoints.setBrokenWaterPoints(communityWaterPoints.getBrokenWaterPoints() + (waterPointIsBroken ? 1 : 0));
				communityWaterPointsMap.put(key, communityWaterPoints);
				
			}
		}
		
		return communityWaterPointsMap;
	}
	
	public WaterPointStatistics getWaterPointsStatistics(Map<String, CommunityWaterPoints> waterPointsMap){
		
		WaterPointStatistics waterPointStatistics = new WaterPointStatistics();
		
		int functionalWaterPoints = 0;
		Map<String, Integer> numberOfWaterPointsPerCommunity = new HashMap<String, Integer>();
		Map<String, String> communityRanking = new HashMap<String, String>();
		
		Collection<CommunityWaterPoints> wps = waterPointsMap.values();
		List<CommunityWaterPoints> list = new ArrayList<CommunityWaterPoints>(wps);
		Collections.sort(list);
		
		for (CommunityWaterPoints entry : list) {
			CommunityWaterPoints communityWaterPoints = waterPointsMap.get(entry.getCumunityName());
			
			functionalWaterPoints += communityWaterPoints.getFunctionalPoints();
			numberOfWaterPointsPerCommunity.put(communityWaterPoints.getCumunityName(), communityWaterPoints.getWaterPoints().size());
			communityRanking.put(communityWaterPoints.getCumunityName(), communityWaterPoints.getBrokenWaterPointsPercentage() + " %" );
			
			System.out.println(communityWaterPoints.getCumunityName() + " : " + communityWaterPoints.getBrokenWaterPointsPercentage() + "%" );
		}
		
		waterPointStatistics.setFunctionalWaterPoints(functionalWaterPoints);
		waterPointStatistics.setNumberOfWaterPointsPerCommunity(numberOfWaterPointsPerCommunity);
		waterPointStatistics.setCommunityRanking(communityRanking);
		
		return waterPointStatistics;
	}
	
	public boolean waterPointIsBroken(WaterPoint waterPoint){
		return !waterPoint.getWaterFunctioning().equalsIgnoreCase("yes"); // Yes / No values expected
	}
	
	public Map<String, CommunityWaterPoints> getCommunityWaterPointsMap() {
		return communityWaterPointsMap;
	}

	public void setCommunityWaterPointsMap(Map<String, CommunityWaterPoints> communityWaterPointsMap) {
		this.communityWaterPointsMap = communityWaterPointsMap;
	}
	
}
