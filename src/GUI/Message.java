/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import namechanger.NameChanger;

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
        this.acceptButton.setVisible(false);
        this.messageText.setText("Loading...");
        ArrayList<String> badFiles = nc.changeTheNames();
        if(badFiles==null){
            this.messageText.setText("Fail!\nThe params are not right");
            this.acceptButton.setVisible(true);
            this.acceptButton.setBackground(Color.red);
            this.messageText.setForeground(Color.red);
        }
        else if(badFiles.isEmpty()){
            this.messageText.setFont(new Font("Arial", 15, 52));
            this.messageText.setText("Done!");
            this.acceptButton.setVisible(true);
            this.acceptButton.setBackground(new java.awt.Color(204, 255, 204));
        }
        else{
            String text = "<html>There is an error in the next files: </br>";
            text+=badFiles.get(0);
            int max;
            if(badFiles.get(0).length()>38) max = badFiles.get(0).length();
            else max = 38;
            for(int i=1;i<badFiles.size();i++){
                String thisPart = badFiles.get(i);
                text=text+" </br> "+thisPart;
                if(thisPart.length()>max) max = thisPart.length();
            }
            text+="</html>";
            this.setSize((int)Math.ceil(243+((max-38)*6.5)), 81+((badFiles.size()-1)*28));
            this.messageText.setText(text);
            this.acceptButton.setVisible(true);
            this.acceptButton.setBackground(Color.red);
            this.messageText.setForeground(Color.red);
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

        acceptButton = new javax.swing.JButton();
        messageText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        acceptButton.setText("Aceptar");
        acceptButton.setActionCommand("ok");
        acceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptButtonMouseClicked(evt);
            }
        });

        messageText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageText.setMaximumSize(new java.awt.Dimension(2, 2));
        messageText.setMinimumSize(new java.awt.Dimension(2, 2));
        messageText.setName(""); // NOI18N
        messageText.setPreferredSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptButton, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(messageText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acceptButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseClicked
        nci.restart();
        this.setVisible(false);
        nci.setVisible(true);
    }//GEN-LAST:event_acceptButtonMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JLabel messageText;
    // End of variables declaration//GEN-END:variables
}
