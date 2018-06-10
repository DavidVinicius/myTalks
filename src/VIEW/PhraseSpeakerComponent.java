/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Services.Speaker;

/**
 *
 * @author David
 */
public class PhraseSpeakerComponent extends javax.swing.JPanel {

    /**
     * Creates new form PhraseSpeakerComponent
     */
    public PhraseSpeakerComponent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phraseLabel = new javax.swing.JLabel();
        translationLabel = new javax.swing.JLabel();
        iconSpeaker = new javax.swing.JLabel();

        setBackground(new java.awt.Color(206, 214, 224));

        phraseLabel.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        phraseLabel.setText("Phrase");

        translationLabel.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        translationLabel.setText("translation");

        iconSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/speaker.png"))); // NOI18N
        iconSpeaker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconSpeaker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconSpeakerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(translationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE))
                    .addComponent(phraseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(111, 111, 111)
                .addComponent(iconSpeaker, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(phraseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(translationLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(iconSpeaker, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iconSpeakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconSpeakerMouseClicked
        Speaker.speak(getPhrase());
    }//GEN-LAST:event_iconSpeakerMouseClicked
      
    public void setPhrase(String phrase)
    {
        this.phraseLabel.setText(phrase);
    }
    
    public String getPhrase()
    {
        return this.phraseLabel.getText();
    }
    
    public void setTranslation(String translation)
    {
        this.translationLabel.setText(translation);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconSpeaker;
    private javax.swing.JLabel phraseLabel;
    private javax.swing.JLabel translationLabel;
    // End of variables declaration//GEN-END:variables
}
