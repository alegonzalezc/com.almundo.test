package com.almundo.test.enums;

public enum CallState {
	
	NEW ( "new" ),
	ACTIVE ( "active" ),
	ENDED ( "ended" ),
	;
	
	private String code;
	
	private CallState(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
