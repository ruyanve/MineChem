package pixlepix.minechem.api.recipe;

import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.api.core.Chemical;

import java.util.ArrayList;
import java.util.Collections;

public class DecomposerRecipe {

	@NotNull
	public static ArrayList<DecomposerRecipe> recipes = new ArrayList<DecomposerRecipe>();

	ItemStack input;
	@NotNull
	public ArrayList<Chemical> output = new ArrayList<Chemical>();

	public static DecomposerRecipe add(DecomposerRecipe recipe) {
		recipes.add(recipe);
		return recipe;
	}

	public DecomposerRecipe(ItemStack input, Chemical... chemicals) {
		this(chemicals);
		this.input = input;
	}

	public DecomposerRecipe(@NotNull Chemical... chemicals) {
		Collections.addAll(this.output, chemicals);
	}

	public ItemStack getInput() {
		return this.input;
	}

	public ArrayList<Chemical> getOutput() {
		return this.output;
	}

	public ArrayList<Chemical> getOutputRaw() {
		return this.output;
	}
}
