package Poly.OE.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import Poly.OE.DAO.UserDAO;
import Poly.OE.DAO.UserDAOImpl;
//import Entity.User;
import Poly.OE.Entity.User;

/**
 * Servlet implementation class User
 */
@WebServlet({("/UserControl"),
"/user/crud/index", "/user/crud/edit/*", "/user/crud/create",
"/user/crud/update", "/user/crud/delete", "/user/crud/reset"
})

public class UserCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAOImpl();
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		User form = new User();
        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = "Enter user information";
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
            form = new User();
        }

        List<User> list = dao.findAll();
        req.setAttribute("message", message);
        req.setAttribute("user", form);
        req.setAttribute("users", list);
        req.getRequestDispatcher("/views/Program/user-crud.jsp").forward(req, resp);
		
	}

	

}
