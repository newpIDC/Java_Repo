/*package com.threading.threadingWorkout;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class JoinForkExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool() ;
        List<File> directories = forkJoinPool.invoke(new DirectoryListingTask(new File("C:/xampp"))) ;
         for (int i = 0; i < directories.size(); i++) {
            File file = (File) directories.get(i);
            System.out.println(file.getAbsolutePath());
        }
    }
}*/