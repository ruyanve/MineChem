package pixlepix.minechem.fluid;

import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface IMinechemFluid {

	@NotNull
	public ItemStack getOutputStack();

}
