package studentmanagmentapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import studentmanagment.db.DbHelper;
import studentmanagment.model.Teacher;


	public class TeacherDAOImpl implements TeacherDAO{
		@Override
		public boolean saveTeacher(Teacher teacher) {
			boolean isAdded = false;
			Connection c = null;
			PreparedStatement ps = null;
			String sql = "INSERT INTO teacher (t_name, t_surname, age, seria_num) Value (?,?,?,?)";

			c = DbHelper.getConnection();
			if (c != null) {
				try {
					ps = c.prepareStatement(sql);
					ps.setString(1, teacher.getName());
					ps.setString(2, teacher.getSurname());
					ps.setInt(3, teacher.getAge());
					ps.setString(4, teacher.getSeriaNum());
					ps.setLong(5, teacher.getId());
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
		public List<Teacher> getTeachers() {
			List<Teacher> teachers = new ArrayList<>();
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT id, t_name, t_surname, age, seria_num FROM teacher WHERE active = 1";

			try {
				c = DbHelper.getConnection();
				if (c != null) {
					ps = c.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						Teacher teacher = new Teacher();
						teacher.setId(rs.getLong("id"));
						teacher.setName(rs.getString("t_name"));
						teacher.setSurname(rs.getString("t_surname"));
						teacher.setSeriaNum(rs.getString("seria_num"));
						teacher.setAge(rs.getInt("age"));
						teachers.add(teacher);
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

			return teachers;
		}
		
		@Override
		public Teacher getTeacherById(Long id) {
			Teacher teacher = new Teacher();
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT id, t_name, t_surname, age, seria_num FROM teacher WHERE active = 1 and id = " + id;

			try {
				c = DbHelper.getConnection();
				if (c != null) {
					ps = c.prepareStatement(sql);
					rs = ps.executeQuery();
					if (rs.next()) {
						teacher.setId(rs.getLong("id"));
						teacher.setName(rs.getString("t_name"));
						teacher.setSurname(rs.getString("t_surname"));
						teacher.setSeriaNum(rs.getString("seria_num"));
						teacher.setAge(rs.getInt("age"));
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
			return teacher;
		}
		
		@Override
		public boolean updateTeacherById(Teacher teacher) {
			boolean isUpdated = false;
			Connection c = null;
			PreparedStatement ps = null;
			String sql = "UPDATE teacher SET t_name = ?, t_surname = ?, age = ?, seria_num = ? WHERE id = ?";

			c = DbHelper.getConnection();
			if (c != null) {
				try {
					ps = c.prepareStatement(sql);
					ps.setString(1, teacher.getName());
					ps.setString(2, teacher.getSurname());
					ps.setInt(3, teacher.getAge());
					ps.setString(4, teacher.getSeriaNum());
					ps.setLong(5, teacher.getId());
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
		public boolean hardDeleteTeacher(Long id) {

			boolean isDeleted = false;
			Connection c = null;
			PreparedStatement ps = null;
			String sql = "DELETE FROM teacher WHERE id = ?";
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
		
		public boolean softDeleteTeacher(Long id) {

			boolean isDeleted = false;
			Connection c = null;
			PreparedStatement ps = null;
			String sql = "UPDATE teacher SET active = 0 WHERE id = ?";
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
			}catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			return isDeleted;

		}
		}
}
