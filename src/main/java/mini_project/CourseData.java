/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_project;

/**
 *
 * @author USER
 */

import java.util.HashMap;
import java.util.Map;

public class CourseData {
    public static Map<String, Course> courseMap = new HashMap<>();
    
    static {
        courseMap.put("Hydraulics Technology", new Course(
            "Hydraulics Technology",
            "This course provides an in-depth study of hydraulic systems used in industrial and mobile applications. Students will learn the principles of fluid power, system components such as pumps, valves, actuators, and accumulators, and how to design, maintain, and troubleshoot hydraulic circuits. Emphasis is placed on safety practices, interpreting hydraulic schematics, and hands-on experience with real-world systems.",
            "3 Months",
            "hydraulic.jpg"
        ));

        courseMap.put("Fundamental Of Industrial Robotics", new Course(
            "Fundamental Of Industrial Robotics",
            "This course introduces students to the core concepts of industrial robotics, including robotic components, kinematics, control systems, programming, and integration into manufacturing environments. Students will explore different types of robots and their applications in automation, gain experience in programming robotic arms, and understand the role of robotics in Industry 4.0.\n" +
"",
            "4 Months",
            "Industrial_Robotics.jpg"
        ));

        courseMap.put("Programmable Logic Controller", new Course(
            "Programmable Logic Controller",
            "This course covers the principles and applications of programmable logic controllers in industrial automation. Students will learn to program, troubleshoot, and implement PLC-based control systems using ladder logic and other programming methods. Topics include input/output devices, timers, counters, data handling, and real-time control of industrial machinery.",
            "5 Months",
            "PLC.jpg"
        ));

        courseMap.put("Electrical Installation", new Course(
            "Electrical Installation",
            "This course equips students with practical knowledge and skills in residential, commercial, and industrial electrical installations. Topics include electrical safety, wiring systems, circuit protection, switchgear, grounding, and adherence to national electrical codes and standards. Hands-on lab sessions provide experience in designing and installing electrical circuits and systems.\n" +
"",
            "2 Months",
            "Electrical_installation.jpg"
        ));
    }
}
