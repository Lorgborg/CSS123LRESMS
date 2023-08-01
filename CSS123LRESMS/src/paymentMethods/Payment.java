/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymentMethods;

/**
 *
 * @author Riniel
 */
public interface Payment {
    String processPayment(double price);
    void getPaymentDetails();
    void setPaymentDetails();
}

