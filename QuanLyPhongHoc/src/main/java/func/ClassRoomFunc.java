/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package func;

import entity.ClassRoom;
import entity.ClassRoomXML;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import utils.FileUtils;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ClassRoomFunc {

    private static final String CLASSROOM_FILE_NAME = "classroom.xml";
    private List<ClassRoom> listClassroomes;

    public ClassRoomFunc() {
        this.listClassroomes = readListClassRoomes();
    }

    public void writeListStudents(List<ClassRoom> classroomes) {
        ClassRoomXML classroomXML = new ClassRoomXML();
        classroomXML.setClassRoom(classroomes);
        // ghi đối tượng classRoomXML vào 1 CLASSROOM_FILE_NAME
        FileUtils.writeXMLtoFile(CLASSROOM_FILE_NAME, classroomXML);
    }

    public List<ClassRoom> readListClassRoomes() {
        List<ClassRoom> list = new ArrayList<ClassRoom>();
        // Sử dụng lớp tiện ích FileUtils để đọc đối tượng ClassRoomXML từ một tệp tin có tên là CLASSROOM_FILE_NAME.
        ClassRoomXML classroomXML = (ClassRoomXML) FileUtils.readXMLFile(CLASSROOM_FILE_NAME,
                ClassRoomXML.class);
        // Kiểm tra đối tượng classroomXML khác null, nếu đúng thì lấy danh sách các đối tượng lớp học từ classroomXML và gán vào biến list.
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

  


    public ClassRoom findClassRoomById(String id) {
       ClassRoom classroom = null;
        try {
            // tạo ra một đối tượng,  JAXBContext để ánh xạ các lớp Java quá file xml
            JAXBContext context = JAXBContext.newInstance(ClassRoomXML.class);
            // Tạo một đối tượng Unmarshaller để giải mã tài liệu xml thành các đối tượng java
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Sử dụng unmarshaller để giải mã tài liệu XML chứa danh sách ClassRoom từ tệp được chỉ định bởi CLASSROOM_FILE_NAME.
            ClassRoomXML ClassRoomXML = (ClassRoomXML) unmarshaller.unmarshal(new File(CLASSROOM_FILE_NAME));
            for (ClassRoom cr : ClassRoomXML.getClassRoom()) {
                if (cr.getMa().contains(id)) {
                    classroom = cr;
                    break;
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    

    



    public ClassRoom findClassRoomBySucChua(int sucChua) {
        ClassRoom classroom = null;
        try {
            JAXBContext context = JAXBContext.newInstance(ClassRoomXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ClassRoomXML ClassRoomXML = (ClassRoomXML) unmarshaller.unmarshal(new File(CLASSROOM_FILE_NAME));
            for (ClassRoom cr : ClassRoomXML.getClassRoom()) {
                if (cr.getSucChua() == sucChua) {
                    classroom = cr;
                    break;
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public List<ClassRoom> getListClassRoomes() {
        return listClassroomes;
    }

    public void setListClassRoomes(List<ClassRoom> listClassroomes) {
        this.listClassroomes = listClassroomes;
    }

 

}
