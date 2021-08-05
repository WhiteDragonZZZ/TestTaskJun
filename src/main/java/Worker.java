import java.util.Date;

public class Worker {
    private String fullName;
    private String dateOfBorn;
    private Date dateOffer;
    private int identificatedCode;
    private int salary;


    public Worker() {

    }

    public Worker(String fullName, String dateOfBorn, Date dateOffer, int identificatedCode, int salary) {
        this.fullName = fullName;
        this.dateOfBorn = dateOfBorn;
        this.dateOffer = dateOffer;
        this.identificatedCode = identificatedCode;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "fullName='" + fullName + '\'' +
                ", dateOfBorn='" + dateOfBorn + '\'' +
                ", dateOffer='" + dateOffer + '\'' +
                ", identificatedCode=" + identificatedCode +
                ", salary=" + salary +
                '}';
    }
}
