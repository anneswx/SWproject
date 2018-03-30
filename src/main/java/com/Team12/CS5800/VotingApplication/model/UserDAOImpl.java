package com.Team12.CS5800.VotingApplication.model;

public class UserDAOImpl {

}

/* 
 * 
 * @Override
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
	
	 
	 */