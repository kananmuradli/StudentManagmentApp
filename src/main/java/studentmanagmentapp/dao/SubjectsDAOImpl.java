package studentmanagmentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import studentmanagment.db.DbHelper;
import studentmanagment.model.Group;
import studentmanagment.model.Subjects;

public class SubjectsDAOImpl implements SubjectsDAO{

	@Override
	public boolean saveSubjects(Subjects subjects) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO subjects (subject_name) Value (?)";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setLong(1, subjects.getId());
				ps.setString(2, subjects.getName());
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
	public List<Subjects> getSubjects() {
		List<Subjects> subjects1 = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, subject_name FROM subjects WHERE active = 1";

		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Subjects subjects = new Subjects();
					subjects.setId(rs.getLong("id"));
					subjects.setName(rs.getString("subject_name"));
					subjects1.add(subjects);
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
		return subjects1;
	}

	@Override
	public Subjects getSubjectsById(Long id) {
		Subjects subjects = new Subjects();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, subject_name FROM subjects WHERE active = 1  and id =" + id;

		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					subjects.setId(rs.getLong("id"));
					subjects.setName(rs.getString("subject_name"));

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
		return subjects;
	}

	@Override
	public boolean updateSubjectsById(Subjects subjects) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE subjects SET subject_name = ? WHERE id = ?";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, subjects.getName());
				ps.setLong(2, subjects.getId());
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
	public boolean hardDeleteSubjects(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM subjects WHERE id = ?";
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
	public boolean softDeleteSubjects(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE subjects SET active = 0 WHERE id = ?";
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
