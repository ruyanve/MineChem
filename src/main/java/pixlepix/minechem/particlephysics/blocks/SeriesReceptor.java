package pixlepix.minechem.particlephysics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import pixlepix.minechem.common.MinechemBlocks;
import pixlepix.minechem.particlephysics.helper.BasicComplexBlock;
import pixlepix.minechem.particlephysics.tile.SeriesReceptorTileEntity;

import java.util.ArrayList;

public class SeriesReceptor extends BasicComplexBlock {

	public SeriesReceptor() {
		super(MinechemBlocks.seriesReceptorID);
	}

	public SeriesReceptor(int i) {
		super(i);
	}

	@Override
	public void addStacksDroppedOnBlockBreak(TileEntity tileEntity, ArrayList<ItemStack> itemStacks) {

	}

	@Override
	public String getFront() {
		// TODO Auto-generated method stub
		return "SeriesReceptor";
	}

	@Override
	public boolean hasModel() {
		return true;
	}

	@Override
	public String getTop() {
		// TODO Auto-generated method stub
		return "SeriesReceptorTop";
	}

	@Override
	public Class getTileEntityClass() {
		return SeriesReceptorTileEntity.class;
	}

	@Override
	public void addRecipe() {
		GameRegistry.addRecipe(new ItemStack(this), "III", "D  ", "III", 'I', new ItemStack(Item.ingotIron), 'D', new ItemStack(Item.diamond));

	}

	@Override
	public String getName() {
		return "Series Receptor";
	}

	@Override
	public boolean hasItemBlock() {
		return true;
	}

	@Override
	public Class getItemBlock() {
		return null;

	}

	@Override
	public boolean topSidedTextures() {
		return true;
	}

}
