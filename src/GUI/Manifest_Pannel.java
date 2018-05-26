package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Manifest_Pannel extends JFrame {

	public Manifest_Pannel(String title)
	{
		super (title);
		
		
		
		//set layout
				setLayout(new BorderLayout());
				
				//maKE BUTTONS
				JTextArea inv = new JTextArea();
				JButton quit = new JButton("Back");
				
				//swing stuff to a container
				Container c = getContentPane();
				
				c.add(inv, BorderLayout.CENTER);
				c.add(quit, BorderLayout.SOUTH);
				
				inv.setEditable(false);//user cant edit the inventory here
				
				quit.addActionListener(new ActionListener()
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
				
/*
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		
		
		//create swing components
		
		Container menu_content = getContentPane();
		
		JButton view_Inventory = new JButton("View Inventory");
		JButton View_Sales_Log = new JButton("View Sales Log");
		//JButton view_Manifest = new JButton("View Manifest");
		JButton order_Stock = new JButton("Order Stock");
		
		JLabel Title = new JLabel("SuperMart Systems");
		
		
		
		//add swing components to frame
		
		
		
		
		
				
				
				
				//set layout
				setLayout(new GridBagLayout());
				
				GridBagConstraints gc = new GridBagConstraints();
		

				gc.gridx = 3;
				gc.gridy = 1;//top left?
				add(view_Inventory, gc);
		
				
				gc.gridx = 2;
				gc.gridy = 1;//top right?
				add(View_Sales_Log, gc);
				
				gc.gridx = 1;
				gc.gridy = 1;//top mid?
				add(order_Stock, gc);
				
				gc.gridx = 2;
				gc.gridy = 0;//top left?
				add(Title, gc);
				
	
				//add Functionality to buttons
						
				view_Inventory.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Inventory_Pannal("Inventory Infomation");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				View_Sales_Log.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Sales_Pannel("Sales Logs");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				
				
				order_Stock.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Stock_Order_Pannel("Order Stock");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
		*/
		
	}

}
