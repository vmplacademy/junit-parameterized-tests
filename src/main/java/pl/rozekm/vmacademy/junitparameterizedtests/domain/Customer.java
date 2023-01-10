package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;

public class Customer {

	public static final String PRICE_OK = "Great offer! The price is OK";
	public static final String PRICE_TOO_HIGH = "I still have some of my sanity! The price is too high!";

	private final Sanity sanity = new Sanity();

	public String thinkOf(Car dreamCar) {
		BigDecimal sanePrice = sanity.getConditionPriceMap().get(dreamCar.getVehicleCondition());

		if (dreamCar.getPrice().compareTo(sanePrice) > 0) {
			return PRICE_TOO_HIGH;
		}
		return PRICE_OK;
	}
}
