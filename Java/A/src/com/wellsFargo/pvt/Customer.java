package com.wellsFargo.pvt;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Customer extends JFrame
{
//Variables of labels
	JLabel Heading;
	JLabel labelCustNo;
	JLabel labelCustName;
	JLabel labelCustSex;
	JLabel labelCustAge;
	//Variables for data entry controls
	JTextField textCustNo;
	JTextField textCustName;
	JComboBox comboCustSex;
	JTextField textCustAge;
	
	Customer() {
		
	super ( "Customer" ) ;
	Container con;
	con = this.getContentPane();
	con.setLayout(new FlowLayout());
	labelCustNo 	= new JLabel("Customer Number");
	labelCustName 	= new JLabel("Name");
	labelCustSex 	= new JLabel("Sex");
	labelCustAge 	= new JLabel("Age");
//Initializing textfield
	textCustNo 		= new JTextField(20);
	textCustName 	= new JTextField(25);
	textCustAge 	= new JTextField(2);
	String Sex[] 	= { "Male", "Female"};
	comboCustSex 	= new JComboBox(Sex);
	//Adding controls for Customer Number
	con.add (labelCustNo) ;
	con.add ( textCustNo ) ;
	//Adding controls for Customer Name
	con .add ( labelCustName ) ;
	con .add ( textCustName ) ;
	//Adding controls for Customer Sex
	con .add ( labelCustSex ) ;
	con . add ( comboCustSex ) ;
	//Adding controls for Customer Age
	con .add( labelCustAge ) ;
	con .add( textCustAge ) ;
//close the program when the close button is c l i c k e d
	setDefaultCloseOperation ( EXIT_ON_CLOSE ) ;
	setSize ( 350 , 250 ) ;	
	show();
}
}
