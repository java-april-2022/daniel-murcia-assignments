package zooKeeperP1;

public class Mammal {
	protected int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.printf("Total Energy: %s\n", getEnergyLevel());
		return getEnergyLevel();
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
