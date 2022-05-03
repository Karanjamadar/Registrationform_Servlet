import java.io.*;
import java.util.ResourceBundle;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class registered extends HttpServlet {

    public void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException, ServletException {
        // resp.setContentType("text/html");
        // PrintWriter out = resp.getWriter();

        String title = "New user created";

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String doctype = "<!doctype html>\n";
        out.println(doctype + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                "<body>\n" + "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<li> <b> First name </b>:"
                + fname + "\n" +
                "<li><b>last name</b>:"
                + lname + "\n" +
                "<li><b>email</b>:"
                + email + "\n" +
                "<li><b>password</b>:"
                + password + "\n" +
                "</ul>\n");

        try {
            String querry = "INSERT INTO user_login VALUES('" + fname + "','" + lname + "','" + email + "','" + password
                    + "')";
            Class.forName("org.postgresql.Driver");
            Connection cn = DriverManager.getConnection(
                    "jdbc:postgresql:ec2-52-3-200-138.compute-1.amazonaws.com:5432/de42rrf9l3mhqt", "ezryqdphjhtojz",
                    "a502726a91339ee600dc530c80c382e0a411dfd82253f3d0ec42ec2f577ba1c6");

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(querry);
            out.println("<p><values inserted</p>");
            // while(rs.next()){
            // int id = rs.getInt("s_id");
            // String name = rs.getString("s_name");
            // int age = rs.getInt("age");
            // out.println("ID : "+id+ "<br>");
            // out.println("Name : "+name+ "<br>");
            // out.println("AGE : "+age+ "<br>");
            // out.println("</body> </html>");
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        catch (Exception e) {
            e.printStackTrace();

        }

    }
}
