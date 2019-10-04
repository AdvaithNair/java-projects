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
public class DateTester {
    public static void main(String[] args) {

        Date date1 = new Date(15, 12, 2014);
        Date date2 = new Date(1, 1, 2012);
        Date date3 = new Date();
        //three tester dates
        
        //mostly self explanatory, i'm just going thru each function
        System.out.println(Date.isLeap(1995));
        System.out.println("Expected: false");

        System.out.println(Date.daysInMonth(2, 2012));
        System.out.println("Expected: 29");

        System.out.println(date1.toString());
        System.out.println("Expected: December 15, 2014");

        System.out.println(date1.daysInYear());
        System.out.println("Expected: 349");

        System.out.println(date1.daysInBetween(date2));
        System.out.println("Expected: 348");
        
        date3.setDay(1);
        date3.setMonth(1);
        date3.setYear(2005);
        System.out.println(date3.getDay() + " " + date3.getMonth() + " " + date3.getYear());
        System.out.println("Expected: 1 1 2005");
        
        System.out.println(Date.toMonthString(3));
        System.out.println("Expected: March");
    }
}
