package com.almundo.test.model;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.almundo.test.enums.CallState;


public class CallTest {
	
	private static final Logger logger =  Logger.getLogger(CallTest.class.getName());

	@Test
	public void testCallLifeSpan() {
		Call call = new Call("127.0.0.1", new Operator("1032452063", "Alexander", 3452));
		
		call.startCall();
		
		assertTrue(call.getState()==CallState.ACTIVE);
		
		try {
			TimeUnit.SECONDS.sleep(call.getLifeSpan()+1);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Exception occur", e);
		}
		assertTrue(call.getState()==CallState.ENDED);
		
	}

}
