package loginregistration;

public class Customer {

    private int userid;
    private String username;
    private String password;
    private String email;
    private int voterstatus;
    private String realname;
    private int ssn;
    private String address;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getVoterstatus() {
        return voterstatus;
    }

    public void setVoterstatus(int voterstatus) {
        this.voterstatus = voterstatus;
    }

    public String getRealname() { return realname; }

    public void setRealname(String realname) { this.realname = realname; }

    public int getSsn() { return ssn; }

    public void setSsn(int ssn) { this.ssn = ssn; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

}
