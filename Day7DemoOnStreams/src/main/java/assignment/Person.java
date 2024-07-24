package assignment;

public class Person {
		
	private String name;
	private int age;
	private String city;
	private String aadharNuber;
	
	public Person() {
		super();
	}
	
	public Person(String name, int age, String city, String aadharNuber) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.aadharNuber = aadharNuber;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAadharNuber() {
		return aadharNuber;
	}

	public void setAadharNuber(String aadharNuber) {
		this.aadharNuber = aadharNuber;
	}		

}
