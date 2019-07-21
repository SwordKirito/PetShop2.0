package com.ccx.model;

public class Pet {
	private int id;
	private String petName;
	private int petTypeId;
	private String petColor;
	
	
	
	
	/**
	 * @param petName
	 * @param petTypeId
	 * @param petColor
	 */
	public Pet(String petName, int petTypeId, String petColor) {
		super();
		this.petName = petName;
		this.petTypeId = petTypeId;
		this.petColor = petColor;
	}
	/**
	 * @param id
	 * @param petName
	 * @param petTypeId
	 * @param petColor
	 */
	public Pet(int id, String petName, int petTypeId, String petColor) {
		super();
		this.id = id;
		this.petName = petName;
		this.petTypeId = petTypeId;
		this.petColor = petColor;
	}
	/**
	 * 
	 */
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetColor() {
		return petColor;
	}
	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}
	public int getPetTypeId() {
		return petTypeId;
	}
	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}
	
}
