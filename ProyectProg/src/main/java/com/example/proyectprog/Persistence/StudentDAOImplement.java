package com.example.proyectprog.Persistence;
import com.example.proyectprog.Logic.Student;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImplement implements StudentDAO{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/student";
    private static final String USER = "root";
    private static final String PASSWD = "";


    @Override
    public void addStudent(Student student) {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =
                    DriverManager.getConnection( URL, USER,PASSWD );//,USER,PASSWD
        ){
            Statement statement = connection.createStatement();

            String code = student.getCode();
            String name = student.getName();
            String sport = student.getSport();
            String activity = student.getActivity();



            final String query = "INSERT INTO students VALUES(" + "'" + code + "','" + name + "','" + sport + "','"  + activity + "')";

            System.out.println( query );

            statement.execute( query );

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void delete(String code1) {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =
                    DriverManager.getConnection( URL, USER,PASSWD );//,USER,PASSWD
        ){
            Statement statement = connection.createStatement();


            final String query = "DELETE from students where  code=" + "'" + code1 + "'";

            System.out.println( query );

            statement.execute( query );

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Student findByCode(String code2) {


        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try(Connection connection =
                    DriverManager.getConnection(URL,USER,PASSWD);//,USER,PASSWD)
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from students");
        ){
            while( result.next()){
                String code = result.getString( "code" );
                String name = result.getString( "name" );
                String sport = result.getString("sport");
                String activity = result.getString("activity");

                students.add( new Student(code, name,sport,activity));
            }

            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
