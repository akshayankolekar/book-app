package bookmnagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookmnagement.dto.IBook;
import bookmnagement.model.Book;

@Service
public class BookService implements BookServiceImpl{

	@Autowired
	IBook bookService;

	@Override
	public Book getBookById(int bookID) {
		return bookService.getBookById(bookID);
	}

	@Override
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int bookID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBook(Book book) {
		bookService.insertBook(book);
	}
	
	
}
