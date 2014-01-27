package pixlepix.minechem.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pixlepix.minechem.api.recipe.DecomposerRecipe;
import pixlepix.minechem.api.recipe.SynthesisRecipe;
import pixlepix.minechem.common.MinechemItems;
import pixlepix.minechem.common.inventory.BoundedInventory;
import pixlepix.minechem.common.inventory.Transactor;
import pixlepix.minechem.common.recipe.DecomposerRecipeHandler;
import pixlepix.minechem.common.recipe.SynthesisRecipeHandler;
import pixlepix.minechem.computercraft.IMinechemMachinePeripheral;

public class TileEntityMicroscope extends MinechemTileEntity implements IInventory, IMinechemMachinePeripheral {
	@NotNull
	public static int[] kInput = { 0 };
	@NotNull
	public static int[] kJournal = { 1 };

	public boolean isShaped = true;

	private final BoundedInventory inputInvetory = new BoundedInventory(this, kInput);
	private final BoundedInventory journalInventory = new BoundedInventory(this, kJournal);
	@NotNull
	private Transactor inputTransactor = new Transactor(inputInvetory, 1);
	@NotNull
	private Transactor journalTransactor = new Transactor(journalInventory, 1);

	public TileEntityMicroscope() {
		inventory = new ItemStack[getSizeInventory()];
	}

	public void onInspectItemStack(@NotNull ItemStack itemstack) {
		SynthesisRecipe synthesisRecipe = SynthesisRecipeHandler.instance.getRecipeFromOutput(itemstack);
		DecomposerRecipe decomposerRecipe = DecomposerRecipeHandler.instance.getRecipe(itemstack);
		if (inventory[1] != null && (synthesisRecipe != null || decomposerRecipe != null)) {
			MinechemItems.journal.addItemStackToJournal(itemstack, inventory[1], worldObj);
		}
	}

	@Override
	public int getSizeInventory() {
		return 11;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		ItemStack itemstack = inventory[slot];
		return itemstack;
	}

	@Nullable
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slot >= 0 && slot < inventory.length) {
			ItemStack itemstack = inventory[slot];
			inventory[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Nullable
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, @Nullable ItemStack itemStack) {
		inventory[slot] = itemStack;
		if (slot == 0 && itemStack != null && !worldObj.isRemote)
			onInspectItemStack(itemStack);
		if (slot == 1 && itemStack != null && inventory[0] != null && !worldObj.isRemote)
			onInspectItemStack(inventory[0]);
	}

	@NotNull
	@Override
	public String getInvName() {
		return "container.microscope";
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(@NotNull EntityPlayer entityPlayer) {
		double dist = entityPlayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D);
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : dist <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	public int getFacing() {
		return worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	}

	@Override
	public void writeToNBT(@NotNull NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		ItemStack inpectingStack = inventory[0];
		if (inpectingStack != null) {
			NBTTagCompound inspectingStackTag = inpectingStack.writeToNBT(new NBTTagCompound());
			nbtTagCompound.setTag("inspectingStack", inspectingStackTag);
		}
		ItemStack journal = inventory[1];
		if (journal != null) {
			NBTTagCompound journalTag = journal.writeToNBT(new NBTTagCompound());
			nbtTagCompound.setTag("journal", journalTag);
		}
	}

	@Override
	public void readFromNBT(@NotNull NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		NBTTagCompound inspectingStackTag = nbtTagCompound.getCompoundTag("inspectingStack");
		NBTTagCompound journalTag = nbtTagCompound.getCompoundTag("journal");
		ItemStack inspectingStack = ItemStack.loadItemStackFromNBT(inspectingStackTag);
		ItemStack journalStack = ItemStack.loadItemStackFromNBT(journalTag);
		inventory[0] = inspectingStack;
		inventory[1] = journalStack;
	}

	@Nullable
	@Override
	public ItemStack takeOutput() {
		return null;
	}

	@Override
	public int putOutput(ItemStack output) {
		return 0;
	}

	@Nullable
	@Override
	public ItemStack takeInput() {
		return inputTransactor.removeItem(true);
	}

	@Override
	public int putInput(@NotNull ItemStack input) {
		return inputTransactor.add(input, true);
	}

	@Nullable
	@Override
	public ItemStack takeFusionStar() {
		return null;
	}

	@Override
	public int putFusionStar(ItemStack fusionStar) {
		return 0;
	}

	@Nullable
	@Override
	public ItemStack takeJournal() {
		return journalTransactor.removeItem(true);
	}

	@Override
	public int putJournal(@NotNull ItemStack journal) {
		return journalTransactor.add(journal, true);
	}

	@Nullable
	@Override
	public String getMachineState() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, @NotNull ItemStack itemstack) {
		if (i == kInput[0])
			return true;
		if (i == kJournal[0] && itemstack.itemID == MinechemItems.journal.itemID)
			return true;
		return false;
	}

	@Override
	void sendUpdatePacket() {
		// TODO Auto-generated method stub

	}

}
