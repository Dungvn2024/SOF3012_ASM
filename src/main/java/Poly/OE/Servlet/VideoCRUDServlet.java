package Poly.OE.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import Poly.OE.DAO.VideoDAO;
import Poly.OE.DAO.VideoDAOlmpl;
import Poly.OE.Entity.Video;

/**
 * Servlet implementation class VideoControl
 */
@WebServlet({
    "/VideoControl",
    "/video/crud/index", "/video/crud/edit/*", "/video/crud/create",
    "/video/crud/update", "/video/crud/delete", "/video/crud/reset"
})
public class VideoCRUDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public VideoCRUDServlet() {
        super();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
    	VideoDAO dao = new VideoDAOlmpl();
        resp.getWriter().append("Served at: ").append(req.getContextPath());

        Video form = new Video();
        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = "Enter video information";
        String path = req.getServletPath();

        if (path.contains("edit")) {
            String id = req.getPathInfo().substring(1);
            form = dao.findById(id);
            message = "Edit: " + id;
        } else if (path.contains("create")) {
            dao.create(form);
            message = "Created: " + form.getId();
        } else if (path.contains("update")) {
            dao.update(form);
            message = "Updated: " + form.getId();
        } else if (path.contains("delete")) {
            dao.deleteById(form.getId());
            message = "Deleted: " + form.getId();
        } else if (path.contains("reset")) {
            form = new Video();
        }

        List<Video> list = dao.findAll();
        req.setAttribute("message", message);
        req.setAttribute("video", form);
        req.setAttribute("videos", list);
        req.getRequestDispatcher("/views/Program/video-crud.jsp").forward(req, resp);
    }
}