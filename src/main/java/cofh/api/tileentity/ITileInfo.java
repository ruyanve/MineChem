package cofh.api.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Implement this interface on Tile Entities which can send state information through chat.
 *
 * @author Zeldo Kavira
 */
public interface ITileInfo {

	@NotNull
	public List<String> getTileInfo();

	public void sendTileInfoToPlayer(EntityPlayer player);

}
