package backend;

import java.io.Serializable;
import java.util.Date;

/**
 * An Admin object. Every Admin has a first name, last name, email, password
 * address, credit card number and its related expiry date.
 * The expiry date is in the format 'YYYY-MM-DD'
 *
 * <p>An Admin can search Flight and Itinerary, book Itineraries,
 * show results sorted by price or total travel time, view and edit its
 * own information.
 *
 * <p>In addition, Admin users are granted special permissions.
 * An Admin can load Client and Flight object into the app (FileDatabase)
 * from CSV files, view and book Itinerary for Client, view and edit Client and
 * Flight information.
 */
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = -1763989618297575346L;

    /**
     * Creates a new Admin instance with the given fields. Takes a last name,
     * first name, email, address, credit card number, its expiry date and
     * password and creates the corresponding Admin.
     *
     * @param lastName  this admins' last name.
     * @param firstName  this admins' first name.
     * @param email  this admins' email.
     * @param address  this admins' address.
     * @param creditCardNumber  this admins' credit card number.
     * @param expiryDate  a Date indicating this admins' credit card
     * 															expiry date.
     * @param password  the password for this admin.
     */
    public Admin(String lastName, String firstName, String email,
                 String address, long creditCardNumber, Date expiryDate,
                 String password) {

        super(lastName, firstName, email, address, creditCardNumber,
                expiryDate, password);
    }

    /**
     * Creates a new Admin instance with the given fields. Takes a last name,
     * first name, email, address, credit card number, its expiry date and
     * creates the corresponding Admin.
     *
     * <p> The password of this Admin is null and can be set later.
     *
     * @param lastName  this admins' last name.
     * @param firstName  this admins' first name.
     * @param email  this admins' email.
     * @param address  this admins' address.
     * @param creditCardNumber  this admins' credit card number.
     * @param expiryDate  a Date indicating this admins' credit card
     * 															expiry date.
     */
    public Admin(String lastName, String firstName, String email,
                 String address, long creditCardNumber, Date expiryDate) {
        super(lastName, firstName, email, address, creditCardNumber,
                expiryDate);
    }

    /**
     * Creates a new Admin instance with the given login Information.
     *
     * <p>All other information is set to null and can be reset later.
     *
     * @param email  this admins' email.
     * @param password  this admins' password.
     */
    public Admin(String email, String password) {
        super(email, password);
    }
}