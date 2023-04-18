/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classroom")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "ma")
    private String ma;
    @XmlElement(name = "ten")
    private String ten;
    @XmlElement(name = "loaiPhong")
    private String loaiPhong;
    @XmlElement(name = "sucChua")
    private int sucChua;
    @XmlElement(name = "diaChi")
    private String diaChi;
    @XmlElementWrapper(name = "csvc")
    @XmlElement(name = "csvcName")
    private List<String> csvc;
    
    public ClassRoom() {
    
    }

    public ClassRoom(int id, String ma, String ten, String loaiPhong, int sucChua,String diaChi, List<String> csvc) {
        super();
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiPhong = loaiPhong;
        this.sucChua = sucChua;
        this.diaChi = diaChi;
        this.csvc = csvc;
    }
     public ClassRoom( String ma, String ten, String loaiPhong, int sucChua,String diaChi, List<String> csvc) {
        super();
      
        this.ma = ma;
        this.ten = ten;
        this.loaiPhong = loaiPhong;
        this.sucChua = sucChua;
        this.diaChi = diaChi;
        this.csvc = csvc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public List<String> getCsvc() {
        return csvc;
    }

    public void setCsvc(List<String> csvc) {
        this.csvc = csvc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
    
    
   
    
}
