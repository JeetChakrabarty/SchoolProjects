/*
 * Program for creating and and outputting magic square representing squares
 * Author: Jeet Chakrabarty
*/

#include <stdio.h>	//Includes inputs and outpus

/*
 * Function to calculate smallest number number of bills/coins equivalent
 * to some integer amount
 * @param dollars represents dollar amount to be calculated
 * @param *twenties, *tens, *fives, *toonies, *loonies represents pointers
 * to bill/coin amounts
*/
void pay_amount(int dollars, int *twenties, int *tens, int *fives,
				int *toonies, int *loonies){

	*twenties=dollars/20;	//Calculates number of $20 bills
	dollars%=20;	//Changes dollar to remaining amount
	*tens=dollars/10;	//As above, except with $10 bills
	dollars%=10;
	*fives=dollars/5;
	dollars%=5;
	*toonies=dollars/2;
	dollars%=2;
	*loonies=dollars;

}

/*
 * Main program to ask user for $ and output minimum equivalent bills
*/
int main (void){

	int dolla;	//Variable representing user's dollar input
	int tw, te, fi, to, lo;	//Pointers representing change

	//Input loop does not continue program until valid input
	do {
		printf("Enter integer $ amount: ");
		scanf("%d", &dolla); //Accepts size input
	} 
	while (dolla<0); //Condition repreats loop if not positive

	//Calls pay_amount function to calculate change
	pay_amount(dolla, &tw, &te, &fi, &to, &lo);

	//Prints out values dollars split into
	printf("You should get: %d twentie(s), %d ten(s), %d five(s), %d toonie(s), and %d loonie(s).\n", tw, te, fi, to, lo);
}
