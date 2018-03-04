package loginregistration;

public interface CustomerDAO {

    int insertCustomer(Customer c);

    boolean isNewUsername(String username);

    Customer getCustomer(String username, String password);

    int updateVoterinfo(Customer c);

}
