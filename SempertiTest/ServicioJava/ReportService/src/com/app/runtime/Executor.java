package com.app.runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.util.StringConstant;

/**
 * 
 * @author Marcos
 *
 * devuelve una lista con los resultados de la ejecucion de comandos nativos
 * del sistema operativo. dicha lista sera manipulada para ser enviada como 
 * informacion al servidor
 *
 */

public class Executor implements IExecutor {

	private Runtime runtime;
	private Process process;
	private InputStreamReader inputStreamReader;
	private BufferedReader buffer;

	@Override
	public List<String> runCommand(String command) {

		List<String> resultList = new ArrayList<String>();
		String line = null;

		try {
			runtime = Runtime.getRuntime();
			String[] commandLine = { "cmd.exe", "/c", command };
			process = runtime.exec(commandLine);
			inputStreamReader = new InputStreamReader(process.getInputStream());
			buffer = new BufferedReader(inputStreamReader);
			while ((line = buffer.readLine()) != null) {
				if (!line.equals(StringConstant.EMPTY)) {
					resultList.add(line.trim());
				};
			}
		} catch (Exception e) {
			e.printStackTrace();
		};
		return resultList;
	}

}
