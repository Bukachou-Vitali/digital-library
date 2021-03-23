package by.electronicLibrary.controller;


import by.electronicLibrary.entity.Book;
import by.electronicLibrary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class BookController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listDoGet(){
        ModelAndView mav = new ModelAndView("allListPage");
        List<Book> allBooks = new BookService().getAllBooks();
        mav.addObject("bookList", allBooks);
        return mav;
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.GET)
    public ModelAndView deleteBookDoGet(@RequestParam int deleteIdBook){
        ModelAndView mav = new ModelAndView("allDeletePage");
        mav.addObject("idDelete", deleteIdBook);
        Book book = new BookService().getBookById(deleteIdBook);
        mav.addObject("nameDelete", book.getName());
        mav.addObject("authorDelete", book.getAuthor());
        mav.addObject("yearDelete", book.getYear());
        return mav;
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.POST)
    public String deleteBookDoPost(@RequestParam int deleteIdBook){
        BookService bookService = new BookService();
        bookService.deleteBookById(deleteIdBook);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/create", method = RequestMethod.GET)
    public ModelAndView createBookDoGet(){
        ModelAndView mav = new ModelAndView("allCreatePage");
        return mav;
    }

    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public String createBookDoPost(@RequestParam String nameBook, String authorBook, int yearBook,String descriptionBook){
        BookService bookService = new BookService();
        bookService.createBook(nameBook, authorBook, yearBook, descriptionBook);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.GET)
    public ModelAndView updateBookDoGet(@RequestParam int updateIdBook){
        ModelAndView mav = new ModelAndView("allUpdatePage");
        mav.addObject("idUpdate", updateIdBook);
        Book book = new BookService().getBookById(updateIdBook);
        mav.addObject("nameUpdateBook", book.getName());
        mav.addObject("authorUpdateBook", book.getAuthor());
        mav.addObject("yearUpdateBook", book.getYear());
        mav.addObject("descriptionUpdateBook", book.getDescription());
        return mav;
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public String updateBookDoPost(@RequestParam int updateIdBook, String nameUpdateBook, String authorUpdateBook, int yearUpdateBook, String descriptionUpdateBook){
        BookService bookService = new BookService();
        bookService.updateBook(updateIdBook, nameUpdateBook, authorUpdateBook, yearUpdateBook, descriptionUpdateBook);
        return "redirect:/";
    }


}
