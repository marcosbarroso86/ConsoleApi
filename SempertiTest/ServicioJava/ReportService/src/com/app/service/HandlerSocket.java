package com.app.service;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


/**
 * 
 * @author Marcos
 *
 * clase encargada de escuchar y enviar mensaje por medio 
 * de eventos con el servidor
 */

public class HandlerSocket {
	
	private String sentMessage;
	private String receivedMessage;
	private Socket socket;
	private String event;
		
	public void connect (){
		try {
			socket = IO.socket("http://localhost:3000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public void establishCommunication(){
						
		try {
			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
			  @Override
			  public void call(Object... args) {
				socket.emit(getEvent(), getSentMessage());
			    socket.disconnect();
			  }
			}).on(getEvent(), new Emitter.Listener() {
			  @Override
			  public void call(Object... args) {
				 setReceivedMessage((String) args[0]);				 
			  }
			}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

			  @Override
			  public void call(Object... args) {}

			});
			socket.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public String getSentMessage() {
		return sentMessage;
	}

	public void setSentMessage(String sentMessage) {
		this.sentMessage = sentMessage;
	}

	public String getReceivedMessage() {
		return receivedMessage;
	}

	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}		
	
	
	

}
