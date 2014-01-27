package pixlepix.minechem.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.common.ModMinechem;
import pixlepix.minechem.common.utils.ConstantValue;

public class ItemTestTube extends Item {

	public ItemTestTube(int id) {
		super(id);
		setUnlocalizedName("minechem.itemTestTube");
		setCreativeTab(ModMinechem.minechemTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(@NotNull IconRegister ir) {
		itemIcon = ir.registerIcon(ConstantValue.TESTTUBE_TEX);
	}

}
