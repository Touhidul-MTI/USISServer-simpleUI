
public class Course {
    private String name;
    private String id;
    private String courseName;
    private int section;
    private String time;
    public Course(String n, String i, String c, int s, String t){
        this.name=n;
        this.id=i;
        this.courseName=c;
        this.section=s;
        this.time=t;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getCourseName(){
        return courseName;
    }
    public int getSection(){
        return section;
    }
    public String getTime(){
        return time;
    }
    public String toString(){
    return courseName+","+section+","+time;
    }
}
