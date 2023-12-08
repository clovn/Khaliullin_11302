package models;

public class Members {
	private User user;
	private Group group;

	public Members(User user, Group group){
		this.user = user;
		this.group = group;
	}

	public User getUser(){
		return user;
	}

	public Group getGroup(){
		return group;
	}
}