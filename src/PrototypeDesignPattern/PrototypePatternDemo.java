package PrototypeDesignPattern;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe", "Software Engineer");
        employee1.showDetails();

        // Cloning the object
        Employee employee2 = (Employee) employee1.clone();
        employee2.showDetails();
    }
}
