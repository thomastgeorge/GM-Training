package assignment;

public class AbstractMain {
    public static void main(String[] args) {
        Customer customer = new Customer("User", 001, "Reg Custmer");
        Employee employee = new Employee("X", 002, "SDE");
        Admin admin = new Admin("Wahh", 003, "IT Head");

        customer.getDetails();
        employee.getDetails();
        admin.getDetails();
    }
}
