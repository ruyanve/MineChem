package pixlepix.minechem.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.common.MinechemItems;
import pixlepix.minechem.common.ModMinechem;
import pixlepix.minechem.common.blueprint.MinechemBlueprint;
import pixlepix.minechem.common.utils.ConstantValue;
import pixlepix.minechem.common.utils.MinechemHelper;

import java.util.List;

public class ItemBlueprint extends Item {

	public static final String[] names = { "item.name.blueprintFusion", "item.name.blueprintFission" };

	public ItemBlueprint(int id) {
		super(id);
		setUnlocalizedName("minechem.itemBlueprint");
		setCreativeTab(ModMinechem.minechemTab);
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(@NotNull IconRegister ir) {
		itemIcon = ir.registerIcon(ConstantValue.BLUEPRINT_TEX);
	}

	@NotNull
	public static ItemStack createItemStackFromBlueprint(@NotNull MinechemBlueprint blueprint) {
		return new ItemStack(MinechemItems.blueprint, 1, blueprint.id);
	}

	public MinechemBlueprint getBlueprint(@NotNull ItemStack itemstack) {
		int metadata = itemstack.getItemDamage();
		return MinechemBlueprint.blueprints.get(metadata);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(@NotNull ItemStack itemstack, EntityPlayer entityPlayer, @NotNull List list, boolean par4) {
		MinechemBlueprint blueprint = getBlueprint(itemstack);
		if (blueprint != null) {
			String dimensions = String.format("%d x %d x %d", blueprint.xSize, blueprint.ySize, blueprint.zSize);
			list.add(dimensions);
		}
	}

	@NotNull
	@Override
	public String getUnlocalizedName(@NotNull ItemStack itemstack) {
		return getUnlocalizedName() + "." + names[itemstack.getItemDamage()];
	}

	@Override
	public String getItemDisplayName(@NotNull ItemStack itemstack) {
		int metadata = itemstack.getItemDamage();
		return MinechemHelper.getLocalString(names[metadata]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTabs, @NotNull List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}

}
