package com.DecryptAccount.DecryptAccount;

import com.DecryptAccount.DecryptAccount.entities.Request;
import com.DecryptAccount.DecryptAccount.entities.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DecryptAccountApplication {

	public static void main(String[] args) {

		SpringApplication.run(DecryptAccountApplication.class, args);
		System.out.println("---- Arranco mi proyecto -----");
		Response res= new Response();


	}

}
