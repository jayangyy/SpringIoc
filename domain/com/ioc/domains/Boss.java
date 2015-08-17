package com.ioc.domains;

import org.springframework.beans.factory.annotation.Autowired;

public class Boss {
	 private Car car;
		@Autowired
	    private Office office;

	    // Ê¡ÂÔ get/setter

	    @Override
	    public String toString() {
	        return "car:" + car + "\n" + "office:" + office;
	    }

		public Car getCar() {
			return car;
		}
		@Autowired
		public void setCar(Car car) {
			this.car = car;
		}

		public Office getOffice() {
			return office;
		}

		public void setOffice(Office office) {
			this.office = office;
		}
}
