package edu.buu.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	protected Connection conn;

	// 创建连接模块
	public void openConnection() throws Exception {
		try {
			if (this.conn == null) {
				// 注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 创建连接
				String url = "jdbc:mysql://127.0.0.1:3306/meeting";
				String user = "root";
				String password = "123456";
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// 关闭连接模块
	public void closeConnection() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	// 打开事务模块
	public void beginTransaction() throws Exception {
		this.openConnection();
		this.conn.setAutoCommit(false);
	}

	// 提交事务模块
	public void commit() throws SQLException {
		if (this.conn != null) {
			this.conn.commit();
		}
	}

	// 回滚事务模块
	public void rollback() throws SQLException {
		if (this.conn != null) {
			this.conn.rollback();
		}
	}
}
