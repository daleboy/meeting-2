package edu.buu.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	protected Connection conn;

	// ��������ģ��
	public void openConnection() throws Exception {
		try {
			if (this.conn == null) {
				// ע������
				Class.forName("com.mysql.jdbc.Driver");
				// ��������
				String url = "jdbc:mysql://127.0.0.1:3306/meeting";
				String user = "root";
				String password = "123456";
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// �ر�����ģ��
	public void closeConnection() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

	// ������ģ��
	public void beginTransaction() throws Exception {
		this.openConnection();
		this.conn.setAutoCommit(false);
	}

	// �ύ����ģ��
	public void commit() throws SQLException {
		if (this.conn != null) {
			this.conn.commit();
		}
	}

	// �ع�����ģ��
	public void rollback() throws SQLException {
		if (this.conn != null) {
			this.conn.rollback();
		}
	}
}
