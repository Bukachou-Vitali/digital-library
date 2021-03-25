package by.electronicLibrary.repository;

import by.electronicLibrary.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
