package bookmnagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "getAllBooks",
        query = "SELECT * from book",
                    resultClass=Book.class
    ),
    @NamedNativeQuery(
        name = "getBookById",
        query = "SELECT * " +
                    "FROM book " +
                    "WHERE book.id = :id",
                    resultClass=Book.class
    )
})
@Entity(name="Book")
public class Book {

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String author;
	
	@Column
	private String title;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name="id"))
	private List<Genre> genre_id;
	

	public List<Genre> getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(List<Genre> genre_id) {
		this.genre_id = genre_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + "]";
	}
	
}
