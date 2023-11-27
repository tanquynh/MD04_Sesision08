package com.lecture.model.dao;

import com.lecture.model.entity.Student;
import com.lecture.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements IGenericDAO<Student, Integer> {
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        List<Student> list = new ArrayList<>();
        connection = ConnectionDB.getConnection();
        try {
            // chuẩn bị câu truy vấn
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentCode(resultSet.getInt("studentCode"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;
        // mở kết nối
        connection = ConnectionDB.getConnection();

        try {
            // xây dựng câu truy vấn
            String sql = "insert into student(studentName, age, sex) values(?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setBoolean(3, student.isSex());
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Student findId(Integer studentCode) {
        Connection connection = null;
        Student student = new Student();
        connection = ConnectionDB.getConnection();

        try {
            String sql = "select * from student where studentCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setStudentCode(resultSet.getInt("studentCode"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return student;
    }

    @Override
    public Boolean update(Student student, Integer studentCode) {
        Connection connection = null;
        connection = ConnectionDB.getConnection();
        try {
            String sql = "update student set studentName = ?, age = ?, sex = ? where studentCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setBoolean(3, student.isSex());
            preparedStatement.setInt(4, studentCode);
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void delete(Integer studentCode) {
        Connection connection = null;
        connection = ConnectionDB.getConnection();

        try {
            String sql = "delete from student where studentCode = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentCode);
            int check = preparedStatement.executeUpdate();

            if (check > 0) {
                System.out.println("Đã xóa thành công");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

    }
}
