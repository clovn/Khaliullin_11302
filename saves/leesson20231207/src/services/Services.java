package services;

import storage.Storage;
import models.*;

public class Services{
	private Storage data;

	public Services(Storage st) throws Exception{
		data = st;
	}

	public String getUserNameWithMaxSubsFromHisCity(){


		int userCount = data.getUsers().length;
		int max = 0;
		User haveMaxSubs = data.getUsers()[0];

		for(int i = 0; i < userCount; i++){
			int subsCount = 0;

			for(int j = i + 1; j < userCount; j++){

				User user1 = data.getUsers()[i];
				User user2 = data.getUsers()[j];

				if(user1.getCity().equals(user2.getCity())){

					for(Subscription sub : data.getSubs()){
						if(sub.getUser1Id() == user2.getId() && sub.getUser2Id() == user1.getId()) {
							subsCount++;
							break;
						}
					}

				}
			}

			if(subsCount > max){
				max = subsCount;
				haveMaxSubs = data.getUsers()[i];
			}
		}

		return haveMaxSubs.getName();
	}

	public String getGroupNameWithSubsFromAnotherCity(){
		String answer = "";

		for(Group group : data.getGroups()){
			boolean flag = true;

			for(Members member : data.getMembers()){
				if(group.equals(member.getGroup()) && group.getCity().equals(member.getUser().getCity())){
					flag = false;
					break;
				}
			}

			if(flag) answer += group.getName() + "\n";
		}

		return answer;
	}

	public String getGroupNameWhereSubsFromAdminAnotherCity(){
		String answer = "";

		for(Group group : data.getGroups()){
			String adminCity = group.getAdmin().getCity();
			System.out.println(adminCity + " " + group.getName());
			int count = 0;

			for(User user : data.getUsers()){
				for(Members sub : data.getMembers()){
					if(user.equals(sub.getUser()) && group.equals(sub.getGroup()) && !user.getCity().equals(adminCity)) {
						count++;
					}
				}
			}
			System.out.println(count + " " + data.getGroupCountOfMembers(group));
			if(count > data.getGroupCountOfMembers(group) / 2.0) answer += group.getName() + "\n";
		}

		return answer;
	}
}