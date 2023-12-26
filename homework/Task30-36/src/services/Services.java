package services;

import storage.IStorage;
import models.*;

public class Services{
	private IStorage data;

	public Services(IStorage st) throws Exception{
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

			if(flag) answer += group.getName() + ", ";
		}

		return answer;
	}

	public String getGroupNameWhereSubsFromAdminAnotherCity(){
		String answer = "";

		for(Group group : data.getGroups()){
			String adminCity = group.getAdmin().getCity();
			int count = 0;

			for(User user : data.getUsers()){
				for(Members sub : data.getMembers()){
					if(user.equals(sub.getUser()) && group.equals(sub.getGroup()) && !user.getCity().equals(adminCity)) {
						count++;
					}
				}
			}
			if(count > data.getGroupCountOfMembers(group) / 2.0) answer += group.getName() + ", ";
		}

		return answer;
	}

	public boolean isFriendly1(Group group) throws Exception{
		User[] subs = data.getGroupMembers(group);

		for(int i = 0; i < subs.length; i++){
			for(int j = 0; j < subs.length; j++){
				if(!isFriends(subs[i], subs[j])) return false;
			}
		}

		return true;
	}

	public boolean isFriendly2(Group group) throws Exception{
		User[] subs = data.getGroupMembers(group);

		for(int i = 0; i < subs.length; i++){
			boolean flag = false;

			for(int j = 0; j < subs.length; j++){
				if(isFriends(subs[i], subs[j])) {
					flag = true;
					break;
				}
			}

			if(!flag) return false;

		}

		return true;

	}

	public boolean isFriendly3(Group group) throws Exception{
		User[] subs = data.getGroupMembers(group);
		if(subs.length == 0) return false;
		
		int forRead = 0;
		int forAdd = 1;
		User[] q = new User[subs.length];
		q[0] = subs[0];

		while(forRead < forAdd){
			for(User sub : subs){
				if(isFriends(q[forRead], sub) && notInQueue(sub, q)) {
					q[forAdd] = sub;
					forAdd++;
				}
			}
			forRead++;
		}

		if(q.length == subs.length) return true;
		return false;
	}

	private boolean notInQueue(User user, User[] queue){
		for(User sub : queue){
			if(user.equals(sub)) return false;
		}

		return true;
	}

	private boolean isFriends(User user1, User user2) throws Exception{
		boolean flag1 = false;
		boolean flag2 = false;
		for(Subscription sub : data.getSubs()){
			if(sub.getUser1Id() == user1.getId() && sub.getUser2Id() == user2.getId()) flag1 = true;
			if(sub.getUser2Id() == user1.getId() && sub.getUser1Id() == user2.getId()) flag2 = true;
		}

		return flag1&&flag2;
	}
}