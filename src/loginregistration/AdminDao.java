package loginregistration;

public interface AdminDao {
    int insertAdmin(Admin a);

    Admin getAdmin(String ausername, String apassword);

    boolean isManager(String username) ;

}
