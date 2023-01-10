package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static pl.rozekm.vmacademy.junitparameterizedtests.domain.VehicleCondition.NEW;

import lombok.Data;
import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongMileageException;

@Data
public class Car {

	private String manufacturer;
	private String model;
	private Integer power;
	private List<Equipment> equipment;
	private BigDecimal price;
	private VehicleCondition vehicleCondition;
	private BigDecimal mileage;

	public Car(VehicleCondition vehicleCondition) {
		this.vehicleCondition = vehicleCondition;
	}

	public Car(VehicleCondition vehicleCondition, BigDecimal price) {
		this.vehicleCondition = vehicleCondition;
		this.price = price;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = formatEntry(manufacturer);
	}

	public void setMileage(BigDecimal mileage) {
		this.mileage = validateMileage(this, mileage);
	}

	private BigDecimal validateMileage(Car car, BigDecimal mileage) {
		if (Objects.equals(NEW, car.getVehicleCondition()) && !BigDecimal.ZERO.equals(mileage)) {
			throw new WrongMileageException(mileage);
		}
		return mileage;
	}

	public void setModel(String model) {
		this.model = formatEntry(model);
	}

	public String formatEntry(String entry) {
		return entry.substring(0, 1).toUpperCase() + entry.substring(1).toLowerCase();
	}
}
