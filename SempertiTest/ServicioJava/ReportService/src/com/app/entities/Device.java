/**
 * 
 */
package com.app.entities;

import com.app.runtime.IExecutor;
import com.app.service.HandlerSocket;

/**
 * @author Marcos
 * 
 * clase abstracta de ella heredan CentralProcessingUnit , Memory.java, SystemGeneral
 * contiene las propiedades necesarias para trabajar con los datos del sistema y 
 * la comunicacion con el servidor para reportarlas
 *
 */
public abstract class Device implements Runnable {
	
	private IExecutor executor;
	
	private HandlerSocket handlerSocket;
	
	public IExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(IExecutor executor) {
		this.executor = executor;
	}

	public HandlerSocket getHandlerSocket() {
		return handlerSocket;
	}

	public void setHandlerSocket(HandlerSocket handlerSocket) {
		this.handlerSocket = handlerSocket;
	}
	
	public void beginHandshake(String message , String event){
		getHandlerSocket().connect();
		getHandlerSocket().setSentMessage(message);
		getHandlerSocket().setEvent(event);
		getHandlerSocket().establishCommunication();
	};

}
