package inventory.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Set;
import javax.swing.border.*;
import inventory.models.InventoryCarModel;
import inventory.presenters.InventoryPresenter;

public class DetailView extends javax.swing.JFrame implements View {
    private InventoryPresenter mainview;
    private Set<InventoryCarModel> carModels;
    String foundVIN;

    public DetailView(InventoryPresenter view, Set<InventoryCarModel> carModels, String foundVIN) {
        mainview = view;
        this.carModels = carModels;
        this.foundVIN = foundVIN;
        initComponents();
        System.out.println("Im here");
    }

    public String render()
    {
        initComponents();
        this.setVisible(true);
        StringBuilder response = new StringBuilder("Car in inventory\n");
        for (InventoryCarModel i : carModels) {
            if (i.getVIN().equals(foundVIN)) {
                response.append("Car Vin: " + i.getVIN() +  "\nCar Make " + i.getMake()+"\nCar Model "+ i.getModel()+"\nCar Color "+ i.getColor()+"\nCar Price "
                        + i.getPrice());
            }
        }
        return response.toString();
    }

    private void button_backActionPerformed(ActionEvent e) {
        View new_view = new InventoryMainView(carModels, mainview);
        this.mainview.switchView(new_view);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hammad Hanif
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        vin = new JTextPane();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        make = new JTextPane();
        label6 = new JLabel();
        scrollPane3 = new JScrollPane();
        model = new JTextPane();
        label8 = new JLabel();
        scrollPane4 = new JScrollPane();
        color = new JTextPane();
        label9 = new JLabel();
        scrollPane5 = new JScrollPane();
        price = new JTextPane();
        button_back = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("Detailed View");
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("VIN");
            panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(vin);
            }
            panel1.add(scrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label4 ----
            label4.setText("Make");
            panel1.add(label4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(make);
            }
            panel1.add(scrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label6 ----
            label6.setText("Model");
            panel1.add(label6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(model);
            }
            panel1.add(scrollPane3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label8 ----
            label8.setText("Color");
            panel1.add(label8, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(color);
            }
            panel1.add(scrollPane4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label9 ----
            label9.setText("Price");
            panel1.add(label9, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane5 ========
            {
                scrollPane5.setViewportView(price);
            }
            panel1.add(scrollPane5, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- button_back ----
            button_back.setText("Back");
            button_back.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    button_backActionPerformed(evt);
                }
            });
            panel1.add(button_back, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        for (InventoryCarModel i : carModels) {
            if (i.getVIN().equals(foundVIN)) {
                vin.setText(i.getVIN());
                make.setText(i.getMake());
                model.setText(i.getModel());
                color.setText(i.getColor());
                price.setText(Integer.toString(i.getPrice()));
            } else {
                System.out.println("VIN number not found in inventory");
            }
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hammad Hanif
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextPane vin;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextPane make;
    private JLabel label6;
    private JScrollPane scrollPane3;
    private JTextPane model;
    private JLabel label8;
    private JScrollPane scrollPane4;
    private JTextPane color;
    private JLabel label9;
    private JScrollPane scrollPane5;
    private JTextPane price;
    private JButton button_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}