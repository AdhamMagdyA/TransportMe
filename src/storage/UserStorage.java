package storage;

import users_pack.Driver;
import users_pack.User;

import java.util.ArrayList;
import java.util.List;

import rides.Ride;

public abstract class UserStorage {
    public abstract boolean addRegisteredUser( User user );
    public abstract boolean removeRegisteredUser( User user );
    public abstract boolean addPendingRegistration( Driver driver );
    public abstract boolean removePendingRegistration( Driver driver );
    public abstract ArrayList<Driver> getRegisteredDrivers();
    public abstract List<Driver> getPendingRegistrations();

    public abstract ArrayList<Ride> getRidesEvents();
}
