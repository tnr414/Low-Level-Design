package TemplateDesignPattern;

abstract public class PaymentFlow {
    public final void pay() {
        // step 1
        validateRequest();

        // step 2
        debitAmount();

        // step 3
        calculateFees();

        // step 4
        creditAmount();
    }

    abstract void validateRequest();
    abstract void debitAmount();
    abstract void calculateFees();
    abstract void creditAmount();
}
