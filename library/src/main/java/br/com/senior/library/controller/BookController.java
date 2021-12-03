package br.com.senior.library.controller;

import br.com.senior.library.exception.IdNullException;
import br.com.senior.library.exception.InvalidConstructorArgumentsException;
import br.com.senior.library.exception.InvalidParametersException;
import br.com.senior.library.model.*;
import br.com.senior.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> get(){
        List<BookDTO> booksDTO = bookMapper.toDTO(bookRepository.findAll());
        return ResponseEntity.ok().body(booksDTO);
    }

    @PostMapping
    public ResponseEntity<BookDTO> post(@Validated @RequestBody BookDTO bookDTO){

        verifyParameters(bookDTO);

        Book book = bookMapper.toEntity(bookDTO);

        bookRepository.save(book);

        return ResponseEntity.ok().body(bookDTO);
    }

    @DeleteMapping
    public HttpStatus deleteBook(@RequestParam Long id){

        isValidId(id);

        bookRepository.deleteById(id);

        return HttpStatus.OK;
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDTO> put(@Validated @RequestBody BookDTO bookDTO, @PathVariable Long id){

        Book book = bookRepository.getById(id);

        book.setTitle(bookDTO.title);
        book.setSynopsis(bookDTO.synopsis);
        book.setGenre(bookDTO.genre);
        book.setAuthor(bookDTO.author);

        bookRepository.save(book);

        return ResponseEntity.ok().body(bookDTO);
    }
    @GetMapping("{id}")
    public ResponseEntity<BookDTO> get(@PathVariable Long id){


        isValidId(id);

        Book book = bookRepository.getById(id);
        BookDTO bookDTO = bookMapper.toDTO(book);

        return ResponseEntity.ok().body(bookDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<UUID> login(@RequestBody UserDTO userDTO){

        UserDTO user = new UserDTO();
        user.username = "jorge";
        user.password = "1234";
        if (userDTO.username.equals(user.username) && userDTO.password.equals(user.password)){
            UUID token = UUID.randomUUID();
            TokenList.tokens.add(String.valueOf(token));
            return ResponseEntity.ok().body(token);
        }
        throw new InvalidParametersException("Parâmetros Inválidos!");
    }


    private void verifyParameters(BookDTO bookDTO) {
        if(bookDTO.title == null || bookDTO.author == null || bookDTO.genre == null || bookDTO.synopsis == null){

            String msg = "Os seguintes parâmetros estão nulos: ";

            if(bookDTO.title == null)
                msg += "title; ";
            if(bookDTO.synopsis == null)
                msg += "synopsis; ";
            if(bookDTO.genre == null)
                msg += "genre; ";
            if(bookDTO.author == null)
                msg += "author; ";
            throw new InvalidConstructorArgumentsException(msg);
        }
    }

    private void isValidId(Long id) {
        List<Book> books = bookRepository.findAll();

        boolean isPresent = false;

        for(Book book : books){
            if (book.getId() == id){
                isPresent = true;
            }
        }

        if(id == null || !isPresent)
            throw new IdNullException("Id inválido");
    }

}
