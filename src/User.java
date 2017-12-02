
public class User {
    private String name;
    private String id;
    private String email;
    private String password;
    public User(String n,String i, String e, String p){
        this.name=n;
        this.id=i;
        this.email=e;
        this.password=p;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPass(){
        return password;
    } 
    public String toString(){
        return name+","+id+","+email+","+password;
    }
}
