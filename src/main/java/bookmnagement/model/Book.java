package bookmnagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
