/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Controller.SessionManager;
import Model.Product;
import java.awt.CardLayout;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtProduct extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    private String username;
    
    public MgmtProduct(SQLite sqlite, int role) {
        initComponents();
        this.sqlite = sqlite;
        this.username = SessionManager.getInstance().getLoggedInUser();
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        
        if (role==2){
            addBtn.setVisible(false);
            editBtn.setVisible(false);
            deleteBtn.setVisible(false);    
        } else if (role==3||role==4) {
            purchaseBtn.setVisible(false);
        }
        
    }

    public void init(){
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }

        ArrayList<Product> products = sqlite.getProduct();
        for(int nCtr = 0; nCtr < products.size(); nCtr++){
            tableModel.addRow(new Object[]{
                products.get(nCtr).getName(), 
                products.get(nCtr).getStock(), 
                products.get(nCtr).getPrice()});
        }
    }
    
    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
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
        table = new javax.swing.JTable();
        purchaseBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        purchaseBtn.setBackground(new java.awt.Color(255, 255, 255));
        purchaseBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        purchaseBtn.setText("PURCHASE");
        purchaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn.setText("EDIT");
        editBtn.setToolTipText("");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(purchaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBtnActionPerformed
        if (!checkSessionAndRedirect()) return;
        
        if(table.getSelectedRow() >= 0){
            JTextField stockFld = new JTextField();
            designer(stockFld, "PRODUCT STOCK");

            Object[] message = {
                "How many " + tableModel.getValueAt(table.getSelectedRow(), 0) + " do you want to purchase?", stockFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "PURCHASE PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                System.out.println(stockFld.getText());
                String stockAvail = stockFld.getText();
                if (stockAvail.matches("\\d+") && stockAvail.length() <= 6) {
                    int numStock = Integer.parseInt(stockAvail);
                    try{
                        int numberAvail = (Integer) tableModel.getValueAt(table.getSelectedRow(), 1);
                    
                        if (numStock >= 1 && numStock <= numberAvail) {
                            JOptionPane.showMessageDialog(null, "Purchased " + numStock + " "+ tableModel.getValueAt(table.getSelectedRow(), 0), "Success", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println(username);
                            sqlite.addLogs("Purchase", username, "Purchased " + numStock +" " + tableModel.getValueAt(table.getSelectedRow(), 0), new Timestamp(new Date().getTime()).toString());
                            Product product = sqlite.getProduct(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                            int stocksInDb = product.getStock();
                            int updatedStocks = stocksInDb - numStock;

                            System.out.println(product.getName());
                            System.out.println(updatedStocks);
                            sqlite.updateProductStock(product.getName(), updatedStocks);
                            sqlite.addHistory(username, product.getName(), numStock, new Timestamp(new Date().getTime()).toString());
                        } else if (numStock <= 0) {
                            JOptionPane.showMessageDialog(null, "You must purchase at least one item. Please enter a valid quantity.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                        } else if (numStock > numberAvail) {
                            JOptionPane.showMessageDialog(null, "The quantity entered exceeds the available stock.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch(ClassCastException e) {
                        JOptionPane.showMessageDialog(null, "Request not available", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number (up to 100000).", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        init();
    }//GEN-LAST:event_purchaseBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (!checkSessionAndRedirect()) return;
        
        JTextField nameFld = new JTextField();
        JTextField stockFld = new JTextField();
        JTextField priceFld = new JTextField();

        designer(nameFld, "PRODUCT NAME");
        designer(stockFld, "PRODUCT STOCK");
        designer(priceFld, "PRODUCT PRICE");

        Object[] message = {
            "Insert New Product Details:", nameFld, stockFld, priceFld
        };

        int result = JOptionPane.showConfirmDialog(null, message, "ADD PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
        
        boolean validName = false;
        boolean validPrice = false;
        boolean validStock = false;

        if (result == JOptionPane.OK_OPTION) {
            String prodName = nameFld.getText();
            String prodStock = stockFld.getText();
            String prodPrice = priceFld.getText();
            
            String regex ="^[a-zA-Z0-9 ]{1,30}$";
            Pattern prodNamePattern = Pattern.compile(regex);
            Matcher prodNameMatcher = prodNamePattern.matcher(prodName);
            
            if(prodNameMatcher.matches()){
                validName = true;
                System.out.println("true prodname");
            } else {
                JOptionPane.showMessageDialog(null, "Input a valid name using alphanumeric characters at least 30 characters long.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            
            int numStock2 = 0;
            
            try {
                int numStock = Integer.parseInt(prodStock);

                if(numStock <= 200 && numStock >= 0){
                    numStock2 = numStock;
                    validStock = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Product stock is out of bounds", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input a valid stock format", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            
            double numPrice2 = 0;
            
            try {
                double numPrice = Double.parseDouble(prodPrice);
                
                if(numPrice <= 10000 && numPrice >= 0){
                    validPrice = true;
                    numPrice2 = numPrice;
                    System.out.println("True prod price");
                } else {
                    JOptionPane.showMessageDialog(null, "Product price is out of bounds", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input a valid price format", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            
            if (validStock && validPrice && validName) {
                sqlite.addProduct(prodName, numStock2, numPrice2);
                sqlite.addLogs("NOTICE", username, "Added a new product", new Timestamp(new Date().getTime()).toString());
                JOptionPane.showMessageDialog(null, "Product Added", "Product Added", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        init();
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (!checkSessionAndRedirect()) return;
        
        if(table.getSelectedRow() >= 0){
            JTextField nameFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
            JTextField stockFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 1) + "");
            JTextField priceFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 2) + "");

            designer(nameFld, "PRODUCT NAME");
            designer(stockFld, "PRODUCT STOCK");
            designer(priceFld, "PRODUCT PRICE");

            Object[] message = {
                "Edit Product Details:", nameFld, stockFld, priceFld
            };

            String currentName = nameFld.getText();
            String currentPrice = priceFld.getText();
            String currentStock = stockFld.getText();

            int result = JOptionPane.showConfirmDialog(null, message, "EDIT PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {

                String prodName = nameFld.getText();
                String prodStock = stockFld.getText();
                String prodPrice = priceFld.getText();

                boolean validName = false;
                boolean validStock = false;
                boolean validPrice = false;

                String regex ="^[a-zA-Z0-9 ]{1,30}$";
                Pattern prodNamePattern = Pattern.compile(regex);
                Matcher prodNameMatcher = prodNamePattern.matcher(prodName);
                
                if(prodNameMatcher.matches()){
                    validName = true;
                    System.out.println("true prodname");
                } else {
                    JOptionPane.showMessageDialog(null, "Input a valid name using alphanumeric characters at least 30 characters long.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }

                int numStock2 = 0;
                try{
                    int numStock = Integer.parseInt(prodStock);

                    if(numStock <= 200 && numStock >= 0){
                        numStock2 = numStock;
                        validStock = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product stock is out of bounds", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Input a valid stock format", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }

                double numPrice2 = 0;
                
                try {
                    double numPrice = Double.parseDouble(prodPrice);
                    if(numPrice <= 10000 && numPrice >= 0){
                        validPrice = true;
                        System.out.println("True prod price");
                        numPrice2 = numPrice;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product price is out of bounds", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Input a valid price format", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                
                String updatedLog = "Edited product from "  + currentName + " to " + prodName +" Stocks from " + currentStock + " to "+ numStock2 + " Price from " + currentPrice + " to " + numPrice2;
                if(validName && validPrice && validStock){
                    sqlite.addLogs("NOTICE", username, updatedLog , new Timestamp(new Date().getTime()).toString());
                    sqlite.updateProduct(currentName, prodName, numPrice2, numStock2);
                    JOptionPane.showMessageDialog(null, "Product Edited", "Product Edited", JOptionPane.INFORMATION_MESSAGE);
                }
                System.out.println("Previous name " + currentName);
                System.out.println("Current name " + prodName);
            }
        }
        init();
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (!checkSessionAndRedirect()) return;
        
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE PRODUCT", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                sqlite.deleteProductByName(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                sqlite.addLogs("NOTICE", username, "Deleted Product " + tableModel.getValueAt(table.getSelectedRow(), 0) , new Timestamp(new Date().getTime()).toString());
                JOptionPane.showMessageDialog(null, "Product Deleted", "Product Deleted", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        init();
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    private boolean checkSessionAndRedirect() {
        if (!SessionManager.getInstance().isSessionValid()) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

            if (topFrame instanceof Frame) {
                Frame frame = (Frame) topFrame;
                CardLayout cardLayout = frame.getFrameViewLayout();
                cardLayout.show(frame.getContainerPanel(), "loginPnl");
                return false;
            } else {
                System.err.println("Top Frame is not an instance of Frame");
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton purchaseBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
