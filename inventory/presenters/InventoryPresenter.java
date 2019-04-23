package inventory.presenters;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

import inventory.models.CarModel;
import inventory.models.InventoryCarModel;
import inventory.views.InventoryCarRenderable;
import inventory.views.MainView;
import inventory.views.View;
import mailing.brokers.MessageBroker;
import mailing.messages.Message;
import mailing.publishers.Publisher;


public class InventoryPresenter implements Publisher
{
	//the mailing list message broker
	private MessageBroker broker;
	String data_location = "CarsDatabase.csv";

	//the currently-selected view, defaults to the main view
	private View currentView;

	//the list of all cars currently in inventory
	Set<InventoryCarModel> inventoryItems;


	public InventoryPresenter(MessageBroker broker) {
		this.broker = broker;
		inventoryItems = loadInventoryItems();

		Set<InventoryCarRenderable> renderItems = new HashSet<InventoryCarRenderable>();
		for (InventoryCarModel car : inventoryItems) {
			renderItems.add(new InventoryCarRenderable(car.getVIN(), car.getMake(), car.getModel(), car.getColor(), car.getPrice()));
		}
		currentView = new MainView(inventoryItems, this);
	}

	public Set<InventoryCarModel> getInventoryItems() {
		return inventoryItems;
	}

	//replace the current view with the specified view
	public void switchView(View view) {
		this.currentView = view;
		renderView();
	}


	//publishes a message to the mailing list by pushing it to the message broker
	public void publish(MessageBroker broker, Message message) {
		broker.sendMessage(message);
	}


	//tells the currently-selected view to render
	private void renderView() {
		System.out.println(this.currentView.render());
	}


	//loads inventory from a source
	//TODO: add the ability to load from a file or something
	public Set<InventoryCarModel> loadInventoryItems() {
		Set<InventoryCarModel> items = new HashSet<InventoryCarModel>();
		try(BufferedReader br = new BufferedReader(new FileReader(this.data_location))) {
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null && line != "\n") {
				String[] values = line.split(",");
				if (values[0].equals("vin")) {
					continue;
				}
				else {
					InventoryCarModel Inventory = new InventoryCarModel(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
					items.add(Inventory);
				}
			}
		} catch (Exception e) {
			System.out.println("Error adding vehicle to inventory: " + e.getMessage());
		}
		return items;
	}


	public void addInventoryItem(String VIN, String make, String model, String color, int price) {
		try{
			InventoryCarModel inventoryCarModel = new InventoryCarModel(VIN, make, model, color, price);
			inventoryItems.add(inventoryCarModel);
			FileWriter writer = new FileWriter(data_location,true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("\n");
			bw.write(VIN);
			bw.write(",");
			bw.write(make);
			bw.write(",");
			bw.write(model);
			bw.write(",");
			bw.write(color);
			bw.write(",");
			bw.write(Integer.toString(price));
			bw.close();
			writer.close();
			System.out.println("hello");
		}
		catch (IOException e)
		{
			System.out.println("Sorry, but something was corupted with the information giving to adding car to inventory");
		}
	}


	public void updateInventoryItem(InventoryCarModel update_car) {
		for (InventoryCarModel s : inventoryItems) {
			if (s.getVIN().equals(update_car.getVIN())) {
				deleteInventoryItem(s);
				addInventoryItem(update_car.getVIN(), update_car.getMake(), update_car.getModel(), update_car.getColor(), update_car.getPrice());
			}
		}
	}


	public void deleteInventoryItem(InventoryCarModel removeCar) {
		try{
			this.inventoryItems.remove(removeCar);
		}
		catch (Exception e)
		{
			System.out.println("Sorry, but something was corupted with the information givin to remoFinancedCar");
		}
	}
}