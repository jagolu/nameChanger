/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechanger;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Javi
 */
public class Message extends javax.swing.JDialog {
    private NameChangerInterface nci;

    public Message(NameChanger nc, NameChangerInterface nci) {
        initComponents();
        this.getContentPane().setBackground( Color.white );
        this.nci = nci;
        this.jButton1.setVisible(false);
        this.jTextPane1.setText("Loading...");
        ArrayList<File> badFiles = nc.changeTheNames();
        if(badFiles==null){
            this.jTextPane1.setText("Fail!\nThe params are not right");
            this.jButton1.setVisible(true);
            this.jButton1.setBackground(Color.red);
        }
        else if(badFiles.isEmpty()){
            this.jTextPane1.setText("Done!");
            this.jButton1.setVisible(true);
            this.jButton1.setBackground(new java.awt.Color(204, 255, 204));
        }
        else{
            String text = "There is an error in the next files: \n";
            text+=badFiles.get(0).getAbsolutePath();
            for(int i=1;i<badFiles.size();i++){
                text=text+"\n"+badFiles.get(i).getAbsolutePath();
            }
            this.jButton1.setVisible(true);
            this.jButton1.setBackground(Color.red);
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
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextPane1.setEditable(false);
        jTextPane1.setToolTipText("");
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Aceptar");
        jButton1.setActionCommand("ok");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        nci.restart();
        this.setVisible(false);
        nci.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
