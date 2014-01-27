package pixlepix.minechem.particlephysics.helper;

import net.minecraft.tileentity.TileEntity;
import org.jetbrains.annotations.Nullable;

public interface IBlock {

	@Nullable
	public Class<TileEntity> getTileEntityClass();

	public void addRecipe();

	public String getName();

	public boolean hasItemBlock();

	@Nullable
	public Class getItemBlock();

	public boolean inCreativeTab();

}
