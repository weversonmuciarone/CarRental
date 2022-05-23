package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import mode.entities.CarRental;
import mode.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

public class Project {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Enter price per hour: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		Double pricePerDay = sc.nextDouble();
		
		RentalServices rentalServices = new RentalServices(pricePerDay, pricePerHour, new BrazilTaxServices());
		
		rentalServices.processInvoice(cr);
		
		System.out.println("INVOICE");
		System.out.println("-------");
		System.out.println("Basic payment: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f",cr.getInvoice().totalPayment()));
	}

}
