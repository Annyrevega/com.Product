package app.implementation;

import app.Model.CustomerDao;
import app.config.Database;
import app.object.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDao {
    private static CustomerImpl customerImpl = null;
    private Connection connection = Database.getConnection();

    public long saveCustomer(Customer customer) {
        String sql = "Insert into business.product" + "(product_name, price, shop_id" + "VALUES(?,?,?)";
        int product_id = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getProduct_name());
            preparedStatement.setString(2, String.valueOf(customer.getPrice()));
            preparedStatement.setString(3, String.valueOf(customer.getShop_id()));

            if (preparedStatement.executeUpdate() > 0) {//созд-е записи
                ResultSet resultSet = preparedStatement.getGeneratedKeys();//возв-е первичного сгенерированного ключа
                if (resultSet.next())
                    product_id = resultSet.getInt(1);

            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return product_id;
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE business.product SET" + "product_name=?, price=? shop_id=?" + "WHERE product_id=?";

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getProduct_name());
            preparedStatement.setInt(2,customer.getPrice());
            preparedStatement.setInt(3,customer.getProduct_id());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM business.product where product_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();//удаление записи
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM business.product where product_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setProduct_id(resultSet.getInt(1));
                customer.setProduct_name(resultSet.getString(2));
                customer.setPrice((resultSet.getInt(3)));
                customer.setShop_id(resultSet.getInt(4));
                return customer;
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public List<Customer> findAllCustomers() {
        String sql="SELECT *FROM business.product";
        List<Customer>customers = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                if(customers==null)
                    customers=new ArrayList<Customer>();

                Customer customer = new Customer();
                customer.setProduct_id(resultSet.getInt(1));
                customer.setProduct_name(resultSet.getString(2));
                customer.setPrice(resultSet.getInt(3));
                customer.setShop_id(resultSet.getInt(4));
                customers.add(customer);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return customers;
    }
    public  static CustomerDao getInstance(){
        if(customerImpl==null){
            customerImpl = new CustomerImpl();
        }
        return customerImpl;
    }
}
