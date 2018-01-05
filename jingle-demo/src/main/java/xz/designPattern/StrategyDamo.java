package xz.designPattern;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2017/2/15.
 */
public class StrategyDamo {
	public static void main(String a[]) {
		ShippingInfo shippingInfo = new ShippingInfo();
		shippingInfo.CalculateShippingAmount(State.Alaska);
	}
	
}

enum State {
	Alaska,
	NewYork,
	Florida
}

class ShippingInfo {
	private Map<State,IShippingCalculation> ShippingCalculations;
	
	public ShippingInfo() {
		ShippingCalculations = new HashMap<>();
		ShippingCalculations.put(State.Alaska, new AlaskShippingCalculation());
		ShippingCalculations.put(State.NewYork, new NewYorkShippingCalculation());
		ShippingCalculations.put(State.Florida, new FloridaShippingCalculation());
	}
	
	public int CalculateShippingAmount(State shipToState) {
		return ShippingCalculations.get(shipToState).Calculate();
	}
}

interface IShippingCalculation {
	int Calculate();
}

class AlaskShippingCalculation implements IShippingCalculation {
	public int Calculate() {
		return 15;
	}
}

class NewYorkShippingCalculation implements IShippingCalculation {
	public int Calculate() {
		return 10;
	}
}

class FloridaShippingCalculation implements IShippingCalculation {
	public int Calculate() {
		return 3;
	}
}
