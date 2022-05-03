import java.sql.*;
import java.io.*;
import java.util.ResourceBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class login extends HttpServlet{
    public void doPost(HttpServletRequest req,
    HttpServletResponse resp)
throws IOException, ServletException
{
    String email_user= req.getParameter("email");
    String password_user= req.getParameter("password");
    String email_db=null;
    String password_db=null;
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
       
        
        try {
            // String email_user = "karan@gmail.com";
            // String password_user = "karan1";
            String querry = "select * from user_login";
            Class.forName("org.postgresql.Driver");
            // out.println("Driver loaded ");
            Connection cn = DriverManager.getConnection(
                "jdbc:postgresql:ec2-52-3-200-138.compute-1.amazonaws.com:5432/de42rrf9l3mhqt", "ezryqdphjhtojz",
                "a502726a91339ee600dc530c80c382e0a411dfd82253f3d0ec42ec2f577ba1c6");
            //System.out.println("connection Established");
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //System.out.println("statement created");
            ResultSet rs = st.executeQuery(querry);
            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();
            if (size != 0) {
                while (rs.next()) {
                    email_db = rs.getString(3);
                    password_db = rs.getString(4);
                }
            }
            rs.close();
            st.close();
            cn.close();
            // if ((email_db == email_user) && (password_db == password_user)) {
            //     System.out.println("welcome");
            // }
            System.out.println(email_db);
            System.out.println(password_db);
            if(email_db.equals(email_user)){
                if(password_db.equals(password_user)){
                    String doctype = "<!doctype html>\n";
                    out.println(doctype + "<html>\n" + "<head><title>" + "</title></head>\n" +
                    "<body>\n" + "<h1> Welcome!! You have successfully login to our website</h1>");
                }
                else{
                    out.println("<h1>Password Invalid!</h1>");
                }
            }
            else{
                out.println("<h1>Email invalid</h1>");
            }

            }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
        //      Class.forName("org.postgresql.Driver");
        //    //  out.println("Driver loaded ");
        //  Connection cn = DriverManager.getConnection("jdbc:postgresql:karan", "postgres", "karan");
         
        //     PreparedStatement ps = cn.prepareStatement("select * from register where email=? and password=?");
        //     ps.setString(1, email_db);
        //     ps.setString(2, password_db);
        //     
        //     if ((email_db == email_user) && (password_db == password_user)) {
                
        
       

                
        //     }
        //     else{
                
        //         out.println("<h1>Sorry!!! Try again </h1>" + "</body> </html>");

        //     }

        // }
       