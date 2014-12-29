/*
 *Program for creating and and outputting magic square representing squares
 *Author: Jeet Chakrabarty
*/

#include <stdio.h>	//Includes inputs and outpus

int main (void){

	//Variables for size of magic square, and indices of 2D array
	int size, i=0, j, n=2;

	//Input loop does not continue program until valid input
	do {
		printf("Enter (odd and positive integer) size of magic square: ");
		scanf("%d", &size); //Accepts size input
	} while (size%2==0 || size<1 || size>99); //checks if even and valid

	//Initializes 2d square array of size inputted by user
	int array [size][size];

	for (i=0; i<size; i++)	//Sets all values in array to 0
	{
		for (j=0; j<size; j++)
		{
			array[i][j]=0;
		}
	}
	i=0;
	j=size/2; //Sets j equivalent to the position in the middle of the array

	array[i][j]=1;	//Sets top-middle element

	//Loop to input square numbers into square
	while(n<=size*size){
		
		i=i-1;	//Moves up one row
		if(i<0)	//Checks if index out of bounds
			i=i+size;	//Moves to bottom of square

		j=(j+1)%size;	//Moves forward one column while wrapping
		
		if (array[i][j]==0)	//Checks is element is occupied
			array[i][j]=n++;	//Places number into element then increments
		else{	//Executes if element is empty
			i=i+2;	//Moves down 2 rows (counters move-up from before)
			j--;	//Counters move from before
			if(j<0)	//Checks if index out of bounds
				j=j+size;
			i%=size;
			array[i][j]=n++;	//Places number into element then increments

		}
	}

	//Loop to output contents of magic square
	for(i=0; i<size; i++){	//Iteratres through rows
		for(j=0; j<size; j++){	//Iterates through columns
			printf("%2d\t", array[i][j]);	//Prints contents
		}
	printf("\n");
	}
}
