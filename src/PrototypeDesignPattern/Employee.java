package PrototypeDesignPattern;

public class Employee implements Prototype {
    private final String name;
    private final String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public Prototype clone() {
        return new Employee(name, designation);
    }

    public void showDetails() {
        System.out.println("Employee: " + name + ", Designation: " + designation);
    }
}
