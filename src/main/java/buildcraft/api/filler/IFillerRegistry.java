package buildcraft.api.filler;

import net.minecraft.inventory.IInventory;
import org.jetbrains.annotations.NotNull;

public interface IFillerRegistry {

	public void addRecipe(IFillerPattern pattern, Object aobj[]);

	@NotNull
	public IFillerPattern findMatchingRecipe(IInventory inventorycrafting);

	public int getPatternNumber(IFillerPattern pattern);

	public IFillerPattern getPattern(int n);

}
