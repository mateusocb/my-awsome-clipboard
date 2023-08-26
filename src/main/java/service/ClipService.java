package service;

import dao.ClipDAO;
import entity.Clip;

import java.sql.SQLException;
import java.util.List;

public class ClipService {
    public List<Clip> findAll() {
        try {
            return ClipDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}
