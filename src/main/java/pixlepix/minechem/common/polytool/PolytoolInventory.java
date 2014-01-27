package pixlepix.minechem.common.polytool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.common.items.ItemElement;
import pixlepix.minechem.common.network.PacketHandler;

public class PolytoolInventory implements IInventory {
	@Nullable
	public ItemStack item;
	public EntityPlayer player;

	public PolytoolInventory(ItemStack currentItem, EntityPlayer player) {
		this.player = player;
	}

	@Override
	public int getSizeInventory() {

		return 1;
	}

	@Nullable
	@Override
	public ItemStack getStackInSlot(int i) {

		return item;
	}

	@Nullable
	@Override
	public ItemStack decrStackSize(int i, int j) {

		ItemStack itemstack = getStackInSlot(i);

		if (itemstack != null) {
			if (itemstack.stackSize <= j) {
				setInventorySlotContents(i, null);
			} else {
				itemstack = itemstack.splitStack(j);
			}
		}
		return itemstack;
	}

	@Nullable
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, @Nullable ItemStack itemstack) {
		item = itemstack;

		if (itemstack != null && itemstack.stackSize == 64 && (itemstack.getItem() instanceof ItemElement) && PolytoolHelper.getTypeFromElement(ItemElement.getElement(itemstack), 1) != null && ItemPolytool.validAlloyInfusion(player.getCurrentEquippedItem(), itemstack)) {
			item = null;
			ItemPolytool.addTypeToNBT(player.inventory.getCurrentItem(), PolytoolHelper.getTypeFromElement(ItemElement.getElement(itemstack), 1));

			if (!player.worldObj.isRemote) {
				PacketHandler.sendPolytoolUpdatePacket(PolytoolHelper.getTypeFromElement(ItemElement.getElement(itemstack), 1), player);
			}
		}

	}

	@NotNull
	@Override
	public String getInvName() {

		return "Polytool Inventory";
	}

	@Override
	public boolean isInvNameLocalized() {

		return false;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public void onInventoryChanged() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {

		return false;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, @Nullable ItemStack itemstack) {

		return itemstack == null || itemstack.stackSize == 64 && (itemstack.getItem() instanceof ItemElement) && PolytoolHelper.getTypeFromElement(ItemElement.getElement(itemstack), 1) != null;
	}

}
