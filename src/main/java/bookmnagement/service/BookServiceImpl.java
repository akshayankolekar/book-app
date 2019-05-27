package bookmnagement.service;

import java.util.List;

import bookmnagement.model.Book;
import bookmnagement.model.Genre;
import bookmnagement.model.UserBookMapping;

public interface BookServiceImpl {

	public Book getBookById(int bookID);
	public List<Book> getBooks();
	public void updateBook(Book book);
	public void deleteBook(int bookID);
	public void insertBook(UserBookMapping userBook);
	public List<Book> getBooksByUserId(int userID);
	public List<Genre> getGenreList();
}
