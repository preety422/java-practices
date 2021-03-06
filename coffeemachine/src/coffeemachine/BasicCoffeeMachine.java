package coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class BasicCoffeeMachine implements CoffeeMachine{

	private Map<CoffeeSelection, Configuration> configMap;
	private Map<CoffeeSelection, GroundCoffee> coffeeBean;
	private BrewingUnit brewingUnit;

	public BasicCoffeeMachine(Map<CoffeeSelection, GroundCoffee> coffee) {
		this.coffeeBean = coffee;
		this.brewingUnit = new BrewingUnit();

		this.configMap = new HashMap<>();
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
	}

	public Coffee brewCoffee(CoffeeSelection selection) {
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

		// get the coffee
		GroundCoffee CoffeeBean = this.coffeeBean.get(CoffeeSelection.FILTER_COFFEE);

		// brew a filter coffee
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, CoffeeBean, config.getQuantityWater());
	}

	public void addCoffeeBean(CoffeeSelection sel, GroundCoffee newCoffee) throws CoffeeException {
		GroundCoffee existingCoffee = this.coffeeBean.get(sel);
		if (existingCoffee != null) {
			if (existingCoffee.getName().equals(newCoffee.getName())) {
				existingCoffee.setQuantity(existingCoffee.getQuantity() + newCoffee.getQuantity());
			} else {
				throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
			}
		} else {
			this.coffeeBean.put(sel, newCoffee);
		}
	}
}