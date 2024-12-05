package Poly.OE.Entity;

import java.util.Date;

import jakarta.persistence.Column;
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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Share", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"UserId", "VideoId"})
})
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "VideoId")
    private Video video;

    @Column(name = "Email")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "ShareDate")
    private Date shareDate;

    public Share() {
        super();
    }

    public Share(Long id, User user, Video video, String email, Date shareDate) {
        super();
        this.id = id;
        this.user = user;
        this.video = video;
        this.email = email;
        this.shareDate = shareDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }
}
