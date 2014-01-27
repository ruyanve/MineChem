package pixlepix.minechem.common.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.common.MinechemItems;

public class SlotFakeChemical extends SlotFake {

	public SlotFakeChemical(IInventory iInventory, int id, int x, int y) {
		super(iInventory, id, x, y);
	}

	@Override
	public boolean isItemValid(@NotNull ItemStack itemStack) {
		return itemStack.itemID == MinechemItems.element.itemID || itemStack.itemID == MinechemItems.molecule.itemID;
	}

}
