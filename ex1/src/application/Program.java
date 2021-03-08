package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("BaseSalary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

		System.out.print("How many contracts to this worker: ");
		int n = sc.nextInt();

		for (int i = 1; i < n; i++) {
			System.out.println("Enter contract " + i + "# data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("value per hour:");
			double hourValue = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hour = sc.nextInt();
//teste
			HourContract contract = new HourContract(contractDate, hourValue, hour);

			worker.addContract(contract);

		}

		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		String monthAndYear = sc.nextLine();
		int year = Integer.parseInt(monthAndYear.substring(0, 2));
		int month = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name:  " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Incom for: " + worker.income(year, month));

		sc.close();
	}

}
