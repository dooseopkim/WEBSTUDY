package dao;

import dto.TodoDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

    /**
     * insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1);
     * insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
     */
    public int addTodo(TodoDto todoDto) {
        String addTodoSql = "INSERT INTO todo(title, name, sequence) VALUES(?, ?, ?)";
        int addCount = -1;
        try (PreparedStatement ps = TodoConnection
                .getConnection()
                .prepareStatement(addTodoSql)) {
            ps.setString(1, todoDto.getTitle());
           System.out.println(todoDto.getTitle());
            ps.setString(2, todoDto.getName());
            ps.setInt(3, todoDto.getSequence());
            addCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addCount;
    }

    public List<TodoDto> getTodos() {
        List<TodoDto> todoList = new ArrayList<>();
        String getTodosSql = "SELECT `id`, `title`, `name`, `sequence`, `type`, `regdate` " +
                "FROM `todo` " +
                "ORDER BY `regdate` DESC";

        try (ResultSet rs = TodoConnection
                .getConnection()
                .prepareStatement(getTodosSql)
                .executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String name = rs.getString("name");
                int sequence = rs.getInt("sequence");
                String type = rs.getString("type");
                String regDate = rs.getString("regdate");
                todoList.add(new TodoDto(id, name, regDate, sequence, title, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    public int updateTodo(TodoDto todoDto) {

        String updateTodoSql = "UPDATE `todo` SET `type` = ? WHERE `id` = ?";

        Long id = todoDto.getId();
        String nowType = todoDto.getType();
        String nextType = null;
        if (nowType.equals("TODO")) nextType = "DOING";
        else if (nowType.equals("DOING")) nextType = "DONE";

        int updateCount = -1;
        try (PreparedStatement ps = TodoConnection
                .getConnection()
                .prepareStatement(updateTodoSql)) {
            ps.setString(1, nextType);
            ps.setLong(2, id);
            updateCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount;
    }

}
