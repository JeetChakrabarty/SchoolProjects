/*
 * Program to estimate value of pi based on random guessing
  * Author: Jeet Chakrabarty
*/

#include <time.h>	//Makes random numbers more random
#include <stdio.h>	//Includes inputs and outpus
#include <stdlib.h>	//Includes use of RAND_MAX
#include <math.h>	//Includes use of sqrt function

int main (void){
	//Variables for indices and sum of dots landed in circle
	int i, j, k, sum;
	//Values for N to loop through
	int values [] = {10, 100, 1000, 100000, 1000000, 10000000, 100000000};
	//Array to hold ten approximations per value
	double tenValues [10];
	//Array for x,y coordinates, ratio landed inside, mean, sum to calculate mean, and standard deviation
	double x, y, ratio, mean, meanSum, stDev;
		
	//Makes pseudo-random number generator based on time (more random)
	srand(time(NULL));

	//Loops through designated values of N (10, 100, 1000, etc)
	for (i=0; i<sizeof(values)/sizeof(values[0]); i++){
		mean=0;	//Resets value of mean to 0
		meanSum=0;	//Resets value of sum of mean to 0

		//Loops through 10 values 
		for (j=0; j<10; j++){
			sum=0;	//Resets sum to 0

			//Loops through N times
			for (k=0; k<values[i]; k++){
				//Assigns x and y coordinates random values
				x = (double)rand()/(double)RAND_MAX;
				y = (double)rand()/(double)RAND_MAX;
				
				//Increments sum if point inside circle
				if (x*x+y*y<=1){
					sum++;
				}
			}

			//Calculates one pi approximation ratio
			tenValues[j] = (double)sum/(double)values[i];
			//Adds approximation to sum to calculate mean
			meanSum += tenValues[j]*4;
			//Prints approximation
			printf("%f \n", tenValues[j]*4);
		}

		//Calculates mean of 10 approximations
		mean=meanSum/10.0;
		//Resets sum to calculate mean to 0
		meanSum=0;

		//Loops through 10 values to calculate standard deviation
		for (j=0; j<10; j++){
			//Calculates value of each term
			meanSum+=(tenValues[j]*4-mean)*(tenValues[j]*4-mean);
		}
		//Calculates final standard deviation
		stDev=sqrt(meanSum/10);

		//Prints standards deviation
		printf("For %d, the mean is: %f and the std Dev is: %f \n", values[i], mean, stDev);
	}
	return 0;
}
