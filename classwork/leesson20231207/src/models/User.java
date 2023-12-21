package models;

public class  User {
	private int id;
	private String name;
	private String city;

	public User(int id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}


	public String toString(){
		return name + "`s from " + city;
	}

	public String getCity(){
		return city;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public boolean equals(User user){
		try{
			return id == user.id;
		} catch(NullPointerException e){
			return false;
		}
	}
}