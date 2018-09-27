
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {

    public static final String newline = "\n";
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String GET_ORDER = "Get order";
    public static final String SAVE_ORDER = "Save Order";
    public static final String EXIT = "Exit";
    public static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER
            = "Non-California Order";
    public static final String OVERSEAS_ORDER = "Overseas Order";
    private JComboBox cmbOrderType;
    private JTextField txtOrderAmount, txtAdditionalTax,
            txtAdditionalSH, txtNumOrder;
    private JLabel lblOrderType, lblOrderAmount;
    private JLabel lblAdditionalTax, lblAdditionalSH;
    private JLabel lblTotal, lblTotalValue;
    private JLabel lblNumOrder;
    
    private OrderVisitor objVisitor;
    
    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();
        
        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
        
        txtOrderAmount = new JTextField(10);
        txtAdditionalTax = new JTextField(10);
        txtAdditionalSH = new JTextField(10);
        
        txtNumOrder = new JTextField(10);
        
        lblOrderType = new JLabel("Order Type:");
        lblOrderAmount = new JLabel("Order Amount:");
        lblAdditionalTax
                = new JLabel("Additional Tax(CA Orders Only):");
        lblAdditionalSH
                = new JLabel("Additional S & H(Overseas Orders Only):");
        
        lblTotal = new JLabel("Result:");
        lblTotalValue
                = new JLabel("Click Create or GetTotal Button");
        
        lblNumOrder = new JLabel("Edit Order Only");

        //Create the open button
        JButton getTotalButton
                = new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);
        JButton createOrderButton
                = new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);
        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        ButtonHandler objButtonHandler = new ButtonHandler(this);
        
        JButton getOrderButton = new JButton(OrderManager.GET_ORDER);
        JButton saveOrderButton = new JButton(OrderManager.SAVE_ORDER);
        
        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(new ButtonHandler());
        
        getOrderButton.addActionListener(objButtonHandler);
        saveOrderButton.addActionListener(objButtonHandler);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        
        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(getOrderButton);
        panel.add(saveOrderButton);
        panel.add(exitButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getOrderButton, gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 0;
        gridbag2.setConstraints(saveOrderButton, gbc2);
        gbc2.gridx = 4;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        
        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);
        buttonPanel.add(lblAdditionalTax);
        buttonPanel.add(txtAdditionalTax);
        buttonPanel.add(lblAdditionalSH);
        buttonPanel.add(txtAdditionalSH);
        buttonPanel.add(lblNumOrder);
        buttonPanel.add(txtNumOrder);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);
        
        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtAdditionalTax, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblNumOrder, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(txtNumOrder, gbc);
        
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gridbag.setConstraints(lblTotalValue, gbc);
        
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new OrderManager();
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
    
    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }
    
    public void setOrderAmount(String msg){
        txtOrderAmount.setText(msg);
    }
    
    public void setTax(String msg){
        txtAdditionalTax.setText(msg);
    }
    
    public void setSH(String msg){
        txtAdditionalSH.setText(msg);
    }
    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    public String getOrderAmount() {
        return txtOrderAmount.getText();
    }

    public String getTax() {
        return txtAdditionalTax.getText();
    }

    public String getSH() {
        return txtAdditionalSH.getText();
    }
    
    public String getNumOrder(){
        return txtNumOrder.getText();
    }
    
    public JComboBox getCmbOrderType(){
        return cmbOrderType;
    }
    
} // End of class OrderManager

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    int keyNum;
    AllOrders iterator = new AllOrders();
    Order retrivedOrder = null;

    public void actionPerformed(ActionEvent e) {
        //System.out.println();
        String totalResult = null;
        
        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.exit(1);
        }
        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
            retrivedOrder = null;

            //get input values
            String orderType = objOrderManager.getOrderType();
            String strOrderAmount = objOrderManager.getOrderAmount();
            String strTax = objOrderManager.getTax();
            String strSH = objOrderManager.getSH();
            
            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;
            
            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }
            if (strTax.trim().length() == 0) {
                strTax = "0.0";
            }
            if (strSH.trim().length() == 0) {
                strSH = "0.0";
            }
            
            dblOrderAmount = new Double(strOrderAmount).doubleValue();
            dblTax = new Double(strTax).doubleValue();
            dblSH = new Double(strSH).doubleValue();

            //Create the order
            Order newOrder = createOrder(orderType, dblOrderAmount, dblTax, dblSH);
            iterator.put(keyNum, newOrder);

            objOrderManager.setTotalValue(" Order " + keyNum + " Created Successfully");
            keyNum++;
        }
        
        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();
            visitor.setOrderTotal(0);
            System.out.println(iterator.getLiquidacion(visitor));
            totalResult = new Double(
                    visitor.getOrderTotal()).toString();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
        }
        if (e.getActionCommand().equals(OrderManager.GET_ORDER)){
            String numOrder = objOrderManager.getNumOrder();
            int intNumOrder = new Integer(numOrder);
            
            retrivedOrder = (Order) iterator.get(intNumOrder);
            objOrderManager.setOrderAmount(String.valueOf(retrivedOrder.getOrderAmount()));
            
            if(retrivedOrder.getClass().getName().equals("CaliforniaOrder")){
                objOrderManager.setTax(String.valueOf(retrivedOrder.getAdditionalAmount()));
            }
            if(retrivedOrder.getClass().getName().equals("OverseasOrder"))
                objOrderManager.setSH(String.valueOf(retrivedOrder.getAdditionalAmount()));
            
            String orderType = objOrderManager.getOrderType();
            objOrderManager.getCmbOrderType().setSelectedItem(orderType);
        }
        if (e.getActionCommand().equals(OrderManager.SAVE_ORDER)){
            
            String strOrderAmount = objOrderManager.getOrderAmount();
            String strTax = objOrderManager.getTax();
            String strSH = objOrderManager.getSH();
            
            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;
            
            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }
            if (strTax.trim().length() == 0) {
                strTax = "0.0";
            }
            if (strSH.trim().length() == 0) {
                strSH = "0.0";
            }
            
            dblOrderAmount = new Double(strOrderAmount).doubleValue();
            dblTax = new Double(strTax).doubleValue();
            dblSH = new Double(strSH).doubleValue();
            
            retrivedOrder.setOrderAmount(dblOrderAmount);
            
            if(retrivedOrder.getClass().getName().equals("CaliforniaOrder")){
                retrivedOrder.setAdditionalAmount(dblTax);
            }
            if(retrivedOrder.getClass().getName().equals("OverseasOrder")){
                retrivedOrder.setAdditionalAmount(dblSH);
            }  
        }
    }
    
    public Order createOrder(String orderType,
            double orderAmount, double tax, double SH) {
        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
            return new CaliforniaOrder(orderAmount, tax);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.NON_CA_ORDER)) {
            return new NonCaliforniaOrder(orderAmount);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.OVERSEAS_ORDER)) {
            return new OverseasOrder(orderAmount, SH);
        }
        return null;
    }
    
    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
        keyNum = 0;
    }
    
} // End of class ButtonHandler

