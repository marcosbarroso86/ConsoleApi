package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import com.app.util.StringConstant;
import com.google.gson.Gson;

/**
 * 
 * 
 * @author Marcos
 *
 * este objeto se encargara de procesar la informacion con respecto
 * a la memoria ram del sistema
 *
 */


public class Memory extends Device implements Runnable {

	@Override
	public void run() {
		List<Feature> featureList = new ArrayList<Feature>();
		Gson json = new Gson();
		while (true) {
			try {
				String command = StringConstant.MEMORY_FEATURES_COMMAND;
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
				String event = StringConstant.MEMORY_EVENT;
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
