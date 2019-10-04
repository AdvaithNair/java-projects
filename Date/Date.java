/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

/**
 *
 * @author advaithnair
 */
public class Date {

    /**
     * Initialize Day Variable
     */
    private int day;

    /**
     * Initialize Month Variable
     */
    private int month;

    /**
     * Initialize Year Variable
     */
    private int year;

    /**
     * Constructor
     */
    Date() {
    }

    /**
     * Initializes class
     */
    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Return the day of the date
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Return the month of the date
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Return the year of the date
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the day of the date
     *
     * @param day
     *
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Set the month of the date
     *
     * @param month
     *
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Set the year of the date
     *
     * @param year
     *
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Convert month number entered to corresponding name of the month
     *
     * @param monthNum ranges from 1 - 12; represents the 12 months in the Gregorian Calendar
     * @return String - corresponding month name for month number
     */
    public static String toMonthString(int monthNum) {
        switch (monthNum) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Error";
        }
    }

    /**
     * Convert month number and year entered to corresponding number of days in said month
     *
     *
     * @param monthNum ranges from 1 - 12; represents the 12 months in the Gregorian Calendar
     * @param year used to determine if the year is leap (affects output in February)
     * @return Int - number of days in entered month number, depending on the year
     */
    public static int daysInMonth(int monthNum, int year) {
        switch (monthNum) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31; //Jan, Mar, May, Jul, Aug, Oct, and Dec have 31 days
            case 2:
                if (isLeap(year)) { //If the year is leap year
                    return 29; //Leap Feb has 29 days
                } else {
                    return 28; //Reg Feb has 28 days
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30; //Apr, Jun, Sep and Nov have 30 days
            default:
                return -1; //Essentially error message
        }
    }

    /**
     * Determines if the year entered is a leap year
     *
     *
     * @param year the integer value for the year to be checked for leap year status
     * @return bool - true if leap year, false if normal year
     *
     */
    public static boolean isLeap(int year) {
        if (year % 4 > 0) {
            return false;
        } else if ((year % 100 == 0) && (year % 400 > 0)) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Returns the date in string format
     *
     * @return String of the date
     */
    public String toString() {
        return toMonthString(this.month) + " " + this.day + ", " + this.year;
    }

    /**
     * Returns the day of the year the date object is in 
     *
     * @return number of this day in the Date object
     */
    public int daysInYear() {
        int days = 0;
        for (int i = 1; i < this.month; i++) {
            days += daysInMonth(i, this.year);
        }
        return days + this.day;
    }

    /**
     * Calculate the days in between date object and another date
     *
     * @param another
     * @return days in between date object and another date
     *
     */
    public int daysInBetween(Date another) {
        return Math.abs(daysInYear() - another.daysInYear());
    }

}
