package sample.Utils;

import sample.entity.User;
import sample.entity.UserType;

public class Client {
    private String userName;
    private UserType userType;
    private ClientInterface clientInterface;

    public Client(User user) {
        this.userName = user.getUsername();
        this.userType = user.getUserType();
        setClientInterface(switchClient(userType));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public ClientInterface getClientInterface() {
        return clientInterface;
    }

    public void setClientInterface(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    public ClientInterface switchClient(UserType userType) {
        if (userType.equals(UserType.EMPLOYEE)) {
            return new EmployeeClient();
        } else if (userType.equals(UserType.LUCKYONE)) {
            return new LuckyOneClient();
        }
        return new CustomerClient();
    }
}

