package bookmnagement.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import bookmnagement.model.Book;
import bookmnagement.model.Genre;
import bookmnagement.model.QBook;
import bookmnagement.model.QUserBookMapping;
import bookmnagement.model.UserBookMapping;

@Repository
public class BookImpl implements IBook{

	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Book getBookById(int bookID) {
		System.out.println(bookID);
		NativeQuery<?> query = (NativeQuery<?>) sessionFactory.getCurrentSession().createNamedQuery("getBookById", Book.class);
		query.setParameter("id", bookID);
		System.out.println(query);
		Book book = (Book) query.getResultList().get(0);
		return book;
	}

	@Transactional
	public List<Genre> getGenreList() {
	  TypedQuery<Genre> query = em.createNamedQuery("getAllGenres", Genre.class);
	  List<Genre> genreList = query.getResultList();
	  return genreList;
	}

	@Transactional
	public List<Book> getBooks() {
		List<Book> books = em.createNamedQuery("getAllBooks", Book.class).getResultList();
		return books;
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<Book> getBooksByUserId(int userID) {
		QBook book = new QBook("book");
		QUserBookMapping map = new QUserBookMapping("bookMap");
		JPAQueryFactory queryFactory = new JPAQueryFactory(sessionFactory.getCurrentSession());
		List<Book> books = queryFactory.selectFrom(book).innerJoin(map).on(book.id.eq(map.bookID)).where(map.userId.eq(userID)).fetch();
		System.out.println(books);
		return books;
	}

	public void deleteBook(int bookID) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void insertBook(UserBookMapping userbookDto) {
		try {
			sessionFactory.getCurrentSession().persist(userbookDto);
		}catch(Exception e) {
			
		}
		
	}
	
}
