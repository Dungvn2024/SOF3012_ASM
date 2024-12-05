package Poly.OE.Entity;

import java.util.List;

import Poly.OE.Utils.XJPA;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
//	private List<Share> shares;
//	EntityManager em = XJPA.getEntityManager();
//    User entity =em.find(User.class, "id");
//    private List<Favorite> favorites = getFavorites();
//
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // Liên kết với Favorite
//    private List<Favorite> favorites;
//	
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // Liên kết với Share
 //   private List<Share> shares;
    
	@Id
	@Column(name="Id")
	String id;
	
	@Column(name="Password")
	String password;
	
	@Column(name="Fullname")
	String fullname;
	
	@Column(name="Email")
	String email;
	
	@Column(name="Admin")
    Boolean admin = false;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Share> shares;

	public User() {
		super();
	}

	public User(String id, String password, String fullname, String email, Boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}
}