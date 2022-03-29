package com.example.proyectprog;

import com.example.proyectprog.Logic.Student;
import com.example.proyectprog.Persistence.StudentDAOFactory;
import com.example.proyectprog.Persistence.StudentDAOImplement;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "servletTest", value = "/servlet-test")
public class ServletTest extends HttpServlet{
    StudentDAOFactory st = new StudentDAOFactory();
    StudentDAOImplement st2 = new StudentDAOImplement();
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("text/json");
        //ArrayList<Student> students = new Student("2112","Daniela Pinto","Tenis", "Torneo Universitario InterCarreras 4 lugar");
        String code1 = request.getParameter("code");
        String code2 = request.getParameter("code1");
        ArrayList<Student> students = st.createStudentDAO().getAllStudents();
        String stAux = gson.toJson(students);
        try (
                PrintWriter out = response.getWriter();
        ) {
            out.println(stAux);
        }
        st2.findByCode(code2);
        st2.delete(code1);


       // String stAux = gson.toJson( students );


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String sport = request.getParameter("sport");
        String activity = request.getParameter("activity");
        Student s = new Student(code,name,sport,activity);
        st.createStudentDAO().addStudent(s);


        try( PrintWriter out = response.getWriter()){

        }
    }
}
