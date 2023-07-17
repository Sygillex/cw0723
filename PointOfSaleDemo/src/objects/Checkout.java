package objects;

import java.time.LocalDate;

public class Checkout {
    private String toolCode;
    private int numRentalDays;

    private int discountPercent;

    private LocalDate checkoutDate;

    public Checkout(
        String toolCode,
        int numRentalDays,
        int discountPercent,
        LocalDate checkoutDate
    ) {
        this.toolCode = toolCode;
        this.numRentalDays = numRentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getNumRentalDays() {
        return numRentalDays;
    }

    public void setNumRentalDays(int numRentalDays) {
        this.numRentalDays = numRentalDays;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
