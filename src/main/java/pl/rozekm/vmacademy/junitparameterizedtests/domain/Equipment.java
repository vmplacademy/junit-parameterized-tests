package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import pl.rozekm.vmacademy.junitparameterizedtests.exception.WrongEquipmentNameException;

@Data
public class Equipment {
	private String name;
	private BigDecimal price;

	public Equipment(String name, BigDecimal price) {
		this.name = validateName(name);
		this.price = price;
	}

	public String validateName(String name) {
		if (StringUtils.isBlank(name) || name.startsWith(" ") || name.endsWith(" ")) {
			throw new WrongEquipmentNameException(name);
		}
		return name;
	}
}
