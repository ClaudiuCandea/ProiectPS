package com.example.demo;

import com.example.demo.Test.DBOperation;
import com.example.demo.Test.Dobanda;
import com.example.demo.Test.OperatiiDobanda;
import com.example.demo.Test.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectPsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPsApplication.class, args);
		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(new Repository());
		//System.out.println(operatiiDobanda.calculDobanda(Dobanda.MEDIUM));
		//DBOperation dbOperation = new Repository();
		int res = operatiiDobanda.calcUserDobanda();
		System.out.println(res);
	}

}
