package pixlepix.minechem.common.assembler;

import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.common.CoordTuple;

import java.util.ArrayList;

public interface IShapeType {
	@NotNull
	public ArrayList<CoordTuple> getCoords(CoordTuple origin, int size);
}
