package csc207.flightapp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import backend.Flight;
import backend.InvalidFlightException;

public class FlightTest {

    private static Flight testFlight;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" +
            " HH:mm");


    // Flight constructor
    @BeforeClass
    public static void setUpBeforeClass() throws InvalidFlightException,
            ParseException {
        testFlight = new Flight("American Airlines", 123l, "A", "B",
                format.parse("2015-11-10 7:30"), format.parse("2015-11-11" +
                " 12:30"), 1500.0, 300);
    }

    @Test(expected=InvalidFlightException.class)
    public void flightClassShouldThrowErrorWithCycle()
            throws InvalidFlightException, ParseException {
        new Flight("Emirates", 516l, "W", "W", format.parse("2015-11-10 7:30"),
                format.parse("2015-11-11 12:30"), 0.0, 500);
    }

    @Test(expected=InvalidFlightException.class)
    public void flightClassShouldThrowErrorWithWrongTiming()
            throws InvalidFlightException, ParseException{
        new Flight("Emirates", 516l, "W", "X",
                format.parse("2015-11-10 7:30"),
                format.parse("2015-11-10 6:30"),
                0.0, 500);
    }

    @Test(expected=InvalidFlightException.class)
    public void flightClassShouldThrowErrorWithNegativePrice()
            throws InvalidFlightException, ParseException{
        new Flight("Emirates", 516l, "W", "X", format.parse("2015-11-10 7:30"),
                format.parse("2015-11-10 8:30"), -10.0, 500);
    }

    @Test(expected=InvalidFlightException.class)
    public void flightClassShouldThrowErrorWithNegativeSeats()
            throws InvalidFlightException, ParseException{
        new Flight("Emirates", 516l, "W", "X", format.parse("2015-11-10 7:30"),
                format.parse("2015-11-10 8:30"), 30.0, -200);
    }

    // getAirline
    @Test
    public void getAirlineShouldReturnCorrectValue() {
        assertEquals(testFlight.getAirline(), "American Airlines");
    }

    /*
    @Test
    public void setAirlineShouldChangeValue()
            throws InvalidFlightException {
        Flight f = new Flight("Emirates", 303l, "S", "T",
                new Date(2016, 8, 19, 01, 00), new Date(2016, 8, 19, 03, 00),
                100.0, 50);

        f.setAirline("China Eastern");
        assertEquals(f.getAirline(), "China Eastern");
    }
    */

    // getNumber
    @Test
    public void getNumberShouldReturnCorrectValue() {
        assertEquals(testFlight.getNumber(), 123l);
    }

    /*
    @Test
    public void setNumberShouldChangeValue() throws InvalidFlightException {
        Flight f = new Flight("Emirates", 303l, "S", "T",
                new Date(2016, 8, 19, 01, 00), new Date(2016, 8, 19, 03, 00),
                100.0, 50);

        f.setNumber(513l);
        assertEquals(f.getNumber(), 513l);
    }
    */

    // getOrigin
    @Test
    public void getOriginShouldReturnCorrectValue() {
        assertEquals(testFlight.getOrigin(), "A");
    }

    // setOrigin
    @Test
    public void setOriginShouldChangeValue() throws InvalidFlightException,
            ParseException {
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);
        f.setOrigin("R");
        assertEquals(f.getOrigin(), "R");
    }

    @Test(expected=InvalidFlightException.class)
    public void setOriginShouldThrowErrorIfCycle()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setOrigin("T");
    }

    // getDestination
    @Test
    public void getDestinationShouldReturnCorrectValue() {
        assertEquals(testFlight.getDestination(), "B");
    }

    // setDestination
    @Test
    public void setDestinationShouldChangeValue()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setDestination("U");
        assertEquals(f.getDestination(), "U");
    }

    @Test(expected=InvalidFlightException.class)
    public void setDestinationShouldThrowErrorIfCycle()
            throws InvalidFlightException, ParseException {
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setDestination("S");
    }

    // getDepartureDateTime
    @Test
    public void getDepartureDateTimeShouldReturnCorrectValue()
            throws ParseException{
        assertEquals(
                testFlight.getDepartureDateTime(),
                format.parse("2015-11-10 7:30")
        );
    }

    // setDepartureDateTime
    @Test
    public void setDepartureDateTimeShouldChangeValue()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setDepartureDateTime(format.parse("2016-8-19 02:15"));
        assertEquals(f.getDepartureDateTime(), format.parse("2016-8-19 02:15"));
    }

    @Test(expected=InvalidFlightException.class)
    public void setDepartureDateTimeShouldThrowErrorIfNegativeTime()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setDepartureDateTime(format.parse("2016-9-1 10:30"));
    }

    // getArrivalDateTime
    @Test
    public void getArrivalDateTimeShouldReturnCorrectValue()
            throws ParseException{
        assertEquals(
                testFlight.getArrivalDateTime(), format.parse("2015-11-11 " +
                        "12:30"));
    }

    // setArrivalDateTime
    @Test
    public void setArrivalDateTimeShouldChangeValue()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setArrivalDateTime(new Date(2016, 8, 19, 02, 15));
        assertEquals(f.getArrivalDateTime(), new Date(2016, 8, 19, 02, 15));
    }

    @Test(expected=InvalidFlightException.class)
    public void setArrivalDateTimeShouldThrowErrorIfNegativeTime()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setArrivalDateTime(format.parse("2015-12-10 00:30"));
    }

    // getPrice
    @Test
    public void getPriceShouldReturnCorrectValue() {
        assertTrue(testFlight.getPrice() == 1500.00);
    }

    // setPrice
    @Test
    public void setPriceShouldChangePriceIfCorrect()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setPrice(250.12);
        assertTrue(f.getPrice() == 250.12);
        f.setPrice(-23.0);
        assertTrue(f.getPrice() == 250.12);
    }

    // getNumSeats
    @Test
    public void getNumSeatsShouldReturnCorrectValue() {
        assertEquals(testFlight.getNumSeats(), 300);
    }

    // setNumSeats
    @Test
    public void setNumSeatsShouldWork()
            throws InvalidFlightException, ParseException {
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setNumSeats(70);
        assertEquals(f.getNumSeats(), 70);
        assertEquals(f.getNumEmptySeats(), 70);
        f.setNumSeats(-1);
        assertEquals(f.getNumSeats(), 70);
        assertEquals(f.getNumEmptySeats(), 70);
        f.setNumSeats(10);
        assertEquals(f.getNumSeats(), 10);
        assertEquals(f.getNumEmptySeats(), 10);
        f.setNumEmptySeats(-1);
        f.setNumEmptySeats(6);
        f.setNumEmptySeats(12);
        assertEquals(f.getNumSeats(), 10);
        assertEquals(f.getNumEmptySeats(), 6);
        f.setNumSeats(6);
        assertEquals(f.getNumSeats(), 6);
        assertEquals(f.getNumEmptySeats(), 2);
        f.setNumSeats(30);
        assertEquals(f.getNumSeats(), 30);
        assertEquals(f.getNumEmptySeats(), 26);
    }

    // getNumEmptySeats, setNumEmptySeats
    @Test
    public void getNumEmptySeatsReturnsCorrectValue()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        assertTrue(!f.isFull());
        assertEquals(f.getNumSeats(), 50);
        assertEquals(f.getNumEmptySeats(), 50);
        f.bookSeat();
        assertTrue(!f.isFull());
        assertEquals(f.getNumSeats(), 50);
        assertEquals(f.getNumEmptySeats(), 49);
        f.setNumSeats(2);
        assertTrue(!f.isFull());
        assertEquals(f.getNumSeats(), 2);
        assertEquals(f.getNumEmptySeats(), 1);
        f.bookSeat();
        assertTrue(f.isFull());
        assertEquals(f.getNumSeats(), 2);
        assertEquals(f.getNumEmptySeats(), 0);
        f.bookSeat();
        assertTrue(f.isFull());
        assertEquals(f.getNumSeats(), 2);
        assertEquals(f.getNumEmptySeats(), 0);
    }

    // bookSeats
    @Test
    public void bookSeatBooksASingleSeatWhenFlightNotFull()
            throws InvalidFlightException, ParseException {
        Flight f = new Flight("Emirates", 303l, "S", "T", format.parse
                ("2016-08-19 01:00"),
                format.parse("2016-08-19 03:00"), 100.0, 50);

        f.setNumEmptySeats(43);

        assertTrue(!f.isFull());
        assertEquals(f.getNumSeats(), 50);
        assertEquals(f.getNumEmptySeats(), 43);
        f.bookSeat();
        assertTrue(!f.isFull());
        assertEquals(f.getNumSeats(), 50);
        assertEquals(f.getNumEmptySeats(), 42);
    }

    // compareTo
    @Test
    public void comparingFlightsShouldReturnCorrectValue()
            throws InvalidFlightException, ParseException{
        Date early = format.parse("2014-12-8 00:00");
        Date late = format.parse("2016-1-19 00:50");
        Date same = testFlight.getDepartureDateTime();

        Flight earlyFlight = new Flight(
                "Emirates", 69l, "B", "C", early, early, 10000.0, 100);
        Flight lateFlight = new Flight(
                "China Eastern", 34l, "M", "O", late, late, 0.0, 200);
        Flight sameFlight = new Flight(
                "Delta", 2000l, "Q", "Z", same, late, 0.0, 300);

        assertEquals(
                testFlight.compareTo(earlyFlight),
                testFlight.getDepartureDateTime().compareTo(early)
        );
        assertEquals(
                testFlight.compareTo(lateFlight),
                testFlight.getDepartureDateTime().compareTo(late)
        );
        assertEquals(
                testFlight.compareTo(sameFlight),
                testFlight.getDepartureDateTime().compareTo(same)
        );
    }

    // equals
    @Test
    public void equalsShouldReturnCorrectValue()
            throws InvalidFlightException, ParseException{
        Date early = format.parse("2014-12-8 0:0");
        Date late = format.parse("2016-1-19 0:50");
        Date same = testFlight.getDepartureDateTime();

        Flight f1 = new Flight("A", 123l, "A", "T",
                format.parse("2016-8-19 01:00"), format.parse("2016-8-19 " +
                "03:00"), 100.0, 50);
        Flight f2 = new Flight("American Airlines", 123l, "E", "F",
                format.parse("2016-8-19 10:00"), format.parse("2016-8-19 " +
                "13:00"), 300.0, 75);
        Flight f3 = new Flight("American Airlines", 606l, "A", "B",
                format.parse("2015-11-10 7:30"), format.parse("2015-11-11 " +
                "12:30"), 1500.0, 300);
        Flight f4 = new Flight(
                "China Eastern", 712l, "E", "B", early, late, 0.0, 200);
        Flight f5 = new Flight(
                "Delta", 2000l, "Q", "Z", same, late, 0.0, 300);

        assertNotEquals(testFlight, f1);
        assertEquals(testFlight, f2);
        assertNotEquals(testFlight, f3);
        assertNotEquals(testFlight, f4);
        assertNotEquals(testFlight, f5);
    }

    // getDuration
    @Test
    public void getDurationShouldReturnCorrectValue()
            throws InvalidFlightException, ParseException{
        Date early = format.parse("2014-12-8 0:0");
        Date late = format.parse("2015-11-20 7:30");
        Date same = testFlight.getDepartureDateTime();

        Flight earlyFlight = new Flight(
                "Emirates", 69l, "B", "C", early, early, 10000.0, 100);
        Flight lateFlight = new Flight(
                "China Eastern", 34l, "M", "O", late, late, 0.0, 200);
        Flight sameFlight = new Flight(
                "Delta", 2000l, "Q", "Z", same, late, 0.0, 300);

        assertTrue(earlyFlight.getDuration() == 0l);
        assertTrue(lateFlight.getDuration() == 0l);
        assertTrue(sameFlight.getDuration() == 14400l); // 10 day time diff
    }

    // toString
    @Test
    public void toStringShouldReturnCorrectString()
            throws InvalidFlightException, ParseException{
        Flight f = new Flight("American Airlines", 123l, "A", "B",
                format.parse("2000-11-10 7:30"), format.parse("2000-11-11 " +
                        "12:30"), 1500.0, 300);
        String expectedString = "123,2000-11-10 07:30,2000-11-11 12:30," +
                "American Airlines,A,B,1500.00";
        assertEquals(f.toString(), expectedString);
    }
}


