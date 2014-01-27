package ljdp.easypacket.serializer;

import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class LongSerializer extends Serializer {

	@Override
	public void read(Object obj, @NotNull Field field, DataInputStream in) throws IOException, IllegalArgumentException, IllegalAccessException {
		long value = in.readLong();
		field.set(obj, value);
	}

	@Override
	public void write(Object obj, Field field, DataOutputStream out) throws IOException, IllegalArgumentException, IllegalAccessException {
		long value = field.getLong(obj);
		out.writeLong(value);
	}

}
