package com.almundo.test.model;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.almundo.test.enums.CallState;

public class Call {
	
	private static final Logger logger =  Logger.getLogger(Call.class.getName());
	
	private static final Random r = new Random();
	
	private Employee employee;
	private String origin;
	private long lifeSpan;
	private CallState state;
	
	public Call(String origin, Employee employee) {
		this.origin = origin;
		this.employee = employee;
		this.state = CallState.NEW;
	}
	
	public void startCall(){
		this.lifeSpan = r.nextInt(5+1)+5;
		this.state = CallState.ACTIVE;
		
		CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(this.lifeSpan);
				this.endCall();
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Exception occur", e);
			}
		});
	}
	
	private void endCall(){
		this.state = CallState.ENDED;
		this.employee.setAvailable(true);
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public long getLifeSpan() {
		return lifeSpan;
	}
	public void setLifeSpan(long lifeSpan) {
		this.lifeSpan = lifeSpan;
	}
	public CallState getState() {
		return state;
	}
	public void setState(CallState state) {
		this.state = state;
	}
	

}
