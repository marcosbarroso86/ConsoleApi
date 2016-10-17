package com.app.service;

import com.app.entities.CentralProcessingUnit;
import com.app.entities.Device;
import com.app.entities.Memory;
import com.app.entities.SystemGeneral;
import com.app.runtime.Executor;

public class Service {
		
	public static void main(String[] args) {
	
		try {
			//se crean los objetos que representaran los componentes	
			Device centraProcessingUnit = new CentralProcessingUnit();
			Device memory = new Memory();
			Device systemGral = new SystemGeneral();
			
			//se le asigna un executor y un handler de socket
			centraProcessingUnit.setExecutor(new Executor());
			centraProcessingUnit.setHandlerSocket(new HandlerSocket());
			memory.setHandlerSocket(new HandlerSocket());
			memory.setExecutor(new Executor());
			systemGral.setExecutor(new Executor());
			systemGral.setHandlerSocket(new HandlerSocket());
			
			//creamos hilos para cada uno  asi trabajan de forma paralela
			Thread systemThread = new Thread(systemGral);
			Thread cpuThread = new Thread(centraProcessingUnit);
			Thread memoryThread = new Thread(memory);
			
			//iniciamos los hilos
			cpuThread.start();
			memoryThread.start();
			systemThread.start();
			
			
		} catch (Exception e) {
			System.out.println("Ocurrio un error en el inicio del servicio " + e.getMessage());
		}
			
	}

}
