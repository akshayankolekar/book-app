package bookmnagement.dto;

import java.util.List;

import bookmnagement.model.Book;

public interface IBook {

	public Book getBookById(int bookID);
	public List<Book> getBooks();
	public void updateBook(Book book);
	public void deleteBook(int bookID);
	public void insertBook(Book book);
}
