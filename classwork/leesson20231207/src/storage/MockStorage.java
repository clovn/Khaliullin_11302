package storage;

import models.*;

public class MockStorage extends Storage{
	private final static String[] CITIES = new String[]{"Moscow", "Omsk", "Kazan", "Ufa", "Saints-Peterburg"};

	protected void parseUsers() throws Exception{
		int countOfUsers = (int) (Math.random()*90 + 10);
		users = new User[countOfUsers];
		for(int i = 0; i < countOfUsers; i++){
			users[i] = new User(i, generateName(), CITIES[(int) (Math.random()*CITIES.length)]);
		}
	}

	protected void parseSubscriptions() throws Exception{
		int countOfSubscriptions = (int) (Math.random()*190 + 10);
		subs = new Subscription[countOfSubscriptions];
		for(int i = 0; i < countOfSubscriptions; i++){
			subs[i] = new Subscription((int) (Math.random()*users.length), (int) (Math.random()*users.length));
		}

	}

	protected void parseGroups() throws Exception {
		int countOfGroups = (int) (Math.random()*40 + 10);
		groups = new Group[countOfGroups];
		for(int i = 0; i < countOfGroups; i++){
			groups[i] = new Group(i, generateName(), CITIES[(int) (Math.random()*CITIES.length)], users[(int) (Math.random()*users.length)]);
		}
	}

	protected void parseMembers() throws Exception{
		int countOfMembers = (int) (Math.random()*450 +50);
		members = new Members[countOfMembers];
		for(int i = 0; i < countOfMembers; i++){
			members[i] = new Members(getUserById((int) (Math.random()*users.length)), getGroupById((int) (Math.random()*groups.length)));
		}
	}

	private String generateName(){
		String name = "";
		for(int i = 0; i < 7; i++) name += (char) (int) (Math.random()*26 + 97);
		return name;
	}
}