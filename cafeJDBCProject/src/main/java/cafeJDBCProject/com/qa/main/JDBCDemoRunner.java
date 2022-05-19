package cafeJDBCProject.com.qa.main;

public class JDBCDemoRunner {

	public static void main(String[] args) {
		
//		create JDBC demo object
		JDBCDemo jdbc = new JDBCDemo();
				
		Cafe newCafe = new Cafe();
		
		
//		Drink latte = new Drink("Latte", "Large", true, 3.65f);
//		
//		newCafe.addDrink(latte);
//		
//		Drink cappuccino = new Drink("Cappuccino", "Medium", false, 4.05f);
//		
//		newCafe.addDrink(cappuccino);
		
		System.out.println(newCafe.getDrinkById(1));
		System.out.println("-------------------------------");		
		System.out.println(newCafe.getDrinkBySize("Large"));
		System.out.println("-------------------------------");
		System.out.println(newCafe.getAllDrinks());
		System.out.println("-------------------------------");
//		newCafe.deleteDrinkById(4);
		System.out.println("-------------------------------");
		System.out.println(newCafe.getAllDrinks());
		System.out.println("-------------------------------");
		
	}

}
