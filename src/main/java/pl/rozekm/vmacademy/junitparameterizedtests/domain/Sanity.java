package pl.rozekm.vmacademy.junitparameterizedtests.domain;

import java.math.BigDecimal;
import java.util.EnumMap;

import lombok.Data;

@Data
public class Sanity {

	private EnumMap<VehicleCondition, BigDecimal> conditionPriceMap;

	public Sanity() {
		conditionPriceMap = new EnumMap<>(VehicleCondition.class);
		conditionPriceMap.put(VehicleCondition.NEW, BigDecimal.valueOf(100000));
		conditionPriceMap.put(VehicleCondition.USED, BigDecimal.valueOf(20000));
		conditionPriceMap.put(VehicleCondition.ANTIQUE, BigDecimal.valueOf(50000));
		conditionPriceMap.put(VehicleCondition.DEMONSTRATION, BigDecimal.valueOf(80000));
	}
}
