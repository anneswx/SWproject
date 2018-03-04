package loginregistration;

import DataConnection.MyConnectionProvider;

import java.sql.*;

public class AdminDaoImpl implements AdminDao {
    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertAdmin(Admin a) {
        int status = 0;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("insert into admin (username, password)values(?,?)");
            ps.setString(1, a.getAusername());
            ps.setString(2, a.getApassword());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public Admin getAdmin(String ausername, String apassword) {

        Admin a = new Admin();

        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("select * from admin where username = ? and password = ?");
            ps.setString(1, ausername);
            ps.setString(2, apassword);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.setAid(rs.getInt(1));
                a.setAusername(rs.getString(2));
                a.setApassword(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    @Override
    public boolean isManager(String username) {
        boolean ismanager = false ;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("select * from admin where username = ? and manager = ?");
            ps.setString(1, username);
            ps.setInt(2, 1);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ismanager = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ismanager;
    }
}
