package pixlepix.minechem.particlephysics.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.particlephysics.ParticlePhysics;
import pixlepix.minechem.particlephysics.blocks.*;

import java.util.ArrayList;

public class BetterLoader {

	@NotNull
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	@NotNull
	public static ArrayList<Class> classes = new ArrayList<Class>();

	public void populateClasses() {

		classes.add(Emitter.class);

		classes.add(InfiniteEmitter.class);

		classes.add(PolarizedGlass.class);

		classes.add(SeriesReceptor.class);

		classes.add(ControlGlass.class);

	}

	public void loadBlocks() {

		populateClasses();

		try {
			for (int i = 0; i < classes.size(); i++) {

				Class currentClass = classes.get(i);
				Class clazz = (Class<Block>) currentClass;
				Block newBlock = ((Block) clazz.newInstance()).setHardness(0.5F).setStepSound(Block.soundAnvilFootstep);
				if (((IBlock) newBlock).inCreativeTab()) {
					newBlock.setCreativeTab(ParticlePhysics.creativeTab);
				}
				blocks.add(newBlock);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Nullable
	public static Block getBlock(@NotNull Class clazz) {

		for (int i = 0; i < blocks.size(); i++) {

			Block currentBlock = blocks.get(i);

			if (clazz.isInstance(currentBlock)) {
				return currentBlock;
			}
		}
		System.out.println("Failed to find block in BetterLoader. Crash incoming.");
		return null;
	}

	public void mainload() {
		for (int i = 0; i < blocks.size(); i++) {

			Block currentBlock = blocks.get(i);
			if (currentBlock instanceof IBlock) {
				IBlock currentIBlock = (IBlock) currentBlock;
				LanguageRegistry.addName(currentBlock, currentIBlock.getName());
				MinecraftForge.setBlockHarvestLevel(currentBlock, "pickaxe", 0);
				if (currentIBlock.getItemBlock() != null) {
					GameRegistry.registerBlock(currentBlock, currentIBlock.getItemBlock(), currentIBlock.getName());
				} else {
					GameRegistry.registerBlock(currentBlock, currentIBlock.getName());
				}
				currentIBlock.addRecipe();

				GameRegistry.registerTileEntity(currentIBlock.getTileEntityClass(), currentIBlock.getName() + "Minechem Tile Entity");
			}

		}
	}

}
