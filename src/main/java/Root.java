import java.util.List;

public class Root {
    private String name;
    private List<Worker> workers;
    private List<Manager> managers;


    public Root() {

    }

    public Root(String name, List<Worker> workers) {
        this.name = name;
        this.workers = workers;
    }

    public Root(String name, List<Worker> workers, List<Manager> managers) {
        this.name = name;
        this.workers = workers;
        this.managers = managers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", workers=" + workers +
                '}';
    }
}
