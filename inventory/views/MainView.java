package inventory.views;

import java.awt.event.ActionEvent;
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

public class MainView extends javax.swing.JFrame implements View {

	private Set<InventoryCarModel> renderItems;
	private InventoryPresenter presenter;

	public MainView(Set<InventoryCarModel> items, InventoryPresenter presenter) {
		renderItems = items;
		this.presenter = presenter;
		initComponents();
	}


	public String render() {

		this.setVisible(true);
		StringBuilder response = new StringBuilder(renderItems.size() + " CARS IN CURRENT INVENTORY:\nRESULT #\t VIN\n");

		int counter = 1;
		for (InventoryCarModel car : renderItems) {
			response.append(counter++ + "\t\t" + car.toString() + "\n");
		}
		return response.toString();
	}



	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO open the new item window here
		View new_view = new AddInventoryView(presenter);
		this.presenter.switchView(new_view);
	}

	private void inventoryViewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			View new_view = new InventoryMainView(renderItems, presenter);
			this.presenter.switchView(new_view);
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hammad Hanif
    private JLabel label1;
    private JButton addNew;
    private JButton inventoryView;
    private JButton button_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hammad Hanif
        label1 = new JLabel();
        addNew = new JButton();
        inventoryView = new JButton();
        button_back = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("Main View");
        contentPane.add(label1, BorderLayout.NORTH);

        //---- addNew ----
        addNew.setText("Add a New Car");
		addNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newItemButtonActionPerformed(evt);
			}
		});
        contentPane.add(addNew, BorderLayout.WEST);

        //---- inventoryView ----
        inventoryView.setText("View Inventory");
		inventoryView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				inventoryViewButtonActionPerformed(evt);
			}
		});
		contentPane.add(inventoryView, BorderLayout.EAST);

        //---- button_back ----
        button_back.setText("Back");
        button_back.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		backButtonActionPerformed(evt);
			}
		});
        contentPane.add(button_back, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
