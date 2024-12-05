package Poly.OE.Account.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import Poly.OE.DAO.UserDAO;
import Poly.OE.DAO.UserDAOImpl;
import Poly.OE.Entity.User;

@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO dao;

    public RegisterServlet() {
        super();
        dao = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/Account/Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy dữ liệu từ form đăng ký
        String id = req.getParameter("id");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String admin = req.getParameter("admin");

        // Kiểm tra mật khẩu và các trường khác
        String message;
        if (!password.equals(confirmPassword)) {
            message = "Passwords do not match!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/views/Account/Register.jsp").forward(req, resp);
            return;
        }

        try {
            // Tạo User mới
            User newUser = new User();
            newUser.setId(id);
            newUser.setFullname(fullname);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setAdmin(Boolean.parseBoolean(admin));

            // Lưu vào DB
            dao.create(newUser);
            message = "Registration successful! Please sign in.";
        } catch (Exception e) {
            e.printStackTrace();
            message = "Registration failed. Please try again.";
        }

        // Gửi thông báo
        req.setAttribute("message", message);
        if (message.startsWith("Registration successful")) {
            resp.sendRedirect("/SOF3012_ASM/signin");
        } else {
            req.getRequestDispatcher("/views/Account/Register.jsp").forward(req, resp);
        }
    }
}
