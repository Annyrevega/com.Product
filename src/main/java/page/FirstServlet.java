package page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        try {
            Driver drv = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(drv);
        } catch (SQLException exception) {
            System.out.println("Драйвер не создан");
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "rootroot");
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT* FROM business.product");

            while (res.next()) {
                printWriter.println(res.getString("product_name"));

            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(" Соединение не установлено");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
