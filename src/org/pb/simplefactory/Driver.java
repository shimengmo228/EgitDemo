package org.pb.simplefactory;

import org.pb.factorymethod.Benz;
import org.pb.factorymethod.Bmw;
import org.pb.factorymethod.Car;

public class Driver {
	public static Car driverCar(String s) throws Exception {
		if (s.equalsIgnoreCase("Benz")) {
			return new Benz();
		} else if (s.equalsIgnoreCase("Bmw")) {
			return new Bmw();
		} else {
			throw new Exception("no this type of car");
		}
	}
}
