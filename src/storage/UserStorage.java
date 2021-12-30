package storage;

import users_pack.Driver;
import users_pack.User;

import java.util.List;

public abstract class UserStorage {
    public abstract boolean addRegisteredUser( User user );
    public abstract boolean removeRegisteredUser( User user );
    public abstract boolean addPendingRegistration( Driver driver );
    public abstract boolean removePendingRegistration( Driver driver );

    public abstract List<Driver> getPendingRegistrations();
}
