package pixlepix.minechem.particlephysics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.particlephysics.api.BaseParticle;
import pixlepix.minechem.particlephysics.api.IParticleBouncer;
import pixlepix.minechem.particlephysics.helper.BasicComplexBlock;

import java.util.ArrayList;
import java.util.List;

public class ControlGlass extends BasicComplexBlock implements IParticleBouncer {

	public ControlGlass() {
		super(1181);
	}

	public ControlGlass(int i) {
		super(i);
	}

	@Override
	public void addStacksDroppedOnBlockBreak(TileEntity tileEntity, ArrayList<ItemStack> itemStacks) {

	}

	@NotNull
	@Override
	public String getFront() {
		// TODO Auto-generated method stub
		return "ControlGlass";
	}

	@Override
	public boolean hasModel() {
		return true;
	}

	@NotNull
	@Override
	public String getTop() {
		// TODO Auto-generated method stub
		return "ControlGlass";
	}

	@Override
	public boolean isBlockNormalCube(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public void addCollisionBoxesToList(@NotNull World par1World, int par2, int par3, int par4, @NotNull AxisAlignedBB par5AxisAlignedBB, @NotNull List par6List, Entity par7Entity) {
		if (par7Entity instanceof BaseParticle && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			return;
		}
		AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);

		if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
			par6List.add(axisalignedbb1);
		}
	}

	@Nullable
	@Override
	public Class getTileEntityClass() {
		return null;
	}

	@Override
	public void addRecipe() {
		GameRegistry.addRecipe(new ItemStack(this), "R R", " G ", "R R", 'R', new ItemStack(Item.redstone), 'G', new ItemStack(Block.glass));

	}

	@NotNull
	@Override
	public String getName() {
		return "Control Glass";
	}

	@Override
	public boolean hasItemBlock() {
		return false;
	}

	@Nullable
	@Override
	public Class getItemBlock() {
		return null;

	}

	@Override
	public boolean topSidedTextures() {
		return false;
	}

	@Override
	public boolean canBounce(@NotNull World world, int x, int y, int z,
	                         BaseParticle particle) {
		return !(world.isBlockIndirectlyGettingPowered(x, y, z));
	}

}
