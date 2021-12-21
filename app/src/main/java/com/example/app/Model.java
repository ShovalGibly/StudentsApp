package com.example.app;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<10;i++){
            Student s = new Student("name",""+i,"054123456"+i,"rishon"+i,false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }

    public Student getStudentById(String studentId) {
        for (Student s:data
             ) {
            if (s.getId().equals(studentId)){
                return s;
            }
        }
        return null;
    }

    public void RemoveStudent(Student student) { data.remove(student);}
}
