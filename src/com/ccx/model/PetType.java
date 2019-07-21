package com.ccx.model;

public class PetType {
	private int id;
	private String petTypeName;
	
	
	@Override
	public String toString() {
		return petTypeName;
	}
	/**
	 * @param id
	 * @param petTypeName
	 */
	public PetType(int id, String petTypeName) {
		super();
		this.id = id;
		this.petTypeName = petTypeName;
	}
	/**
	 * @param petTypeNameString
	 */
	public PetType(String petTypeName) {
		super();
		this.petTypeName = petTypeName;
	}
	public PetType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetTypeName() {
		return petTypeName;
	}
	public void setPetTypeName(String petTypeName) {
		this.petTypeName = petTypeName;
	}
	
}
