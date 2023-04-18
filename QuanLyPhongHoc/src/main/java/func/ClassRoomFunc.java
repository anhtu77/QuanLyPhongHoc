/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package func;

import entity.ClassRoom;
import entity.ClassRoomXML;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.FileUtils;
import java.util.List;


public class ClassRoomFunc {
    private static final String CLASSROOM_FILE_NAME = "classroom.xml";
    private List<ClassRoom> listClassroomes;
    
    public ClassRoomFunc() {
        this.listClassroomes = readListClassRoomes();
    }
    
    public void writeListStudents(List<ClassRoom> classroomes) {
        ClassRoomXML classroomXML = new ClassRoomXML();
        classroomXML.setClassRoom(classroomes);
        FileUtils.writeXMLtoFile(CLASSROOM_FILE_NAME, classroomXML);
    }
    
    public List<ClassRoom> readListClassRoomes() {
        List<ClassRoom> list = new ArrayList<ClassRoom>();
        ClassRoomXML classroomXML = (ClassRoomXML) FileUtils.readXMLFile(CLASSROOM_FILE_NAME,
                 ClassRoomXML.class);
                
       if (classroomXML != null) {
           list = classroomXML.getClassRoom();
       }
       return list;
    }


    
     public void add(ClassRoom classroom) {
        int id = (listClassroomes.size() > 0) ? (listClassroomes.size() + 1) : 1;
        classroom.setId(id);
        listClassroomes.add(classroom);
        writeListStudents(listClassroomes);
    }
       public void edit(ClassRoom classroom) {
        int size = listClassroomes.size();
        for (int i = 0; i < size; i++) {
            if (listClassroomes.get(i).getId() == classroom.getId()) {
                listClassroomes.get(i).setMa(classroom.getMa());
                listClassroomes.get(i).setTen(classroom.getTen());
                listClassroomes.get(i).setLoaiPhong(classroom.getLoaiPhong());
                listClassroomes.get(i).setSucChua(classroom.getSucChua());
                 listClassroomes.get(i).setCsvc(classroom.getCsvc());
                 listClassroomes.get(i).setDiaChi(classroom.getDiaChi());
                writeListStudents(listClassroomes);
                break;
            }
        }
    }
       public boolean delete(ClassRoom classroom) {
        boolean isFound = false;
        int size = listClassroomes.size();
        for (int i = 0; i < size; i++) {
            if (listClassroomes.get(i).getId() == classroom.getId()) {
                classroom = listClassroomes.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listClassroomes.remove(classroom);
            writeListStudents(listClassroomes);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortClassRoomByName() {
        Collections.sort(listClassroomes, new Comparator<ClassRoom>() {
            public int compare(ClassRoom classroom1, ClassRoom classroom2) {
                return classroom1.getTen().compareTo(classroom2.getTen());
            }
        });
    }

    /**
     * sắp xếp danh sách student theo GPA theo tứ tự tăng dần
     */
    public void sortClassRoomBySucChua() {
        Collections.sort(listClassroomes, new Comparator<ClassRoom>() {
            public int compare(ClassRoom classroom1, ClassRoom classroom2) {
                if (classroom1.getSucChua() > classroom2.getSucChua()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<ClassRoom> getListClassRoomes() {
        return listClassroomes;
    }

    public void setListClassRoomes(List<ClassRoom> listClassroomes) {
        this.listClassroomes = listClassroomes;
    }
    
    public static void main(String[] args) {
        new ClassRoomFunc().readListClassRoomes().forEach(s -> System.out.println(s.toString()));
    }
    
}
