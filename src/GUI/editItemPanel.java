package GUI;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import store.Stock;
import store.Store;
import store.Item;

public class editItemPanel extends JFrame {

	public editItemPanel(String string, String text) {

		//create swing components
		
		Container menu_content = getContentPane();
		
		JButton view_Inventory = new JButton("View Inventory");
		JButton View_Sales_Log = new JButton("View Sales Log");
		JButton view_Manifest = new JButton("View Manifest");
		//JButton order_Stock = new JButton("Order Stock");
		
		JLabel Title = new JLabel("SuperMart Systems");
		
		JLabel editedItem = new JLabel("You are editing: " + text);
		
		
		JButton incManufactureCost = new JButton("Increase Manufacture Cost");
		JButton decManufactureCost = new JButton("Decrease Manufacture Cost");
		JButton intSalesCost = new JButton("Increase Sales Cost");
		JButton decSalesCost = new JButton("Decrease Sales Cost");
		JButton incReorderAmm = new JButton("Increase Reorder Amount");
		JButton decReorderAmm = new JButton("Decrease Reorder Amount");
		JButton changeReorderLocation = new JButton("Change Reorder Location");
		
		JTextField reorderLocation = new JTextField(10);
		JTextField manufactureCost = new JTextField(10);
		JTextField salesCost = new JTextField(10);
		JTextField reorderAmm = new JTextField(10);
		
		
		
		//add swing components to frame
		
				
				//set layout
	
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 0.5;

		gc.gridx = 3;
		gc.gridy = 1;//top left?
		add(view_Inventory, gc);

		
		gc.gridx = 2;
		gc.gridy = 1;//top right?
		add(View_Sales_Log, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;//top mid?
		add(view_Manifest, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;//top left?
		add(Title, gc);
		
		
		
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(incManufactureCost, gc);
		
		gc.gridx = 2;
		gc.gridy = 4;
		add(manufactureCost, gc);
		
		gc.gridx = 3;
		gc.gridy = 4;
		add(decManufactureCost, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(intSalesCost, gc);
		
		gc.gridx = 2;
		gc.gridy = 5;
		add(salesCost, gc);
		
		gc.gridx = 3;
		gc.gridy = 5;
		add(decSalesCost, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(incReorderAmm, gc);
		
		gc.gridx = 2;
		gc.gridy = 6;
		add(reorderAmm, gc);
		
		gc.gridx = 3;
		gc.gridy = 6;
		add(decReorderAmm, gc);
		
		gc.gridx = 2;
		gc.gridy = 7;
		add(reorderLocation, gc);
		
		gc.gridx = 3;
		gc.gridy = 7;
		add(changeReorderLocation, gc);
		
		
		gc.gridx = 2;
		gc.gridy = 8;
		add(editedItem, gc);
		
	
				//add Functionality to buttons
						
				view_Inventory.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Inventory_Pannal("Inventory Infomation");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				View_Sales_Log.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Sales_Pannel("Sales Logs");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				view_Manifest.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Manifest_Pannel("Manifest");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				
				
				//Functionality************************************************
				
				
				incManufactureCost.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.increaseManufactureCost(Integer.parseInt(manufactureCost.getText()));
					}
				});
				
				decManufactureCost.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.decreaseManufactureCost(Integer.parseInt(manufactureCost.getText()));
					}
				});
				
				
				
				
				intSalesCost.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.increaseRetailPrice(Integer.parseInt(salesCost.getText()));
					}
				});
				
				decSalesCost.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.decreaseRetailPrice(Integer.parseInt(salesCost.getText()));
					}
				});
				
				
				
				
				
				incReorderAmm.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.increaseReorderAmount(Integer.parseInt(reorderAmm.getText()));
					}
				});
				
				decReorderAmm.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.decreaseReorderAmount(Integer.parseInt(reorderAmm.getText()));
					}
				});
				
				
				
				
				
				changeReorderLocation.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						Item.changeReorderPoint(reorderLocation.getText());
					}
				});
				
				
	}

}
