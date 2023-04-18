package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {

    /**
     * Chuyển đổi đối tượng object về định dạng XML
     * Sau đo lưu vào fileName
     * 
     * @param fileName
     * @param object
     */
    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            // tạo đối tượng JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            // Create đối tượng Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // formating 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // lưu nội dung XML vào file
            File xmlFile = new File(fileName);
            jaxbMarshaller.marshal(object, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc nội dung fileName, sau đó chuyển đổi nội dung của file 
     * thành đối tượng có kiểu là clazz.
     * 
     * @param fileName
     * @param clazz
     * @return
     */
//    public static Object readXMLFile(String fileName, Class<?> clazz) {
//        try {
//           
//            File xmlFile = new File("C:\\Users\\admin\\Documents\\JaVa\\BaiTapLon\\src\\main\\java\\main\\student.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            return jaxbUnmarshaller.unmarshal(xmlFile);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static List<Object> readXMLFiles(String CLASSROOM_FILE_NAME, Class<?> clazz) {
    List<Object> objects = new ArrayList<>();
    String[] fileNames = {"C:\\Users\\admin\\Documents\\JaVa\\QuanLyPhongHoc\\src\\main\\java\\main\\classroom.xml"};

    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        for (String fileName : fileNames) {
            File xmlFile = new File(fileName);
            Object obj = jaxbUnmarshaller.unmarshal(xmlFile);
            objects.add(obj);
        }
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    return objects;
}

}
