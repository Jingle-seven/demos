package com.xz.day_9_21;

import java.sql.*;

import javax.sql.DataSource;

public class Dao {
	Pool pool;
	DataSource ds;
	Connection conn = null;
	PreparedStatement pst;

	public Dao() {
		pool = Pool.getPool();
		ds = pool.getDataSource();

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * base query
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	protected ResultSet baseQuery(String sql, Object... objs) {
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					pst.setObject(i + 1, objs[i]);
				}
			}
			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * base update
	 * 
	 * @param id
	 * @return
	 */
	protected void baseUpdate(String sql, Object... objs) {
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					pst.setObject(i + 1, objs[i]);
				}
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		closeDB();
	}

	protected void closeDB() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
