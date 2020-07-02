package app.Controller;

import app.Model.CustomerDao;
import app.implementation.CustomerImpl;
import app.object.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/update")
public class UpdateCustomer extends HttpServlet {
    private static final long SerialVersion = 1L;

    public UpdateCustomer() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String custId = req.getParameter("custid");

       if(custId==null || custId==" "){
           req.getRequestDispatcher("/").forward(req,resp);
       }else{
           int id = Integer.parseInt(custId);
           CustomerDao customerDao = CustomerImpl.getInstance();
           Customer customer =customerDao.findCustomerById(id);
           req.setAttribute("customer", customer);
           req.getRequestDispatcher("/").forward(req,resp);
       }
    }
}
