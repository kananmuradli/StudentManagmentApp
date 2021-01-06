package studentmanagmentapp.service;

import studentmanagment.model.Group;

public interface GroupService {
	
	public boolean addGroups();

	public void printGroups();

	public Group getGroupById();

	public void updateGroupById();
	
	public void hardDeleteGroup();

	public void softDeleteGroup();

	public void printGroup(Group group);
}
