package co.edu.unbosque.wsresttutorial.dtos;

public class Userdb {
    private String email;
    private String password;
    private String name;
    private String role;

    public Userdb() {
    }
    public Userdb(String email,String password,String name,String role){
        this.email=email;
        this.password=password;
        this.name=name;
        this.role=role;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }



}
