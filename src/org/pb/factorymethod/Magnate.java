package org.pb.factorymethod;

public class Magnate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new BenzDriver();
		Car car = driver.driverCar();
		car.driver();
	}
}
