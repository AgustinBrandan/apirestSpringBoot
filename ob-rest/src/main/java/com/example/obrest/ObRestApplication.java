package com.example.obrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(ObRestApplication.class, args);
		BookRepository repository= context.getBean(BookRepository.class);


		//CRUD
		//Crear Libro
		Book book = new Book(null,"Homo Deus","Yuyal Noah",450,30.99, LocalDate.of(2019,10,12),true);
		Book book1 = new Book(null,"Homo Sapies","Yuyal Noah",450,31.99, LocalDate.of(2020,10,12),true);

		//Almacenar Libro
		System.out.println("num de libro en base de datos: "+repository.findAll().size());
		repository.save(book);
		repository.save(book1);

		//Recuperar un Libro
		System.out.println("num de libro en base de datos: "+repository.findAll().size());
		System.out.println("num de libro en base de datos: "+repository.findAll());

		//Borrar un libroo
		repository.deleteById(1L);
		System.out.println("num de libro en base de datos: "+repository.findAll().size());


	}

}
