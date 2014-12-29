/*
 * Program to compute loan balances
 * Author: Jeet Chakrabarty
 */

#include <stdio.h> 

int main() 
{
 //Variable Declarations
 float amount, interest, monthlyp;
 int n, boolean = 0, i = 0;

 //While loop for input
 while (boolean == 0){
	//Loops continues to execute until valid input is obtained
	printf ("Enter the loan amount:\t"); 
 	scanf ("%f", &amount ); 
 	printf ("Enter the yearly interest rate (If 12%% type 0.12):\t"); 
 	scanf ("%f", &interest );
	printf ("Enter the monthly payment:\t"); 
 	scanf ("%f", &monthlyp );
	printf ("Enter the number of monthly payments:\t"); 
 	scanf ("%d", &n );
	//Checks if inputs are valid inputs
 	if(amount > 0 && interest > 0 && monthlyp > 0 && n > 0)
		//Chenges boolean to exit loop
		boolean = 1;
 }
 for (i = 1; i <= n; i++){
	//Checks if difference between balance and payment is less than 0
	if (amount*(1+interest/12)-monthlyp < 0) {
		//Changes amount to 0		
		amount = 0;
		//Prints specified output (2nd is amount paid to zero account)
		printf("\t %d \t \t \t %.2f \n", i,amount*(1+interest/12));	
		break;
	}
	else {
		//Calculates account balance after interest and payment
		amount = amount*(1+interest/12)-monthlyp;
		printf("\t %d \t \t \t %.2f \n", i,amount);
	}
 }
 return 0;
}
