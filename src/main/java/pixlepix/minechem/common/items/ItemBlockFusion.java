package pixlepix.minechem.common.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemBlockFusion extends ItemBlock {

	private static final String[] names = { "Fusion Wall", "Tungsten Plating", "Fusion Core" };

	public ItemBlockFusion(int par1) {
		super(par1);
		setHasSubtypes(true);
		setUnlocalizedName("minechem.itemBlockFusion");
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@NotNull
	@Override
	public String getUnlocalizedName(@NotNull ItemStack itemstack) {
		return super.getUnlocalizedName(itemstack) + names[itemstack.getItemDamage()];
	}

	@Override
	public String getItemDisplayName(@NotNull ItemStack itemstack) {
		return names[itemstack.getItemDamage()];
	}

}
