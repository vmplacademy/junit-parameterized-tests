package pl.rozekm.vmacademy.junitparameterizedtests.exception;

public class WrongEquipmentNameException extends IllegalArgumentException {

	public WrongEquipmentNameException(String wrongName) {
		super(String.format("wrong equipment name given: '%s'", wrongName));
	}
}
