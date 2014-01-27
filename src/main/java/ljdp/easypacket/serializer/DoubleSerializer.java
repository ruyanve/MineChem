package ljdp.easypacket.serializer;

import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class DoubleSerializer extends Serializer {

	@Override
	public void write(Object obj, @NotNull Field field, DataOutputStream out)
			throws IOException, IllegalArgumentException,
			IllegalAccessException {
		double value = field.getDouble(obj);
		out.writeDouble(value);
	}

	@Override
	public void read(Object obj, Field field, DataInputStream in)
			throws IOException, IllegalArgumentException,
			IllegalAccessException {
		double value = in.readDouble();
		field.setDouble(obj, value);
	}

}
