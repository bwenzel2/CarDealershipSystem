package finance.views;

import finance.viewmodels.FinanceViewModel;
import java.lang.StringBuilder;
import inventory.views.View;
import java.util.*;
import inventory.models.CarModel;
import finance.models.FinanceCarModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Sun Apr 21 15:21:54 EDT 2019
 */



/**
 * @author Justin Lee Plassmeyer
 */
public class FinanceDetailView extends javax.swing.JFrame implements View {
    private FinanceViewModel view;
    private FinanceCarModel car;

    public FinanceDetailView(FinanceViewModel view, FinanceCarModel car) {
        this.view = view;
        this.car = car;
    }
    public String render() {
        initComponents();
        this.setVisible(true);
        car_vin.setText(car.getCar().getVIN());
        car_make.setText(car.getCar().getMake());
        car_price.setText(String.valueOf(car.getPrice()));
        car_model.setText(car.getCar().getModel());
        car_color.setText(car.getCar().getColor());
        amount_paid.setText(String.valueOf(car.getAmount_paid()));
        StringBuilder response = new StringBuilder("Financed Car\n");
        CarModel tempCar = car.getCar();
        response.append("Car Vin: " + tempCar.getVIN() +  "\nCar Make " + tempCar.getMake()+"\nCar Model "+ tempCar.getModel()+"\nCar Color "+ tempCar.getColor()+"\nCar Price "
        + car.getPrice()+"\nDown Payment "+car.getAmount_paid()+ "\n");
        return response.toString();
    }


    private void okButtonActionPerformed(ActionEvent e) {
        View new_view = new FinanceMainView(this.view);
        this.view.switchView(new_view);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Justin Lee Plassmeyer
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        car_vin = new JLabel();
        label3 = new JLabel();
        car_model = new JLabel();
        label4 = new JLabel();
        car_make = new JLabel();
        label5 = new JLabel();
        car_color = new JLabel();
        label6 = new JLabel();
        car_price = new JLabel();
        label7 = new JLabel();
        amount_paid = new JLabel();
        label1 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.01, 0.01, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.0, 0.0, 1.0E-4};

                //---- label2 ----
                label2.setText("Car Vin");
                label2.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- car_vin ----
                car_vin.setMaximumSize(new Dimension(450, 41));
                contentPanel.add(car_vin, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 25, 5, 10), 0, 0));

                //---- label3 ----
                label3.setText("Car Model");
                label3.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
                contentPanel.add(car_model, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- label4 ----
                label4.setText("Car Make");
                label4.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
                contentPanel.add(car_make, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- label5 ----
                label5.setText("Car Color");
                label5.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
                contentPanel.add(car_color, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- label6 ----
                label6.setText("Car's Price");
                label6.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label6, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
                contentPanel.add(car_price, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- label7 ----
                label7.setText("Amount Paid");
                label7.setFont(new Font("Segoe UI", Font.PLAIN, 45));
                contentPanel.add(label7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
                contentPanel.add(amount_paid, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //---- label1 ----
            label1.setText("Detailed View of Car Finances");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 40));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            dialogPane.add(label1, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("Back");
                okButton.setPreferredSize(new Dimension(250, 48));
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Justin Lee Plassmeyer
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JLabel car_vin;
    private JLabel label3;
    private JLabel car_model;
    private JLabel label4;
    private JLabel car_make;
    private JLabel label5;
    private JLabel car_color;
    private JLabel label6;
    private JLabel car_price;
    private JLabel label7;
    private JLabel amount_paid;
    private JLabel label1;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
