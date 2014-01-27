package ljdp.easypacket.serializer;

import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class FloatSerializer extends Serializer {

	@Override
	public void write(Object obj, @NotNull Field field, DataOutputStream out) throws IOException, IllegalArgumentException, IllegalAccessException {
		float value = field.getFloat(obj);
		out.writeFloat(value);
	}

	@Override
	public void read(Object obj, Field field, DataInputStream in) throws IOException, IllegalArgumentException, IllegalAccessException {
		float value = in.readFloat();
		field.setFloat(obj, value);
	}

}
