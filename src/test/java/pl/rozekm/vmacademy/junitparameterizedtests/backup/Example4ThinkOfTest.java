package pl.rozekm.vmacademy.junitparameterizedtests.backup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.Customer.PRICE_OK;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.Customer.PRICE_TOO_HIGH;

import pl.rozekm.vmacademy.junitparameterizedtests.domain.Car;
import pl.rozekm.vmacademy.junitparameterizedtests.domain.Customer;
import pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition;

class Example4ThinkOfTest {

	Customer customer = new Customer();

	@Test
	void thinkOf_priceOk() {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(VehicleCondition.NEW, BigDecimal.valueOf(95000)));
		cars.add(new Car(VehicleCondition.USED, BigDecimal.valueOf(14000)));
		cars.add(new Car(VehicleCondition.DEMONSTRATION, BigDecimal.valueOf(67000)));
		cars.add(new Car(VehicleCondition.ANTIQUE, BigDecimal.valueOf(49500)));

		cars.forEach(car -> {
			String result = customer.thinkOf(car);
			assertThat(result, is(PRICE_OK));
		});
	}

	@Test
	void thinkOf_priceTooHigh() {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(VehicleCondition.NEW, BigDecimal.valueOf(112000)));
		cars.add(new Car(VehicleCondition.USED, BigDecimal.valueOf(95000)));
		cars.add(new Car(VehicleCondition.DEMONSTRATION, BigDecimal.valueOf(95000)));
		cars.add(new Car(VehicleCondition.ANTIQUE, BigDecimal.valueOf(95000)));

		cars.forEach(car -> {
			String result = customer.thinkOf(car);
			assertThat(result, is(PRICE_TOO_HIGH));
		});
	}

	@ParameterizedTest
	@CsvSource(value = {
			"NEW, 95000",
			"USED, 14000",
			"DEMONSTRATION, 67000",
			"ANTIQUE, 49500" })
	void thinkOf_priceOk_Param(VehicleCondition vehicleCondition, BigDecimal price) {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(vehicleCondition, price));

		cars.forEach(car -> {
			String result = customer.thinkOf(car);
			assertThat(result, is(PRICE_OK));
		});
	}

	private static Stream<Arguments> dreamCars() {
		return Stream.of(
				Arguments.of(VehicleCondition.NEW, BigDecimal.valueOf(112000)),
				Arguments.of(VehicleCondition.USED, BigDecimal.valueOf(27000)),
				Arguments.of(VehicleCondition.DEMONSTRATION, BigDecimal.valueOf(83000)),
				Arguments.of(VehicleCondition.ANTIQUE, BigDecimal.valueOf(54000))
		);
	}

	@ParameterizedTest
	@MethodSource("dreamCars")
	void thinkOf_priceTooHigh(VehicleCondition vehicleCondition, BigDecimal price) {
		String result = customer.thinkOf(new Car(vehicleCondition, price));
		assertThat(result, is(PRICE_TOO_HIGH));
	}
}
