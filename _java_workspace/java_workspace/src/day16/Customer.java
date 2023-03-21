package day16;

public class Customer {
	
	private String name;
	private int age;
	private int price;
	
	public Customer() {}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		if(this.age >= 15) {
			price = 100;
		} else {
			price = 50;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
