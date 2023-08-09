import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	protected static Scanner scnr = new Scanner(System.in);
	protected static ArrayList<Dog> dogList = new ArrayList<Dog>(); // Array list that holds all dog objects
	protected static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Array list that holds all monkey objects
	protected static String userString = null; // Variable placeholder used throughout this package to receive input from the user
	private static int userInt = 0; // Variable placeholder used in Driver.java to receive an integer input from the user

	public static void main(String[] args) {

		initializeDogList(); // Dog list used for testing
		initializeMonkeyList(); // Monkey list used for testing

		userString = " "; // Initial input
		while (userString.toLowerCase().charAt(0) != 'q') { // Loop runs until user enters 'q'
			try {
				displayMenu(); // Menu is displayed to show user their options
				userString = scnr.nextLine(); // User input is prompted
				displayMenuCommands(userString.toLowerCase().charAt(0));
			}
			catch (Exception e) { // Any exception will inform the user to enter a new command and reset initial input for the loop to continue
				System.out.println("Command not recognized.");
				userString = " ";
			}
		}
		System.out.println("Goodbye"); // When user enters 'q', program tells them goodbye
		scnr.close();
	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// This method takes the user input and forwards the command to the selected method
	public static void displayMenuCommands(char input) {
		if (input == '1') {
			intakeNewDog(scnr); // Uses intakeNewDog method using the scanner class
		}
		else if (input == '2') {
			intakeNewMonkey(scnr); // Uses intakeNewMonkey method using the scanner class
		}
		else if (input == '3') {
			reserveAnimal(scnr); // Uses reserveAnimal method using the scanner class
		}
		else if (input == '4') {
			printAnimals("dog"); // Prints all dogs
		}
		else if (input == '5') {
			printAnimals("monkey"); // Prints all monkeys
		}
		else if (input == '6') {
			printAnimals("all"); // Prints all animals not reserved
		}
		else if (input == 'q') { // Quits the program
			return;
		}
		else {
			System.out.println("Command not recognized."); // User is informed if they entered a command not usable by the program
		}
	}

	// Dog list used for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service",
				false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false,
				"Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Monkey list used for testing
	public static void initializeMonkeyList() {
		Monkey dog1 = new Monkey("Ralph", "Marmoset", "male", "1", "25.6", "05-12-2019", "United States", "in service",
				false, "United States", "5", "50", "40");
		Monkey dog2 = new Monkey("Amy", "Tamarin", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
				"United States", "30", "35", "40");
		Monkey dog3 = new Monkey("Pedro", "Guenon", "female", "4", "25.6", "12-12-2019", "United States", "in service",
				false, "United States", "24", "35", "40");

		monkeyList.add(dog1);
		monkeyList.add(dog2);
		monkeyList.add(dog3);

	}

	// This method creates a dog object and adds the dogs information to the dog
	// array
	public static void intakeNewDog(Scanner scnr) {
		String name = null;
		String breed = null;
		String gender = "unassigned";
		String age;
		String weight;
		String acquisitionDate;
		String acquisitionCountry;
		String trainingStatus;
		String isReserved;
		boolean reserved = false; // Default reserved boolean
		String inServiceCountry;
		Dog newDog;
		
		System.out.println("What is the dog's name?"); // User is prompted to enter the dog name
		do {
			name = scnr.nextLine();
			if (name == "") {
				System.out.println("Name cannot be empty. What is the dog's name?"); // Dog name cannot be empty, user is prompted until they enter
																					 // a name
			}
		} while (name == "");
		
		for (Dog dog : dogList) { // dogList is iterated through to check for the users input dog name
			if (dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis dog is already in our system\n\n");
				return;// returns to menu
			}
			else { // If name is not found, dog object information is prompted
				System.out.println("Adding " + name); // User is informed the dog they named is to be added to the system

				System.out.print("\nEnter breed: "); // User enters dog breed
				breed = scnr.nextLine();

				System.out.print("\nEnter gender (male or female): "); // User enters dog gender
				do {
					try {
						gender = scnr.nextLine();
						if (gender.toLowerCase().charAt(0) == 'm') { // Male for male
							gender = "Male";
						}
						else if (gender.toLowerCase().charAt(0) == 'f') { // Female for female
							gender = "Female";
						}
						else {
							System.out.println("Please enter male or female."); // Inputs not recognized are reset to "unassigned" so loop resets
							gender = "unassigned";
						}
					}
					catch (Exception e) { // Exceptions inform the user they must enter male or female
						System.out.println("Please enter male or female.");
						gender = "unassigned";
					}
				} while (gender == "unassigned"); // Loop continues until a valid input is used

				System.out.print("\nEnter age: "); // Dog age is entered
				age = scnr.nextLine();

				System.out.print("\nEnter weight: "); // Dog weight is entered
				weight = scnr.nextLine();

				System.out.print("\nEnter acquisition date: "); // Dog acquisition date is entered
				acquisitionDate = scnr.nextLine();

				System.out.print("\nEnter acquisition country: "); // Dog acquisition country is entered
				acquisitionCountry = scnr.nextLine();

				trainingStatus = "default"; // Default trainingStatus value
				RescueAnimal.trainingStatusOptions(); // User is shown their options for the dog's current training status
				do {
					try {
						userInt = scnr.nextInt();
						if (userInt == 1) {
							trainingStatus = "Intake"; // User enters '1' for intake
						}
						else if (userInt == 2) {
							trainingStatus = "Phase 1"; // User enters '2' for phase 1
						}
						else if (userInt == 3) {
							trainingStatus = "Phase 2"; // User enters '3' for phase 2
						}
						else if (userInt == 4) {
							trainingStatus = "Phase 3"; // User enters '4' for phase 3
						}
						else if (userInt == 5) {
							trainingStatus = "Phase 4"; // User enters '5' for phase 4
						}
						else if (userInt == 6) {
							trainingStatus = "Phase 5"; // User enters '6' for phase 5
						}
						else if (userInt == 7) {
							trainingStatus = "in-service"; // User enters '7' for in-service
						}
						else if (userInt == 8) {
							trainingStatus = "Farm"; // User enters '8' for farm
						}
						else {
							System.out.println("That is not a valid option, please try again."); // Invalid inputs reset userInt to 0 so loop resets
							userInt = 0;
						}
					}
					catch (Exception e) { // Exceptions inform the user to enter a number from 1 to 8
						System.out.println("Please enter a selection using numbers 1 to 8.");
						scnr.nextLine();
					}
				} while (userInt <= 0 || userInt >= 9); // Loop continues until a valid input is used

				boolean accepted = false; // Default boolean for the loop
				scnr.nextLine();
				while (!accepted == true) { // Loop continues until accepted boolean is true
					try {
						System.out.println("\nIs this dog reserved? (Yes/No): "); // User is asked if dog is reserved
						isReserved = scnr.nextLine();
						if (isReserved.toLowerCase().charAt(0) == 'y') {
							reserved = true;
							accepted = true;
						}
						else if (isReserved.toLowerCase().charAt(0) == 'n') {
							reserved = false;
							accepted = true;
						}
						else {
							System.out.println("Invalid input, try again."); // Invalid inputs reset the loop
						}
					}
					catch (Exception e) { // Exceptions reset the loop
						System.out.println("Please type yes or no.");
					}
				}

				System.out.print("\nEnter country of service: "); // User enters dog's country of service
				inServiceCountry = scnr.nextLine().toLowerCase();

				// After all dog object is prompted, a new dog object is created
				newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
						reserved, inServiceCountry);
				dogList.add(newDog); // New dog object is added to the dogList array
				System.out.println(name + " has been added"); // Program tells the user their dog was successfully added
				return; // returns to menu
			}
		}
	}

	// Same as intakeNewDog method, only with a monkey instead
	public static void intakeNewMonkey(Scanner scnr) {
		String species = null;
		String name = null;
		String gender = "unassigned";
		String age;
		String weight;
		String acquisitionDate;
		String acquisitionCountry;
		String trainingStatus;
		String isReserved = null;
		boolean reserved = false; // Default reserve boolean
		String inServiceCountry;
		String tailLength;
		String height;
		String bodyLength;
		Monkey newMonkey;

		System.out.println("What is the monkey's name?"); // Monkey name prompt
		do {
			name = scnr.nextLine();
			if (name == "") {
				System.out.println("Name cannot be empty. What is the monkey's name?");
			}
		} while (name == ""); // Loop continues until name entry is not blank
		
		for (Monkey monkey : monkeyList) { // Monkey list iteration
			if (monkey.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis monkey is already in our system\n\n");
				return; // returns to menu
			}
			else {
				System.out.println("Adding " + name);
				

				while (species == null) { // Loop ensures a valid number is used
					try {
						System.out.println("\nSelect the monkey's species: ");
						Monkey.monkeySpeciesList(); // Species list is printed, allowing the user to select from species options
						species = scnr.nextLine();
						if (species.charAt(0) == '1') { // User enters '1' for Capuchin
							species = "Capuchin";
						}
						else if (species.charAt(0) == '2') { // User enters '2' for Guenon
							species = "Guenon";
						}
						else if (species.charAt(0) == '3') { // User enters '3' for Macaque
							species = "Macaque";
						}
						else if (species.charAt(0) == '4') { // User enters '4' for Marmoset
							species = "Marmoset";
						}
						else if (species.charAt(0) == '5') { // User enters '5' for Squirrel Monkey
							species = "Squirrel Monkey";
						}
						else if (species.charAt(0) == '6') { // User enters '6' for Tamarin
							species = "Tamarin";
						}
						else { // Invalid inputs reset species to null to reset the loop
							System.out.println("That is not a valid option. Enter 1-6 to select the monkey's species.");
							species = null;
						}
					}
					catch (Exception e) { // Exceptions reset species to null and reset the loop
						System.out.println("That is not a valid option. Enter 1-6 to select the monkey's species.");
						species = null;
					}
				}
			}

			System.out.print("\nEnter gender (male or female): ");
			do { 		// User enters the monkey's gender, loop continues until male or female are entered
				try {
					gender = scnr.nextLine();
					if (gender.toLowerCase().charAt(0) == 'm') {
						gender = "Male";
					}
					else if (gender.toLowerCase().charAt(0) == 'f') {
						gender = "Female";
					}
					else { // Invalid inputs reset gender to unassigned and reset the loop
						System.out.println("Please enter male or female.");
						gender = "unassigned";
					}
				}
				catch (Exception e) { // Exceptions reset gender to unassigned and reset the loop
					System.out.println("Please enter male or female.");
					gender = "unassigned";
				}
			} while (gender == "unassigned"); // Loop continues until gender is male or female

			System.out.print("\nEnter age: "); // Monkey age
			age = scnr.nextLine();

			System.out.print("\nEnter weight: "); // Monkey weight
			weight = scnr.nextLine();

			System.out.print("\nEnter acquisition date: "); // Monkey acquisition date
			acquisitionDate = scnr.nextLine();

			System.out.print("\nEnter acquisition country: "); // Monkey acquisition country
			acquisitionCountry = scnr.nextLine();
			
			trainingStatus = "default"; // Default training status variable
			RescueAnimal.trainingStatusOptions(); // Training status options are printed to the user
			do {		// Do while loop attempts to accept users first input and resets if user enters something other than a number from 1 to 8
				try {
					userInt = scnr.nextInt();
					if (userInt == 1) {
						trainingStatus = "Intake"; // User enters '1' for intake
					}
					else if (userInt == 2) {
						trainingStatus = "Phase 1"; // User enters '2' for phase 1
					}
					else if (userInt == 3) {
						trainingStatus = "Phase 2"; // User enters '3' for phase 2
					}
					else if (userInt == 4) {
						trainingStatus = "Phase 3"; // User enters '4' for phase 3
					}
					else if (userInt == 5) {
						trainingStatus = "Phase 4"; // User enters '5' for phase 4
					}
					else if (userInt == 6) {
						trainingStatus = "Phase 5"; // User enters '6' for phase 5
					}
					else if (userInt == 7) {
						trainingStatus = "in-service"; // User enters '7' for in-service
					}
					else if (userInt == 8) {
						trainingStatus = "Farm"; // User enters '8' for farm
					}
					else {
						System.out.println("That is not a valid option, please try again."); // Invalid inputs reset userInt to 0 so loop resets
						userInt = 0;
					}
				}
				catch (Exception e) { // Exceptions inform the user to enter a number from 1 to 8
					System.out.println("Please enter a selection using numbers 1 to 8.");
					scnr.nextLine();
				}
			} while (userInt <= 0 || userInt >= 9); // Loop continues until a valid input is used

			boolean accepted = false; // Default accepted boolean
			scnr.nextLine();
			while (!accepted == true) { // While accepted is false, loop continues
				try {
					System.out.println("\nIs this monkey reserved? (Yes/No): ");
					isReserved = scnr.nextLine();
					if (isReserved.toLowerCase().charAt(0) == 'y') {
						reserved = true;
						accepted = true;
					}
					else if (isReserved.toLowerCase().charAt(0) == 'n') {
						reserved = false;
						accepted = true;
					}
					else { // User is notified if they enter an invalid input 
						System.out.println("Invalid input, try again.");
					}
				}
				catch (Exception e) { // Exceptions inform the user to only enter yes or no
					System.out.println("Please type yes or no.");
				}
			}

			System.out.print("\nEnter country of service: "); // Monkey's country of service
			inServiceCountry = scnr.nextLine().toLowerCase();

			System.out.print("\nEnter tail length in inches (nearest whole number): "); // Monkey's tail length
			tailLength = scnr.nextLine();

			System.out.print("\nEnter height in inches (nearest whole number): "); // Monkey's height
			height = scnr.nextLine();

			System.out.print("\nEnter length of body (in inches): "); // Monkey's body length
			bodyLength = scnr.nextLine();

			// New monkey object is created
			newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry,
					trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
			monkeyList.add(newMonkey); // New monkey is added to monkeyList
			System.out.println(name + " has been added"); // Confirmation of monkey addition
			return; // Return to main menu
		}
	}

	// This method is used for reserving a dog or monkey
	public static void reserveAnimal(Scanner scnr) {
		String animalType = null; // Default animal type string
		String serviceCountry;

		System.out.print("Which animal would like to reserve? \n[1] Dog\n[2] Monkey\n"); // User selects an animal
		do {
			try {
				userInt = scnr.nextInt();
				if (userInt == 1) { // User enters 1 for dog and the loop breaks
					animalType = "dog";
					break;
				}
				else if (userInt == 2) { // user enters 2 for monkey and the loop breaks
					animalType = "monkey";
					break;
				}
				else { // User is notified of an invalid input
					System.out.println("That is not a valid input, try again.");
				}
			}
			catch (InputMismatchException e) { // Exceptions inform the user to enter 1 for dog or 2 for monkey
				System.out.println("Please use \"1\" to select a dog or \"2\" to select a monkey.");
				scnr.next();
			}
		} while (animalType == null);
		System.out.print("Enter the country of service: "); // User enters the country they want to reserve an animal in
		scnr.nextLine();
		serviceCountry = scnr.nextLine().toLowerCase(); // User enters animals service country
		System.out.println();
		RescueAnimal.animalReservation(animalType, serviceCountry); // Program attempts to reserve the animal in that country
	}

	// Method is used to print animal information based off of main menu specifications
	public static void printAnimals(String animalType) {
		if (animalType == "dog") { // All dogs and select dog information are printed
			for (Dog dog : dogList) {
				dog.printInfo();
			}
		}
		else if (animalType == "monkey") { // All monkeys and select monkey information are printed
			for (Monkey monkey : monkeyList) {
				monkey.printInfo();
			}
		}
		else if (animalType == "all") { // All in service and not reserved dogs and monkeys are printed
			for (Dog dog : dogList) {
				if ((!dog.getReserved()) && (dog.getTrainingStatus() == "in service")) {
					dog.printInfo();
				}
			}
			for (Monkey monkey : monkeyList) {
				if ((!monkey.getReserved()) && (monkey.getTrainingStatus() == "in service")) {
					monkey.printInfo();
				}
			}
		}
		return; // return to main menu
	}
}
