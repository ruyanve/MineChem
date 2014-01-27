package pixlepix.minechem.api.core;

import org.jetbrains.annotations.NotNull;

public class Mineral extends Chemical {
	public EnumMineral mineral;

	public Mineral(EnumMineral mineral, int amount) {
		super(amount);
		this.mineral = mineral;
	}

	@NotNull
	@Override
	public Chemical copy() {
		return new Mineral(mineral, amount);
	}

	;

	public Mineral(EnumMineral mineral) {
		super(1);
		this.mineral = mineral;
	}

	@Override
	public boolean sameAs(Chemical chemical) {
		return chemical instanceof Mineral
				&& ((Mineral) chemical).mineral == mineral;
	}

}
