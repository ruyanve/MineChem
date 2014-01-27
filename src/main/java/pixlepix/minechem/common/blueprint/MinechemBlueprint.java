package pixlepix.minechem.common.blueprint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public abstract class MinechemBlueprint {

	public static final int wildcard = -1;
	public static final int air = 0;
	@NotNull
	public static HashMap<Integer, MinechemBlueprint> blueprints = new HashMap<Integer, MinechemBlueprint>();
	public static MinechemBlueprint fusion;
	public static MinechemBlueprint fission;

	public int xSize;
	public int ySize;
	public int zSize;
	private int totalSize;
	private int horizontalSize;
	private int verticalSize;
	public String name;
	public int id;

	public static void registerBlueprint(int id, @NotNull MinechemBlueprint blueprint) {
		blueprint.id = id;
		blueprints.put(id, blueprint);
	}

	public static void registerBlueprints() {
		fusion = new BlueprintFusion();
		registerBlueprint(0, fusion);
		fission = new BlueprintFission();
		registerBlueprint(1, fission);
	}

	public MinechemBlueprint(int xSize, int ySize, int zSize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
		this.horizontalSize = xSize * zSize;
		this.verticalSize = ySize * zSize;
		this.totalSize = this.horizontalSize * ySize;
	}

	@NotNull
	public Integer[][] getHorizontalSlice(int y) {
		Integer[][][] structure = getStructure();
		Integer[][] slice = new Integer[xSize][zSize];
		for (int x = 0; x < xSize; x++) {
			System.arraycopy(structure[y][x], 0, slice[x], 0, zSize);
		}
		return slice;
	}

	@NotNull
	public Integer[][] getVerticalSlice(int x) {
		Integer[][][] structure = getStructure();
		Integer[][] slice = new Integer[ySize][zSize];
		for (int y = 0; y < ySize; y++) {
			System.arraycopy(structure[y][x], 0, slice[y], 0, zSize);
		}
		return slice;
	}

	public int getHorizontalSliceSize() {
		return this.horizontalSize;
	}

	public int getVerticalSliceSize() {
		return this.verticalSize;
	}

	public int getTotalSize() {
		return this.totalSize;
	}

	@NotNull
	public abstract HashMap<Integer, BlueprintBlock> getBlockLookup();

	@NotNull
	public abstract Integer[][][] getStructure();

	@NotNull
	public abstract Integer[][][] getResultStructure();

	public abstract int getManagerPosX();

	public abstract int getManagerPosY();

	public abstract int getManagerPosZ();

	@Nullable
	public abstract BlueprintBlock getManagerBlock();
}
