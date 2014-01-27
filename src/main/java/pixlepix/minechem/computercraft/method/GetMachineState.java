package pixlepix.minechem.computercraft.method;

import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.computercraft.ICCMethod;
import pixlepix.minechem.computercraft.IMinechemMachinePeripheral;

public class GetMachineState extends InteractMachine implements ICCMethod {

	@NotNull
	@Override
	public String getMethodName() {
		return "getMachineState";
	}

	@Nullable
	@Override
	public Object[] call(IComputerAccess computer, ITurtleAccess turtle, Object[] arguments) throws Exception {
		IMinechemMachinePeripheral machine = getMachineInFront(turtle);
		String result = null;
		if (machine != null) {
			result = machine.getMachineState();
		}
		return new Object[]{ result };
	}

}
