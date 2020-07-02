package app.Controller;

import app.Model.CustomerDao;
import app.implementation.CustomerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/delete")
public class DeleteController extends HttpServlet {
    private static final long serialVersion = 1L;

    public DeleteController() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custId =req.getParameter("custId");

        if(custId==null || custId=="")
            req.getRequestDispatcher("/").forward(req,resp);
        else{
            int id = Integer.parseInt(custId);
            CustomerDao customerDao = CustomerImpl.getInstance();
            customerDao.deleteCustomer(id);
            resp.sendRedirect(req.getContextPath()+"/");
    }
    }
}
