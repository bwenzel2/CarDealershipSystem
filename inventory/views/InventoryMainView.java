package inventory.views;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import java.lang.StringBuilder;
import inventory.models.InventoryCarModel;
import inventory.views.InventoryCarRenderable;
import inventory.views.View;
import inventory.presenters.InventoryPresenter;

import javax.swing.*;
import java.awt.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

public class InventoryMainView extends javax.swing.JFrame implements View {

    private Set<InventoryCarRenderable> renderItems;
    private InventoryPresenter presenter;
    private MainView mainView;
    String foundVIN;
    private Set<InventoryCarModel> inventoryItems;
    public InventoryMainView(Set<InventoryCarModel> items, InventoryPresenter presenter) {
        inventoryItems = items;
        this.presenter = presenter;
    }

    public String render() {
        initComponents();
        this.setVisible(true);
        StringBuilder response = new StringBuilder(renderItems.size() + " CARS IN CURRENT INVENTORY:\nRESULT #\t VIN\n");

        int counter = 1;
        for (InventoryCarRenderable car : renderItems) {
            response.append(counter++ + "\t\t" + car.toString() + "\n");
        }
        return response.toString();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        View new_view = new MainView(inventoryItems, presenter);
        this.presenter.switchView(new_view);
        this.setVisible(false);
        this.dispose();
    }

    private void detailedViewButtonActionPerformed(ActionEvent e) {

        for (InventoryCarModel s: inventoryItems) {
            if(s.getVIN().equals(foundVIN)) {
                View new_view = new DetailView(presenter, inventoryItems, foundVIN);
                this.presenter.switchView(new_view);
            }

        }
    }

    private void deleterActionPerformed(ActionEvent e) {
        for (InventoryCarModel s: inventoryItems) {
            if (s.getVIN().equals(foundVIN)) {
                inventoryItems.remove(s);

                JOptionPane.showMessageDialog(null, "Car was removed from system");
                initComponents();
            }
        }
    }

    private javax.swing.JButton backButton;
    private javax.swing.JLabel inventoryLabel;
    private javax.swing.JList<String> inventoryList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newItemButton;


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hammad Hanif
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        DefaultListModel<String> model = new DefaultListModel<>();
        list1 = new JList<>(model);
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("Inventory Main View");
        contentPane.add(label1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, BorderLayout.WEST);

        //---- button1 ----
        button1.setText("Detailed View");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailedViewButtonActionPerformed(evt);
            }
        });
        contentPane.add(button1, BorderLayout.CENTER);

        //---- button2 ----
        button2.setText("Back");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        contentPane.add(button3, BorderLayout.SOUTH);
        button3.setText("Delete");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleterActionPerformed(evt);
            }
        });
        int count = 0;
        for (InventoryCarModel i : inventoryItems) {
            model.addElement(i.getVIN());
        }

        MouseListener m = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() >= 1) {
                    int index = list.locationToIndex(e.getPoint());
                    if(index >= 0) {
                        foundVIN = list.getModel().getElementAt(index).toString();
                    }
                }
            }
        };
        list1.addMouseListener(m);

        contentPane.add(button2, BorderLayout.EAST);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hammad Hanif
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}