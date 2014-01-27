package pixlepix.minechem.computercraft.method;

import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.computercraft.ChemistryTurtleUpgradePeripherial;
import pixlepix.minechem.computercraft.ICCMethod;
import pixlepix.minechem.computercraft.IMinechemTurtlePeripheral;

public class ClearSynthesisRecipe implements ICCMethod {

	@NotNull
	@Override
	public String getMethodName() {
		return "clearSynthesisRecipe";
	}

	@Nullable
	@Override
	public Object[] call(IComputerAccess computer, ITurtleAccess turtle, Object[] arguments) throws Exception {
		IMinechemTurtlePeripheral peripheral = ChemistryTurtleUpgradePeripherial.getMinechemPeripheral(turtle);
		peripheral.setSynthesisRecipe(null);
		return null;
	}

}
