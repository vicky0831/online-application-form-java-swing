
package mini_project;

/**
 *
 * @author Vicky
 */

public class Course {
    private String Course_Name;
    private String description;
    private String duration;
    private String imagePath;
    
    
    public Course(String title, String description, String duration, String imagePath){
        this.Course_Name = title;
        this.description = description;
        this.duration = duration;
        this.imagePath = imagePath;
    }
    
    public String getTitle(){
        return Course_Name;
    }
    
    public String getDescription(){
        return description;
    }
        
    public String getDuration(){
        return duration;
    }
    
    public String getImagePath(){
        return imagePath;
    }
}
