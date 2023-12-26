package storage;

import java.util.Arrays;
import models.*;

public abstract class Storage implements IStorage {
	protected User[] users;
	protected Group[] groups;
	protected Members[] members;
	protected Subscription[] subs;

	public void init() throws Exception{
		parseUsers();
		parseGroups();
		parseMembers();
		parseSubscriptions();
	} 

	protected abstract void parseUsers() throws Exception;

	protected abstract void parseSubscriptions() throws Exception;

	protected abstract void parseGroups() throws Exception;

	protected abstract void parseMembers() throws Exception;

	public User getUserById(int id) throws Exception{
		for(User user : users){
			if(user.getId() == id) return user;
		}

		return null;
	}

	public Group getGroupById(int id) throws Exception{
		for(Group group : groups){
			if(group.getId() == id) return group;
		}

		return null;
	}

	public int getGroupCountOfMembers(Group group){
		int count = 0;

		for(User user : users){
			for(Members member : members){
				if(user.equals(member.getUser()) && group.equals(member.getGroup())) count++;
			}
		}

		return count;
	}

	public User[] getGroupMembers(Group group){
		int count = 0;
		User[] res = new User[members.length];

		for(Members member : members){
			if(member.getGroup().equals(group)){
				res[count] = member.getUser();
				count++;

			}
		}

		res = Arrays.copyOf(res, count);

		return res;
	}

	public User[] getUsers(){
		return users;
	}

	public Group[] getGroups(){
		return groups;
	}

	public Members[] getMembers(){
		return members;
	}

	public Subscription[] getSubs(){
		return subs;
	}
}