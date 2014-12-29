/* 
 * Program to approximate value of e
 * Author: Jeet Chakrabarty
 */

#include <stdio.h> 

int main() 
{
 //Variable declarations
 double n, e = 0;
 int boolean = 0, factorial = 1, i = 0, j;

 //Loop for valid input
 while (boolean == 0){
	printf ("Enter the value of approximation:\t"); 
 	scanf ("%lf", &n ); 
 	//Changes value of boolean to exit loop when condition met
	if(n > 0)
		boolean = 1;
 }
 
 //loop executes until 1/n! is less than input specified by user
 while (1/(double)factorial > n) {
	//Adds next term to e
	e = e + 1/(double)factorial;
	//Increments i
	i++;
	//Resets factorial value
	factorial = 1;
	//Loop to calculate factorial
	for (j = 1; j <= i; j++){
		factorial = factorial*j;
	}
 }
 printf ("The value of e is:\t %.15lf and the value of i is: \t %d\n", e, i); 
 return 0;
}
