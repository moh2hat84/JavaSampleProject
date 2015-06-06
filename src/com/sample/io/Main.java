package com.sample.io;


public class Main {
	
	private static final String URL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";

	public static void main(String[] args){
		Service service = new Service();
		WaterPointStatistics statistics = service.calculate(URL);
		System.out.println(statistics);
	}
}
