package bookmnagement.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import bookmnagement.dto.GenreDTO;
import bookmnagement.dto.UserBookMapDTO;
import bookmnagement.model.Book;
import bookmnagement.model.Genre;
import bookmnagement.model.UserBookMapping;
import bookmnagement.service.BookService;

@CrossOrigin("*")
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity<String> getBooks() {
		List<Book> books = bookService.getBooks();
		System.out.println(books);
		ArrayNode node = mapper.createArrayNode();
		for(Book book: books) {
			ObjectNode obj = mapper.createObjectNode();
			obj.put("id", book.getId());
			obj.put("title", book.getTitle());
			obj.put("author", book.getAuthor());
			node.add(obj);
		}
		try {
			return ResponseEntity.ok().body(mapper.writeValueAsString(node));
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/insertBooks/")
	@ResponseBody
	public String insertBooks(@RequestBody UserBookMapDTO userbookDto) {
		List<Long> ids = userbookDto.getBookID();
		//System.out.println(ids);
		for(Long id: ids) {
			UserBookMapping userBook = new UserBookMapping();
			userBook.setUserId(userbookDto.getUserId());
			userBook.setBookID(id);
			//System.out.println(userBook);
			bookService.insertBook(userBook);
		}
		return null;
	}
	
	@GetMapping("/getBooksByUser/{id}")
	public ResponseEntity<List<Book>> getBooksByUser(@PathVariable("id") int id) {
		List<Book> book = bookService.getBooksByUserId(id);
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping("/getBooksReferenceData")
	public ResponseEntity<String> getBooksReferenceData() throws org.codehaus.jackson.JsonGenerationException, org.codehaus.jackson.map.JsonMappingException, IOException {
		List<Genre> genreList = bookService.getGenreList();
        ArrayNode node = mapper.createArrayNode();        
        for(Genre i: genreList) {
        	GenreDTO dto = new GenreDTO();
        	ObjectNode obj = mapper.createObjectNode();
        	dto.setGenre(i.getGenre());
        	dto.setId(i.getId());
        	obj.put("id", i.getId());
        	obj.put("genre", i.getGenre());
        	ArrayNode bookList = mapper.createArrayNode();
        	for(Book book: i.getIds()) {
        		ObjectNode books = mapper.createObjectNode();
        		books.put("title", book.getTitle());
        		books.put("author", book.getAuthor());
        		books.put("id", book.getId());
        		bookList.add(books);
        	}
        	obj.put("bookList", bookList);
        	node.add(obj);
        }
        System.out.println(node);
		return ResponseEntity.ok().body(mapper.writeValueAsString(node));
	}
}
