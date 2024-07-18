package assignment;

class Employee extends AbstractUser {
    private String department; 

    public Employee(String name, int id) {
		super(name, id);
	}

	public Employee(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDetails() {
        System.out.println("Employee Name: " + getName() + ", ID: " + getId() + ", Department: " + department);
    }

    @Override
    public void setDetails(String name, int id) {
        setName(name);
        setId(id);
    }
}