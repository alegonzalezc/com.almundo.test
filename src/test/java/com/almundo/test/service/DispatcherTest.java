package com.almundo.test.service;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.almundo.test.model.Director;
import com.almundo.test.model.Employee;
import com.almundo.test.model.Operator;
import com.almundo.test.model.Supervisor;

public class DispatcherTest {

	@Test
	public void testDispatchCall() {
		EmployeeManager manager = new EmployeeManager();
		Dispatcher dispatcher = new Dispatcher(manager);
		ConcurrentHashMap<String, Employee> employees = new ConcurrentHashMap<String, Employee>();
		manager.setEmployees(employees);
		
		for (int i=0; i<10; i++) {
			String id = i+"";
			employees.put(id, new Operator(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		for (int i=10; i<14; i++) {
			String id = i+"";
			employees.put(id, new Supervisor(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		for (int i=14; i<16; i++) {
			String id = i+"";
			employees.put(id, new Director(id, "Alex_"+i, Integer.valueOf("53"+i)));
		}
		
		String origin = "127.0.0.1";
		dispatcher.dispatchCall(origin);
		
		assertNotNull(dispatcher.getHistoryCalls().get(0));
	}

}
