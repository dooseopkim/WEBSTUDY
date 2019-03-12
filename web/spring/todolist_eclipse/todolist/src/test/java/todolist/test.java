package todolist;

import java.sql.Connection;

import dao.TodoConnection;

public class test {
	public static void main(String[] args) {
		Connection conn = TodoConnection.getConnection();
		System.out.println(conn);
	}
}
