package ljdp.minechem.common;

import net.minecraft.tileentity.TileEntity;
import universalelectricity.compatibility.UniversalNetwork;
import buildcraft.api.core.SafeTimeTracker;
import buildcraft.api.power.IPowerReceptor;

public class MinechemPowerProvider extends UniversalNetwork {

    public static final int ENERGY_USAGE_UPDATE_RATE = 10;
    float lastEnergyStored = 0.0F;
    float energyUsageAccumulator = 0.0F;
    float lastEnergyUsage = 0.0F;
    float currentEnergyUsage = 0.0F;
    boolean didEnergyStoredChange;
    boolean didEnergyUsageChange;
    SafeTimeTracker energyUsageTracker = new SafeTimeTracker();

    public MinechemPowerProvider(int minEnergyReceived, int maxEnergyReceived, int activationEnergy, int maxStoredEnergy) {
        
    }

    public boolean didEnergyStoredChange() {
        boolean didChange = didEnergyStoredChange;
        didEnergyStoredChange = false;
        return didChange;
    }

    public boolean didEnergyUsageChange() {
        boolean didChange = didEnergyUsageChange;
        didEnergyUsageChange = false;
        return didChange;
    }



    public void setCurrentEnergyUsage(float amount) {
        currentEnergyUsage = amount;
    }

    public float getCurrentEnergyUsage() {
        return currentEnergyUsage;
    }





}
