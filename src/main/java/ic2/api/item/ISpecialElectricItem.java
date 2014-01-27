package ic2.api.item;

import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ISpecialElectricItem extends IElectricItem {
	/**
	 * Supply a custom IElectricItemManager.
	 *
	 * @param itemStack ItemStack to get the manager for
	 * @return IElectricItemManager instance
	 */
	@NotNull
	IElectricItemManager getManager(ItemStack itemStack);
}
