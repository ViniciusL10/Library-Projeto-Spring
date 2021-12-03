package br.com.senior.library.repository;

import br.com.senior.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
