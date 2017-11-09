package com.makh.mysql;

import com.makh.beans.Student;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;

import java.sql.*;
import java.util.ArrayList;

public class MySqlStudentDao extends AbstractDao<Student,Integer> {
    public MySqlStudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Students JOIN Users USING(login) WHERE id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Students JOIN Users USING(login);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Students JOIN Users USING(login) " +
                "SET login=?,password=?,user_state=?,user_group=?,last_access=?," +
                "name=?,surname=?,birthday=?" +
                "email=?,average_rating=?, group_id=? WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Students (name, surname, birthday, email, average_rating," +
                "group_id, login) VALUES(?,?,?,?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Students WHERE id=?;";
    }

    @Override
    public ArrayList<Student> parsData(ResultSet rs) throws DaoException {
        ArrayList<Student> students = new ArrayList<>();
        try {
            while (rs.next()) {
                Student student = new Student();

                student.setLogin(rs.getString("login"));
                student.setPassword(rs.getString("password"));
                student.setState(rs.getString("user_state"));
                student.setGroup(rs.getString("user_group"));
                student.setCreated(rs.getTimestamp("created").toLocalDateTime());
                student.setLastAccess(rs.getTimestamp("last_access").toLocalDateTime());
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setBirthday(rs.getDate("birthday").toLocalDate());
                student.setEmail(rs.getString("email"));
                student.setAverageRating(rs.getDouble("average_rating"));
                student.setGroupId(rs.getInt("group_id"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return students;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Student obj) throws DaoException {
        try {
            prSt.setString(1, obj.getLogin());
            prSt.setString(2, obj.getPassword());
            prSt.setString(3, String.valueOf(obj.getState()));
            prSt.setString(4, String.valueOf(obj.getGroup()));
            prSt.setTimestamp(5, Timestamp.valueOf(obj.getLastAccess()));
            prSt.setString(6, obj.getName());
            prSt.setString(7, obj.getSurname());
            prSt.setDate(8, Date.valueOf(obj.getBirthday()));
            prSt.setString(9,obj.getEmail());
            prSt.setDouble(10,obj.getAverageRating());
            prSt.setInt(11,obj.getGroupId());
            prSt.setInt(12, obj.getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Student obj) throws DaoException {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getSurname());
            prSt.setDate(3, Date.valueOf(obj.getBirthday()));
            prSt.setString(4,obj.getEmail());
            prSt.setDouble(5,obj.getAverageRating());
            prSt.setInt(6,obj.getGroupId());
            prSt.setString(7, obj.getLogin());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
