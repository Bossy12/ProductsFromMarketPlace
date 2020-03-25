package sample.Utils;

import sample.entity.User;

public interface UserStrategy {
    public User activeUser(User user);
}
