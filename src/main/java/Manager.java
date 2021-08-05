import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager {
    private String fullName;
    private String dateOfBorn;
    private Date dateOffer;
    private int identificatedCode;
    private List<Worker> workers = new ArrayList<>();
    private int salary;

    public Manager() {

    }

    public Manager(String fullName, String dateOfBorn, Date dateOffer, int identificatedCode, List<Worker> workers, int salary) {
        this.fullName = fullName;
        this.dateOfBorn = dateOfBorn;
        this.dateOffer = dateOffer;
        this.identificatedCode = identificatedCode;
        this.workers = workers;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(String dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public Date getDateOffer() {
        return dateOffer;
    }

    public void setDateOffer(Date dateOffer) {
        this.dateOffer = dateOffer;
    }

    public int getIdentificatedCode() {
        return identificatedCode;
    }

    public void setIdentificatedCode(int identificatedCode) {
        this.identificatedCode = identificatedCode;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "fullName='" + fullName + '\'' +
                ", dateOfBorn='" + dateOfBorn + '\'' +
                ", dateOffer='" + dateOffer + '\'' +
                ", identificatedCode=" + identificatedCode +
                ", workers=" + workers +
                ", salary=" + salary +
                '}';
    }
}