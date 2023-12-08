package models;

public class Subscription {
	private int user1Id;
	private int user2Id;

	public Subscription(int user1Id, int user2Id){
		this.user1Id = user1Id;
		this.user2Id = user2Id;
	}

	public String toString(){
		return user1Id + " subbed " + user2Id;
	}

	public int getUser1Id(){
		return user1Id;
	}

	public int getUser2Id(){
		return user2Id;
	}
}