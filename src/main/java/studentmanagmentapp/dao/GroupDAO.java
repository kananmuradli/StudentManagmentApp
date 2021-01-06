package studentmanagmentapp.dao;

import java.util.List;

import studentmanagment.model.Group;

public interface GroupDAO {
	
	public boolean saveGroup(Group group);

	public List<Group> getGroups();
	
	public Group getGroupById(Long id);

	public boolean updateGroupById(Group group);

	public boolean hardDeleteGroup(Long id);
	
	public boolean softDeleteGroup(Long id);




}
