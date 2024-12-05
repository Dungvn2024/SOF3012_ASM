package Poly.OE.Account.Servlet;

import java.io.IOException;

import Poly.OE.Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Poly.OE.DAO.UserDAO;
import Poly.OE.DAO.UserDAOImpl;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển tiếp tới trang đăng nhập
        request.getRequestDispatcher("/views/Account/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idOrEmail = request.getParameter("idOrEmail");
        String password = request.getParameter("password");

        // Kiểm tra nếu không nhập tên đăng nhập
        if (idOrEmail == null || idOrEmail.trim().isEmpty()) {
            request.setAttribute("error", "Tên đăng nhập thiếu. Vui lòng nhập lại!");
            request.getRequestDispatcher("/views/Account/Login.jsp").forward(request, response);
            return;
        }

        User user = userDAO.findByIdOrEmail(idOrEmail);

        if (user == null) {
            // Tên đăng nhập không tồn tại
            request.setAttribute("error", "Tên đăng nhập không tồn tại. Vui lòng kiểm tra lại!");
            request.getRequestDispatcher("/views/Account/Login.jsp").forward(request, response);
            return;
        }

        if (password == null || password.trim().isEmpty() || !user.getPassword().equals(password)) {
            // Sai mật khẩu hoặc không nhập mật khẩu
            request.setAttribute("error", "Mật khẩu không đúng. Vui lòng nhập lại!");
            request.getRequestDispatcher("/views/Account/Login.jsp").forward(request, response);
            return;
        }

        // Đăng nhập thành công
        request.getSession().setAttribute("user", user);

        // Phân quyền
        if (Boolean.TRUE.equals(user.getAdmin())) {
            response.sendRedirect("/UserControl");
        } else {
            response.sendRedirect("/VideoControl");
        }
    }

//@Override
//protected void doPost(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    String idOrEmail = request.getParameter("idOrEmail");
//    String password = request.getParameter("password");
//
//    User user = userDAO.findByIdOrEmail(idOrEmail);
//    if (user != null && user.getPassword().equals(password)) {
//        // Lưu thông tin user vào session và chuyển hướng
//        request.getSession().setAttribute("user", user);
//        response.sendRedirect("/UserControl"); // Chuyển hướng về trang chủ
//    } else {
//        // Trả lại lỗi đăng nhập
//        request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
//        request.getRequestDispatcher("/views/Account/Login.jsp").forward(request, response);
//    }
//}



}