package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conn.PostgresConn;

public class TestDAO {
	/*public static int addBook(String bookName, String bookAuthor, int bookQuantity) {
		int status = 0;

		try {
			Connection conn = PostgresConn.dbConnect();
			PreparedStatement preparedstm = conn
					.prepareStatement("INSERT INTO Books (book_name, book_author,quantity) VALUES (?, ?, ?)");

			preparedstm.setString(1, bookName);
			preparedstm.setString(2, bookAuthor);
			preparedstm.setInt(3, bookQuantity);
			status = preparedstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}*/
}
