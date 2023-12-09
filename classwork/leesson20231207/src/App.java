import services.Services;
import storage.*;

public class App {
	public static void main(String[] args) throws Exception{
		IStorage db = new MockStorage();
		db.init();
		Services a = new Services(db);
		System.out.println(a.getUserNameWithMaxSubsFromHisCity());
		System.out.println(a.getGroupNameWithSubsFromAnotherCity());
		System.out.println(a.getGroupNameWhereSubsFromAdminAnotherCity());
	}
}