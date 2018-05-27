package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import store.Stock;
import store.Store;
import store.Item;

public class Add_Item_Pannel extends JFrame {

	public Add_Item_Pannel(String title)
	{
		
		JButton addItem = new JButton("Add");
		
		JTextField Name = new JTextField(10);
		JTextField manufactureCost = new JTextField(10);
		JTextField retailPrice = new JTextField(10);
		JTextField reorderPoint = new JTextField(10);
		JTextField reorderAmount = new JTextField(10);
		
		JTextField quantity = new JTextField(10);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(addItem, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(Name, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(manufactureCost, gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		add(retailPrice, gc);
		
		gc.gridx = 4;
		gc.gridy = 1;
		add(reorderPoint, gc);
		
		gc.gridx = 5;
		gc.gridy = 1;
		add(reorderAmount, gc);
	/*
		gc.gridx = 6;
		gc.gridy = 1;
		add(quantity, gc);*/
		// TODO Auto-generated constructor stub
		
		Name.setText("name");
		manufactureCost.setText("manufacture cost");
		retailPrice.setText("retail price");
		reorderPoint.setText("reorder point");
		reorderAmount.setText("reorder amount");
		quantity.setText("quantity");
		
		
		addItem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) //add item then back to the main menu
			{
				try 
				{
					//make the new item
					Item thing = new Item(Name.getText(),Double.parseDouble(manufactureCost.getText()),Double.parseDouble(retailPrice.getText()),reorderPoint.getText(),Integer.parseInt(reorderAmount.getText()));
					Store.getInstance().getInventory().addItem(thing);
					
					setVisible(false);
					JFrame frame = new Inventory_Pannal("Inventory Infomation");
					frame.setSize(1000,1000);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
				catch (Exception e1)
				{
					
				}
				
				
				//Item item = new Item(Name.getText(),Integer.parseInt(quantity.getText()));//add a new item that only has quantity and its name
				//Stock.addItem();
				
				
				
			}
		});
	}
	
}
