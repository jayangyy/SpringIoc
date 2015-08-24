package com.ioc.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("Offic1")
public class Offic1  extends TestGenic<Offic1>  {
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
