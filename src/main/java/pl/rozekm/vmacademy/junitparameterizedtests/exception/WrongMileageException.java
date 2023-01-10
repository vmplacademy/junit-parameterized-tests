package pl.rozekm.vmacademy.junitparameterizedtests.exception;

import java.math.BigDecimal;

public class WrongMileageException extends IllegalArgumentException {

	public WrongMileageException(BigDecimal mileage) {
		super(String.format("wrong mileage given: '%f'", mileage));
	}
}
