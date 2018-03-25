package com.Team12.CS5800.VotingApplication.model;

import com.Team12.CS5800.VotingApplication.model.DataConnection.MyConnectionProvider;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {

    static Connection con;
    static PreparedStatement ps;
    
    @Override
    public int insertCustomer(Customer c) {
        int status = 0;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("insert into customer (username, password,email)values(?,?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getEmail());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }


    @Override
    public boolean isNewUsername(String username) {
        boolean isnew = true ;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("select * from customer where username = ?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                isnew = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isnew;
    }

    @Override
    public Customer getCustomer(String username, String password) {
        Customer c = new Customer();

        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("select * from customer where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
        	
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setUserid(rs.getInt(1));
                c.setUsername(rs.getString(2));
                c.setPassword(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setVoterstatus(rs.getInt(5));
                c.setRealname(rs.getString(6));
                c.setSsn(rs.getInt(7));
                c.setAddress(rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public int updateVoterinfo(Customer c) {
        int status = 0;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("update customer set voterstatus = ?, realname = ?, ssn = ?, address = ? where userid = ?");
            ps.setInt(1, 1);
            ps.setString(2, c.getRealname());
            ps.setInt(3, c.getSsn());
            ps.setString(4, c.getAddress());
            ps.setInt(5, c.getUserid());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
