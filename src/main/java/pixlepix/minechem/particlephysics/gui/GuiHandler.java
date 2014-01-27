package pixlepix.minechem.particlephysics.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.particlephysics.ParticlePhysics;
import pixlepix.minechem.particlephysics.tile.EmitterTileEntity;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(ParticlePhysics.instance, this);
	}

	@Nullable
	@Override
	public Object getServerGuiElement(int ID, @NotNull EntityPlayer player, @NotNull World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				return new ContainerEmitter(player.inventory, (EmitterTileEntity) world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

	@Nullable
	@Override
	public Object getClientGuiElement(int ID, @NotNull EntityPlayer player, @NotNull World world,
	                                  int x, int y, int z) {
		switch (ID) {
			case 0:
				return new GuiEmitter(player.inventory, (EmitterTileEntity) world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

}
