import java.util.Arrays;

public class Task1{
	public static void main(String[] args) throws Exception{
		User[] users = Storage.parseUsers();
		Subscription[] subs =  Storage.parseSubscriptions();


		int userCount = users.length;
		int max = 0;
		User haveMaxSubs = users[0];

		for(int i = 0; i < userCount; i++){
			int subsCount = 0;

			for(int j = i + 1; j < userCount; j++){
				if(users[i].getCity().equals(users[j].getCity())){
					for(Subscription sub : subs){
						if(sub.getUser1Id() == users[j].getId() && sub.getUser2Id() == users[i].getId()) {
							subsCount++;
							break;
						}
					}
				}
			}

			if(subsCount > max){
				max = subsCount;
				haveMaxSubs = users[i];
			}
		}

		System.out.println(haveMaxSubs.getName());
	}
}