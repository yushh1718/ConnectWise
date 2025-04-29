package com.ConnectWise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Hashtable;
import java.util.Map;

@SpringBootApplication
public class ConnectWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectWiseApplication.class, args);
	}
	Hashtable<Integer, Integer> table = new Hashtable<>();
	// npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch
	
}
