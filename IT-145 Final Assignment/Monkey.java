
public class Monkey extends RescueAnimal {
	private String species;
	private String tailLength;
	private String height;
    private String bodyLength;
	
	// Constructor
	public Monkey(String name, String species, String gender, String age,
		    String weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry,
			String tailLength, String height, String bodyLength) {
		setName(name);
		this.species = species;
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		this.tailLength = tailLength;
		this.height = height;
		this.bodyLength = bodyLength;
		
	}
	
	// Species list used in Driver.intakeNewMonkey() to list accepted monkey species
    public static void monkeySpeciesList() {
	    System.out.println("[1] Capuchin");
	    System.out.println("[2] Guenon");
	    System.out.println("[3] Macaque");
	    System.out.println("[4] Marmoset");
	    System.out.println("[5] Squirrel monkey");
	    System.out.println("[6] Tamarin");
    }
    
    // Return monkey species
	public String getSpecies() {
		return this.species;
	}
	// Set monkey species
	public void setSpecies(String species) {
		this.species = species;
	}
	
	// Return monkey tail length
	public String getTailLength() {
		return this.tailLength;
	}
	// Set monkey tail length
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	// Return monkey height
	public String getHeight() {
		return this.height;
	}
	// Set monkey height
	public void setHeight(String height) {
		this.height = height;
	}
    
	// Return monkey body length
    public String getBodyLength() {
    	return this.bodyLength;
    }
    // Set monkey body length
    public void setBodyLength(String bodyLength) {
    	this.bodyLength = bodyLength;
    }
}
