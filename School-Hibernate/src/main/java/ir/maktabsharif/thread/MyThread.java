package ir.maktabsharif.thread;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;
import java.util.List;

public class MyThread implements Runnable {

    StudentRepository studentRepository;
    public MyThread(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run() {
        while (true) {
            List<Student> students = studentRepository.findAll();
            int n = students.size();
            System.out.println(n);
            try {
                Thread.sleep(1234,1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
