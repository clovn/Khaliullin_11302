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

			if(flag) answer += group.getName() + "\n";
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
			if(count > data.getGroupCountOfMembers(group) / 2.0) answer += group.getName() + "\n";
		}

		return answer;
	}

	public boolean isFriendly1(Group group) throws Exception{
		Members[] members = data.getMembers();
		for(int i = 0; i < members.length; i++){
			for(int j = i + 1; j < members.length; j++){
				if(!isFriends(members[i].getUser(), members[j].getUser()) && members[i].getGroup().equals(group) && members[j].getGroup().equals(group)) return false;
			}
		}

		return true;
	}

	public boolean isFriendly2(Group group) throws Exception{
		for(Members member : data.getMembers()){
			if(member.getGroup().equals(group)){
				boolean hasFriends = false;
				for(Subscription sub : data.getSubs()){
					if(isMember(group, data.getUserById(sub.getUser2Id())) && isFriends(data.getUserById(sub.getUser1Id()), data.getUserById(sub.getUser2Id())) && isMember(group, data.getUserById(sub.getUser2Id()))){
						hasFriends = true;
						break;
					} 
				}
				if(!hasFriends){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isFriendly3(Group group) throws Exception{
		User[] subs = data.getGroupMembers(group);
		return false;
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

	private boolean isMember(Group group, User user){
		for(Members member : data.getMembers()){
			if(member.getUser().equals(user) && member.getGroup().equals(group)) return true;
		}

		return false;
	}
}