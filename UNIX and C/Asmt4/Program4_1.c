/*
 * Program to estimate value of pi based on random guessing for user value N
 * Author: Jeet Chakrabarty
*/

#include <time.h>	//Makes random numbers more random
#include <stdio.h>	//Includes inputs and outpus
#include <stdlib.h>	//Includes use of RAND_MAX

int main (void){
	
	//Variables representing input, index, and sum of guesses inside circle
	int N, i, sum = 0;
	//Variables representing x and y coordinates and ratio landed inside
	double x, y, ratio;

	//Loop iterates through input reception until valid input is typed
	do {
		printf("What positive N would you like to calculate to?\n");
		scanf("%d", &N);	//Scans integer into N
	} while (N<=0);	//Condition for validity
	
	//Makes pseudo-random number generator based on time (more random)
	srand(time(NULL));

	//Loops through random value pairs N times
	for (i=0; i<N; i++){
		//Assigns //Assigns x random value between 0 and 1x random value between 0 and 1
		x = (double)rand()/(double)RAND_MAX;
		//Assigns y random value between 0 and 1
		y = (double)rand()/(double)RAND_MAX;

		//Increments sum if random value falls in circle
		if (x*x+y*y<=1){
			sum++;
		}
	}

	//Calculates ratio of dots landed inside to outside
	ratio = (double)sum/(double)N;
	
	//Outputs the approximated value of pi
	printf("The approximated value of pi is: %f\n", ratio*4);

	return 0;
}
