package pl.rozekm.vmacademy.junitparameterizedtests.backup;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import pl.rozekm.vmacademy.junitparameterizedtests.domain.Equipment;
import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongEquipmentNameException;

class EquipmentTest {

	@ParameterizedTest
	@ValueSource(strings = {" Air Condition"})
//	@NullSource
//	@EmptySource
	@NullAndEmptySource
	void givenNameValidated3_throwsException(String givenName) {

		WrongEquipmentNameException error = assertThrows(WrongEquipmentNameException.class,
														 () -> new Equipment(givenName, BigDecimal.valueOf(49.99)));
		assertThat(error.getMessage(), is("wrong equipment name given: '" + givenName + "'"));
	}
}
