package com.almundo.test.service;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.almundo.test.model.Director;
import com.almundo.test.model.Employee;
import com.almundo.test.model.Operator;
import com.almundo.test.model.Supervisor;

public class EmployeeManagerTest {

	@Test
	public void testGetAvailableEmployee() {
		EmployeeManager manager = new EmployeeManager();
		ConcurrentHashMap<String, Employee> employees = new ConcurrentHashMap<String, Employee>();
		
		for (int i=0; i<10; i++) {
			String id = i+"";
			employees.put(id, new Operator(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		manager.setEmployees(employees);
		assertNotNull("Searching at least one available operator", manager.getAvailableEmployee());
		
		
		employees.forEach( (k,v) -> {
			v.setAvailable(false);
		});
		assertNull("No available operator employees", manager.getAvailableEmployee());
		
		
		for (int i=10; i<20; i++) {
			String id = i+"";
			employees.put(id, new Supervisor(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		assertNotNull("Searching at least one available supervisor", manager.getAvailableEmployee());
		
		
		employees.forEach( (k,v) -> {
			v.setAvailable(false);
		});
		assertNull("No available supervisor employees", manager.getAvailableEmployee());
		
		
		for (int i=20; i<30; i++) {
			String id = i+"";
			employees.put(id, new Director(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		assertNotNull("Searching at least one available director", manager.getAvailableEmployee());
		
		
		employees.forEach( (k,v) -> {
			v.setAvailable(false);
		});
		assertNull("No available director employees", manager.getAvailableEmployee());
	}

}
