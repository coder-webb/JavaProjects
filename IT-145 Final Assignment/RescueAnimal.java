public class RescueAnimal
{

	// Instance variables
	protected String name;
	private String animalType;
	private String gender;
	private String age;
	private String weight;
	private String acquisitionDate;
	private String acquisitionCountry;
	private String trainingStatus;
	private boolean reserved;
	private String inServiceCountry;

	// Constructor
	public RescueAnimal() {
	}

	// Return rescue animal name
	public String getName() {
		return name;
	}

	// Set rescue animal name
	public void setName(String name) {
		this.name = name;
	}

	// Return rescue animal type
	public String getAnimalType() {
		return animalType;
	}

	// Set rescue animal type
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	// Return rescue animal gender
	public String getGender() {
		return gender;
	}

	// Set rescue animal gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// Return rescue animal age
	public String getAge() {
		return age;
	}

	// Set rescue animal age
	public void setAge(String age) {
		this.age = age;
	}

	// Return rescue animal weight
	public String getWeight() {
		return weight;
	}

	// Set rescue animal weight
	public void setWeight(String weight) {
		this.weight = weight;
	}

	// Return rescue animal acquisition date
	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	// Set rescue animal acquisition date
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	// Return rescue animal acquisition location
	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}

	// Set rescue animal acquisition location
	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}

	// Return rescue animal reservation status
	public boolean getReserved() {
		return reserved;
	}

	// Set rescue animal reservation status
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	// Return rescue animal service location
	public String getInServiceLocation() {
		return inServiceCountry;
	}

	// Set rescue animal service location
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}

	// Return rescue animal training status
	public String getTrainingStatus() {
		return trainingStatus;
	}

	// Set rescue animal training status
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public static void animalReservation(String animalType, String serviceCountry) {
		while ((animalType != "dog") || (animalType != "monkey")) { // Loop is used to ensure user enters a valid input
																	// of dog or monkey
			if (animalType.toLowerCase().equals("dog")) {
				for (Dog dog : Driver.dogList) { // Dog list is iterated through
					if (dog.getInServiceLocation().equalsIgnoreCase(serviceCountry)) { // Program searches for user and dog country match
						if ((dog.getReserved() == false) && (dog.getTrainingStatus().equals("in service"))) { // Program searches for
																											  // "in service" dogs
							System.out.println(
									dog.getName() + " is available. Do you want to reserve this dog? (Yes/No)");
							Driver.userString = Driver.scnr.nextLine(); // User is prompted to reserve a dog
							while (
								(Driver.userString.toLowerCase().charAt(0) != 'y')
										|| (Driver.userString.toLowerCase().charAt(0) != 'n')
							) {
								if (Driver.userString.toLowerCase().charAt(0) == 'y') {
									dog.setReserved(true);
									System.out.println(dog.getName() + " has been reserved. Returning to main menu.");
									return; // return to main menu
								}
								else if (Driver.userString.toLowerCase().charAt(0) == 'n') {
									System.out.println(dog.getName() + " not reserved. Moving to next dog if available");
								}
								else {
									System.out.println("Please enter yes or no.");
									Driver.userString = Driver.scnr.nextLine();
								}
							}
						}
					}
				}
				System.out.println("There are no dogs available in your country. Returning to the main menu."); // If there are no dogs available, 
																												// user is notified
				return;
			}
			else if (animalType.toLowerCase().equals("monkey")) { // Same as dog, only with monkeys
				for (Monkey monkey : Driver.monkeyList) { // Monkey list is iterated through
					if (monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry)) { // User and monkey country comparison
						if ((monkey.getReserved() == false) && (monkey.getTrainingStatus().equals("in service"))) { // "in service" check
							System.out.println(
									monkey.getName() + " is available. Do you want to reserve this monkey? (Yes/No)");
							Driver.userString = Driver.scnr.nextLine(); // User prompted to reserve the monkey
							while ((Driver.userString.toLowerCase().charAt(0) != 'y')
									|| (Driver.userString.toLowerCase().charAt(0) != 'n')
						) {
								if (Driver.userString.toLowerCase().charAt(0) == 'y') {
									monkey.setReserved(true);
									System.out.println(monkey.getName() + " has been reserved. Returning to main menu.");
									return; // return to main menu
								}
								else if (Driver.userString.toLowerCase().charAt(0) == 'n') {
									System.out.println(monkey.getName() + " not reserved. Moving to next monkey if available");
								}
								else {
									System.out.println("Please enter yes or no.");
									Driver.userString = Driver.scnr.nextLine();
								}
							}
						}
					}
				}
				System.out.println("There are no monkeys available in your country. Returning to the main menu."); // If there are no monkeys
																												   // available, user is notified
				return; // return to main menu
			}
			else {
				System.out.println("That is not a valid animal type. Enter \"dog\" or \"monkey\": "); // Invalid input types (not monkey or dog)
				animalType = Driver.scnr.nextLine(); // User is prompted again to enter an animal type
			}
		}
	}

	public static void trainingStatusOptions() {
		// Intake, Phase 1-5, in service, or farm
		System.out.println("\nWhat is the animals training status?");
		System.out.println("[1] Intake");
		System.out.println("[2] Phase 1");
		System.out.println("[3] Phase 2");
		System.out.println("[4] Phase 3");
		System.out.println("[5] Phase 4");
		System.out.println("[6] Phase 5");
		System.out.println("[7] In service");
		System.out.println("[8] Farm");
	}

	// Print select rescue animal information. Used in Driver.printAnimals()
	public void printInfo() {
		System.out.println("Name: " + getName());
		System.out.println("Training status: " + getTrainingStatus());
		System.out.println("Acquisition country: " + getAcquisitionLocation());
		System.out.println("Reserved: " + getReserved() + "\n");
	}
}
