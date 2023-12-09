import services.Services;
import storage.*;
import models.Group;

public class App {
	public static void main(String[] args) throws Exception{
		IStorage db = new FileStorage();
		db.init();
		Services a = new Services(db);
		for(Group group : db.getGroups()){
			System.out.print(a.isFriendly1(group) + " ");
			System.out.print(a.isFriendly2(group) + " ");
			System.out.print(a.isFriendly3(group) + "\n");
		}
	}
}