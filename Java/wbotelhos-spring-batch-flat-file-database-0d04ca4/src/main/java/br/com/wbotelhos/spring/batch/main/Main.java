package br.com.wbotelhos.spring.batch.main;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) {
		//CommandLineJobRunner.main(new String[] { "csvToDBJob.xml", "copy" });
		CommandLineJobRunner.main(new String[] { "txtToDBJob.xml", "copy" });
	}

}