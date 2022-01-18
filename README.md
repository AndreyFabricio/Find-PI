# Find-PI
This project generates up to the Nth decimal place of PI

## The program step-by-step
- The program gets the Nth value from the user	
- Then finds the value of PI using the [Chudnovsky algorithm](https://www.craig-wood.com/nick/articles/pi-chudnovsky/)
- And finally prints the result with the decimal place limitation using [Decimal Format](https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html)

## Limitations
- Because of the [Decimal Format](https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html), the number of decimal PI digits the program can find is limited to eleven
- Without the [Decimal Format](https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html) the number of decimal PI digits the program can find is limited to the number type (*Ex:* [Double](https://docs.oracle.com/javase/7/docs/api/java/lang/Double.html) *is 15*)
