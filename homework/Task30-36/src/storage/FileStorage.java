package storage;
import models.*;

import java.util.Scanner;
import java.io.File;

public class FileStorage extends Storage {

	protected void parseUsers() throws Exception{
		Scanner in = new Scanner(new File("./resources/Users.txt"));
		int userCount = Integer.parseInt(in.nextLine());
		users = new User[userCount];

		for(int i = 0; i < userCount; i++){
			String[] data = in.nextLine().split(" ");

			users[i] = new User(Integer.parseInt(data[0]), data[1], data[2]);
		}
	}

	protected void parseSubscriptions() throws Exception{
		Scanner in = new Scanner(new File("./resources/Subscriptions.txt"));
		int subsCount = Integer.parseInt(in.nextLine());
	 	subs = new Subscription[subsCount];

		for(int i = 0; i < subsCount; i++){
			String[] data = in.nextLine().split(" ");

			subs[i] = new Subscription(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		}
	}

	protected void parseGroups() throws Exception {
		Scanner in = new Scanner(new File("./resources/Groups.txt"));
		int groupCount = Integer.parseInt(in.nextLine());
		groups = new Group[groupCount];

		for(int i = 0; i < groupCount; i++){
			String[] data = in.nextLine().split(" ");

			groups[i] = new Group(Integer.parseInt(data[0]), data[1], data[2], getUserById(Integer.parseInt(data[3])));
		}
	}

	public void parseMembers() throws Exception{
		Scanner in = new Scanner(new File("./resources/Members.txt"));
		int membersCount = Integer.parseInt(in.nextLine());
		members = new Members[membersCount];

		for(int i = 0; i < membersCount; i++){
			String[] data = in.nextLine().split(" ");

			members[i] = new Members(getUserById(Integer.parseInt(data[1])), getGroupById(Integer.parseInt(data[0])));
		}
	}
}