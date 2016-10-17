package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import com.app.util.StringConstant;
import com.google.gson.Gson;

public class SystemGeneral extends Device {
	
	@Override
	public void run() {
		List<Feature> featureList = new ArrayList<Feature>();
		Gson json = new Gson();
		while (true) {
			try {
				String command = StringConstant.SYSTEM_GRAL_COMMAND;
				List<String> resultList = getExecutor().runCommand(command);
				for (String feaure : resultList) {
					String[] split = feaure.split("=");
					if(split.length > 1){
						String description = split[0];
						String value = split[1];
						featureList.add(new Feature(description, value));
					}					
				}				
				String jsonFeatures = json.toJson(featureList);
				String event = StringConstant.GENERAL_EVENT;
				beginHandshake(jsonFeatures, event);
				featureList.clear();
				Thread.sleep(1000);				
				featureList.clear();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
		
	}

}
