package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.Period;

public class DateTimeLab {
    public static void main(String[] args) {
        System.out.println("Exercise 1: LocalDate and DateTimeFormatter");
        LocalDate today = LocalDate.of(2025, 8, 21);

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.ENGLISH);

        System.out.println("Default format: " + today);
        System.out.println("Custom format 1: " + today.format(format1));
        System.out.println("Custom format 2: " + today.format(format2));

        System.out.println("\nExercise 2: LocalTime and DateTimeFormatter");
        LocalTime now = LocalTime.of(16, 45, 30);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println("Default format: " + now);
        System.out.println("24-hour format: " + now.format(dtf1));
        System.out.println("12-hour format with AM/PM: " + now.format(dtf2));
        /*
        1. Prediction:
        What do you think will be the output?
        First, 16:45:30 as the default time. Then it’ll repeat in 24-hour format. After that, you’ll see the same time but in 12-hour format with PM—something like 04:45:30 PM.

        2. Observation:
        Now, run the code. What is the actual output?
        Default format: 2025-08-21
        Custom format 1: 21/08/2025
        Custom format 2: Thursday, August 21, 2025

        3. Explanation:
        Default format: 16:45:30
        24-hour format: 16:45:30
        12-hour format with AM/PM: 04:45:30 PM
         */

        System.out.println("\nExercise 3: LocalDateTime and DateTimeFormatter");
        LocalDateTime event = LocalDateTime.of(2025, 11, 27, 19, 0, 0);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm a");

        System.out.println("Default format: " + event);
        System.out.println("Custom format: " + event.format(dtf));
        /*
        1. Prediction:
        What do you think will be the output?
        The default will look like 2025-11-27T19:00. Then, it’ll switch to a friendlier format: Nov 27, 2025 at 07:00 PM. The 'at' part is as is.

        2. Observation:
        Now, run the code. What is the actual output?
        Default format: 2025-11-27T19:00
        Custom format: Nov 27, 2025 at 07:00 PM

        3. Explanation:
        The formatter combines patterns for both date and time. MMM gives the abbreviated month name (e.g., "Nov"). You can also include literal text in the pattern by enclosing it in single quotes, like 'at'. The default format for LocalDateTime separates the date and time with a T.
         */

        System.out.println("\nExercise 4: The Immutability of Date-Time Objects");
        LocalDate startDate = LocalDate.of(2025, 9, 1);

        // Attempt to add 10 days, but don't assign the result
        startDate.plusDays(10);

        System.out.println("Start date after trying to modify it: " + startDate);

        // Now, correctly add 10 days by assigning the result to a new variable
        LocalDate endDate = startDate.plusDays(10);

        System.out.println("The original start date is still: " + startDate);
        System.out.println("The new end date is: " + endDate);
        /*
        1. Prediction:
        What do you think will be the output?
        This will show that startDate stays the same even after trying to add 10 days. Why? Because it didn’t store the new result. The next line will show the updated date (2025-09-11) since it assigned it to endDate.

        2. Observation:
        Start date after trying to modify it: 2025-09-01
        The original start date is still: 2025-09-01
        The new end date is: 2025-09-11

        3. Explanation:
        The first println shows that startDate was not changed by calling startDate.plusDays(10), because the result was discarded. startDate is immutable. To capture the change, you must assign the result of the operation to a variable, as shown with endDate. This prevents accidental modification and makes the code's behavior predictable.
         */

        System.out.println("\nExercise 5: Adding and Subtracting Time (plus and minus)");
        LocalDateTime baseTime = LocalDateTime.of(2025, 10, 15, 10, 30, 0);

        LocalDateTime futureTime = baseTime.plusYears(1).plusMonths(2).plusHours(5);
        LocalDateTime pastTime = baseTime.minusWeeks(3).minusDays(3);

        DateTimeFormatter dtfEx5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Base time:   " + baseTime.format(dtfEx5));
        System.out.println("Future time: " + futureTime.format(dtfEx5));
        System.out.println("Past time:   " + pastTime.format(dtfEx5));
        /*
        1. Prediction:
        What do you think will be the output?
        The base date is 2025-10-15 10:30. After adding 1 year, 2 months, and 5 hours, the future time becomes something like 2026-12-15 15:30. The past time subtracts 3 weeks and 3 days, ending around 2025-09-19 10:30.

        2. Observation:
        Base time:   2025-10-15 10:30
        Future time: 2026-12-15 15:30
        Past time:   2025-09-21 10:30

        3. Explanation:
        You can chain plus... and minus... methods to perform complex calculations fluently. Each method call returns a new LocalDateTime object, which is then used for the next call in the chain. The API correctly handles details like the number of days in a month.
         */

        System.out.println("\nExercise 6: Period - Measuring a Span of Time");
        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2026, 7, 20);

        Period period = Period.between(date1, date2);

        System.out.print("The period between the two dates is: ");
        System.out.print(period.getYears() + " years, ");
        System.out.print(period.getMonths() + " months, and ");
        System.out.println(period.getDays() + " days.");
        /*
        1. Prediction:
        What do you think will be the output?
        You’ll get a span between March 15, 2024 and July 20, 2026. That’s 2 years, 4 months, and 5 days. It breaks the time into parts so it's easy to read.

        2. Observation:
        Now, run the code. What is the actual output?
        The period between the two dates is: 2 years, 4 months, and 5 days.

        3. Explanation:
        Period.between(startDate, endDate) calculates the time difference between two LocalDate objects. It breaks down the total duration into years, months, and days. The calculation is smart; for instance, from March 15 to July 20, it correctly identifies the full months that have passed (April, May, June) and the remaining days.
         */
    }
}