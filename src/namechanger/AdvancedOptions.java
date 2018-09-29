/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechanger;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AdvancedOptions extends javax.swing.JDialog {
    NameChanger nc;
    NameChangerInterface nci;
    Help helpWindows;
    /**
     * Creates new form AdvancedOptions
     */
    public AdvancedOptions(NameChanger nc, NameChangerInterface nci) {
        initComponents();
        this.setAlwaysOnTop(true);
        this.nc = nc;
        this.nci= nci;
        this.helpWindows = new Help();
        helpWindows.setResizable(false);
        this.helpWindows.setVisible(false);
        this.getContentPane().setBackground( Color.white );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeSubDir = new javax.swing.JCheckBox();
        beginWithCapitalLetter = new javax.swing.JCheckBox();
        changeDirsName = new javax.swing.JCheckBox();
        changeFilesName = new javax.swing.JCheckBox();
        EraseAccentMarks = new javax.swing.JCheckBox();
        deleteLastSpaces = new javax.swing.JCheckBox();
        changeRootDirName = new javax.swing.JCheckBox();
        acceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Advanced options");
        setBackground(new java.awt.Color(255, 102, 51));
        setForeground(new java.awt.Color(255, 255, 255));

        changeSubDir.setSelected(true);
        changeSubDir.setText("Change the subs dirs");
        changeSubDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeSubDirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeSubDirMouseExited(evt);
            }
        });

        beginWithCapitalLetter.setSelected(true);
        beginWithCapitalLetter.setText("Begin with capital letters");
        beginWithCapitalLetter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                beginWithCapitalLetterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                beginWithCapitalLetterMouseExited(evt);
            }
        });

        changeDirsName.setSelected(true);
        changeDirsName.setText("Change dirs name");
        changeDirsName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeDirsNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeDirsNameMouseExited(evt);
            }
        });

        changeFilesName.setSelected(true);
        changeFilesName.setText("Change files name");
        changeFilesName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeFilesNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeFilesNameMouseExited(evt);
            }
        });

        EraseAccentMarks.setBackground(new java.awt.Color(255, 255, 255));
        EraseAccentMarks.setSelected(true);
        EraseAccentMarks.setText("Erase accent marks");
        EraseAccentMarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EraseAccentMarksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EraseAccentMarksMouseExited(evt);
            }
        });

        deleteLastSpaces.setSelected(true);
        deleteLastSpaces.setText("Delete the last spaces");
        deleteLastSpaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteLastSpacesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteLastSpacesMouseExited(evt);
            }
        });

        changeRootDirName.setSelected(true);
        changeRootDirName.setText("Change the root dir name");
        changeRootDirName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeRootDirNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeRootDirNameMouseExited(evt);
            }
        });

        acceptButton.setText("Aceptar");
        acceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeSubDir)
                    .addComponent(changeDirsName)
                    .addComponent(beginWithCapitalLetter)
                    .addComponent(changeRootDirName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeFilesName)
                    .addComponent(EraseAccentMarks)
                    .addComponent(deleteLastSpaces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeSubDir)
                    .addComponent(changeFilesName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginWithCapitalLetter)
                    .addComponent(EraseAccentMarks))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeDirsName)
                    .addComponent(deleteLastSpaces))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeRootDirName)
                    .addComponent(acceptButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseClicked

        this.nc.setEraseAccentMarks(this.EraseAccentMarks.isSelected());
        this.nc.setBeginWithMayus(this.beginWithCapitalLetter.isSelected());
        this.nc.setChangeDirsName(this.changeDirsName.isSelected());
        this.nc.setChangeFileName(this.changeFilesName.isSelected());
        this.nc.setChangeRootDir(this.changeRootDirName.isSelected());
        this.nc.setChangeSubDir(this.changeSubDir.isSelected());
        this.nc.setDeleteLastSpace(this.deleteLastSpaces.isSelected());
        this.setVisible(false);
        nci.setVisible(true);
    }//GEN-LAST:event_acceptButtonMouseClicked

    private void startHelpMessage(int x, int y, int type){
        this.helpWindows.setVisible(true);
        this.helpWindows.setLocation(x, y);
        this.helpWindows.setHelp(type);
    }
    
    private int getHelpWindowsX(){
        return this.getX()+86;
    }
    
    private int getHelpWindowsY(){
        return this.getY()-140;
    }
    
    private void changeSubDirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeSubDirMouseEntered
        //this.startHelpMessage(evt.getXOnScreen()-100, evt.getYOnScreen()-230,1);
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(), 1);
    }//GEN-LAST:event_changeSubDirMouseEntered

    private void changeSubDirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeSubDirMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_changeSubDirMouseExited

    private void changeFilesNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeFilesNameMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),2);
    }//GEN-LAST:event_changeFilesNameMouseEntered

    private void changeFilesNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeFilesNameMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_changeFilesNameMouseExited

    private void beginWithCapitalLetterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beginWithCapitalLetterMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),3);
    }//GEN-LAST:event_beginWithCapitalLetterMouseEntered

    private void beginWithCapitalLetterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beginWithCapitalLetterMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_beginWithCapitalLetterMouseExited

    private void EraseAccentMarksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EraseAccentMarksMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),4);
    }//GEN-LAST:event_EraseAccentMarksMouseEntered

    private void EraseAccentMarksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EraseAccentMarksMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_EraseAccentMarksMouseExited

    private void changeDirsNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeDirsNameMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),5);
    }//GEN-LAST:event_changeDirsNameMouseEntered

    private void changeDirsNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeDirsNameMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_changeDirsNameMouseExited

    private void deleteLastSpacesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLastSpacesMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),6);
    }//GEN-LAST:event_deleteLastSpacesMouseEntered

    private void deleteLastSpacesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLastSpacesMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_deleteLastSpacesMouseExited

    private void changeRootDirNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeRootDirNameMouseEntered
        this.startHelpMessage(this.getHelpWindowsX(), this.getHelpWindowsY(),5);
    }//GEN-LAST:event_changeRootDirNameMouseEntered

    private void changeRootDirNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeRootDirNameMouseExited
        this.helpWindows.setVisible(false);
    }//GEN-LAST:event_changeRootDirNameMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox EraseAccentMarks;
    private javax.swing.JButton acceptButton;
    private javax.swing.JCheckBox beginWithCapitalLetter;
    private javax.swing.JCheckBox changeDirsName;
    private javax.swing.JCheckBox changeFilesName;
    private javax.swing.JCheckBox changeRootDirName;
    private javax.swing.JCheckBox changeSubDir;
    private javax.swing.JCheckBox deleteLastSpaces;
    // End of variables declaration//GEN-END:variables
}
