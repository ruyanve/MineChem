package cofh.api.core;

import org.jetbrains.annotations.NotNull;

/**
 * Access to the Cape and Skin Registries of CoFH Core.
 *
 * @author Zeldo Kavira
 */
public class RegistryAccess {

	@NotNull
	public static ISimpleRegistry capeRegistry = new NullSimpleRegistry();
	public static ISimpleRegistry skinRegistry = new NullSimpleRegistry();

}
