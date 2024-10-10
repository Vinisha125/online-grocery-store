package entities;

public class Product {
	private int quantity;
	private int id;
	private String name;
	private float price;
	
	
	public Product(int quantity, int id, String name, float price) {
		super();
		this.quantity = quantity;
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
