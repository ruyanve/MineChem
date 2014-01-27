package pixlepix.minechem.client.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import org.jetbrains.annotations.NotNull;

public class NEIMinechemConfig implements IConfigureNEI {

	@NotNull
	@Override
	public String getName() {
		return "MineChem NEI Plugin";
	}

	@Override
	public String getVersion() {
		return "test-1";
	}

	@Override
	public void loadConfig() {
		DecomposerNEIRecipeHandler decomposerRecipeHandler =
				new DecomposerNEIRecipeHandler();
		API.registerRecipeHandler(decomposerRecipeHandler);
		API.registerUsageHandler(decomposerRecipeHandler);

		SynthesisNEIRecipeHandler synthesisRecipeHandler =
				new SynthesisNEIRecipeHandler();
		API.registerRecipeHandler(synthesisRecipeHandler);
		API.registerUsageHandler(synthesisRecipeHandler);
	}

}
