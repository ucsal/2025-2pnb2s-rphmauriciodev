package br.com.mariojp.solid.srp;

public class ReceiptService {
	public String generate(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();

		var taxCalculator = new TaxCalculator();
		var receiptFormatter = new ReceiptFormatter();

		double tax = taxCalculator.calculate(subtotal);
		double total = subtotal + tax;

		return receiptFormatter.format(order, subtotal, tax, total);
	}
}
