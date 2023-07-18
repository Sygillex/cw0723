package objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int numRentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private BigDecimal preDiscountTotal;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    public RentalAgreement() {}

    public RentalAgreement(
            String toolCode,
            String toolType,
            String toolBrand,
            int numRentalDays,
            LocalDate checkoutDate,
            LocalDate dueDate,
            double dailyRentalCharge,
            int chargeDays,
            BigDecimal preDiscountTotal,
            int discountPercent,
            BigDecimal discountAmount,
            BigDecimal finalCharge
    ) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.numRentalDays = numRentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountTotal = preDiscountTotal;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public int getNumRentalDays() {
        return numRentalDays;
    }

    public void setNumRentalDays(int numRentalDays) {
        this.numRentalDays = numRentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public BigDecimal getPreDiscountTotal() {
        return preDiscountTotal;
    }

    public void setPreDiscountTotal(BigDecimal preDiscountTotal) {
        this.preDiscountTotal = preDiscountTotal;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
    }

    public void printRentalAgreement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        System.out.println("HERE IS YOUR RENTAL AGREEMENT");
        System.out.println("Tool Code: " + toolCode);
        System.out.println("Tool Type: " + toolType);
        System.out.println("Tool Brand: " + toolBrand);
        System.out.println("Number of Rental Days: " + numRentalDays);
        System.out.println("Checkout Date: " + checkoutDate.format(formatter));
        System.out.println("Due Date: " + dueDate.format(formatter));
        System.out.println("Daily Rental Charge: $" + dailyRentalCharge);
        System.out.println("Charge Days: " + chargeDays);
        System.out.println("Pre-Discount Total: $" + preDiscountTotal);
        System.out.println("Discount Percent: " + discountPercent + "%");
        System.out.println("Discount Amount: $" + discountAmount);
        System.out.println("Final Charge: $" + finalCharge);
    }
}
