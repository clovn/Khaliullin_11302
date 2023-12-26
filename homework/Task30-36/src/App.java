import services.Services;
import storage.*;
import models.Group;

public class App {
	public static void main(String[] args) throws Exception{
		IStorage db = new MockStorage();
		db.init();
		Services a = new Services(db);

		System.out.println("30. " + a.getUserNameWithMaxSubsFromHisCity());

		System.out.println("31. " + a.getGroupNameWithSubsFromAnotherCity());

		System.out.println("33. " + a.getGroupNameWhereSubsFromAdminAnotherCity());

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		double countOfGroups = db.getGroups().length;

		for(Group group : db.getGroups()){
			if(a.isFriendly1(group)) count1++;
			if(a.isFriendly2(group)) count2++;
			if(a.isFriendly3(group)) count3++;
		}

		System.out.println("34. " + count1/countOfGroups*100 + "% ");
		System.out.println("35. " + count2/countOfGroups*100 + "% ");
		System.out.println("36. " + count3/countOfGroups*100 + "% ");
	}
}