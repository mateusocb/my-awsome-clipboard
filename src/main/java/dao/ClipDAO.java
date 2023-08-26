package dao;


import entity.Clip;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static config.Database.getConnection;

public class ClipDAO {
    public static List<Clip> findAll() throws SQLException {
        List<Clip> clips = new ArrayList<>();

        try {
            String selectQuery = "SELECT * FROM clip";
            PreparedStatement selectStatement = getConnection().prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                var build = Clip.builder()
                        .id(resultSet.getString("id"))
                        .content(resultSet.getString("content"))
                        .build();

                clips.add(build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            getConnection().close();
        }

        return clips;
    }

    public static void addByContent(String content) throws SQLException {
        try {
            String insertQuery = "INSERT INTO clip (id, content) VALUES (?, ?)";

            var preparedStatement = getConnection().prepareStatement(insertQuery);

            preparedStatement.setObject(1, UUID.randomUUID());
            preparedStatement.setObject(2, content);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            getConnection().close();
        }
    }
}
