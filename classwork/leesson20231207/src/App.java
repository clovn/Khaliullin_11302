import services.Services;
import storage.*;
import models.Group;

public class App {
	public static void main(String[] args) throws Exception{
		IStorage db = new MockStorage();
		db.init();
		Services a = new Services(db);
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		double countOfGroups = db.getGroups().length;
		for(Group group : db.getGroups()){
			if(a.isFriendly1(group)) count1++;
			if(a.isFriendly2(group)) count2++;
			if(a.isFriendly3(group)) count3++;
		}

		System.out.println(count1/countOfGroups*100 + "% " + count2/countOfGroups*100+ "% " + count3/countOfGroups*100 + "%");
	}
}