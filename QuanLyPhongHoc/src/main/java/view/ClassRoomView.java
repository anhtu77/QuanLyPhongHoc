/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import entity.ClassRoom;
import func.ClassRoomFunc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClassRoomView extends javax.swing.JFrame {

    ClassRoomFunc clr;
    List<ClassRoom> ds;

    public ClassRoomView() {
        initComponents();
        clr = new ClassRoomFunc();
        loadTable();
        clearForm();
        txtID.setEnabled(false);
        ds = this.clr.readListClassRoomes();
        this.setLocationRelativeTo(null);
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblClr.getModel();
        dtm.setRowCount(0);

        List<ClassRoom> ds = this.clr.readListClassRoomes();

        for (ClassRoom d : ds) {

            Object[] rowData = {
                d.getId(),
                d.getMa(),
                d.getTen(),
                d.getLoaiPhong(),
                d.getSucChua(),
                d.getCsvc(),
                d.getDiaChi(),};

            dtm.addRow(rowData);

        }
    }

    public void clearForm() {
        this.txtID.setText("");
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.cbbLoaiPhong.setSelectedIndex(0);
        this.txtSucChua.setText("");
        this.cbkDH.setSelected(false);
        this.cbkMT.setSelected(false);
        this.cbkMC.setSelected(false);
        this.cbkS.setSelected(false);
        this.txtDiaChi.setText("");
        this.txtTimKiem.setText("");

    }

    public ClassRoom getFormData() {
        String id = this.txtID.getText();
        String ma = this.txtMa.getText();
        String tenPhong = this.txtTen.getText();
        String loaiPhong = this.cbbLoaiPhong.getSelectedItem().toString();
        String sucChua = this.txtSucChua.getText();
        String dieuHoa = this.cbkDH.getText();
        String mayTinh = this.cbkMT.getText();
        String mayChieu = this.cbkMC.getText();
        String sach = this.cbkS.getText();
        String diaChi = this.txtDiaChi.getText();

        if (ma.trim().length() == 0
                || tenPhong.trim().length() == 0
                || loaiPhong.trim().length() == 0
                || sucChua.trim().length() == 0
                || diaChi.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }

        ClassRoom clr = new ClassRoom();
        clr.setMa(ma);
        clr.setTen(tenPhong);
        clr.setLoaiPhong(loaiPhong);
        clr.setSucChua(Integer.parseInt(sucChua));

        List<String> lstCsvc = new ArrayList();
        if (cbkDH.isSelected()) {
            lstCsvc.add(cbkDH.getText());
        }

        if (cbkMT.isSelected()) {
            lstCsvc.add(cbkMT.getText());
        }

        if (cbkMC.isSelected()) {
            lstCsvc.add(cbkMC.getText());
        }

        if (cbkS.isSelected()) {
            lstCsvc.add(cbkS.getText());
        }

        clr.setCsvc(lstCsvc);
        clr.setDiaChi(diaChi);

        return clr;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSucChua = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextPane();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbkDH = new javax.swing.JCheckBox();
        cbkMT = new javax.swing.JCheckBox();
        cbkMC = new javax.swing.JCheckBox();
        cbkS = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClr = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnTKMa = new javax.swing.JButton();
        btnTKSC = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCL = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        btnRF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Quản lý phòng học ");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã phòng học ");

        jLabel3.setText("Tên phòng học");

        jLabel4.setText("Loại phòng học");

        jLabel5.setText("Sức chứa");

        jLabel6.setText("Tiện nghi đi kèm");

        jLabel7.setText("Địa chỉ ");

        jScrollPane3.setViewportView(txtDiaChi);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cbkDH.setText("Điều hòa");

        cbkMT.setText("Máy tính");

        cbkMC.setText("Máy chiếu");

        cbkS.setText("Sách");

        tblClr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã phòng học", "Tên phòng học", "Loại phòng học", "Sức chứa", "Tiện nghi", "Địa chỉ"
            }
        ));
        tblClr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClrMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClrMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClr);

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel8.setText("Tìm kiếm");

        btnTKMa.setText("Mã phòng");
        btnTKMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKMaActionPerformed(evt);
            }
        });

        btnTKSC.setText("Sức chứa");
        btnTKSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKSCActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        btnCL.setText("ClearForm");
        btnCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLActionPerformed(evt);
            }
        });

        btnThongKe.setText("Thống kê số phòng học");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        cbbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng máy", "Phòng tiếng anh", "Phòng đọc", "Phòng trình chếu" }));
        cbbLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiPhongActionPerformed(evt);
            }
        });

        btnRF.setText("Refresh");
        btnRF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(btnAdd)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDelete)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCL))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel9))
                                            .addGap(36, 36, 36)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbkDH)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cbkMT)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbkMC)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbkS))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cbbLoaiPhong, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSucChua, javax.swing.GroupLayout.Alignment.LEADING))))
                                        .addComponent(jLabel2))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnThongKe)
                                    .addGap(57, 57, 57))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btnTKMa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(btnTKSC)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnRF)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTKMa)
                    .addComponent(btnTKSC)
                    .addComponent(btnRF))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbkDH)
                        .addComponent(cbkMT)
                        .addComponent(cbkMC)
                        .addComponent(cbkS)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnCL)
                    .addComponent(btnThongKe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void tblClrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClrMouseClicked
        int row = this.tblClr.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Phải trọn 1 hàng trên table");
            return;
        }

        String id = this.tblClr.getValueAt(row, 0).toString();
        String maPhong = this.tblClr.getValueAt(row, 1).toString();
        String tenPhong = this.tblClr.getValueAt(row, 2).toString();
        String loaiPhong = this.tblClr.getValueAt(row, 3).toString();
        String sucChua = this.tblClr.getValueAt(row, 4).toString();
        String csvc = this.tblClr.getValueAt(row, 5).toString();
        String diaChi = this.tblClr.getValueAt(row, 6).toString();

        // ghi lên textfield
        this.txtID.setText(id);
        this.txtMa.setText(maPhong);
        this.txtTen.setText(tenPhong);
        this.cbbLoaiPhong.setSelectedItem(loaiPhong);
        this.txtSucChua.setText(sucChua);
        if (csvc.contains("Điều hòa")) {
            this.cbkDH.setSelected(true);
        }
        if (csvc.contains("Máy tính")) {
            this.cbkMT.setSelected(true);
        }
        if (csvc.contains("Máy chiếu")) {
            this.cbkMC.setSelected(true);
        }
        if (csvc.contains("Sách")) {
            this.cbkS.setSelected(true);
        }
        this.txtDiaChi.setText(diaChi);


    }//GEN-LAST:event_tblClrMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblClrMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClrMousePressed
        clearForm();
    }//GEN-LAST:event_tblClrMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            ClassRoom cl = this.getFormData();
            if (cl == null) {
                return;
            }
            this.clr.add(cl);

        } catch (Exception e) {
            // Ngoại lệ in ra theo phương thức
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Thêm thành công ");
        this.loadTable();
        this.clearForm();


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = this.tblClr.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Phải chọn 1 hàng trên table");
            return;

        }
        String ma = txtMa.getText();
        // tìm kiếm đối tượng có mã tương ứng trong danh sách
        ClassRoom cl = clr.findClassRoomById(ma);
        clr.delete(cl);
        JOptionPane.showMessageDialog(this, "Xóa thành công ");
        this.loadTable();
        this.clearForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public int getId() {
        int row = tblClr.getSelectedRow();
        return Integer.parseInt(tblClr.getValueAt(row, 0).toString());
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = this.tblClr.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Phải chọn 1 hàng trên table");
            return;

        }

        ClassRoom classroom = this.getFormData();
        int id = getId();
        classroom.setId(id);
        clr.edit(classroom);
        JOptionPane.showMessageDialog(this, "Sửa thành công ");
        this.loadTable();
        this.clearForm();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTKMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKMaActionPerformed
        // Lấy table model của table và lưu trữ trong biến model
        String ma = this.txtTimKiem.getText();
        ClassRoom cl = clr.findClassRoomById(ma);
         if (ma.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblClr.getModel();

        // Xóa các dòng dữ liệu cũ trên table
        model.setRowCount(0);

        // Kiểm tra nếu tìm được phòng học thì cập nhật dữ liệu trên table
        if (cl != null) {
            // Thêm dòng mới với thông tin phòng học tìm được
            model.addRow(new Object[]{cl.getId(), cl.getMa(), cl.getTen(), cl.getLoaiPhong(), cl.getSucChua(), cl.getCsvc(), cl.getDiaChi()});
        } else {
            JOptionPane.showMessageDialog(this, "Không có phòng học nào có mã: " + this.txtTimKiem.getText());
            this.clearForm();
        }


    }//GEN-LAST:event_btnTKMaActionPerformed

    private void btnTKSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKSCActionPerformed

        String succhua = this.txtTimKiem.getText();
        DefaultTableModel model = (DefaultTableModel) tblClr.getModel();
        if (succhua.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập sức chứa");
            return;
        }
        List<ClassRoom> ds = this.clr.readListClassRoomes();
        List<Integer> indexList = new ArrayList<>();
        boolean a = false;
        for (int i = 0; i < ds.size(); i++) {
            ClassRoom d = ds.get(i); // Lấy một thành phần trong Arraylist
            if (d.getSucChua() == Integer.parseInt(succhua)) {
                indexList.add(i);
                a = true;
            }
        }
        if (a == false) {
            JOptionPane.showMessageDialog(this, "Không có phòng học nào có sức chứa là: " + this.txtTimKiem.getText());
            this.clearForm();
            this.loadTable();
        } else {

            model.setRowCount(0); // Xóa hết các dòng trong bảng
            for (int index : indexList) {
                ClassRoom cl = ds.get(index);
                model.addRow(new Object[]{cl.getId(), cl.getMa(), cl.getTen(), cl.getLoaiPhong(), cl.getSucChua(), cl.getCsvc(), cl.getDiaChi()}); // Thêm một dòng mới vào bảng
                clearForm();
            }

//        this.getDataTable(indexList.get(0));
        }


    }//GEN-LAST:event_btnTKSCActionPerformed


    private void btnCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLActionPerformed
        tblClr.clearSelection();
        clearForm();
    }//GEN-LAST:event_btnCLActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) this.tblClr.getModel();
        dtm.setRowCount(0);

        List<ClassRoom> ds = this.clr.readListClassRoomes();

        for (ClassRoom d : ds) {

            Object[] rowData = {
                d.getId(),
                d.getMa(),
                d.getTen(),
                d.getLoaiPhong(),
                d.getSucChua(),
                d.getCsvc(),
                d.getDiaChi(),};

            dtm.addRow(rowData);

        }
        JOptionPane.showMessageDialog(this, "Tổng số phòng học: " + ds.size());


    }//GEN-LAST:event_btnThongKeActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        clearForm();
        tblClr.clearSelection();
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void cbbLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiPhongActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnRFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRFActionPerformed
        clearForm();
        loadTable();
    }//GEN-LAST:event_btnRFActionPerformed

    public void getDataTable(int row) {
        String id = this.tblClr.getValueAt(row, 0).toString();
        String maPhong = this.tblClr.getValueAt(row, 1).toString();
        String tenPhong = this.tblClr.getValueAt(row, 2).toString();
        String loaiPhong = this.tblClr.getValueAt(row, 3).toString();
        String sucChua = this.tblClr.getValueAt(row, 4).toString();
        String csvc = this.tblClr.getValueAt(row, 5).toString();
        String diaChi = this.tblClr.getValueAt(row, 6).toString();

//         ghi lên textfield
        this.txtID.setText(id);
        this.txtMa.setText(maPhong);
        this.txtTen.setText(tenPhong);
        this.cbbLoaiPhong.setSelectedItem(loaiPhong);
        this.txtSucChua.setText(sucChua);
        if (csvc.contains("Điều hòa")) {
            this.cbkDH.setSelected(true);
        }
        if (csvc.contains("Máy tính")) {
            this.cbkMT.setSelected(true);
        }
        if (csvc.contains("Máy chiếu")) {
            this.cbkMC.setSelected(true);
        }
        if (csvc.contains("Sách")) {
            this.cbkS.setSelected(true);
        }
        this.txtDiaChi.setText(diaChi);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCL;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRF;
    private javax.swing.JButton btnTKMa;
    private javax.swing.JButton btnTKSC;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JCheckBox cbkDH;
    private javax.swing.JCheckBox cbkMC;
    private javax.swing.JCheckBox cbkMT;
    private javax.swing.JCheckBox cbkS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClr;
    private javax.swing.JTextPane txtDiaChi;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSucChua;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
