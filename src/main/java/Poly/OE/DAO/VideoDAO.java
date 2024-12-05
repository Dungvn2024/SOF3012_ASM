package Poly.OE.DAO;

import java.util.List;
import Poly.OE.Entity.Video;
public interface VideoDAO {
	
	    List<Video> findAll();
	    Video findById(String id);
	    void create(Video entity);
	    void update(Video entity);
	    void deleteById(String id);
}

