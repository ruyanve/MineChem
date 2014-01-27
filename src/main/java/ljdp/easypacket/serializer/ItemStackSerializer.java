package ljdp.easypacket.serializer;

import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class ItemStackSerializer extends Serializer {

	@Override
	public void write(Object obj, @NotNull Field field, DataOutputStream out) throws IOException, IllegalArgumentException, IllegalAccessException {
		ItemStack value = (ItemStack) field.get(obj);
		Packet.writeItemStack(value, out);
	}

	@Override
	public void read(Object obj, Field field, DataInputStream in) throws IOException, IllegalArgumentException, IllegalAccessException {
		ItemStack value = Packet.readItemStack(in);
		field.set(obj, value);
	}

}
