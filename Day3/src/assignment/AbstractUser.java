package assignment;

abstract class AbstractUser {
	
    private String name;
    private int id;

    public AbstractUser(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void getDetails();

    public abstract void setDetails(String name, int id);
}

