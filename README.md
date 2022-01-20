# Find-PI
This project generates up to the Nth decimal place of PI

## The program step-by-step
- To run the program you need java jre version 1.8.0 or higher that can be found [here](https://java.com/en/download/manual.jsp)
- The program gets the Nth value from the user	
- Then finds the value of PI using the [Chudnovsky algorithm](https://www.craig-wood.com/nick/articles/pi-chudnovsky/)
- And finally prints the result with the decimal place limitation using [Substring](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

## Limitations
- The number of precise decimal PI digits the program can find is limited to the number type (*Ex:* [Double](https://docs.oracle.com/javase/7/docs/api/java/lang/Double.html) is 15)
- The maximum number of digits that the program can generate is 11 because of limitations in converting from Double to String and in the number of digits that are generated to a Double in the passings of the *for* loop
