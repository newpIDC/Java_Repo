/*package com.threading.threadingWorkout;

import java.io.File;
import java.io.*;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirectoryListingTask extends RecursiveTask<List<File>> {

    private static final FileFilter filter = new FileFilter();

    private File file ;

    public DirectoryListingTask(File file) {
        this.file = file;
    }

    @Override
    protected List<File> compute() {
       List<RecursiveTask<List<File>>> forks = new LinkedList<>(); 
       List files = new ArrayList();
        if (file.isDirectory()) {
            File[] filteredFiles = file.listFiles(filter);
            if (null != filteredFiles) {
                files.addAll(Arrays.asList(filteredFiles));
            }
            for (File childFile : file.listFiles()) {
                DirectoryListingTask task = new DirectoryListingTask(childFile);
                forks.add(task);
                task.fork();
            }

            for (RecursiveTask<List<File>> task : forks) {
                files.addAll(task.join());
            }
        }
        return files ;
    }
}*/