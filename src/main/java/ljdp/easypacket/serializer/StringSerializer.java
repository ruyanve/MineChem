package ljdp.easypacket.serializer;

import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class StringSerializer extends Serializer {

	@Override
	public void read(Object obj, @NotNull Field field, DataInputStream in) throws IOException, IllegalArgumentException, IllegalAccessException {
		String value = in.readUTF();
		field.set(obj, value);
	}

	@Override
	public void write(Object obj, Field field, DataOutputStream out) throws IOException, IllegalArgumentException, IllegalAccessException {
		String value = (String) field.get(obj);
		out.writeUTF(value);
	}
}
