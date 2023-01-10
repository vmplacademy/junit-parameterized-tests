package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.NEW;

class Example1SetManufacturerTest {

	private final String EXPECTED_MANUFACTURER = "Koperek";

	@Test
	void setManufacturerTest1() {
		Car car = new Car(NEW);
		car.setManufacturer("Koperek");

		assertThat(car.getManufacturer(), is(EXPECTED_MANUFACTURER));
	}

	@Test
	void setManufacturerTest2() {
		Car car = new Car(NEW);
		car.setManufacturer("KOPEREK");

		assertThat(car.getManufacturer(), is(EXPECTED_MANUFACTURER));
	}

	@Test
	void setManufacturerTest3() {
		Car car = new Car(NEW);
		car.setManufacturer("koperek");

		assertThat(car.getManufacturer(), is(EXPECTED_MANUFACTURER));
	}
}
