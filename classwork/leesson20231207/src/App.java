import services.Services;
import storage.Storage;

public class App {
	public static void main(String[] args) throws Exception{
		Storage db = new Storage();
		Services a = new Services(db);
		System.out.println(a.getUserNameWithMaxSubsFromHisCity());
		System.out.println(a.getGroupNameWithSubsFromAnotherCity());
		System.out.println(a.getGroupNameWhereSubsFromAdminAnotherCity());
	}
}