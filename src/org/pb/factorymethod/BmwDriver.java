package org.pb.factorymethod;

public class BmwDriver implements Driver {

	@Override
	public Car driverCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
