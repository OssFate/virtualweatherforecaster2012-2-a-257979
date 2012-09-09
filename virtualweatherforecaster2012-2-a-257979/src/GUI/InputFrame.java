/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Algorithms.*;

/**
 *
 * @author German
 */
public class InputFrame extends javax.swing.JFrame {

    private ArrayList input;
    private int fcastval;
    private int scale = 0;
    private final String SC_0 = "Celsius";
    private final String SC_1 = "Kelvin";
    private final String SC_2 = "Fahrenheit";
    
    
    public InputFrame() {
        setTitle("Forecast");
        input = new ArrayList<Double>();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fcvField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        dLastButton = new javax.swing.JButton();
        dAllButton = new javax.swing.JButton();
        fcastButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        scField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Weather Report");

        inputField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputField.setText("Input Weather Value");
        inputField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Values to Forecast");

        fcvField.setText("0");
        fcvField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcvFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        dLastButton.setText("Delete Last");
        dLastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dLastButtonActionPerformed(evt);
            }
        });

        dAllButton.setText("Delete All");
        dAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dAllButtonActionPerformed(evt);
            }
        });

        fcastButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fcastButton.setText("Forecast");
        fcastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcastButtonActionPerformed(evt);
            }
        });

        dataArea.setColumns(20);
        dataArea.setRows(5);
        dataArea.setText("Current Data:");
        jScrollPane1.setViewportView(dataArea);

        jButton1.setText("Toggle Scale");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        scField.setEditable(false);
        scField.setText("Celsius");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fcvField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scField)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dLastButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fcastButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fcvField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(dLastButton)
                    .addComponent(dAllButton)
                    .addComponent(scField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcastButton)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        inputField.getAccessibleContext().setAccessibleName("");
        inputField.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFieldActionPerformed

    private void fcvFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcvFieldActionPerformed

    }//GEN-LAST:event_fcvFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try{
            if(inputField.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Input field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            else{
                double aux = Double.parseDouble(inputField.getText());
                input.add(aux);
                printInputs();
                inputField.setText("");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Invalid Input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void dLastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dLastButtonActionPerformed
        
        if(input.isEmpty()) JOptionPane.showMessageDialog(rootPane, "Input data is empty.", "Error", JOptionPane.ERROR_MESSAGE);
        else    input.remove(input.size()-1);
        printInputs();
    }//GEN-LAST:event_dLastButtonActionPerformed

    private void dAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dAllButtonActionPerformed
        input.clear();
        printInputs();
    }//GEN-LAST:event_dAllButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(input.isEmpty()) JOptionPane.showMessageDialog(rootPane, "Current Data converted. This will cause decimal loss", "Warining", JOptionPane.WARNING_MESSAGE);
        switch (scale){
            case 0:
                scale = 1;
                scField.setText(SC_1);
                for (int i=0; i<input.size();i++){
                    double aux = (double) input.get(i) + 273.15;
                    input.set(i, aux);
                }
                printInputs();
                break;
            case 1:
                scale = 2;
                scField.setText(SC_2);
                for (int i=0; i<input.size();i++){
                    double aux = ((((double) input.get(i) * 9)/5)) - 459.67;
                    input.set(i, aux);
                }
                printInputs();
                break;
            case 2:
                scale = 0;
                scField.setText(SC_0);
                for (int i=0; i<input.size();i++){
                    double aux = (double) input.get(i);
                    aux = aux - 32;
                    aux = (aux * 5)/9;
                    input.set(i, aux);
                }
                printInputs();
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fcastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcastButtonActionPerformed
        try{
            fcastval = Integer.parseInt(fcvField.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Values to forecast field is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(fcastval == 0){
            JOptionPane.showMessageDialog(rootPane, "Values to forecast can't be 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(fcastval > input.size()){
            JOptionPane.showMessageDialog(rootPane, "Too little input values. " + fcastval+" or more needed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double odata[] = new double[input.size()];
        for (int i=0;i<input.size();i++){
            odata[i]=(double) input.get(i);
        }
        new OutputFrame(odata, fcastval);
        this.dispose();
        
    }//GEN-LAST:event_fcastButtonActionPerformed
    
    private void printInputs(){
        dataArea.setText("Current Data:");
        for (int i=0; i<input.size();i++)
            dataArea.append("\n      "+input.get(i));
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton dAllButton;
    private javax.swing.JButton dLastButton;
    private javax.swing.JTextArea dataArea;
    private javax.swing.JButton fcastButton;
    private javax.swing.JTextField fcvField;
    private javax.swing.JTextField inputField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField scField;
    // End of variables declaration//GEN-END:variables
}