package storage;

import models.*;

public interface IStorage {
	void init() throws Exception;

	User getUserById(int id) throws Exception;

	Group getGroupById(int id) throws Exception;

	int getGroupCountOfMembers(Group group);

	User[] getUsers();

	Group[] getGroups();

	Members[] getMembers();

	Subscription[] getSubs();
}