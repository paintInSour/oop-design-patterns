# Prototype/Builder

## ABSTRACT TASK

Develop online retail e-commerce platform with payment through PayPal or Credit Card. When user payment is processed
User and Sales Platform should be notified about this order.

### TASK

- Create Order processors using Strategy pattern for PayPal and Credit Card payment.
- Create service for sending order data to User platform and to Sales platform
- Bound Order processors with User and Sales platforms using Observer pattern.

## IMPLEMENTATION

PaymentProcessingService accept **Order** to process payment.
**Order** is processed by **PaymentServiceStrategy** implementation: **PayPalPaymentService** or 
**CreditCardPaymentService**
Each of **PaymentServiceStrategy** implements **PaymentObservable** interface and hold list of **PaymentObserver**
that are notified about events processed it **PaymentServiceStrategy**

**SalesPaymentNotificationCommand** and **UserPaymentNotificationCommand** implement **NotificationCommand** and **PaymentObserver** interfaces.
**PaymentServiceStrategy** and **OrderNotificationService** are loosely coupled together with help of Command patter that act as Observer.

### [Workflow demonstrated here](https://github.com/paintInSour/oop-design-patterns/blob/master/prototype-builder/src/test/java/patterns/command/CommandTest.java)

## Prototype usage diagram

![Prototype](https://github.com/paintInSour/oop-design-patterns/blob/master/strategy-observer-command/static/diagram_lab3.png?raw=true)


