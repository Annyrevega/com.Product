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

@WebServlet("customer/register")
public class CustomerReg extends HttpServlet {
    private static final long SerialVersion = 1L;

    private CustomerDao customerDao = CustomerImpl.getInstance();

    public CustomerReg() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        String product_name = req.getParameter("product_name");
        int price = Integer.parseInt(req.getParameter("price"));
        int shop_id = Integer.parseInt(req.getParameter("shop_id"));

        Customer customer = new Customer(product_name, price, shop_id);
        if (product_id == 0)
            customerDao.saveCustomer(customer);
        else {
customer.setProduct_id(product_id);
customerDao.updateCustomer(customer);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
