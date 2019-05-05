package com.almundo.test.model;

public abstract class Employee {
	
	private String id;
	private String name;
	private int extensionNumber;
	private boolean available;
	
	public Employee(String id, String name, int ext) {
		this.id = id;
		this.name = name;
		this.extensionNumber = ext;
		this.available = true;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExtensionNumber() {
		return extensionNumber;
	}
	public void setExtensionNumber(int extensionNumber) {
		this.extensionNumber = extensionNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
