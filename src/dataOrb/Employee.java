package dataOrb;

public class Employee {
    private int id;
    private String name;
    private String city;
    private String department;

    public Employee(int id, String name, String city, String department) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
