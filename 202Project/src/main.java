import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
	private static MSLL<String> mainList = new MSLL<>();

	public static void main(String[] args) {
		double la1 = Math.toRadians(26.2361), la2 = Math.toRadians(21.4225),
				lo1 = Math.toRadians(50.0393), lo2 = Math.toRadians(39.8262);
		System.out.println(2.0 * 6372.8 * Math.asin(Math.sqrt(Math.pow(Math.sin((la2 - la1) / 2.0), 2)
					+ Math.cos(la1) * Math.cos(la2) * Math.pow(Math.sin((lo2 - lo1) / 2.0), 2))));
		Scanner kb;
		int c = 0;
		while (c != 13) {
			try {
				 kb = new Scanner(System.in);
				System.out.println("1.AddCityToSublistAtRear\n" + "2.AddCityToSublistAtPosition\n" + "3.SearchForCity\n"
						+ "4.DeleteCityFromCitySublist\n" + "5.DeleteCitySublist\n" + "6.MakeCitySublistEmpty\n"
						+ "7.DisplayCitySublist\n" + "8.addToMSSLAtHead\n" + "9.AddToMSSLAtTail\n"
						+ "10.DeleteFromMSSL\n" + "11.SearchMSLList\n" + "12.getDistance\n" + "13.Exit\n"
						+ "Choose number(1-13): ");
				if (!kb.hasNextInt()) {
					kb.nextLine();
					c = 0;
				} else
					c = kb.nextInt();
				switch (c) {
				case 1:
					m1();
					break;
				case 2:
					m2();
					break;
				case 3:
					m3();
					break;
				case 4:
					m4();
					break;
				case 5:
					m5();
					break;
				case 6:
					m6();
					break;
				case 7:
					m7();
					break;
				case 8:
					m8();
					break;
				case 9:
					m9();
					break;
				case 10:
					m10();
					break;
				case 11:
					m11();
					break;
				case 12:
					m12();
					break;
				case 13:
					System.exit(0);
					break;

				default:
					System.out.println("invalid number, try again.");
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	private static void m1() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter city name: ");
		String name = kb.next();
		System.out.print("Enter the city latitude in decimal degrees: ");
		double lat = kb.nextDouble();
		System.out.print("Enter the city longitude in decimal degrees: ");
		double lon = kb.nextDouble();

		MSLLNode mainNode = mainList.getMSLL(name.charAt(0) + "");
		if (mainNode != null)
			mainNode.list.addCityToSublistAtRear(new City(name, lat, lon));
		else
			System.out.println("Failed: add MSLL node with info = " + name.charAt(0) + " first");

	}

	private static void m2() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter city name: ");
		String name = kb.next();
		System.out.print("Enter the city latitude in decimal degrees: ");
		double lat = kb.nextDouble();
		System.out.print("Enter the city longitude in decimal degrees: ");
		double lon = kb.nextDouble();
		System.out.print("Enter the insertion position: ");
		int p = kb.nextInt();
		MSLLNode mainNode = mainList.getMSLL(name.charAt(0) + "");
		if (mainNode != null)
			mainNode.list.addToCitySublistList(new City(name, lat, lon), p);
		else
			System.out.println("Failed: add MSLL node with info = " + name.charAt(0) + " first");
	}

	private static void m3() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter city name: ");
		String name = kb.next();
		MSLLNode mainNode = mainList.getMSLL(name.charAt(0) + "");
		if (mainNode != null)
			if (mainNode.list.cityIsInSubList(new City(name)))
				System.out.println(mainNode.list.getCity(name));
			else
				System.out.println("City is not in list");
		else
			System.out.println("City is not in list");
	}

	private static void m4() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter city name:");
		String name = kb.next();
		MSLLNode mainNode = mainList.getMSLL(name.charAt(0) + "");
		if (mainNode != null)
			mainNode.list.deleteCityFromSublist(name);
		else
			System.out.println("City is not in list");
	}

	private static void m5() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.deleteFromMSLL(kb.next());
	}

	private static void m6() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.makeCitySublistEmpty(kb.next());

	}

	private static void m7() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.displayCitySublist(kb.next());

	}

	private static void m8() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.addToMSLLHead(kb.next());

	}

	private static void m9() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.addToMSLLTail(kb.next());

	}

	private static void m10() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter key: ");
		mainList.deleteFromMSLL(kb.next());

	}

	private static void m11() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter Key: ");
		mainList.getMSLL(kb.next()).list.printAll();
	}

	private static void m12() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of city1: ");
		String city1 = kb.next();
		System.out.print("Enter the name of city2: ");
		String city2 = kb.next();
		System.out.println();
		double distance = mainList.getDistance(city1, city2);
		System.out.println("Distance = "+distance+" km");

	}
}
