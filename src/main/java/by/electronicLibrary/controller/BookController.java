package by.electronicLibrary.controller;


import by.electronicLibrary.entity.Book;

import by.electronicLibrary.repository.BookRepository;
import by.electronicLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listDoGet(Map<String, Object> model) {
        Iterable<Book> allBooks = bookRepository.findAll();
        model.put("bookList", allBooks);
        return "list";
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.GET)
    public String deleteBookDoGet(@RequestParam int deleteIdBook, Map<String, Object> model) {
        model.put("idDelete", deleteIdBook);
        Book book = new BookService().getBookById(deleteIdBook);
        model.put("nameDelete", book.getName());
        model.put("authorDelete", book.getAuthor());
        model.put("yearDelete", book.getYear());
        return "deletePage";
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.POST)
    public String deleteBookDoPost(@RequestParam int deleteIdBook) {
        BookService bookService = new BookService();
        bookService.deleteBookById(deleteIdBook);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/create", method = RequestMethod.GET)
    public String createBookDoGet() {
        return "createPage";
    }

    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public String createBookDoPost(@RequestParam String nameBook, String authorBook, int yearBook, String descriptionBook) {
        BookService bookService = new BookService();
        bookService.createBook(nameBook, authorBook, yearBook, descriptionBook);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.GET)
    public String updateBookDoGet(@RequestParam int updateIdBook, Map<String, Object> model) {
        model.put("idUpdate", updateIdBook);
        Book book = new BookService().getBookById(updateIdBook);
        model.put("nameUpdateBook", book.getName());
        model.put("authorUpdateBook", book.getAuthor());
        model.put("yearUpdateBook", book.getYear());
        model.put("descriptionUpdateBook", book.getDescription());
        return "updatePage";
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public String updateBookDoPost(@RequestParam int updateIdBook, String nameUpdateBook, String authorUpdateBook, int yearUpdateBook, String descriptionUpdateBook) {
        BookService bookService = new BookService();
        bookService.updateBook(updateIdBook, nameUpdateBook, authorUpdateBook, yearUpdateBook, descriptionUpdateBook);
        return "redirect:/";
    }


}
