package zooKeeperP2;

public class Bat extends Mammal {

	protected int energyLevel = 300; 
	
	public void fly() {
		System.out.println("Whoosh...Bat flying!");
		setEnergyLevel(getEnergyLevel() - 50); 
		System.out.printf("Energy: %s\n", energyLevel);
	}
	
	public void eatHumans() {
		System.out.println("Bat is happily munching.");
		setEnergyLevel(getEnergyLevel() + 25);
		System.out.printf("Energy: %s\n", energyLevel);
	}
	
	public void attackTown() {
		System.out.println("Bat descends violently! Town in flames!");
		setEnergyLevel(getEnergyLevel() - 100);
		System.out.printf("Energy: %s\n", energyLevel);
	}

	public void setEnergyLevel(int energyLevel) {
		// TODO Auto-generated method stub
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel() {
		// TODO Auto-generated method stub
		return energyLevel;
	}
}
