package studentmanagmentapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import studentmanagment.db.DbHelper;
import studentmanagment.model.Student;

public class StudentDAOImpl implements StudentDAO {
	@Override
	public boolean saveStudent(Student student) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO student (s_name,s_surname,age,seria_num) Value (?,?,?,?)";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
				ps.setLong(5, student.getId());
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
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, s_name, s_surname, age, seria_num FROM student WHERE active = 1";

		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getLong("id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("s_surname"));
					student.setSeriaNum(rs.getString("seria_num"));
					student.setAge(rs.getInt("age"));
					students.add(student);
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

		return students;
	}

	@Override
	public Student getStudentById(Long id) {
		Student student = new Student();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, s_name, s_surname, age, seria_num FROM student WHERE active = 1 and id =" + id; 
		try {
			c = DbHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					student.setId(rs.getLong("id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("s_surname"));
					student.setSeriaNum(rs.getString("seria_num"));
					student.setAge(rs.getInt("age"));
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
		return student;
	}

	@Override
	public boolean updateStudentById(Student student) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET s_name = ?, s_surname = ?, age = ?, seria_num = ? WHERE id = ?";

		c = DbHelper.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
				ps.setLong(5, student.getId());
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
	public boolean hardDeleteStudent(Long id) {

		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM student WHERE id = ?";
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
	public boolean softDeleteStudent(Long id) {

		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET active = 0 WHERE id = ?";
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


