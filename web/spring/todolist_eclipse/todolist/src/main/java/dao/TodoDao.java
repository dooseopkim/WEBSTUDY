package dao;

import dto.TodoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
   private final String ADD_TODO_SQL = "INSERT INTO todo(title, name, sequence) VALUES(?, ?, ?)";
   private final String GET_TODOS_SQL = "SELECT `id`, `title`, `name`, `sequence`, `type`, `regdate` FROM `todo` ORDER BY `regdate` ASC";
   private final String UPDATE_TODO_SQL = "UPDATE `todo` SET `type` = ? WHERE `id` = ?";

   public int addTodo(TodoDto todoDto) {
      int addCount = 0;
      try (Connection conn = TodoConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_TODO_SQL)) {

         ps.setString(1, todoDto.getTitle());
         ps.setString(2, todoDto.getName());
         ps.setInt(3, todoDto.getSequence());

         addCount = ps.executeUpdate();
      } catch (NullPointerException | SQLException e) {
         e.printStackTrace();
      }
      return addCount;
   }

   public List<TodoDto> getTodos() {
      List<TodoDto> todoList = new ArrayList<>();

      try (Connection conn = TodoConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_TODOS_SQL)) {

         while (rs.next()) {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            String name = rs.getString("name");
            int sequence = rs.getInt("sequence");
            String type = rs.getString("type");
            String regDate = rs.getString("regdate");

            todoList.add(new TodoDto(id, name, regDate, sequence, title, type));
         }
      } catch (NullPointerException | SQLException e) {
         e.printStackTrace();
      }
      return todoList;
   }

   public int updateTodo(TodoDto todoDto) {
      int updateCount = 0;

      Long id = todoDto.getId();
      String nowType = todoDto.getType();
      String nextType = null;
      if (nowType.equals("TODO")) {
         nextType = "DOING";
      } else if (nowType.equals("DOING")) {
         nextType = "DONE";
      }

      try (Connection conn = TodoConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_TODO_SQL)) {

         ps.setString(1, nextType);
         ps.setLong(2, id);
         
         updateCount = ps.executeUpdate();
      } catch (NullPointerException | SQLException e) {
         e.printStackTrace();
      }

      return updateCount;
   }

}