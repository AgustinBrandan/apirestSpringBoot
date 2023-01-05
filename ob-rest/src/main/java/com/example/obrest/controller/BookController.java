package com.example.obrest.controller;

import com.example.obrest.entities.Book;
import com.example.obrest.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Controlador
@RestController
public class BookController {
    //Atributos
    private BookRepository repositorio;
    //Constructores
    public BookController(BookRepository repositorio) {
        this.repositorio = repositorio;
    }

    //Buscar todos los libros

    @GetMapping("/api/books")
    public List<Book> findAll() {
        return repositorio.findAll();
    }

    //Buscar un solo libro en base de datos segun Id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findbook(@PathVariable Long id){
        Optional<Book> bookOpt = repositorio.findById(id); //comprobar si existe el libro
        // opcion 1
        if (bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }
        else return ResponseEntity.notFound().build();
        // opcion 2 es lo mismo return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public Book createBook(@RequestBody Book book){
        return repositorio.save(book);

    }
    //actualizar un libro existente en base de datos
    //borrar un libro en base de datos


}
