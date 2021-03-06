/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.PHRASEDAO.PhraseDAO;
import Services.Transaction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class PhraseComponent extends javax.swing.JPanel {
    Phrases phrasesScreen;
    private int ID;
    private int talkID;
   
    PhraseDAO phraseDAO;
    /**
     * Creates new form PhraseComponent
     */
    public PhraseComponent(Phrases phrasesScreen) {
        initComponents();
        this.phrasesScreen = phrasesScreen;
        phraseDAO = new PhraseDAO();
    }
    
    public PhraseComponent() {
        initComponents();        
        phraseDAO = new PhraseDAO();
    }
    
    public void setPhraseText(String text)
    {
        this.phrase.setText(text);
    }
    
    public String getPhraseText()
    {
        return this.phrase.getText();
    }
    
    public void setTranslationText(String text)
    {
        this.translation.setText(text);
    }
    
    public String getTranslationText()
    {
        return this.translation.getText();
    }
    
    public void setPhrasesScreen(Phrases p)
    {
        this.phrasesScreen = p;
    }
    
    public void setPhraseID(int ID)
    {
        this.ID = ID;
    }
    
    public int getTalkID() {
        return talkID;
    }

    public void setTalkID(int talkID) {
        this.talkID = talkID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phrase = new javax.swing.JLabel();
        translation = new javax.swing.JLabel();
        iconEdit = new javax.swing.JLabel();
        iconDelete = new javax.swing.JLabel();

        setBackground(new java.awt.Color(206, 214, 224));

        phrase.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        phrase.setText("Phrase");

        translation.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        translation.setText("Translation");

        iconEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/tools.png"))); // NOI18N
        iconEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconEditMouseClicked(evt);
            }
        });

        iconDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/remove.png"))); // NOI18N
        iconDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phrase)
                    .addComponent(translation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(iconEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconDelete)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(phrase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(translation)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconDelete)
                    .addComponent(iconEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iconEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconEditMouseClicked
        // TODO add your handling code here:
        PhraseModal phraseModal = new PhraseModal(this.phrasesScreen);        
        phraseModal.setTalkID(this.getTalkID());        
        phraseModal.setPhraseTextField(this.getPhraseText());
        phraseModal.setTranslationTextField(this.getTranslationText());
        phraseModal.setVisible(true);
        phraseModal.setPhraseId(this.ID);
    }//GEN-LAST:event_iconEditMouseClicked

    private void iconDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconDeleteMouseClicked
                
        if(phraseDAO.deletePhrase(this.ID))
        {
            phrasesScreen.removeElement(this);
        }        
        
    }//GEN-LAST:event_iconDeleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconDelete;
    private javax.swing.JLabel iconEdit;
    private javax.swing.JLabel phrase;
    private javax.swing.JLabel translation;
    // End of variables declaration//GEN-END:variables
}
