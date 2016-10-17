package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import com.app.util.StringConstant;
import com.google.gson.Gson;

public class CentralProcessingUnit extends Device implements Runnable {

	@Override
	public void run() {

		List<Feature> featureList = new ArrayList<Feature>();
		Gson json = new Gson();
		while (true) {
			try {
				String command = StringConstant.CPU_FEATURES_COMMAND;
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
				String event = StringConstant.CPU_EVENT_DYM;
				beginHandshake(jsonFeatures, event);
				featureList.clear();
				Thread.sleep(1000);
				
				
				resultList = getExecutor().runCommand("tasklist");
				resultList.remove(1);
				resultList.remove(0);
				String procesos = json.toJson(resultList);
				String cpuEventStc = StringConstant.CPU_EVENT_STC;
				beginHandshake(procesos, cpuEventStc);
				featureList.clear();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
