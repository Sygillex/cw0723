package service;

import objects.Checkout;
import objects.RentalAgreement;
import objects.Tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class CheckoutService {

    public CheckoutService(){}

    public RentalAgreement processCheckout(Checkout checkout) throws Exception {

        // Check immediate failures and throw exceptions
        if (checkout.getNumRentalDays() < 1) {
            throw new Exception("Invalid number of rental days: Tools rental days must be greater than 0.");
        } else if ( checkout.getDiscountPercent() < 0 || checkout.getDiscountPercent() > 100) {
            throw new Exception("Invalid discount: Please apply a discount percentage between 0 and 100.");
        }

        // Get tool information
        Tools tool = getToolToBeRented(checkout.getToolCode());
        if (tool == null) {
            throw new Exception("Invalid tool: The Tool Code you entered does not exist. Please enter an existing ");
        }

        // Calculate due Date
        LocalDate returnDate = checkout.getCheckoutDate().plusDays(checkout.getNumRentalDays());

        // Calculate the number of chargeable days
        int chargeDays = calculateNumberOfChargeDays(
            checkout.getCheckoutDate(),
            checkout.getNumRentalDays(),
            tool.isWeekDayCharge(),
            tool.isWeekendCharge(),
            tool.isHolidayCharge()
        );

        // Calculate the different price amounts
        BigDecimal preDiscountTotal = new BigDecimal(tool.getDailyCharge() * chargeDays).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountAmount = new BigDecimal(preDiscountTotal.doubleValue() * ((double) checkout.getDiscountPercent() /100)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalCharge = new BigDecimal(preDiscountTotal.doubleValue() - discountAmount.doubleValue()).setScale(2, RoundingMode.HALF_UP);


        // Build and return the rental agreement
        return new RentalAgreement(
            checkout.getToolCode(),
            tool.getType(),
            tool.getBrand(),
            checkout.getNumRentalDays(),
            checkout.getCheckoutDate(),
            returnDate,
            tool.getDailyCharge(),
            chargeDays,
            preDiscountTotal,
            checkout.getDiscountPercent(),
            discountAmount,
            finalCharge
        );
    }

    private Tools getToolToBeRented(String toolCode) {
        /*
            Normally I would implement Tools as a database, but that is outside the current scope. Therefore,
            I chose to implement Tools as an ENUM, and then retrieve them using this switch case. This is not
            a scalable solution, but I believe it is the best solution for this case. If the problem were to
            be expanded, I would implement a Tools table on a related database and retrieve the Tools information
            from there.
         */
        switch(toolCode) {
            case "CHNS":
                return Tools.CHNS;
            case "LADW":
                return Tools.LADW;
            case "JAKD":
                return Tools.JAKD;
            case "JAKR":
                return Tools.JAKR;
            default:
                return null;
        }
    }

    private int calculateNumberOfChargeDays(
        LocalDate checkoutDate,
        int numRentalDays,
        boolean weekDayCharge,
        boolean weekendCharge,
        boolean holidayCharge
    ) {
        int numChargeDays = numRentalDays;
        LocalDate chargeDate;

        for (int i = 1; i <= numRentalDays; i++) {
            chargeDate = checkoutDate.plusDays(i);

            if (isWeekend(chargeDate) && !weekendCharge) {
                numChargeDays --;
            } else if (isHoliday(chargeDate) && !holidayCharge) {
                numChargeDays --;
            }  else if (!isWeekend(chargeDate) && !weekDayCharge) {
                numChargeDays --;
            }
        }

        return numChargeDays;
    }

    private boolean isWeekend(LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isHoliday(LocalDate date) {
        LocalDate julyFourth = getJulyFourthChargeDay(date.getYear());
        LocalDate memorialDay = getMemorialDayChargeDay(date.getYear());

        if (date.isEqual(julyFourth)|| date.isEqual(memorialDay) ) {
            return true;
        } else {
            return false;
        }
    }

    private LocalDate getJulyFourthChargeDay(int year) {
        LocalDate date = LocalDate.of(year, Month.JULY, 4);

        if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            date = date.minusDays(1);
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }

        return date;
    }

    private LocalDate getMemorialDayChargeDay(int year) {
        LocalDate date = LocalDate.of(year, Month.SEPTEMBER, 1);
        return date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }
}
