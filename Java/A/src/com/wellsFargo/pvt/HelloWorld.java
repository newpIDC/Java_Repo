package com.wellsFargo.pvt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class HelloWorld extends JFrame
{
	public HelloWorld( String titleText )
	{
		super( titleText );
		addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				HelloWorld . this . dispose ( ) ;
				System.exit( 0 );
			}
		} ) ;

		JLabel greeting = new JLabel( "Hello World!", JLabel.CENTER );
		JTextPane Text_Pane = new JTextPane();
		getContentPane().add( greeting, BorderLayout.CENTER );
		//getContentPane().add(Text_Pane );
		setSize( 300, 300);
		setVisible( true );
	}

	

}