package bookmnagement.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import bookmnagement.model.Book;

@Repository
public class BookImpl implements IBook{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Book getBookById(int bookID) {
		System.out.println(bookID);
		NativeQuery<?> query = (NativeQuery<?>) em.createNamedQuery("getBookById", Book.class);
		query.setParameter("id", bookID);
		System.out.println(query);
		Book book = (Book) query.getResultList().get(0);
		return book;
	}

	@Override
	@Transactional
	public List<Book> getBooks() {
		List<Book> books = em.createNamedQuery("getAllBooks", Book.class).getResultList();
		return books;
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
	@Transactional
	public void insertBook(Book book) {
		try {
			em.persist(book);
		}catch(Exception e) {
			
		}
		
	}
	
}
