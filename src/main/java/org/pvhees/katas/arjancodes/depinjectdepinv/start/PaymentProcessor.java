package org.pvhees.katas.arjancodes.depinjectdepinv.start;

// video: https://www.youtube.com/watch?v=2ejbLVkCndI
public class PaymentProcessor {
    public void pay(Order order) {
        AuthorizerSms authorizer = new AuthorizerSms();
        authorizer.generateCode();
        authorizer.authorize();
        if (!authorizer.isAuthorized()) {
            throw new IllegalStateException("Not authorized");
        }
        System.out.println("Processing payment for order with id " + order.getId());
    }

    public static void main(String[] args) {
        Order order = new Order();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.pay(order);
    }
}
