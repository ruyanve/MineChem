package pixlepix.minechem.api.util;

import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Util {

	public static boolean stacksAreSameKind(@NotNull ItemStack is1, @NotNull ItemStack is2) {
		int dmg1 = is1.getItemDamage();
		int dmg2 = is2.getItemDamage();
		return is1.itemID == is2.itemID && (dmg1 == -1 || dmg2 == -1 || (dmg1 == dmg2));
	}

	public static boolean isStackAChemical(@NotNull ItemStack itemstack) {
		return itemstack.toString().contains("minechem.itemElement") || itemstack.toString().contains("minechem.itemMolecule");
	}

	public static boolean isStackAnElement(@NotNull ItemStack itemstack) {
		return itemstack.toString().contains("minechem.itemElement");
	}

	public static boolean isStackAMolecule(@NotNull ItemStack itemstack) {
		return itemstack.toString().contains("minechem.itemMolecule");
	}

	public static boolean isStackAnEmptyTestTube(@NotNull ItemStack itemstack) {
		return itemstack.toString().contains("minechem.itemTestTube");
	}

}
