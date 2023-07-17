package tests;

import objects.Checkout;
import objects.RentalAgreement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CheckoutService;

import java.time.LocalDate;
import java.time.Month;

public class CheckoutServiceTests {

    CheckoutService service;

    @BeforeEach
    void setup() {
        service = new CheckoutService();
    }

    @Test
    void checkoutTest1() {
        Checkout checkout = new Checkout(
            "JAKR",
            5,
            101,
            LocalDate.of(2015, Month.SEPTEMBER, 3)
        );

        Assert.assertThrows(Exception.class, () -> service.processCheckout(checkout));
    }

    @Test
    void checkoutTest2() throws Exception {
        Checkout checkout = new Checkout(
            "LADW",
            3,
            10,
            LocalDate.of(2020, Month.JULY, 2)
        );

        RentalAgreement response = service.processCheckout(checkout);

        Assertions.assertEquals(response.getToolType(), "Ladder");
        Assertions.assertEquals(response.getToolBrand(), "Werner");
        Assertions.assertEquals(response.getDueDate(), LocalDate.of(2020, Month.JULY, 5));
        Assertions.assertEquals(response.getDailyRentalCharge(), 1.49, .01);
        Assertions.assertEquals(response.getChargeDays(), 1);
        Assertions.assertEquals(response.getPreDiscountTotal().doubleValue(), 1.49, .01);
        Assertions.assertEquals(response.getDiscountAmount().doubleValue(), .15, .01);
        Assertions.assertEquals(response.getFinalCharge().doubleValue(), 1.34, .01);
    }

    @Test
    void checkoutTest3() throws Exception {
        Checkout checkout = new Checkout(
            "CHNS",
            5,
            25,
            LocalDate.of(2015, Month.JULY, 2)
        );

        RentalAgreement response = service.processCheckout(checkout);

        Assertions.assertEquals(response.getToolType(), "Chainsaw");
        Assertions.assertEquals(response.getToolBrand(), "Stihl");
        Assertions.assertEquals(response.getDueDate(), LocalDate.of(2015, Month.JULY, 7));
        Assertions.assertEquals(response.getDailyRentalCharge(), 1.99, .01);
        Assertions.assertEquals(response.getChargeDays(), 4);
        Assertions.assertEquals(response.getPreDiscountTotal().doubleValue(), 7.96, .01);
        Assertions.assertEquals(response.getDiscountAmount().doubleValue(), 1.99, .01);
        Assertions.assertEquals(response.getFinalCharge().doubleValue(), 5.97, .01);
    }

    @Test
    void checkoutTest4() throws Exception {
        Checkout checkout = new Checkout(
            "JAKD",
            6,
            0,
            LocalDate.of(2015, Month.SEPTEMBER, 3)
        );

        RentalAgreement response = service.processCheckout(checkout);

        Assertions.assertEquals(response.getToolType(), "Jackhammer");
        Assertions.assertEquals(response.getToolBrand(), "DeWalt");
        Assertions.assertEquals(response.getDueDate(), LocalDate.of(2015, Month.SEPTEMBER, 9));
        Assertions.assertEquals(response.getDailyRentalCharge(), 2.99, .01);
        Assertions.assertEquals(response.getChargeDays(), 3);
        Assertions.assertEquals(response.getPreDiscountTotal().doubleValue(), 8.97, .01);
        Assertions.assertEquals(response.getDiscountAmount().doubleValue(), 0.0, .01);
        Assertions.assertEquals(response.getFinalCharge().doubleValue(), 8.97, .01);
    }

    @Test
    void checkoutTest5() throws Exception {
        Checkout checkout = new Checkout(
            "JAKR",
            9,
            0,
            LocalDate.of(2015, Month.JULY, 2)
        );

        RentalAgreement response = service.processCheckout(checkout);

        Assertions.assertEquals(response.getToolType(), "Jackhammer");
        Assertions.assertEquals(response.getToolBrand(), "Ridgid");
        Assertions.assertEquals(response.getDueDate(), LocalDate.of(2015, Month.JULY, 11));
        Assertions.assertEquals(response.getDailyRentalCharge(), 2.99, .01);
        Assertions.assertEquals(response.getChargeDays(), 5);
        Assertions.assertEquals(response.getPreDiscountTotal().doubleValue(), 14.95, .01);
        Assertions.assertEquals(response.getDiscountAmount().doubleValue(), 0.0, .01);
        Assertions.assertEquals(response.getFinalCharge().doubleValue(), 14.95, .01);
    }

    @Test
    void checkoutTest6() throws Exception {
        Checkout checkout = new Checkout(
            "JAKR",
            4,
            50,
            LocalDate.of(2020, Month.JULY, 2)
        );

        RentalAgreement response = service.processCheckout(checkout);

        Assertions.assertEquals(response.getToolType(), "Jackhammer");
        Assertions.assertEquals(response.getToolBrand(), "Ridgid");
        Assertions.assertEquals(response.getDueDate(), LocalDate.of(2020, Month.JULY, 6));
        Assertions.assertEquals(response.getDailyRentalCharge(), 2.99, .01);
        Assertions.assertEquals(response.getChargeDays(), 1);
        Assertions.assertEquals(response.getPreDiscountTotal().doubleValue(), 2.99, .01);
        Assertions.assertEquals(response.getDiscountAmount().doubleValue(), 1.50, .01);
        Assertions.assertEquals(response.getFinalCharge().doubleValue(), 1.49, .01);
    }
}
