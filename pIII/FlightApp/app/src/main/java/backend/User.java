package backend;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A User object. A User is a backend representation for both Client and
 * Administrator objects. Every User has a first name, last name, email,
 * address, credit card number and its related expiry date.
 * The expiry date is in the format 'YYYY-MM-DD'
 *
 * <p>For phase III we do not directly instantiate User object, instead
 * we subclass User into Client and Administrator objects. User serves
 * as the object to bridge the similarities between Client and Administrator.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3786727358644943990L;

    private final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd");

    private String lastName;
    private String firstName;

    private String email;
    private String password;

    private String address;
    private long creditCardNumber;
    private Date expiryDate;

    private ArrayList<Itinerary> bookedItineraries;

    /**
     * Creates a new User instance with the given fields. Takes a last name,
     * first name, email, address, credit card number, its expiry date and
     * password and creates the corresponding User.
     *
     * @param lastName  this user's last name.
     * @param firstName  this user's first name.
     * @param email  this user's email.
     * @param address  this user's address.
     * @param creditCardNumber  this user's credit card number.
     * @param expiryDate  a Date indicating this user's credit card expiry date.
     * @param password  the password for this user.
     */
    public User(String lastName, String firstName, String email, String address,
                long creditCardNumber, Date expiryDate, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.password = password;
        bookedItineraries = new ArrayList<>();
    }

    /**
     * Creates a new User instance with the given fields. Takes a last name,
     * first name, email, address, credit card number, its expiry date and
     * creates the corresponding User.
     *
     * <p>password is set to null.
     *
     * @param lastName  this user's last name.
     * @param firstName  this user's first name.
     * @param email  this user's email.
     * @param address  this user's address.
     * @param creditCardNumber  this user's credit card number.
     * @param expiryDate  a Date indicating this user's credit card expiry date.
     */
    public User(String lastName, String firstName, String email, String address,
                long creditCardNumber, Date expiryDate) {
        this(lastName, firstName, email, address,
                creditCardNumber, expiryDate, "");
    }

    /**
     * Creates a new User instance with given login information.
     *
     * <p>All other fields can be set later by the User or Admin in app.
     *
     * @param email  this user's email.
     * @param password  this user's password.
     */
    public User(String email, String password) {
        this("", "", email, "", 0l, null, password);
        try {
            setExpiryDate(formatter.parse("0000-00-00"));
        } catch (ParseException e) {}
    }

    /**
     * Getter for this User's last name.
     *
     * @return  this user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for this User's last name.
     *
     * @param lastName  this user's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for this User's first name.
     *
     * @return this user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for this User's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for this User's email address.
     *
     * @return  this user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for this User's address.
     *
     * @return this user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for this User's address.
     *
     * @param address  this user's new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for this User's credit card number.
     *
     * @return this user's credit card number.
     */
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Setter for this user's credit card number.
     *
     * @param creditCardNumber  this user's new credit card number.
     */
    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Getter for this User's credit card expiry Date.
     *
     * @return this user's credit card's expiry Date.
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Setter for this User's credit card expiry Date.
     *
     * @param expiryDate  a Date representing this user's new credit card
     * expiry date.
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Getter for this User's booked itineraries.
     *
     * @return this User's booked itineraries.
     */
    public ArrayList<Itinerary> getBookedItineraries() {
        return new ArrayList<Itinerary>(bookedItineraries);
    }

    /**
     * Setter for this User's booked itineraries.
     *
     * @param bookedItineraries  the new List of booked Itinerary.
     */
    public void setBookedItineraries(ArrayList<Itinerary> bookedItineraries) {
        this.bookedItineraries = bookedItineraries;
    }

    /**
     * Getter for the User's Password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Setter for the user's password
     *
     * @param password The password to be used
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Book an Itinerary for this User. If the itinerary has already been
     * booked, does nothing.
     *
     * @param selectedItinerary  an Itinerary this User wants to book.
     */
    public void bookItinerary(Itinerary selectedItinerary) {
        if (!bookedItineraries.contains(selectedItinerary) &&
                !selectedItinerary.isFull()) {
            selectedItinerary.bookSeat();
            bookedItineraries.add(selectedItinerary);
        }
    }

    /**
     * Indicates if this User is equal to another Object.
     *
     * @param obj  an Object.
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof User && email.equals(((User) obj).getEmail()));
    }

    /**
     * Returns the information of this User in String.
     *
     * @return the information stored for this User.
     */
    @Override
    public String toString(){
        return String.format(
                "%s,%s,%s,%s,%d,%s",
                lastName,
                firstName,
                email,
                address,
                creditCardNumber,
                formatter.format(expiryDate)
        );
    }
}
