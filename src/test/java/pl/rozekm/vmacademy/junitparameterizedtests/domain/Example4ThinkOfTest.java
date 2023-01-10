package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.Customer.PRICE_OK;
import static pl.rozekm.vmacademy.junitparameterizedtests.domain.Customer.PRICE_TOO_HIGH;

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
}
