package ir.maktabsharif;

import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.thread.MyThread;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        {
        }
        Thread thread = new Thread(new MyThread(studentRepository));
        thread.start();

    }
}