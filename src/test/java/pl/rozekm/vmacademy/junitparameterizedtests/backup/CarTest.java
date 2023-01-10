package pl.rozekm.vmacademy.junitparameterizedtests.backup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.NEW;

import pl.rozekm.vmacademy.junitparameterizedtests.domain.Car;

class CarTest {

	private final String EXPECTED_MANUFACTURER = "Koperek";

	@ParameterizedTest
	@ValueSource(strings = { "Koperek", "KOPEREK", "koperek" })
	void setManufacturerParam(String manufacturer) {
		Car car = new Car(NEW);
		car.setManufacturer(manufacturer);

		assertThat(car.getManufacturer(), is(EXPECTED_MANUFACTURER));
	}
}
