/*
 *Program to compute times on a 24-hour clock
 *Author: Jeet Chakrabarty
 */
#include <stdio.h> 

int main() 
{
 //Variable declarations 
 int day, duration, aminutes, ahours, uminutes, uhours;
 int boolean = 0, output = 0, outputmin = 0;

 //Input loop
 while (boolean == 0){
	//While loop repeats until valid input in accepted
	printf ("Enter a value to represent the time of day:\t"); 
 	scanf ("%d", &day ); 
 	printf ("Enter a value to represent time duration:\t"); 
 	scanf ("%d", &duration );
	//Stores first 2 digits (hours) in a variable
 	ahours = day / 100;
	//Stores second 2 digits (minutes) in a variable
 	aminutes = day % 100; 
	uminutes = duration % 100;
 	uhours = duration / 100;
	if(ahours < 24 && ahours >= 0 && aminutes < 60 && uminutes < 60 && uminutes > -60) {
		//Checks if all numbers are valid
		boolean = 1;
		//Changing Boolean value results in loop stopping execution
	}
 }
 if (duration > 0 && aminutes + uminutes >= 60){
	//Adds 1 hour if sum of minutes totals an hour or more
	output = output + 1;
 }
 if (duration < 0 && aminutes + uminutes < 0){
	//Subtracts 1 hour if difference of minutes is less than 0
	output = output - 1;
 }
 //Calculates last 2 digits of output time
 outputmin = outputmin + (aminutes + uminutes) % 60;
 //Calculates first 2 digits of output time
 output = (output + (ahours + uhours) ) % 24;
 //Adds 24 hours if modulo hours results in negative number
 if (output < 0)
	output = output + 24;
 //Adds 60 minutes if modulo minutes results in negative number
 if (outputmin < 0)
	outputmin = outputmin + 60;
 printf("The final time of day is:\t\t\t%.2d%.2d \n", output, outputmin);
 return 0;
}
