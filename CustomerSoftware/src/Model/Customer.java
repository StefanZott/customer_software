package Model;

public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private String street;
	private int houseNumber;
	private String place;
	private int postCode;
	private String email;
	
	public Customer(int customerID, 
					String firstName, 
					String lastName,
					String street,
					int houseNumber,
					int postCode,
					String place,
					String email) {
		
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.houseNumber = houseNumber;
		this.place = place;
		this.postCode = postCode;
		this.email = email;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @return the postCode
	 */
	public int getPostCode() {
		return postCode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
}
