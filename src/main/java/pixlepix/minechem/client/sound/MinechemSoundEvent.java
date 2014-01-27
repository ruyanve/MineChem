package pixlepix.minechem.client.sound;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.jetbrains.annotations.NotNull;
import pixlepix.minechem.common.utils.ConstantValue;

public class MinechemSoundEvent {

	@ForgeSubscribe
	public void onSound(@NotNull SoundLoadEvent event) {
		event.manager.soundPoolSounds.addSound(ConstantValue.TEXTURE_MOD_ID + "assets/minechem/sound/minechem/projector.ogg");
	}

}
