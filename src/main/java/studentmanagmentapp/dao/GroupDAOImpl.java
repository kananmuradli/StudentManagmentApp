package studentmanagmentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import studentmanagment.db.DbHelper;
import studentmanagment.model.Group;


public class GroupDAOImpl implements GroupDAO {

	@Override
	public boolean saveGroup(Group group) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO qrup (qrup_name) Value (?)";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
                ps.setString(1, group.getName());
				ps.execute();
				isAdded = true;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			} finally {
				try {
					c.close();
					ps.close();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		return isAdded;
	}

	@Override
	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, qrup_name FROM qrup WHERE active = 1";

		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Group group = new Group();
					group.setId(rs.getLong("id"));
					group.setName(rs.getString("qrup_name"));
					groups.add(group);
				}

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

		return groups;
	}

	@Override
	public Group getGroupById(Long id) {
		Group group = new Group();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, qrup_name FROM qrup WHERE active = 1  and id =" + id;

		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					group.setId(rs.getLong("id"));
					group.setName(rs.getString("qrup_name"));

				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}
		return group;
	}

	@Override
	public boolean updateGroupById(Group group) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE qrup SET qrup_name = ? WHERE id = ?";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, group.getName());
				ps.setLong(2, group.getId());
				ps.execute();
				isUpdated = true;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			} finally {
				try {
					c.close();
					ps.close();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		return isUpdated;
	}

	@Override
	public boolean hardDeleteGroup(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM qrup WHERE id = ?";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		return isDeleted;
	}
	}
	@Override
	public boolean softDeleteGroup(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE qrup SET active = 0 WHERE id = ?";
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		return isDeleted;
	}
}
}
