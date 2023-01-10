package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongEquipmentNameException;

class Example2NewEquipmentTest {

	@Test
	void givenNameValidated1_throwsException() {
		WrongEquipmentNameException error = assertThrows(WrongEquipmentNameException.class,
														 () -> new Equipment(" Air Condition", BigDecimal.valueOf(49.99)));
		assertThat(error.getMessage(), is("wrong equipment name given: ' Air Condition'"));
	}

	@Test
	void givenNameValidated2_throwsException() {
		WrongEquipmentNameException error = assertThrows(WrongEquipmentNameException.class,
														 () -> new Equipment(" ", BigDecimal.valueOf(49.99)));
		assertThat(error.getMessage(), is("wrong equipment name given: ' '"));
	}

	@Test
	void givenNameValidated3_throwsException() {

		WrongEquipmentNameException error = assertThrows(WrongEquipmentNameException.class,
														 () -> new Equipment(null, BigDecimal.valueOf(49.99)));
		assertThat(error.getMessage(), is("wrong equipment name given: 'null'"));
	}
}
