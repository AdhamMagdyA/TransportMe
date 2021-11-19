package rides;
import java.util.List;
import users_pack.Driver;
public class Area {
    private String name;
    private List<Driver> driversList;

    public Area(String name) {
        this.name = name;
    }

    public void addDriver(Driver driver){
        driversList.add(driver);
    }

    public String getName() {
        return name;
    }

    public List<Driver> getDriversList() {
        return driversList;
    }

    public void setName(String name) {
        this.name = name;
    }

}
