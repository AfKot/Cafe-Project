package cafeJDBCProject.com.qa.main;

public class Drink {
	
//	JDBC will create a table
//	We need a primary key (ID)
//	Auto incrementing
	
	
//	Fields
	private int id;
	private String type;
	private String size;
	private boolean dairyFree;
	private float price;
	
//	Constructor - for pushing data to database (WITHOUT ID)
	public Drink(String type, String size, boolean dairyFree, float price) {
		super();
		this.type = type;
		this.size = size;
		this.dairyFree = dairyFree;
		this.price = price;
	}

//	Constructor - for getting data out of database (WITH ID)
	public Drink(int id, String type, String size, boolean dairyFree, float price) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.dairyFree = dairyFree;
		this.price = price;
}
	
//	Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isDairyFree() {
		return dairyFree;
	}

	public void setDairyFree(boolean dairyFree) {
		this.dairyFree = dairyFree;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
//	toString

	@Override
	public String toString() {
		return "Drink [id=" + id + ", type=" + type + ", size=" + size + ", dairyFree=" + dairyFree + ", price=" + price
				+ "]";
	}
	
	
	

}
