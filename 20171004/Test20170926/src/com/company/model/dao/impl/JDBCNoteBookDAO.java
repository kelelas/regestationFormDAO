package com.company.model.dao.impl;

import com.company.model.dao.NoteBookDAO;
import com.company.model.entity.NoteBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCNoteBookDAO implements NoteBookDAO {

    private Connection connection;

    public JDBCNoteBookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(NoteBook noteBook) {
        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO notebook (firstName , loginData )" +
                        " VALUES (? ,? )")){
            ps.setString(1 , noteBook.getFirstName());
            ps.setString(2 ,noteBook.getLoginData());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NoteBook findById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM notebook WHERE id = ?")){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                NoteBook result = getNoteBook(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<NoteBook> findAll() {
        List<NoteBook> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery("SELECT * FROM notebook");

            while ( rs.next() ){
                NoteBook result = getNoteBook(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(NoteBook noteBook) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE notebook SET firstName = ? , loginData = ?  " +
                        "WHERE id = ?")){
            ps.setString(1 , noteBook.getFirstName());
            ps.setString(2 ,noteBook.getLoginData());
            ps.setLong(3, noteBook.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM notebook  WHERE id = ?")){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private NoteBook getNoteBook(ResultSet resultSet) throws SQLException {
        NoteBook result = new NoteBook();
        result.setId(resultSet.getLong("id") );
        result.setFirstName( resultSet.getString("firstName") );
        result.setLoginData( resultSet.getString("loginData"));
        return result;
    }
}
