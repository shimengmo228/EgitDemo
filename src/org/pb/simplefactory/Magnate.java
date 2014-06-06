package org.pb.simplefactory;

import org.pb.factorymethod.Car;

public class Magnate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Car car = Driver.driverCar("bmw");
			car.driver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
