package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.ANTIQUE;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.DEMONSTRATION;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.NEW;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.USED;

import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongMileageException;

class Example3SetMileageTest {

	private static final BigDecimal MILEAGE_ZERO = BigDecimal.ZERO;
	private static final BigDecimal MILEAGE_NOT_ZERO = BigDecimal.valueOf(255658.4);

	@Test
	void setMileageNEW_success() {
		Car car = new Car(NEW);

		car.setMileage(MILEAGE_ZERO);

		assertThat(car.getMileage(), is(MILEAGE_ZERO));
	}

	@Test
	void setMileageNEW_failure() {
		Car car = new Car(NEW);

		WrongMileageException error = assertThrows(WrongMileageException.class,
												   () -> car.setMileage(MILEAGE_NOT_ZERO));
		assertThat(error.getMessage(), is("wrong mileage given: '255658.400000'"));
	}

	@Test
	void setMileageUSED_success() {
		Car car = new Car(USED);

		car.setMileage(MILEAGE_NOT_ZERO);

		assertThat(car.getMileage(), is(MILEAGE_NOT_ZERO));
	}

	@Test
	void setMileageDEMONSTRATION_success() {
		Car car = new Car(DEMONSTRATION);

		car.setMileage(MILEAGE_NOT_ZERO);

		assertThat(car.getMileage(), is(MILEAGE_NOT_ZERO));
	}

	@Test
	void setMileageANTIQUE_success() {
		Car car = new Car(ANTIQUE);

		car.setMileage(MILEAGE_NOT_ZERO);

		assertThat(car.getMileage(), is(MILEAGE_NOT_ZERO));
	}
}
