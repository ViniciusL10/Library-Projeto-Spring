package br.com.senior.library.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMapper {

    public BookDTO toDTO(Book book){
        BookDTO bookDto = new BookDTO();

        bookDto.title = book.getTitle();
        bookDto.author = book.getAuthor();
        bookDto.genre = book.getGenre();
        bookDto.synopsis = book.getSynopsis();

        return bookDto;

    }

    public Book toEntity(BookDTO bookDto){
        Book book = new Book();

        book.setTitle(bookDto.title);
        book.setAuthor(bookDto.author);
        book.setGenre(bookDto.genre);
        book.setSynopsis(bookDto.synopsis);

        return book;

    }

    public List<BookDTO> toDTO(List<Book> books){

        List<BookDTO> dtos = new ArrayList<BookDTO>();

        for ( Book book : books){
            dtos.add(toDTO(book));
        }

        return dtos;

    }

    public List<Book> toEntity(List<BookDTO> dtos){

        List<Book> books = new ArrayList<Book>();

        for ( BookDTO dto : dtos){
            books.add(toEntity(dto));
        }

        return books;

    }

}
