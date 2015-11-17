package backend;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable{

	private static final long serialVersionUID = -3786727358644943990L;
	private String lastName;
	private String firstName;
	private String email;
	private String address;
	private int creditCardNumber;
	private Date expiryDate;
	private Itinerary selectedItinerary;
	private ArrayList<Itinerary> bookedItineraries;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public User(String LastName,
			String firstName, String email, String address,
			int creditCardNumber, String expiryDate) {
		try{
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
		this.expiryDate = format.parse(expiryDate);
		this.selectedItinerary = null;
		this.bookedItineraries = new ArrayList<Itinerary>();
		}catch(ParseException e) {
			System.out.println("The date is not in the right format: yyyy-MM-dd HH:mm");
		}
	}
	/**
	 * Adds a client to the clientManager in FileDatabase. Takes client information from a file. 
	 * File should be a csv file. 
	 * @param dir the path to client file. 
	 */
	public void getInfoFromFile(String dir){
		FileDatabase.getInfoFromFile(dir);
	}
	
	/**
	 * Adds a flight to the flightManager in FileDatabase. Takes flight information from a file. 
	 * File should be a csv file. 
	 * @param dir the path to flight csv file. 
	 */
	public void addFlightFromFile(String dir){
		FileDatabase.addFlightFromFile(dir);
	}
	public void addFlight(Flight toAdd) {
		
	}

	/**
	 * Getter for the Client's last name.
	 * @return LastName, a String representation of the Client's last name. 
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter for the Client's last name.
	 * @param lastName, a String representation of the Client's last name.
	 */
	
	public void setLastName(String lastName) {
		lastName = lastName;
	}
	
	/**
	 * Getter for the Client's first names.
	 * @return FirstName, a String representation of the Client's first names.
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for the Client's first names.
	 * @param firstNames, a String representation of the Client's first names.
	 */
	
	public void setFirstName(String firstName) {
		firstName = firstName;
	}
	
	/**
	 * Getter for the Client's email address.
	 * @return Email, a String representation of the Client's email
	 * address.
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter for the Client's email address.
	 * @param email, a String representation of the Client's email.
	 * address.
	 */

	public void setEmail(String email) {
		email = email;
	}
	
	/**
	 * Getter for the Client's email address.
	 * @return Address, a String representation of the Client's address.
	 */

	public String getAddress() {
		return address;
	}
	
	/**
	 * Setter for the Client's address.
	 * @param address, a String representation of the Client's address.
	 */

	public void setAddress(String address) {
		address = address;
	}
	
	/**
	 * Getter for the Client's credit card number.
	 * @return CreditCardNumber, an int representation of the Client's
	 * credit card number.
	 */

	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	
	/**
	 * Setter for the Client's credit card number.
	 * @param creditCardNumber, an int representation of the Client's
	 * credit card number.
	 */

	public void setCreditCardNumber(int creditCardNumber) {
		creditCardNumber = creditCardNumber;
	}
	
	/**
	 * Getter for the Client's credit card expiry date.
	 * @return ExpiryDate, a Calendar (date) representation of the client's
	 * credit card expiry date.
	 */

	public Date getExpiryDate() {
		return expiryDate;
	}
	
	/**
	 * Setter for the Client's credit card expiry date
	 * @param expiryDate, a Calendar (date) representation of the client's
	 * credit card expiry date.
	 */

	public void setExpiryDate(Date expiryDate) {
		expiryDate = expiryDate;

	}
		
	/**
	 * Select an Itinerary from a list of Itinerary.
	 * @param listItineraries, an ArrayList of Itinerary
	 * @param index, an int index for the ArrayList
	 */
	public void selectItinerary(ArrayList<Itinerary> listItineraries, int index) {
		this.selectedItinerary = listItineraries.get(index);
	}
	
	/**
	 * Book an itinerary selected using the selectItinerary method.
	 * @param selectedItinerary, an Itinerary previously selected.
	 */
	public void bookItinerary(Itinerary selectedItinerary) {
		this.bookedItineraries.add(selectedItinerary);
	}
	
	/**
	 * Find a Flight given its origin, destination and departureDate
	 *  
	 * @param origin
	 * @param destination the destination of the flight. 
	 * @param departureDate a string representation of the date. Should be in yyyy-MM-dd HH:mm.  
	 * @return
	 */
	public Flight viewFlights(String origin, String destination, 
			String departureDate){
		Flight value = null;
		value = FileDatabase.getItineraryManger().getFlight(origin, destination, departureDate);
		return value;
	}
	
	public ArrayList<Itinerary> viewItineraries(String origin, String departure, 
			String departureDate){
		return FileDatabase.getItineraryManger().getItineraries(origin, departure, departureDate);
	}
	
	/**
	 * Returns the information stored for the client with the given email.
	 * 
	 * @param email
	 *            the email address of a client
	 * @return the information stored for the client with the given email in
	 *         this format:
	 *         LastName,FirstNames,Email,Address,CreditCardNumber,ExpiryDate
	 *         (the ExpiryDate is stored in the format YYYY-MM-DD)
	 */
	@Override
	public String toString(){
		return lastName + "," + firstName+ ","+ email+"," + address + "," 
	           + String.valueOf(creditCardNumber) + "," + format.format(expiryDate); 
	}
	

			
}
