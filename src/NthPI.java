import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

public class NthPI extends Application {

	static int factorial(int n){    
		// Calculates the factorial value of n
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }
	
	static int readN (String userText, Text error) {
		
		// Gets the Nth value from the user
		
		int N = 0;
		
        try {
            N = Integer.parseInt(userText);
        } catch(NumberFormatException nfe) {
        	error.setFill(Color.FIREBRICK);
        	error.setText("The value is not a valid integer");
        }
        
        if (N > 11 || N < 0) {
        	error.setFill(Color.FIREBRICK);
    		error.setText("Cannot generate more than 11 decimals of PI");
        }        	
        
        return N;
	}
	
	static void createPI (int n, Label PI, Label nPI, Text error) {
		
		// Finds PI using the Chudnovsky algorithm
		
		if (error.getText() == "") {
			
			double x, pi, deno;
			x = pi = deno = 0;
			
			for (int i = 0; i <= n; i ++) {
				x = (Math.pow(-1,  i)) * (factorial(6 * i)) * (13591409+545140134 * i);
				deno = factorial(3 * i) * (Math.pow(factorial(i), 3)) * (Math.pow(640320, 3 * i));
				pi += x/deno;
			}      
			
			pi = pi * 12/Math.pow(640320, 1.5);
			pi = 1/pi;
			
			PI.setText("Calculated PI: " + pi);

			String nthPI = Double.toString(pi);
			
			nPI.setText("PI to the Nth decimal: " + nthPI.substring(0, n+2) );
		}
		
	}
	
	@Override
    public void start(Stage primaryStage) {
		
        primaryStage.setTitle("Nth PI");
        primaryStage.show();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("How many decimal places of PI do you want?");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 4, 1);

        Label dPlaces = new Label("Decimal Places (Max: 11)");
        grid.add(dPlaces, 0, 2);

        TextField userTextField = new TextField();
        userTextField.setPrefWidth(40);
        userTextField.setMaxWidth(40);
        grid.add(userTextField, 1, 2);
        
        Button btn = new Button("Calculate");       
        grid.add(btn, 2, 2);
        
        final Text error = new Text();
        grid.add(error, 2, 6);

        Label PI = new Label("Calculated PI: ");
        grid.add(PI, 0, 3);
        
        Label nPI = new Label("PI to the Nth decimal: ");
        grid.add(nPI, 0, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {            	
            	PI.setText("Calculated PI: ");
            	nPI.setText("PI to the Nth decimal: ");
            	error.setText("");
            	createPI(readN(userTextField.getText(), error), PI, nPI, error);
            }
        });
        
        Scene scene = new Scene(grid, 500, 200);
        primaryStage.setScene(scene);
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
