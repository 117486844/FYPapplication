package Model;

public class Data {


    //https://www.youtube.com/watch?v=hg3zZhMoh5Q&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=21


    private String title;
    private String description;
    private String skills;
    private String location;
    private String salary;

    private String id;
    private String date;

   public Data(){

    }


    public Data(String title, String description, String skills, String location, String salary, String id, String date) {
        this.setTitle(title);
        this.setDescription(description);
        this.setSkills(skills);
        this.setLocation(location);
        this.setSalary(salary);
        this.setId(id);
        this.setDate(date);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
