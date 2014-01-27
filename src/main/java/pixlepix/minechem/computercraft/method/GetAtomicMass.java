package pixlepix.minechem.computercraft.method;

import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.api.core.EnumElement;
import pixlepix.minechem.api.util.Util;
import pixlepix.minechem.common.items.ItemElement;
import pixlepix.minechem.computercraft.ICCMethod;

public class GetAtomicMass implements ICCMethod {

	@NotNull
	@Override
	public String getMethodName() {
		return "getAtomicMass";
	}

	@Nullable
	@Override
	public Object[] call(IComputerAccess computer, @NotNull ITurtleAccess turtle, @NotNull Object[] arguments) throws Exception {
		if (arguments.length == 1) {
			return getAtomicMassFromString(arguments[0]);
		} else {
			return getAtomicMassFromSlot(turtle.getSelectedSlot(), turtle);
		}
	}

	@Nullable
	private Object[] getAtomicMassFromString(Object object) throws Exception {
		if (object instanceof String) {
			String query = (String) object;
			EnumElement element = EnumElement.valueOf(query);
			if (element != null)
				return new Object[]{ element.atomicNumber() };
		} else {
			throw new Exception("Argument must be String");
		}
		return null;
	}

	@Nullable
	private Object[] getAtomicMassFromSlot(int selectedSlot, @NotNull ITurtleAccess turtle) {
		ItemStack selectedStack = turtle.getSlotContents(selectedSlot);
		if (selectedStack != null && Util.isStackAnElement(selectedStack)) {
			EnumElement element = ItemElement.getElement(selectedStack);
			return new Object[]{ element.atomicNumber() };
		}
		return null;
	}

}
