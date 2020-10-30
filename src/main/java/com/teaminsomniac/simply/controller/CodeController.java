package com.teaminsomniac.simply.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teaminsomniac.simply.model.CodeSnippet;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CodeController {
	
	@PostMapping("/code")
	public String getCodeSnippet(@RequestBody CodeSnippet code) {
		System.out.println(code.code);
		
		try {
		      File myObj = new File("Main.java");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        
		        FileWriter myWriter = new FileWriter("Main.java");
//		        myWriter.write(code);
		        myWriter.close();
		        System.out.println("Successfully wrote to the file.");
		        
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		return "all izz well";
	}
}
