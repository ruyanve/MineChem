package pixlepix.minechem.computercraft;

import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ICCMethod {

	@NotNull
	public String getMethodName();

	@Nullable
	public Object[] call(IComputerAccess computer, ITurtleAccess turtle, Object[] arguments) throws Exception;

}
