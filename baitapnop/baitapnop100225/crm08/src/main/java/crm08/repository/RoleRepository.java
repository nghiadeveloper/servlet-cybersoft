package crm08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm08.config.MysqlConfig;
import crm08.entity.RoleEntity;

public class RoleRepository {

	// Nguyên tắc đặt tên hàm làm sao cho dễ hinh dung tới câu truy vấn
	// SELECT -> find
	// WHERE -> By
	// Không có câu điều kiện WHERE -> findAll()
	// Ví dụ 1: SELECT * FROM role r ƯHERE r.id = 1 AND r.name = "admin" ->
	// findByIdAndName()
	// Ví dụ 2: SELECT * FROM role r -> findAll()

	public List<RoleEntity> findAll() {
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		String query = "SELECT * FROM roles r";

		try {
			Connection connection = MysqlConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleEntity entity = new RoleEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));

				list.add(entity);
			}
		} catch (Exception e) {
			System.out.println("findAll: " + e.getLocalizedMessage());
		}

		return list;
	}

	public int insertRoles(String name, String description) {
		int rowInsert = 0;
		String query = "INSERT INTO roles (name , description) VALUES (?, ?)";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);

			rowInsert = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert : " + e.getLocalizedMessage());
		}

		return rowInsert;
	}

	public int deleteByRoleId(int roleId) {
		int rowDelete = 0;
		String query = "DELETE FROM roles r WHERE r.id= ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, roleId);

			rowDelete = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteById : " + e.getLocalizedMessage());

		}
		return rowDelete;
	}

	public RoleEntity findRoleById(int roleId) {
		RoleEntity roleEntity = null;
		String query = "SELECT * FROM roles WHERE id = ?";
		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, roleId);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				roleEntity = new RoleEntity();
				roleEntity.setId(result.getInt("id"));
				roleEntity.setName(result.getString("name"));
				roleEntity.setDescription(result.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleEntity;
	}

	public int updateRole(int roleId, String name, String description) {
		int rowsAffected = 0;
		String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setInt(3, roleId);

			rowsAffected = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
