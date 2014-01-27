package pixlepix.minechem.common.recipe.handlers;

import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.api.core.Chemical;
import pixlepix.minechem.api.core.EnumMolecule;
import pixlepix.minechem.api.core.Molecule;
import pixlepix.minechem.api.recipe.DecomposerRecipe;
import pixlepix.minechem.api.recipe.SynthesisRecipe;
import pixlepix.minechem.common.ModMinechem;
import pixlepix.minechem.common.recipe.OreDictionaryHandler;

public class AppliedEnergisticsOreDictionaryHandler implements
		OreDictionaryHandler {

	@NotNull
	private EnumMolecule certusQuartzMolecule = EnumMolecule.aluminiumPhosphate;

	@NotNull
	private Chemical certusQuartzChemical = new Molecule(certusQuartzMolecule);

	@NotNull
	private Chemical[] certusQuartzDecompositionFormula = new Chemical[]{ new Molecule(
			certusQuartzMolecule, 4) };

	@NotNull
	private Chemical[] certusQuartzCrystalSynthesisFormula = new Chemical[]{
			null, certusQuartzChemical, null, certusQuartzChemical, null,
			certusQuartzChemical, null, certusQuartzChemical, null };

	@NotNull
	private Chemical[] certusQuartzDustSynthesisFormula = new Chemical[]{
			null, certusQuartzChemical, null, certusQuartzChemical,
			certusQuartzChemical, certusQuartzChemical, null, null, null };

	@Override
	public boolean canHandle(@NotNull OreRegisterEvent oreEvent) {
		return oreEvent.Name.endsWith("CertusQuartz");
	}

	@Override
	public void handle(@NotNull OreRegisterEvent oreEvent) {
		if (oreEvent.Name.equals("dustCertusQuartz")) {
			DecomposerRecipe.add(new DecomposerRecipe(oreEvent.Ore,
					certusQuartzDecompositionFormula));
			SynthesisRecipe.add(new SynthesisRecipe(oreEvent.Ore, true,
					30000, certusQuartzDustSynthesisFormula));
			// }
		} else if (oreEvent.Name.equals("crystalCertusQuartz")) {
			DecomposerRecipe.add(new DecomposerRecipe(oreEvent.Ore,
					certusQuartzDecompositionFormula));
			SynthesisRecipe.add(new SynthesisRecipe(oreEvent.Ore, true,
					30000, certusQuartzCrystalSynthesisFormula));
			// }
		} else {
			ModMinechem.logger.info("Unknown type of Certus Quartz : "
					+ oreEvent.Name);
		}
	}
}
