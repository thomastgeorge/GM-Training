package assignment;

class Customer extends AbstractUser {
    private String customer;

    public Customer(String name, int id) {
		super(name, id);
	}

	public Customer(String name, int id, String customer) {
        super(name, id);
        this.customer = customer;
    }

    public String getCustomerLevel() {
        return customer;
    }

    public void customer(String customer) {
        this.customer = customer;
    }

    @Override
    public void getDetails() {
        System.out.println("Customer Name: " + getName() + ", ID: " + getId() + ", customer: " + customer);
    }

    @Override
    public void setDetails(String name, int id) {
        setName(name);
        setId(id);
    }
}
