package com.thoughtworks.movierental;public class TextStatement{private final com.thoughtworks.movierental.Customer customer;	public TextStatement(com.thoughtworks.movierental.Customer customer)	{		this.customer = customer;	}public java.lang.String statement() {
    return header() + details() + footer();
  }private java.lang.String header() {
    return "Rental Record for " + customer.getName() + "\n";
  }private java.lang.String details() {
    java.lang.String result = "";
    for (com.thoughtworks.movierental.Rental rental : customer.getRentals()) {
      result += "\t" + rental.getMovie().getTitle() + "\t" +
          java.lang.String.valueOf(rental.amount()) + "\n";
    }
    return result;
  }private java.lang.String footer() {
    java.lang.String result = "Amount owed is " + customer.totalAmount() + "\n";
    result += "You earned " + customer.totalFrequentRenterPoints()
            + " frequent renter points";
    return result;
  }}