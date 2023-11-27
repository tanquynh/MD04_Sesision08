package com.lecture.controller;

import com.lecture.model.entity.Student;
import com.lecture.model.service.StudentService;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "StudentServlet", value = "/student-servlet")

public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            showStudentList(request, response);
        } else {
            int studentCode = Integer.parseInt(request.getParameter("studentCode"));
            switch (action) {
                case "edit":
                    Student student = studentService.findId(studentCode);
                    request.setAttribute("student", student);
                    request.getRequestDispatcher("views/student-edit.jsp").forward(request, response);
                    break;
                case "delete":
                    studentService.delete(studentCode);
                    showStudentList(request, response);
                    break;
            }
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String studentName = request.getParameter("studentName");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean sex = request.getParameter("sex").equals("male");
        Student student = new Student(studentName, age, sex);

        String action = request.getParameter("action");
        if (action == null) {
            studentService.save(student);
            response.sendRedirect("/student-servlet");

        } else {
            int studentCode = Integer.parseInt(request.getParameter("studentCode"));
            studentService.update(student, studentCode);
            response.sendRedirect("/student-servlet");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
