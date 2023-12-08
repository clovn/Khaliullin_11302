package storage;
import models.*;

import java.util.Scanner;
import java.io.File;

public class Storage {

	private User[] users;
	private Group[] groups;
	private Members[] members;
	private Subscription[] subs;

	public Storage() throws Exception{
		parseUsers();
		parseGroups();
		parseSubscriptions();
		parseMembers();
	} 

	private void parseUsers() throws Exception{
		Scanner in = new Scanner(new File("./resources/users.txt"));
		int userCount = Integer.parseInt(in.nextLine());
		users = new User[userCount];

		for(int i = 0; i < userCount; i++){
			String[] data = in.nextLine().split(" ");

			users[i] = new User(Integer.parseInt(data[0]), data[1], data[2]);
		}
	}

	private void parseSubscriptions() throws Exception{
		Scanner in = new Scanner(new File("./resources/subscription.txt"));
		int subsCount = Integer.parseInt(in.nextLine());
	 	subs = new Subscription[subsCount];

		for(int i = 0; i < subsCount; i++){
			String[] data = in.nextLine().split(" ");

			subs[i] = new Subscription(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		}
	}

	private void parseGroups() throws Exception {
		Scanner in = new Scanner(new File("./resources/groups.txt"));
		int groupCount = Integer.parseInt(in.nextLine());
		groups = new Group[groupCount];

		for(int i = 0; i < groupCount; i++){
			String[] data = in.nextLine().split(" ");

			groups[i] = new Group(Integer.parseInt(data[0]), data[1], data[2], getUserById(Integer.parseInt(data[3])));
		}
	}

	private void parseMembers() throws Exception{
		Scanner in = new Scanner(new File("./resources/members.txt"));
		int membersCount = Integer.parseInt(in.nextLine());
		members = new Members[membersCount];

		for(int i = 0; i < membersCount; i++){
			String[] data = in.nextLine().split(" ");

			members[i] = new Members(getUserById(Integer.parseInt(data[0])), getGroupById(Integer.parseInt(data[1])));
		}
	}

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