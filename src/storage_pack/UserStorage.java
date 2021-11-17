package storage_pack;

import users_pack.User;

public interface UserStorage {
    public void storeUser(User user);
    public boolean login(String username, String password);
}
