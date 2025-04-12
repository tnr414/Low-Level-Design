package TemplateDesignPattern;

public class PayToFriend extends PaymentFlow {
    @Override
    void validateRequest() {
        System.out.println("Request Validated Successfully");
    }

    @Override
    void debitAmount() {
        System.out.println("Amount Debited");
    }

    @Override
    void calculateFees() {
        System.out.println("0% fees");
    }

    @Override
    void creditAmount() {
        System.out.println("Amount credit successfully");
    }
}
