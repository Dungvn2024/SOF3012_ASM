package Poly.OE.Entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Favorite")
public class Favorite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="VideoID")
	private Video video;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UserID")
	private User user;
	
	@Temporal(TemporalType.DATE)
	private Date likeDate;
	
	public Favorite() {
        super();
    }

    public Favorite(Long id, User user, Video video, Date likeDate) {
        super();
        this.id = id;
        this.user = user;
        this.video = video;
        this.likeDate = likeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}


