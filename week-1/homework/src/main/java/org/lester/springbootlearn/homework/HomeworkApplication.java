package org.lester.springbootlearn.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner {
	private final CakeBaker cakeBaker1;
	private final CakeBaker cakeBaker2;


	public HomeworkApplication(CakeBaker cakeBaker1, CakeBaker cakeBaker2) {
		this.cakeBaker1 = cakeBaker1;
		this.cakeBaker2 = cakeBaker2;
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Override
	public void run(String... args) {
		cakeBaker1.bakeCake();
		cakeBaker2.bakeCake();
	}
}
