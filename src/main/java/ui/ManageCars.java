/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.UberCar;

/**
 *
 * @author Trisha
 */
public class ManageCars extends javax.swing.JFrame {

    transient ArrayList<UberCar> uberCars;
    transient String fileName;
    DefaultTableModel model;

    /**
     * Creates new form ManageCars
     */
    public ManageCars() {
        initComponents();
        uberCars = new ArrayList<UberCar>();
        fileName = "";
        model = (DefaultTableModel) manageTable.getModel();
        populateArrayList();
        insertDataInTable();
    }

    public void populateArrayList() {
        try {
            FileInputStream file = new FileInputStream("UberCar.dat");
            ObjectInputStream ipfile = new ObjectInputStream(file);

            boolean eof = false;
            while (!eof) {
                try {
                    uberCars.add((UberCar) ipfile.readObject());
                } catch (EOFException eoe) {
                    eof = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            ipfile.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }

    }

    public void saveCarFile() {
        try {

            FileOutputStream file = new FileOutputStream("UberCar.dat");
            ObjectOutputStream otFile = new ObjectOutputStream(file);
            //JOptionPane.showMessageDialog(null, uberCars.size());
            for (int i = 0; i < uberCars.size(); i++) {
                otFile.writeObject(uberCars.get(i));
            }
            otFile.close();
            JOptionPane.showMessageDialog(null, "Data saved Successfully");
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insertDataInTable() {
        for (UberCar car : uberCars) {
            model.insertRow(model.getRowCount(), new Object[]{car.getEngineNo(), car.getLicenseplate(), car.getManufacturer(), car.getNumberOfSeat(), car.getModelNumber(), car.getUberSerialNumber(), car.getLocation()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        manageTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        modelNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        manufacturer = new javax.swing.JTextField();
        engineNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numberOfSeat = new javax.swing.JTextField();
        uberSerialNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        available = new java.awt.Checkbox();
        jLabel5 = new javax.swing.JLabel();
        licensePlate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        location = new javax.swing.JComboBox<>();
        manufacYear = new javax.swing.JTextField();
        editSave = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1300, 600));

        manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Engine Number", "License Plate", "Manufacturer", "Number of seats", "Model Number", "Uber Serial Number", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manageTable);

        jButton1.setText("View & Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        modelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelNumberActionPerformed(evt);
            }
        });

        jLabel7.setText("Manufacturer :");

        jLabel2.setText("Engine Number :");

        manufacturer.setEditable(false);

        engineNo.setEditable(false);

        jLabel8.setText("Manufacturing Year :");

        jLabel3.setText("Number of seats :");

        jLabel9.setText("Uber Serial Number :");

        uberSerialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uberSerialNumberActionPerformed(evt);
            }
        });

        jLabel4.setText("Maintenance Expiry Date :");

        available.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        available.setLabel("Available");

        jLabel5.setText("License Plate :");

        jLabel6.setText("Model Number :");

        jLabel10.setText("Car Location: ");

        location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston             ", "Worcester          ", "Springfield        ", "Cambridge          ", "Lowell             ", "Brockton           ", "New                ", "Quincy             ", "Lynn               ", "Fall               ", "Newton             ", "Somerville         ", "Lawrence           ", "Framingham         ", "Haverhill          ", "Waltham            ", "Malden             ", "Brookline          ", "Weymouth           ", "Taunton            ", "Medford            ", "Chicopee           ", "Peabody            ", "Revere             ", "Methuen            ", "Everett            ", "Attleboro          ", "Arlington          ", "Barnstable         ", "Salem              ", "Beverly            ", "Leominster         ", "Pittsfield         ", "Westfield          ", "Fitchburg          ", "Woburn             ", "Holyoke            ", "Marlborough        ", "Chelsea            ", "Braintree          ", "Franklin           ", "Watertown          ", "Randolph           ", "Lexington          ", "Needham            ", "Gloucester         ", "Norwood            ", "Wellesley          ", "Agawam             ", "Saugus             ", "Bridgewater        ", "West               ", "Northampton        ", "Melrose            ", "Burlington         ", "Danvers            ", "Milton             ", "Wakefield          ", "Belmont            ", "Milford            ", "Dedham             ", "Reading            ", "Wilmington         ", "Stoneham           ", "Winchester         ", "Gardner            ", "Marblehead         ", "Amherst            ", "Newburyport        ", "Winthrop           ", "Somerset           ", "Amesbury           ", "Greenfield         ", "Southbridge        ", "Abington           ", "Longmeadow         ", "Easthampton        ", "Hudson             ", "Swampscott         ", "Lynnfield          ", "North              ", "Palmer             ", "Webster            ", "South              ", "Holbrook           ", "Maynard            ", "Hull               ", "Andover            " }));

        manufacYear.setEditable(false);
        manufacYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacYearActionPerformed(evt);
            }
        });

        editSave.setText("save");
        editSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSaveActionPerformed(evt);
            }
        });

        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("List Of Cars:");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(engineNo, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(numberOfSeat))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(licensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel10))
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(modelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                                    .addComponent(location, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(258, 258, 258)
                                        .addComponent(jButton1)
                                        .addGap(70, 70, 70)
                                        .addComponent(editSave)))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(manufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(uberSerialNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(manufacYear))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(available, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(engineNo)
                    .addComponent(jLabel5)
                    .addComponent(licensePlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numberOfSeat)
                    .addComponent(jLabel6)
                    .addComponent(modelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(manufacYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uberSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(133, 133, 133))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int rowNumner = manageTable.getSelectedRow();
        UberCar car = uberCars.get(rowNumner);
        this.engineNo.setText(car.getEngineNo() + "");
        this.licensePlate.setText(car.getLicenseplate() + "");
        this.manufacturer.setText(car.getManufacturer() + "");
        this.manufacYear.setText(car.getManufactureYear() + "");
        this.numberOfSeat.setText(car.getNumberOfSeat() + "");
        this.modelNumber.setText(car.getModelNumber() + "");
        this.jDateChooser1.setDate(car.getMaintenanceExpDate());
        if (car.getAvailability()) {
            this.available.setState(Boolean.TRUE);
        } else {
            this.available.setState(Boolean.FALSE);
        }
        this.uberSerialNumber.setText(car.getUberSerialNumber() + "");
//Calendar cal = Calendar.getInstance();
//cal.setTimeInMillis(car.getCatlogUpdateDatetime()+"");
//this.catlogUpdateDatetime.setText(car.getCatlogUpdateDatetime()+"");
//if(car.getLocation().equals(""))
        if (!car.getLocation().isEmpty()) {
            this.location.setSelectedItem(car.getLocation());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void modelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelNumberActionPerformed

    private void uberSerialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uberSerialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uberSerialNumberActionPerformed

    private void manufacYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacYearActionPerformed

    private synchronized void deleteRecord(String engineNo) {
        int getIndexOfCar = 0;
        boolean engineNum = false;
        for (int i = 0; i < uberCars.size(); i++) {
            if (uberCars.get(i).getEngineNo().trim().equals(engineNo)) {
                getIndexOfCar = i;
                engineNum = true;
            }
        }
        if (engineNum == true) {
            uberCars.remove(getIndexOfCar);
        }
    }

    private void editSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSaveActionPerformed
        // TODO add your handling code here:
        int rowNumner = manageTable.getSelectedRow();
        UberCar car = uberCars.get(rowNumner);
        String manufactureYear = car.getManufactureYear();

//Null and data type validation Start
        if (!(this.engineNo.getText().trim()).isEmpty()) {
            try {
                Integer.parseInt((this.engineNo.getText().trim()));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Engine Number : Enter Numbers only");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Engine Number");
            return;
        }

        if ((this.licensePlate.getText().trim()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter License Plate");
            return;
        }

        if ((this.manufacturer.getText().trim()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Manufacturer");
            return;
        }

        if (!(this.numberOfSeat.getText().trim()).isEmpty()) {
            try {
                Integer.parseInt((this.numberOfSeat.getText().trim()));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Number of Seats : Enter Numbers only");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Number of Seats");
            return;
        }

        if (!(this.modelNumber.getText().trim()).isEmpty()) {
            try {
                Integer.parseInt((this.modelNumber.getText().trim()));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Model Number : Enter Numbers only");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Model Number");
            return;
        }

        if ((this.jDateChooser1.getDate().toString()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter License Plate");
            return;
        }

        if ((this.uberSerialNumber.getText().trim()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter License Plate");
            return;
        }
        //Null and data type validation End

        //Uniqueness Validation Start
        if (!(Integer.parseInt(this.uberSerialNumber.getText().trim()) == (car.getUberSerialNumber()))) {
            for (UberCar tempCar : uberCars) {
                if (this.uberSerialNumber.getText().trim().equalsIgnoreCase(tempCar.getEngineNo()) || this.uberSerialNumber.getText().trim() == (tempCar.getEngineNo())) {
                    JOptionPane.showMessageDialog(null, "Enter Unique Uber Serial Number.");
                    return;
                }
            }
        }

        //Uniqueness Validation End
//remove entry from file
        deleteRecord(this.engineNo.getText().trim());

        //uberCars.remove(manageTable.getSelectedRow());
//save data as a new record in file on Edit-Save
        String engineNo = this.engineNo.getText();
        String licenseplate = this.licensePlate.getText();
        String manufacturer = this.manufacturer.getText();
        int numberOfSeat = Integer.parseInt(this.numberOfSeat.getText());
        int modelNumber = Integer.parseInt(this.modelNumber.getText());
        Date maintenanceExpDate = this.jDateChooser1.getDate();
        Boolean availability = this.available.getState();
        int uberSerialNo = Integer.parseInt(this.uberSerialNumber.getText());
        String location = this.location.getSelectedItem() + "";

        if (!(this.engineNo.getText().trim()).isEmpty()) {
            try {
                Integer.parseInt((this.engineNo.getText().trim()));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Engine Number : Enter Numbers only");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Engine Number");
            return;
        }

        if ((this.manufacturer.getText().trim()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Manufacturer");
            return;
        }

        if (this.jDateChooser1.getDate().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Maintenance Expiry Date");
            return;
        }

        UberCar uberCar = new UberCar(engineNo, licenseplate, manufacturer, manufactureYear, numberOfSeat, modelNumber, maintenanceExpDate, availability, uberSerialNo, (System.currentTimeMillis()) + "", location);
        uberCars.add(uberCar);
        saveCarFile();
    }//GEN-LAST:event_editSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int rowNumner = manageTable.getSelectedRow();
        UberCar car = uberCars.get(rowNumner);
        deleteRecord(car.getEngineNo());
        model.setRowCount(0);
        insertDataInTable();
        saveCarFile();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox available;
    private javax.swing.JButton editSave;
    private javax.swing.JTextField engineNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField licensePlate;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JTable manageTable;
    private javax.swing.JTextField manufacYear;
    private javax.swing.JTextField manufacturer;
    private javax.swing.JTextField modelNumber;
    private javax.swing.JTextField numberOfSeat;
    private javax.swing.JTextField uberSerialNumber;
    // End of variables declaration//GEN-END:variables
}
