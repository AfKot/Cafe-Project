package cafeJDBCProject.com.qa.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cafe {

//	DONT NEED AN ARRAY LIST AS OUR DATABASE WILL BE STORING OUR DATA

	Statement stmt = null;
	Connection conn = null;

	JDBCDemo db = new JDBCDemo();

	public void addDrink(Drink drink) {
		try {
			
			conn = db.connect();	
			stmt = conn.createStatement();
			
//			String queryOld = "";
			String query = "INSERT INTO drinks(type, size, dairyFree, price) VALUES('"+ drink.getType() + "', '"+ drink.getSize() +"', " + drink.isDairyFree()+ ", "+ drink.getPrice()+");";;
			System.out.println(query);
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Drink getDrinkById(int id) {
		
		try {
		
		conn = db.connect();
		stmt = conn.createStatement();
		String query = "SELECT * FROM drinks WHERE id = " + id ;
		System.out.println(query);
		
		ResultSet results = stmt.executeQuery(query);
		results.next();
		Drink drinkResult = modelDrink(results);
		return drinkResult;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
		}

	}
	
	public Drink getDrinkBySize(String size) {
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks WHERE size = " + "'" + size + "'" ;
			System.out.println(query);
			
			ResultSet result = stmt.executeQuery(query);
			result.next();
			Drink drinkResult = modelDrink(result);
			return drinkResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Drink> getAllDrinks() {
		ArrayList<Drink> resultList = new ArrayList<Drink>();
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks";
			System.out.println(query);
			ResultSet results = stmt.executeQuery(query);
			
			while(results.next()) {
				
				resultList.add(modelDrink(results));
			}
			return resultList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Drink updateDrinkById(Drink drink, int id) {
		
		try {
			conn = db.connect();
			String query = "UPDATE drinks SET type = ?, size = ?, dairyFree = ?, price = ? WHERE id = ?";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, drink.getType());
			preStmt.setString(2, drink.getSize());
			preStmt.setBoolean(3, drink.isDairyFree());
			preStmt.setFloat(4, drink.getPrice());
			preStmt.setInt(5, id);
			preStmt.executeUpdate();
			return getDrinkById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteDrinkById(int id) {
		
		try {
			conn = db.connect();
			String query = "DELETE FROM drinks WHERE id = ?;";
			PreparedStatement preStmt = conn.prepareStatement(query);
			
			preStmt.setInt(1, id);
			preStmt.executeUpdate();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Drink modelDrink(ResultSet result) {
		try {
			int id = result.getInt(1);
			String type = result.getString("type");
			String size = result.getString("size");
			boolean bool = result.getBoolean("dairyFree");
			float price = result.getFloat("price");
			
			Drink drink = new Drink(id, type, size, bool, price);
			return drink;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

