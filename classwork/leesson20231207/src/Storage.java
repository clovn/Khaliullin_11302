import java.util.Scanner;
import java.io.File;

public class Storage {
	public static User[] parseUsers() throws Exception{
		Scanner in = new Scanner(new File("users.txt"));
		int userCount = Integer.parseInt(in.nextLine());
		User[] users = new User[userCount];

		for(int i = 0; i < userCount; i++){
			String[] data = in.nextLine().split(" ");

			users[i] = new User(Integer.parseInt(data[0]), data[1], data[2]);
		}

		return users;
	}

	public static Subscription[] parseSubscriptions() throws Exception{
		Scanner in = new Scanner(new File("subscription.txt"));
		int subsCount = Integer.parseInt(in.nextLine());
		Subscription[] subs = new Subscription[subsCount];

		for(int i = 0; i < subsCount; i++){
			String[] data = in.nextLine().split(" ");

			subs[i] = new Subscription(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		}

		return subs;
	}
}