# Strategy/Observer/Command

## ABSTRACT TASK

Develop online retail e-commerce platform with payment through PayPal or Credit Card. When user payment is processed
User and Sales Platform should be notified about this order.

### TASK

- Create OrderProcessingService and use Strategy pattern to process PayPal and Credit Card payment.
- Create OrderNotificationService for sending order data to User platform and to Sales platform
- Use Command pattern to execute notifications to User and Sales Platform
- Couple OrderProcessingService and OrderNotificationService using observer pattern to execute NotificationCommands when Observer is notified about new events.

## IMPLEMENTATION

PaymentProcessingService accept **Order** to process payment.
**Order** is processed by **PaymentServiceStrategy** implementation: **PayPalPaymentService** or 
**CreditCardPaymentService**
Each of **PaymentServiceStrategy** implements **PaymentObservable** interface and hold list of **PaymentObserver**
that are notified about events processed it **PaymentServiceStrategy**

**SalesPaymentNotificationCommand** and **UserPaymentNotificationCommand** implement **NotificationCommand** and **PaymentObserver** interfaces.
**PaymentServiceStrategy** and **OrderNotificationService** are loosely coupled together with help of Command patter that act as Observer.

### [Workflow demonstrated here](https://github.com/paintInSour/oop-design-patterns/blob/master/strategy-observer-command/src/test/java/patterns/command/CommandTest.java)

## Usage diagram

![Prototype](https://github.com/paintInSour/oop-design-patterns/blob/master/strategy-observer-command/static/diagram_lab3.png?raw=true)


