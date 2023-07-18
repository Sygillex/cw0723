import objects.Checkout;
import objects.RentalAgreement;
import service.CheckoutService;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();
        Checkout checkout = new Checkout(
                "JAKR",
                4,
                50,
                LocalDate.of(2020, Month.JULY, 2)
        );

        try {
            RentalAgreement response = service.processCheckout(checkout);
            response.printRentalAgreement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}