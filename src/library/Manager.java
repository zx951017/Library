package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager {

	//查询所有图书的方法 showAll
	public void showAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//接続文字列
		String url = "jdbc:postgresql://localhost:5432/zhongxin";
		String user = "postgres";
		String password = "postgres";

		try {

			//PostgreSQLへ接続
			conn = DriverManager.getConnection(url, user, password);

			//自動コミットOFF
			conn.setAutoCommit(false);

			//SELECT文の実行
			stmt = conn.createStatement();
			String sql = "SELECT * from books";
			rset = stmt.executeQuery(sql);

			//SELECT結果の受け取り
			while (rset.next()) {
				String book_id = rset.getString(1);
				String book_name = rset.getString(2);
				String book_author = rset.getString(3);
				String book_price = rset.getString(4);
				System.out.println(book_id + book_name + book_author + book_price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	@SuppressWarnings("null")
	//定义添加图书的方法add
	public void add(Book book) {
		// TODO 自動生成されたメソッド・スタブ

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//接続文字列
		String url = "jdbc:postgresql://localhost:5432/zhongxin";
		String user = "postgres";
		String password = "postgres";

		try {

			Class.forName("org.postgresql.Driver");
			//PostgreSQLへ接続
			conn = DriverManager.getConnection(url, user, password);
			//自動コミットOFF
			conn.setAutoCommit(false);
			//INSERT文の実行
			stmt = conn.createStatement();
			String sql = "INSERT INTO books (book_id,book_name,book_author,book_price) VALUES (" + book.getId() + ",'"
					+ book.getName() + "','" + book.getAuthor() + "','" + book.getPrice() + "');";
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("追加しました");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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

	//按书名修改价格的方法 update
	public void update(String name, String price) {
		// TODO 自動生成されたメソッド・スタブ
		Book book = new Book();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//接続文字列
		String url = "jdbc:postgresql://localhost:5432/zhongxin";
		String user = "postgres";
		String password = "postgres";

		try {

			if(name.equals(book.getName()))
			Class.forName("org.postgresql.Driver");
			//PostgreSQLへ接続
			conn = DriverManager.getConnection(url, user, password);
			//自動コミットOFF
			conn.setAutoCommit(false);
			//update文の実行
			stmt = conn.createStatement();
			String sql = "UPDATE books SET book_price ='"+ price + "'WHERE book_name ='" + name + "';";
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("更新されました");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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

	// 按照图书ID删除图书的方法delete
	public void delete(int id) {
		Book book = new Book();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//接続文字列
		String url = "jdbc:postgresql://localhost:5432/zhongxin";
		String user = "postgres";
		String password = "postgres";

		try {

			if(id == book.getId())
			Class.forName("org.postgresql.Driver");
			//PostgreSQLへ接続
			conn = DriverManager.getConnection(url, user, password);
			//自動コミットOFF
			conn.setAutoCommit(false);
			//update文の実行
			stmt = conn.createStatement();
			String sql = "DELETE FROM books book_id WHERE book_id = "+id+";";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("削除されました");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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

