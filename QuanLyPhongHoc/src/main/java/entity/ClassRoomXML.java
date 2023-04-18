/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classroomes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassRoomXML {
    private List<ClassRoom> classroom;
    public List<ClassRoom> getClassRoom() {
        return classroom;
    }
    
    public void setClassRoom(List<ClassRoom> classroom){
        this.classroom = classroom;
    }
}
