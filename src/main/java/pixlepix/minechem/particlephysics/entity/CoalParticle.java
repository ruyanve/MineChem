package pixlepix.minechem.particlephysics.entity;

import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.particlephysics.api.BaseParticle;

public class CoalParticle extends BaseParticle {

	public CoalParticle(World par1World) {
		super(par1World);
	}

	@Override
	public float getStartingPotential() {
		// TODO Auto-generated method stub
		return 4000;
	}

	@Override
	public void onEntityUpdate() {

		super.onEntityUpdate();
	}

	@NotNull
	@Override
	public String getName() {
		return "Coal";
	}

	@Override
	public void onCollideWithParticle(BaseParticle particle) {
	}

}
