package com.almundo.test.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import com.almundo.test.model.Director;
import com.almundo.test.model.Employee;
import com.almundo.test.model.Operator;
import com.almundo.test.model.Supervisor;

public class EmployeeManager {
	
	private static final Logger logger =  Logger.getLogger(EmployeeManager.class.getName());
	
	private ConcurrentHashMap<String, Employee> employees;
	
	/**
	 * @returns an available employee taking into account the priority: Operators, Supervisors and Directors 
	 */
	public synchronized Employee getAvailableEmployee() {
		Employee result = null;
		result = employees.searchValues(1, v -> v.getClass().getName()==Operator.class.getName()
				&& v.isAvailable()? v: null);
		if(result == null){
			result = employees.searchValues(1, v -> v.getClass().getName()==Supervisor.class.getName()
					&& v.isAvailable()? v: null);
		}
		if(result == null){
			result = employees.searchValues(1, v -> v.getClass().getName()==Director.class.getName()
					&& v.isAvailable()? v: null);
		}
		
		if(result != null){
			result.setAvailable(false);
		}
		
		return result;
	}

	public ConcurrentHashMap<String, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ConcurrentHashMap<String, Employee> employees) {
		this.employees = employees;
	}
	
	
}
