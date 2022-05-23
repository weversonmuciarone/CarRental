package mode.entities;

public class Invoice {
	private double BasicPayment;
	private double Tax;
	
	public Invoice() {
	}

	public Invoice(double basicPayment, double tax) {
		BasicPayment = basicPayment;
		Tax = tax;
	}

	public double getBasicPayment() {
		return BasicPayment;
	}

	public void setBasicPayment(double basicPayment) {
		BasicPayment = basicPayment;
	}

	public double getTax() {
		return Tax;
	}

	public void setTax(double tax) {
		Tax = tax;
	}
	
	public Double totalPayment() {
		return getBasicPayment() + getTax();
	}

}
