package TemplateDesignPattern;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        PaymentFlow friendPayment = new PayToFriend();
        PaymentFlow merchantPayment = new PayToMerchant();

        friendPayment.pay();
        merchantPayment.pay();
    }
}
