package com.ioc.domains;

public class Office {

	private String officNo="001";
	@Override
	public String toString(){		
		return "officNo:"+officNo;
	}
	public String getOfficNo() {
		return officNo;
	}
	public void setOfficNo(String officNo) {
		this.officNo = officNo;
	}
}
