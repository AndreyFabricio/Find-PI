import javax.swing.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrey Fabricio
 * Github: https://github.com/AndreyFabricio
 * LinkedIn: https://www.linkedin.com/in/andrey-fabricio/
 * 
 * This project generates up to the Nth decimal place of PI
 * The PI value is calculated using the Chudnovsky algorithm
 * Chudnovsky algorithm: https://www.craig-wood.com/nick/articles/pi-chudnovsky/
 * 
 * Last update: 19/01/2022
 */

public class NthPI extends JFrame implements ActionListener {
	
	static int factorial(int n){    
		// Calculates the factorial value of n
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }
	
	static int readN (String userText, JLabel err) {
		
		// Gets the Nth value from the user
		
		int N = 0;
		
        try {
            N = Integer.parseInt(userText);
        } catch(NumberFormatException nfe) {        	
        	err.setText("The value \"" + userText +"\" is not a valid integer");
        	// err.setForeground(new java.awt.Color(255,0,0));
        }
        
        if (N > 11 || N < 0) {
        	err.setText("Cannot generate more than 11 decimals of PI");
        	//err.setForeground(new java.awt.Color(255,0,0));
        }        	
        
        return N;
	}
	
	static void createPI (int n, JLabel pI, JLabel nPI, JLabel erro) {
		
		// Finds PI using the Chudnovsky algorithm
		
		if (erro.getText() == "") {
			
			double x, pi, deno;
			x = pi = deno = 0;
			
			for (int i = 0; i <= n; i ++) {
				x = (Math.pow(-1,  i)) * (factorial(6 * i)) * (13591409+545140134 * i);
				deno = factorial(3 * i) * (Math.pow(factorial(i), 3)) * (Math.pow(640320, 3 * i));
				pi += x/deno;
			}      
			
			pi = pi * 12/Math.pow(640320, 1.5);
			pi = 1/pi;
			
			pI.setText("Calculated PI: " + pi);

			String nthPI = Double.toString(pi);
			
			nPI.setText("PI to the Nth decimal: " + nthPI.substring(0, n+2) );
		}
		
	}
	
	Container container=getContentPane();
    JLabel N = new JLabel("How many decimal places of PI do you want? (Max: 11)");
    JLabel PI = new JLabel("Calculated PI: ");
    JLabel nPI = new JLabel("PI to the Nth decimal: ");
    JLabel error = new JLabel("");
    JTextField userTextField = new JTextField();
    JButton btn = new JButton("Calculate");
	
	NthPI()
    {
		setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
 
	public void setLayoutManager()
	   {
	       container.setLayout(null);
	   }
	
	public void setLocationAndSize()
	   {
		
	       N.setBounds(40,10,320,40);
	       userTextField.setBounds(355,21,20,20);
	       btn.setBounds(380,20,100,20);	
	       PI.setBounds(40,40,260,40);
	       nPI.setBounds(40,60,260,40);
	       error.setBounds(40,80,260,40);
	       error.setForeground(new java.awt.Color(255,0,0));
	   }
	
	public void addComponentsToContainer()
	   {
	      
	       container.add(N);
	       container.add(userTextField);
	       container.add(btn);
	       container.add(PI);
	       container.add(nPI);
	       container.add(error);
	   }
	
	public void addActionEvent()
	   {
	       btn.addActionListener(this);
	   }
	
    @Override
    public void actionPerformed(ActionEvent e) {
 
    	if (e.getSource() == btn) {
           
    		PI.setText("Calculated PI: ");
        	nPI.setText("PI to the Nth decimal: ");
        	error.setText("");
        	createPI(readN(userTextField.getText(), error), PI, nPI, error);
        	userTextField.setText("");
 
        }
    	
    }
	
	public static void main(String[] args) {
		
		NthPI frame=new NthPI();
        frame.setTitle("NthPI");
        frame.setVisible(true);
        frame.setBounds(10,10,500,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
	}

}
