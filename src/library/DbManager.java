package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	//データベースへ接続する
	public void DbConnection() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//接続文字列
		String url = "jdbc:postgresql://localhost:5432/zhongxin";
		String user = "postgres";
		String password = "postgres";

		//PostgreSQLへ接続
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//自動コミットOFF
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
