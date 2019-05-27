package bookmnagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookmnagement.dto.IBook;
import bookmnagement.model.Book;
import bookmnagement.model.Genre;
import bookmnagement.model.UserBookMapping;

@Service
public class BookService implements BookServiceImpl {

	@Autowired
	IBook bookService;

	public Book getBookById(int bookID) {
		return bookService.getBookById(bookID);
	}

	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub

	}

	public void deleteBook(int bookID) {
		// TODO Auto-generated method stub

	}

	public void insertBook(UserBookMapping userBook) {
		bookService.insertBook(userBook);
	}

	public List<Book> getBooksByUserId(int userID) {
		return bookService.getBooksByUserId(userID);
	}

	public List<Genre> getGenreList() {
		return bookService.getGenreList();
	}
}
