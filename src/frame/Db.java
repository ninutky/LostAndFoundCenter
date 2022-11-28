package frame;

import java.sql.*;
import java.util.ArrayList;

public class Db {

	private static Connection conn;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "alfla";
	private static final String URL = "jdbc:mysql://localhost:3306/lostfound_db?serverTimezone=UTC";
	public String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public Db() {
		try {
			System.out.println("생성자");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
			try {
				conn.close();
			} catch (SQLException e1) {
			}
		}

	}

	public static void insertItem(boolean itype, String name, String place, String date, String ano) {
		Item item = new Item();
		String sql = "INSERT INTO item(itype, name, place, date, ano) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;

		item.itype = itype;
		item.name = name;
		item.place = place;
		item.date = date;
		item.ano = ano;
		/* item.img = img; */

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, item.itype);
			pstmt.setString(2, item.name);
			pstmt.setString(3, item.place);
			pstmt.setString(4, item.date);
			pstmt.setString(5, item.ano);
			/* pstmt.setString(6, item.img); */

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("삽입 성공");
			}

		} catch (Exception e) {
			System.out.println("삽입 실패");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void updateItem(Item item) {
		String sql = "update student set, itype = ?, name = ?, place = ?, date = ?, ano = ?, img = ? where name = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, item.itype);
			pstmt.setString(2, item.name);
			pstmt.setString(3, item.place);
			pstmt.setString(4, item.date);
			pstmt.setString(5, item.ano);
			pstmt.setString(6, item.img);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteItem(int id) {
		String sql = "delete from item where id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}