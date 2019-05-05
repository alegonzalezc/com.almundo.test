package com.almundo.test.service;

import java.util.concurrent.CopyOnWriteArrayList;

import com.almundo.test.model.Call;
import com.almundo.test.model.Employee;

public class Dispatcher {
	
	private CopyOnWriteArrayList<Call> historyCalls;
	private CopyOnWriteArrayList<Call> pendingCalls;
	private EmployeeManager empManager;
	
	public Dispatcher(EmployeeManager empManager) {
		this.empManager = empManager;
		this.historyCalls = new CopyOnWriteArrayList<Call>();
		this.pendingCalls = new CopyOnWriteArrayList<Call>();
	}
	
	public void dispatchCall(String origin) {
		Employee emp = empManager.getAvailableEmployee();
		
		if(emp != null) {
			Call call = new Call(origin, emp);
			call.startCall();
			historyCalls.add(call);
		}else {
			pendingCalls.add(new Call(origin, null));
		}
	}

	public EmployeeManager getEmpManager() {
		return empManager;
	}

	public void setEmpManager(EmployeeManager empManager) {
		this.empManager = empManager;
	}

	public CopyOnWriteArrayList<Call> getHistoryCalls() {
		return historyCalls;
	}

	public void setHistoryCalls(CopyOnWriteArrayList<Call> historyCalls) {
		this.historyCalls = historyCalls;
	}

	public CopyOnWriteArrayList<Call> getPendingCalls() {
		return pendingCalls;
	}

	public void setPendingCalls(CopyOnWriteArrayList<Call> pendingCalls) {
		this.pendingCalls = pendingCalls;
	}
	

}
