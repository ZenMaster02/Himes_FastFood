//Author Name: Zen Himes
//Date: 2/25/2022
//Program Name: Himes_FastFood
//Purpose: To make a gui of a fast food menu where you can choose food and make special orders and it gives reciept with your total
package fastfood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class Himes_FastFood extends JFrame {
	// TODO Auto-generated method stub
	//initializes every checkbox, button, and special order field as well as adds the text area for the second window and sets the order list
	JCheckBox hb = new JCheckBox("Hamburger");
	JCheckBox cb = new JCheckBox("Cheeseburger");
	JCheckBox bcb= new JCheckBox("Bacon Cheeseburger");
	JCheckBox hd = new JCheckBox("Hot Dog");
	JCheckBox fr = new JCheckBox("Fries");
	JCheckBox sh = new JCheckBox("Shake");
	JCheckBox sd = new JCheckBox("Soda");
	JButton submitOrder = new JButton("Order");
	JButton exit = new JButton("Exit");
	JTextField special = new JTextField();
	JTextArea orderText = new JTextArea();
	JFrame frame = new JFrame("Menu");
	JFrame orderFrame = new JFrame("ORDER");
	
	

	public Himes_FastFood() {
		//sets where the checkboxes and buttons will be on frame
		hb.setBounds(100, 0, 100, 50);
		cb.setBounds(100, 50, 125, 50);
		bcb.setBounds(100,100, 125, 50);
		hd.setBounds(100, 150, 125, 50);
		fr.setBounds(100, 200, 125, 50);
		sh.setBounds(100, 250, 125, 50);
		sd.setBounds(100, 300, 125, 50);
		special.setBounds(100,350, 200, 25);
		submitOrder.setBounds(100,375, 100,50);
		exit.setBounds(200,375,100,50);
		orderText.setBounds(0, 0, 450, 450);
		//adding each checkbox, button, and the special orders to the frame
		frame.add(cb);
		frame.add(hb);
		frame.add(bcb);
		frame.add(hd);
		frame.add(fr);
		frame.add(sh);
		frame.add(sd);
		frame.add(special);
		frame.add(submitOrder);
		frame.add(exit);
		frame.setSize(450, 450);
		frame.setLayout(null);
		frame.setVisible(true);
		
		orderFrame.add(orderText); //sets up the other window that shows the orders
		orderFrame.setSize(450,450);
		orderFrame.setVisible(false);
		
		submitOrder.addActionListener(purchase -> { //if the checkbox associated with the item is checked when the user orders, it gets added to the order list
			List<menuItem> orders = new ArrayList<menuItem>();
			if(hb.isSelected()) {
				orders.add(new menuItem("Hamburger",3.59));
			}
			if(cb.isSelected()) {
				orders.add(new menuItem("Cheeseburger", 3.37));
			}
			
			if(bcb.isSelected()) {
				orders.add(new menuItem("Bacon Cheeseburger",4.35));
			}
			
			if(hd.isSelected()) {
				orders.add(new menuItem("Hot Dog", 1.95));
			}
			
			if(fr.isSelected()) {
				orders.add(new menuItem("Fries",2.79));
			}
			
			if(sh.isSelected()) {
				orders.add(new menuItem("Shake", 3.15));
			}
			
			if(sd.isSelected()) {
				orders.add(new menuItem("Soda", 1.86));
			}
			orderFrame.setVisible(true); //makes the order frame visible
			double total=0;
			for (menuItem item: orders) { //for every item on the orders list, it prints out the name and price and it adds the running total
				orderText.append(item.getName()+ "\t ($"+item.getPrice()+")\n");	
				total=total+item.getPrice();
			}
			DecimalFormat df = new DecimalFormat("###.##");
			orderText.append("\n \n Total:\t $"+ df.format(total)); //formats and prints the total
			String specialOrders= special.getText(); 
			orderText.append("\n ***"+specialOrders+ "***"); //prints the special orders
		}
		);
		exit.addActionListener(e -> {System.exit(0);}); //closes program
		}
	
	public static void main(String[] args) {
		Himes_FastFood menu = new Himes_FastFood(); //opens the frame
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if i close it, the code stops
	}
}
class menuItem{
	
	String name="null"; //each menu item has a name and a price
	double price= 0;
	public menuItem() {
		
	}
	public menuItem(String name, double price) {//standared getters and setters
		setName(name);
		setPrice(price);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double input) {
		this.price=input;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void printDetails(){ //this was to test if it was working
		System.out.println("Name:"+name);
		System.out.println("Salary:"+ price);
	}
}
