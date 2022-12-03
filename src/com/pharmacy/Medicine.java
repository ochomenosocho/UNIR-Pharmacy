package com.pharmacy;

public class Medicine {
	private String name = "";
	private String type = "";
	private int amount = 0;
	private String distributor = "";
	private String branchOffice = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	public String getBranchOffice() {
		return branchOffice;
	}
	public void setBranchOffice(String branchOffice) {
		this.branchOffice = branchOffice;
	}
	
}
