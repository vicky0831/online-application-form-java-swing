/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_project;

/**
 *
 * @author USER
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
