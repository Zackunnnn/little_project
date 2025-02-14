/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SekolahCRUD;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author musa
 */
public class FormUtama extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Connection connection;
    /**
     * Creates new form FormUtama
     */
    public FormUtama() {
        initComponents();
        initTable();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNoInduk = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        textWali = new javax.swing.JTextField();
        textTelepon = new javax.swing.JTextField();
        textTanggal = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelSiswa = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Sekolah");

        jLabel1.setText("NIM");

        jLabel2.setText("Nama Mahasiswa");

        jLabel3.setText("Nama Wali");

        jLabel4.setText("Tanggal Lahir");

        jLabel5.setText("No. Telepon");

        jLabel6.setText("Alamat");

        textTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));
        textTanggal.setValue(new java.util.Date());

        textAlamat.setColumns(20);
        textAlamat.setRows(5);
        jScrollPane1.setViewportView(textAlamat);

        jLabel7.setText("Cari berdasarkan Nama Siswa");

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        tabelSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSiswaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelSiswa);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(textWali)
                                        .addComponent(textTelepon)
                                        .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnHapus, btnRefresh, btnSimpan, btnUbah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textWali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        //mengambil inputan dari form
        String noInduk = textNoInduk.getText();
        String nama = textNama.getText();
        String namaWali = textWali.getText();
        Date tanggalLahir = (Date) textTanggal.getValue();
        String telepon = textTelepon.getText();
        String alamat = textAlamat.getText();

        //masukkan data ke database
        connection = SekolahDatabase.getConnection();
        String query = "INSERT INTO siswa"
                + "(no_induk, nama, nama_wali, tanggal_lahir, telepon, alamat)"
                + "VALUES (?,?,?,?,?,?)";
        try {
          PreparedStatement statement= (PreparedStatement) connection.prepareStatement(query);
          
          statement.setString(1, noInduk);
          statement.setString(2, nama);
          statement.setString(3, namaWali);
          statement.setDate(4, new java.sql.Date(tanggalLahir.getTime()));
          statement.setString(5, telepon);
          statement.setString(6, alamat);
          
          statement.executeUpdate();
        } catch (SQLException ex){
          JOptionPane.showMessageDialog(this, "Terjadi error pada saat input data");
          
        } finally {
          loadData();
          reset();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        //method untuk menyeleksi data yg akan diubah
        int row = tabelSiswa.getSelectedRow();
        if (row==-1){
            return;
        }
        
        //mengambil inputan untuk data yg akan diubah
        String noInduk = (String) tableModel.getValueAt(row, 0);
        String nama = textNama.getText();
        String namaWali = textWali.getText();
        Date tanggalLahir = (Date) textTanggal.getValue();
        String telepon = textTelepon.getText();
        String alamat = textAlamat.getText();

        //lakukan perubahan data ke database
        connection = SekolahDatabase.getConnection();
        String query = "UPDATE siswa SET "
            + "nama=?,nama_wali=?,tanggal_lahir=?,telepon=?,alamat=? "
            + "WHERE no_induk=?";
        try {
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setString(1, nama);
            statement.setString(2, namaWali);
            statement.setDate(3, new java.sql.Date(tanggalLahir.getTime()));
            statement.setString(4, telepon);
            statement.setString(5, alamat);
            statement.setString(6, noInduk);
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Terjadi error pada saat update data");
        } finally {
            loadData();
            reset();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        //method seleksi data yg akan diubah
        int row = tabelSiswa.getSelectedRow();
        if (row==-1){
            return;
        }
        
        //mengambil inputan untuk data yg akan diubah
        String noInduk = (String) tableModel.getValueAt(row, 0);
        
        //lakukan perubahan data ke db
        connection = SekolahDatabase.getConnection();
        String query = "DELETE FROM siswa WHERE no_induk=?";
        
        try {
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setString(1, noInduk);
            statement.executeUpdate();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Terjadi error pada saat delete data");
        } finally {
          loadData();  
          reset();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
        // TODO add your handling code here:
        
        tableModel.getDataVector().removeAllElements();
        
        //pemberitahuan bahwa tabel telah kosong
        tableModel.fireTableDataChanged();
        
        try {
          String cari = textCari.getText();
          
          connection = SekolahDatabase.getConnection();
          String query = "SELECT * FROM siswa WHERE nama LIKE '%"+cari+"%'";
          //String query1 = "SELECT * FROM siswa WHERE nama_wali LIKE '%"+cari+"%'";
          
          Statement statement = (Statement) connection.createStatement();
          ResultSet resultSet = statement.executeQuery(query);
          //ResultSet resultSet1 = statement.executeQuery(query1);
          
          while (resultSet.next()){
              Object[] siswa = new Object[6];
              siswa[0] = resultSet.getString("no_induk");
              siswa[1] = resultSet.getString("nama");
              siswa[2] = resultSet.getString("nama_wali");
              siswa[3] = resultSet.getString("tanggal_lahir");
              siswa[4] = resultSet.getString("telepon");
              siswa[5] = resultSet.getString("alamat");
              tableModel.addRow(siswa);
          }
          
//          while (resultSet1.next()){
//              Object[] siswa = new Object[6];
//              siswa[0] = resultSet1.getString("no_induk");
//              siswa[1] = resultSet1.getString("nama");
//              siswa[2] = resultSet1.getString("nama_wali");
//              siswa[3] = resultSet1.getString("tanggal_lahir");
//              siswa[4] = resultSet1.getString("telepon");
//              siswa[5] = resultSet1.getString("alamat");
//              tableModel.addRow(siswa);
//          }
          
          resultSet.close(); //menutup result set
          //resultSet1.close(); //menutup result set
          statement.close(); //menutup statement
          
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());  
        }
    }//GEN-LAST:event_textCariKeyReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tabelSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSiswaMouseClicked
        // TODO add your handling code here:
        try {
            //mendapatkan baris yang terseleksi
            int row=tabelSiswa.getSelectedRow();
            if (row==-1) {
                return;
            }
        
            //mengambil data dan ditampung
            String noInduk = (String) tableModel.getValueAt(row, 0);
            String nama = (String) tableModel.getValueAt(row, 1);
            String namaWali = (String) tableModel.getValueAt(row, 2);
            String tanggal= (String) tableModel.getValueAt(row, 3);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date=sdf.parse(tanggal);
            String telepon = (String) tableModel.getValueAt(row, 4);
            String alamat = (String) tableModel.getValueAt(row, 5);

            //memberi data di setiap inputan
            textNoInduk.setText(noInduk);
            textNama.setText(nama);
            textWali.setText(namaWali);
            textTanggal.setValue(date);
            textTelepon.setText(telepon);
            textAlamat.setText(alamat);
        } catch (ParseException ex) {
            Logger.getLogger(FormUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tabelSiswaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelSiswa;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNoInduk;
    private javax.swing.JFormattedTextField textTanggal;
    private javax.swing.JTextField textTelepon;
    private javax.swing.JTextField textWali;
    // End of variables declaration//GEN-END:variables

    private void initTable(){
        tableModel = new DefaultTableModel();
        tabelSiswa.setModel(tableModel);
        tableModel.addColumn("No. Induk");
        tableModel.addColumn("Nama Siswa");
        tableModel.addColumn("Nama Wali");
        tableModel.addColumn("Tanggal Lahir");
        tableModel.addColumn("No. Telepon");
        tableModel.addColumn("Alamat");
    }
    
    private void loadData(){
        //menghapus seluruh data yg ada di tabel
        tableModel.getDataVector().removeAllElements();
        //pemberitahuan tabel telah kosong
        tableModel.fireTableDataChanged();
        
        try{
            connection = SekolahDatabase.getConnection();
            String query = "SELECT * FROM siswa";
            
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            //mengisi tabel dgn data hasil query
            while (resultSet.next()){
                Object[] siswa = new Object[6];
                siswa[0] = resultSet.getString("no_induk");
                siswa[1] = resultSet.getString("nama");
                siswa[2] = resultSet.getString("nama_wali");
                siswa[3] = resultSet.getString("tanggal_lahir");
                siswa[4] = resultSet.getString("telepon");
                siswa[5] = resultSet.getString("alamat");
                tableModel.addRow(siswa);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void reset(){
        textNoInduk.setText("");
        textCari.setText("");
        textNama.setText("");
        textTanggal.setValue(new java.util.Date());
        textTelepon.setText("");
        textWali.setText("");
        textAlamat.setText("");
    }
}