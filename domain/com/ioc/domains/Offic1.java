package com.ioc.domains;

import org.springframework.stereotype.Component;

@Component
public class Offic1 {
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
