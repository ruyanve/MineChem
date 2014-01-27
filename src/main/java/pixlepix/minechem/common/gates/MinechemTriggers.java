package pixlepix.minechem.common.gates;

import org.jetbrains.annotations.NotNull;

public class MinechemTriggers {

	@NotNull
	public static MinechemTrigger fullEnergy = new TriggerFullEnergy(191);
	@NotNull
	public static MinechemTrigger noTestTubes = new TriggerNoTestTubes(192);
	@NotNull
	public static MinechemTrigger outputJammed = new TriggerOutputJammed(193);

}
