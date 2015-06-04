package com.sample.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterPoint {

	@JsonProperty("water_pay")
	private String waterPay;
	
	@JsonProperty("respondent")
	private String respondent;
	
	@JsonProperty("research_asst_name")
	private String researchAssistantName;
	
	@JsonProperty("water_source_type")
	private String waterSourceType;
	
	@JsonProperty("water_used_season")
	private String waterUsedSeason;
	
	@JsonProperty("_xform_id_string")
	private String xformIdString;
	
	@JsonProperty("_bamboo_dataset_id")
	private String bambooDatasetId;
	
	@JsonProperty("communities_villages")
	private String communitiesVillages;
	
	@JsonProperty("water_functioning")
	private String waterFunctioning;

	public String getWaterPay() {
		return waterPay;
	}

	public void setWaterPay(String waterPay) {
		this.waterPay = waterPay;
	}

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	public String getResearchAssistantName() {
		return researchAssistantName;
	}

	public void setResearchAssistantName(String researchAssistantName) {
		this.researchAssistantName = researchAssistantName;
	}

	public String getWaterSourceType() {
		return waterSourceType;
	}

	public void setWaterSourceType(String waterSourceType) {
		this.waterSourceType = waterSourceType;
	}

	public String getWaterUsedSeason() {
		return waterUsedSeason;
	}

	public void setWaterUsedSeason(String waterUsedSeason) {
		this.waterUsedSeason = waterUsedSeason;
	}

	public String getXformIdString() {
		return xformIdString;
	}

	public void setXformIdString(String xformIdString) {
		this.xformIdString = xformIdString;
	}

	public String getBambooDatasetId() {
		return bambooDatasetId;
	}

	public void setBambooDatasetId(String bambooDatasetId) {
		this.bambooDatasetId = bambooDatasetId;
	}

	public String getCommunitiesVillages() {
		return communitiesVillages;
	}

	public void setCommunitiesVillages(String communitiesVillages) {
		this.communitiesVillages = communitiesVillages;
	}

	public String getWaterFunctioning() {
		return waterFunctioning;
	}

	public void setWaterFunctioning(String waterFunctioning) {
		this.waterFunctioning = waterFunctioning;
	}
	
}
