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
import javax.swing.JTextField;


import store.Stock;
import store.Store;
import delivery.Manifest;

public class Manifest_Pannel extends JFrame {

	public Manifest_Pannel(String title)
	{
		super (title);
		//set layout
			setLayout(new BorderLayout());
				
			//maKE BUTTONS
			JTextArea inv = new JTextArea();
			JButton quit = new JButton("Back");
			
			
			String var = (Manifest.giveManifest()).toString();
			
			if (var == "")
			{
				inv.append("  ");
			}
			else 
			{
				inv.setText(Manifest.giveManifest());//shows the manifest
			}
			
				
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
	}

}
