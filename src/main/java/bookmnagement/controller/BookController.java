package bookmnagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonNode;

import bookmnagement.model.Book;
import bookmnagement.service.BookService;

@CrossOrigin("*")
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.getBooks();
		return ResponseEntity.ok().body(books);
	}
	
	@PostMapping("/insertBooks")
	public void getBooks(@RequestBody Book book) {
		bookService.insertBook(book);
	}
}
