package org.pb.factorymethod;

public class BenzDriver implements Driver {

	@Override
	public Car driverCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}
}
