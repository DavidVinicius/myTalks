/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.PHRASEDAO.Phrase;
import MODEL.PHRASEDAO.PhraseDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Phrases extends javax.swing.JFrame {
    private Talks talkScreen;
    private int talkID;
    private List <PhraseComponent> phrasesComponent;
    /**
     * Creates new form Phrases
     */
    public Phrases() {
        initComponents();        
    }
    
    public Phrases(Talks talk, int id)
    {
        initComponents();
        phrasesComponent = new ArrayList<>();
        talkScreen       = talk;
        this.talkID      = id;
                        
        updatePhrases(this.talkID);
        this.setLocationRelativeTo(null);
    }
    
    public void setTalkName(String name)
    {
        this.talkName.setText(name);
    }
    
    public void setTalkId(int id)
    {
        this.talkID = id;
    }
    
    
    public void removeElement(PhraseComponent phraseComponent)
    {
        this.phrasesPanel.remove(phraseComponent);
        this.phrasesComponent.remove(phraseComponent);
        phrasesPanel.updateUI();
    }
    
    public void updatePhrases(int id)
    {            
      PhraseDAO phrase  = new PhraseDAO();
      Phrase[]  phrases = phrase.getPhrases(id);
      cleanPhrases();
            
      for(int i = 0; i < phrases.length; i++)
      {
          PhraseComponent tempPhrase = new PhraseComponent(this);          
          tempPhrase.setPhraseText(phrases[i].getPhrase());
          tempPhrase.setTranslationText(phrases[i].getTranslation());          
          tempPhrase.setPhraseID(phrases[i].getId());
          tempPhrase.setTalkID(talkID);
          
          this.phrasesComponent.add(tempPhrase);
          this.phrasesPanel.add(tempPhrase);
      }           
      
      this.phrasesPanel.updateUI();
      
    }
    
    private void cleanPhrases()
    {
        this.phrasesPanel.removeAll();
        this.phrasesComponent.removeAll(phrasesComponent);
        this.phrasesPanel.repaint();
        this.phrasesPanel.validate();
        this.phrasesPanel.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconNewPhrase = new javax.swing.JLabel();
        talkName = new javax.swing.JLabel();
        iconBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        phrasesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phrases");
        setBackground(new java.awt.Color(206, 214, 224));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(206, 214, 224));

        iconNewPhrase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconNewPhrase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add-button-inside-black-circle.png"))); // NOI18N
        iconNewPhrase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconNewPhrase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconNewPhraseMouseClicked(evt);
            }
        });

        talkName.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        talkName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        talkName.setText("NAME Talk");
        talkName.setToolTipText("Nome da conversa");

        iconBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/back (1).png"))); // NOI18N
        iconBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconBackMouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(206, 214, 224));
        jScrollPane1.setBorder(null);

        phrasesPanel.setBackground(new java.awt.Color(206, 214, 224));
        phrasesPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(phrasesPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iconBack)
                        .addGap(32, 32, 32)
                        .addComponent(talkName, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(iconNewPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconBack)
                    .addComponent(talkName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconNewPhrase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconNewPhraseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconNewPhraseMouseClicked
        // TODO add your handling code here:
        PhraseModal phraseModal = new PhraseModal(this);
        phraseModal.setTalkID(talkID);
        phraseModal.setVisible(true);
        phraseModal.setPhraseId(0);
    }//GEN-LAST:event_iconNewPhraseMouseClicked

    private void iconBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconBackMouseClicked
        // TODO add your handling code here:
        talkScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_iconBackMouseClicked
     
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
            java.util.logging.Logger.getLogger(Phrases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phrases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phrases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phrases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Phrases().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconBack;
    private javax.swing.JLabel iconNewPhrase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel phrasesPanel;
    private javax.swing.JLabel talkName;
    // End of variables declaration//GEN-END:variables
}
