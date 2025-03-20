package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

				Scanner sc = new Scanner(System.in);
				int t = sc.nextInt();
				int t2= sc.nextInt();

				System.out.println("Try programiz.pro, sum="+(t+t2));

		SpringApplication.run(DemoApplication.class, args);

	}

}
