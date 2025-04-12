package TemplateDesignPattern;

public class PayToMerchant extends PaymentFlow {
    @Override
    void validateRequest() {
        System.out.println("Request validated successfully");
    }

    @Override
    void debitAmount() {
        System.out.println("Amount debited");
    }

    @Override
    void calculateFees() {
        System.out.println("2% transaction fee");
    }

    @Override
    void creditAmount() {
        System.out.println("Amount credited Successfully");
    }
}
