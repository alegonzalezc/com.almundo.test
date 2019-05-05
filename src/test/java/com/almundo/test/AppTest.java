package com.almundo.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

import org.junit.Test;

import com.almundo.test.model.Director;
import com.almundo.test.model.Employee;
import com.almundo.test.model.Operator;
import com.almundo.test.model.Supervisor;
import com.almundo.test.service.Dispatcher;
import com.almundo.test.service.EmployeeManager;


public class AppTest{
	
	private static final Logger logger =  Logger.getLogger(AppTest.class.getName());
	
	@Test
	public void appTest() {
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
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		int numThreads = 10 ;
		
		for (int i = 0; i < numThreads; i++)
		{	
			String origin = "127.0.0."+i;
			executor.execute(()->{
				dispatcher.dispatchCall(origin);
			});
        }
		executor.shutdown();
		
		assertTrue(true);
		
	}
	
}
