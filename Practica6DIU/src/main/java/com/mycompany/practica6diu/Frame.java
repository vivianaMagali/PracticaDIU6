
package com.mycompany.practica6diu;

import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Frame extends javax.swing.JFrame {
    JFileChooser fc = new JFileChooser();
    String ruta;
    FileNameExtensionFilter filter = null;
    BufferedImage image;
    String nombre;
    List<String> log;



    public Frame() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        initComponents();
        log = new ArrayList<String>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        umbral3 = new com.mycompany.practica6diu.Umbral();
        FileMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        closeFile = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        umbralParameter = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        about = new javax.swing.JMenu();
        history = new javax.swing.JMenuItem();
        team = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout umbral3Layout = new javax.swing.GroupLayout(umbral3);
        umbral3.setLayout(umbral3Layout);
        umbral3Layout.setHorizontalGroup(
            umbral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        umbral3Layout.setVerticalGroup(
            umbral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        closeFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        closeFile.setText("Close");
        closeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileActionPerformed(evt);
            }
        });
        jMenu1.add(closeFile);

        FileMenu.add(jMenu1);

        EditMenu.setText("Edit");

        umbralParameter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        umbralParameter.setText("Parameter Umbral");
        umbralParameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralParameterActionPerformed(evt);
            }
        });
        EditMenu.add(umbralParameter);

        FileMenu.add(EditMenu);

        HelpMenu.setText("Help");

        about.setText("About as...");

        history.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        about.add(history);

        team.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        team.setText("Team");
        team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamActionPerformed(evt);
            }
        });
        about.add(team);

        HelpMenu.add(about);

        FileMenu.add(HelpMenu);

        setJMenuBar(FileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(umbral3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(umbral3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        filter = new FileNameExtensionFilter("imagenes", "*.jpg","*.png", "jpg", "png");
        fc.addChoosableFileFilter(filter);
        int res = fc.showOpenDialog(null);
        if( res == JFileChooser.APPROVE_OPTION ){
            File file = fc.getSelectedFile();
            Mat mat = Imgcodecs.imread(file.getPath()); 
            image = (BufferedImage) HighGui.toBufferedImage(mat);
            umbral3.setMat(mat);
            umbral3.setBufferedImage(image);
            log.add("Se ha elegido una imagen y se ha mostrado");
        }
        if( res == JFileChooser.CANCEL_OPTION ){
            System.out.println(" se dio a cancelar");
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        
        int res = fc.showSaveDialog(null);
        
        if( res == JFileChooser.APPROVE_OPTION ){
            ruta = fc.getSelectedFile().getAbsolutePath();
            nombre = fc.getSelectedFile().getName();
            Imgcodecs.imwrite(ruta,umbral3.getMatSave());
            log.add("Se ha guardado una imagen");
        }
        if( res == JFileChooser.CANCEL_OPTION ){
            System.out.println(" se dio a cancelar");
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void umbralParameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralParameterActionPerformed
        String umbral = JOptionPane.showInputDialog(null, "Introduce the number for the desired threshold"); 
        System.out.println("la string es : "+ umbral);
        int numericUmbral = 0;
        try{
           numericUmbral = Integer.parseInt(umbral); 
           Mat mat = umbral3.umbralizar(umbral3.getMat(),numericUmbral);
           image = (BufferedImage) HighGui.toBufferedImage(mat);
           umbral3.setMatSave(mat);
           umbral3.setBufferedImage(image);
           log.add("Se ha umbralizado una imagen");
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"The data entered is not numeric");
        }
            
    }//GEN-LAST:event_umbralParameterActionPerformed

    private void closeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileActionPerformed
         int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure exit Program?","EXIT",JOptionPane.YES_NO_OPTION);
        if(confirmed == JOptionPane.YES_OPTION)
        {
            dispose();
        }
    }//GEN-LAST:event_closeFileActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
       String res = "";
        
        res += ""
                + "<html>"
                + "<h1>Record</h1>";
        
        for (String string : log) {
            res += "<p>"+string+"</p>";
        }
        
        res += "</html>";
        
       JOptionPane.showMessageDialog(this, res, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_historyActionPerformed

    private void teamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamActionPerformed
        
        String res = "<html><p>Date version: 2020-09-10</p>"
                + "<p>Version: 0.1</p>"
                + "<p><b>Viviana Magali Benitez Sosa & Alexander Álvarez Marques</b></p>"
                + "</html>";
        
        JOptionPane.showMessageDialog(this, res, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_teamActionPerformed

   
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuBar FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenu about;
    private javax.swing.JMenuItem closeFile;
    private javax.swing.JMenuItem history;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenuItem team;
    private com.mycompany.practica6diu.Umbral umbral3;
    private javax.swing.JMenuItem umbralParameter;
    // End of variables declaration//GEN-END:variables
}
