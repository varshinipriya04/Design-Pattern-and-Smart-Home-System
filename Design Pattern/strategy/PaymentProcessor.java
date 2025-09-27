package strategy;

public class PaymentProcessor {
    private IPaymentMethod paymentMethod;

    public void setPaymentMethod(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(float amount) {
        paymentMethod.pay(amount);
    }
}
