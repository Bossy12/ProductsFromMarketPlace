package sample.Utils;

import sample.entity.User;
import sample.entity.UserType;

public class Client {
    private String userName;
    private UserType userType;
    private DiscountClientStrategy discountClientStrategy;

    public Client(User user) {
        this.userName = user.getUsername();
        this.userType = user.getUserType();
        setDiscountClientStrategy(switchDiscountClientStrategy(userType));
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

    public DiscountClientStrategy getDiscountClientStrategy() {
        return discountClientStrategy;
    }

    public void setDiscountClientStrategy(DiscountClientStrategy discountClientStrategy) {
        this.discountClientStrategy = discountClientStrategy;
    }

    public DiscountClientStrategy switchDiscountClientStrategy(UserType userType) {
        if (userType.equals(UserType.EMPLOYEE)) {
            return new EmployeeDiscountClient();
        }else if (userType.equals(UserType.LUCKYONE)){
            return  new LuckyOneDiscountClient();
        }
            return new CustomerDiscountClient();
    }
}

