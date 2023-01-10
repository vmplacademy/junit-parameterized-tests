package pl.rozekm.vmacademy.junitparameterizedtests.backup;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import pl.rozekm.vmacademy.junitparameterizedtests.domain.Car;
import pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition;
import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongMileageException;

class Example3SetMileageTest {

	private static final BigDecimal MILEAGE_NOT_ZERO = BigDecimal.valueOf(255658.4);

	@ParameterizedTest
	@EnumSource(
			value = VehicleCondition.class,
			mode = EnumSource.Mode.EXCLUDE,
			names = { "NEW" })
	void setMileage_success(VehicleCondition vehicleCondition) {
		Car car = new Car(vehicleCondition);

		car.setMileage(MILEAGE_NOT_ZERO);

		assertThat(car.getMileage(), is(MILEAGE_NOT_ZERO));
	}

	@ParameterizedTest
	@EnumSource(
			value = VehicleCondition.class,
			mode = EnumSource.Mode.INCLUDE,
			names = { "NEW" })
	void setMileage_failure(VehicleCondition vehicleCondition) {
		Car car = new Car(vehicleCondition);

		WrongMileageException error = assertThrows(WrongMileageException.class,
												   () -> car.setMileage(MILEAGE_NOT_ZERO));
		assertThat(error.getMessage(), is("wrong mileage given: '255658.400000'"));
	}
}
