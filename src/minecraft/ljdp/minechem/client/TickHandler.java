package ljdp.minechem.client;

import java.util.EnumSet;
import java.util.List;

import ljdp.minechem.api.core.EnumMolecule;
import ljdp.minechem.common.MinechemBlocks;
import ljdp.minechem.common.MinechemItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements ITickHandler {
	public void transmuteWaterToPortal(World world, int dx, int dy, int dz)
	  {
	    int px = dx;
	    int pz = dz;

	    if (world.getBlockMaterial(px - 1, dy, pz) == Material.water)
	    {
	      px--;
	    }
	    if (world.getBlockMaterial(px, dy, pz - 1) == Material.water)
	    {
	      pz--;
	    }

	    world.setBlock(px + 0, dy, pz + 0, 1, 0, 2);
	  }
    @Override
    public void tickStart(EnumSet type, Object[] tickData)
    {
    	  Minecraft mc = FMLClientHandler.instance().getClient();
    	  if(mc.isSingleplayer()){
      EntityPlayer player = mc.thePlayer;
      World world = mc.theWorld;
      if(player != null){
    	  if(world != null){
    			  
    		  }
    		  double rangeToCheck = 32.0D;

    	        List<EntityItem> itemList = world.getEntitiesWithinAABB(EntityItem.class, player.boundingBox.expand(rangeToCheck, rangeToCheck, rangeToCheck));
    	        for(EntityItem entityItem : itemList){
    	          if ((entityItem.getEntityItem().itemID == new ItemStack(MinechemItems.element, 1, EnumMolecule.potassiumNitrate.ordinal()).itemID && (world.isMaterialInBB(entityItem.boundingBox, Material.water))))
    	          {
    	           world.createExplosion(entityItem, entityItem.posX, entityItem.posY, entityItem.posZ, 0.9F, true);
    	           int dx = MathHelper.floor_double(entityItem.posX);
    	           int dy = MathHelper.floor_double(entityItem.posY);
    	           int dz = MathHelper.floor_double(entityItem.posZ);
    	           transmuteWaterToPortal(world, dx, dy, dz);
    	           return;
    	          }
    	  }}
      }
    	  }
        
      
    


    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if (type.contains(TickType.RENDER))
            renderOverlays((Float) tickData[0]);
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
    }

    @Override
    public String getLabel() {
        return null;
    }

    private void renderOverlays(float parialTickTime) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc.renderViewEntity != null && mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping()
                && mc.thePlayer.isInsideOfMaterial(MinechemBlocks.materialGas)) {
            
        }
    }

    /**
     * Renders a texture that warps around based on the direction the player is looking. Texture needs to be bound before being called. Used for the water
     * overlay. Args: parialTickTime
     */
    

}
