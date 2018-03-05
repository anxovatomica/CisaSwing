/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisa_impresores.swing;

import Exceptions.CisaExceptions;
import HPComu.HPComu;
import ImpresoraJordi.BrotherJordi;
import static ImpresoraJordi.BrotherJordi.*;
import java.io.IOException;

/**
 *
 * @author linusdufol
 */
public class BroJordi extends javax.swing.JDialog {

    /**
     * Creates new form BroJordi
     */
    public BroJordi(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        BrotherJordi brojordi = new BrotherJordi();
        brojordi(brojordi);
        BlackBar.setValue(per4);
        perc1.setText(String.valueOf(per4) + "%");
        CianBar.setValue(per);
        perc2.setText(String.valueOf(per) + "%");
        YellowBar.setValue(per3);
        perc4.setText(String.valueOf(per3) + "%");
        MagentaBar.setValue(per2);
        perc3.setText(String.valueOf(per2) + "%");
        
    }
private static void brojordi(BrotherJordi brojordi) throws IOException {
        try {
            brojordi.BrotherJordi();
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
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

        CianBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        MagentaBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        YellowBar = new javax.swing.JProgressBar();
        perc1 = new javax.swing.JLabel();
        perc2 = new javax.swing.JLabel();
        perc3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        perc4 = new javax.swing.JLabel();
        BlackBar = new javax.swing.JProgressBar();
        Torna = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("MAGENTA:");

        jLabel5.setText("GROC:");

        perc1.setText("%");

        perc2.setText("%");

        perc3.setText("%");

        jLabel2.setText("NEGRE:");

        perc4.setText("%");

        Torna.setText("Torna");
        Torna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TornaActionPerformed(evt);
            }
        });

        jLabel3.setText("CIAN:");

        jLabel1.setText("Brother Jordi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(YellowBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CianBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BlackBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MagentaBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(perc1)
                                .addComponent(perc4)
                                .addComponent(perc3)
                                .addComponent(perc2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(Torna)
                            .addGap(116, 116, 116)))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(BlackBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(perc1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CianBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(perc2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(MagentaBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(YellowBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(perc4)))
                        .addComponent(perc3))
                    .addGap(18, 18, 18)
                    .addComponent(Torna)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TornaActionPerformed
        dispose();
    }//GEN-LAST:event_TornaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BlackBar;
    private javax.swing.JProgressBar CianBar;
    private javax.swing.JProgressBar MagentaBar;
    private javax.swing.JButton Torna;
    private javax.swing.JProgressBar YellowBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel perc1;
    private javax.swing.JLabel perc2;
    private javax.swing.JLabel perc3;
    private javax.swing.JLabel perc4;
    // End of variables declaration//GEN-END:variables
}