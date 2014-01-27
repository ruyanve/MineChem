package cofh.api.tileentity;

import net.minecraft.util.Icon;
import org.jetbrains.annotations.NotNull;

/**
 * Implement this interface on Tile Entities which can change their block's texture based on the current render pass. The block must defer the call to its Tile
 * Entity.
 *
 * @author Zeldo Kavira
 */
public interface ISidedBlockTexture {

	@NotNull
	public Icon getBlockTexture(int side, int pass);

}
