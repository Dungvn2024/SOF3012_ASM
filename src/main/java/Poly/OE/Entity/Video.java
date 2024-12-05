package Poly.OE.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {
//	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
//	private List<Favorite> favorites;
	
    @Id
    @Column(name = "Id")
    String id;

    @Column(name = "Title")
    String title;

    @Column(name = "Poster")
    String poster;

    @Column(name = "Views")
    int views;

    @Column(name = "Description")
    String description;

    @Column(name = "Active")
    Boolean active;
    
	
//	public List<Favorite> getFavorites() {
//		return favorites;
//	}
//
//	public void setFavorites(List<Favorite> favorites) {
//		this.favorites = favorites;
//	}
//
//	public List<Share> getShare() {
//		return shares;
//	}
//
//	public void setShare(List<Share> share) {
//		this.shares = share;
//	}
//
//	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY) // Liên kết với Favorite
//    private List<Share> shares;

    public Video() {
        super();
    }

    public Video(String id, String title, String poster, int views, String description, Boolean active) {
        super();
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.description = description;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}