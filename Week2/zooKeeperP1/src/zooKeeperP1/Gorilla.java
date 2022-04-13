package zooKeeperP1;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla throws something!");
		setEnergyLevel(getEnergyLevel() - 5); 
		System.out.printf("Energy: %s\n", energyLevel);
	}
	
	public void eatBananas() {
		System.out.println("Gorilla is happily munching.");
		setEnergyLevel(getEnergyLevel() + 10);
		System.out.printf("Energy: %s\n", energyLevel);
	}
	
	public void climb() {
		System.out.println("Gorilla climbed a tree.");
		setEnergyLevel(getEnergyLevel() - 10);
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
