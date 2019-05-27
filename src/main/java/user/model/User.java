package user.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;


@NamedNativeQueries({
    @NamedNativeQuery(
        name = "getUserById",
        query = "SELECT * from user where user.id = :id",
        resultClass=User.class
    ),
    @NamedNativeQuery(
        name = "getUserByUserID",
        query = "SELECT * from user where user.userID = :userID",
        resultClass=User.class
    )
})
@Entity(name="User")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String userID;
	private String password;
	private String lastName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Role role; 


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", userID=" + userID + ", password=" + password
				+ ", lastName=" + lastName + "]";
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
