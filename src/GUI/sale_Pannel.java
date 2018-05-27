package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import store.Stock;

public class sale_Pannel extends JFrame {

	public sale_Pannel(String title)
	{
		
		JButton saleItem = new JButton("Sell!");
		JTextField Name = new JTextField(10);
		JTextField quantity = new JTextField(10);
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		Name.setText("name");
		quantity.setText("quantity");
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(saleItem, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(Name, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(quantity, gc);
		// TODO Auto-generated constructor stub
		
		
		
		
		saleItem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) //preforms a sale then  back to the main menu
			{
				Store.Sale(Name.getText(),Integer.parseInt(quantity.getText()));
				
				setVisible(false);
				JFrame frame = new Inventory_Pannal("Inventory Infomation");
				frame.setSize(1000,1000);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
