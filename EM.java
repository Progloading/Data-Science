import java.util.*;
import java.util.Scanner;

/********************************************************************************
Author: James ROberson III
Course:	Data Mining
Date: 11/30/2018
Description:
	This program is a basic implementation of the Expectation Maximization Algorithm
	in Data Science. It shows iterations of a simple toss coin and how it is able to
	maximize the chances of either heads or tails.

	Although this is a basic employment of the algorithm, its concept eludes most.
********************************************************************************/
public class EM
{
	public static void main(String[] args)
	{
		ArrayList<Double> list1 = new ArrayList<Double>(100);
		ArrayList<Double> list2 = new ArrayList<Double>(100);
		ArrayList<Double> list3 = new ArrayList<Double>(100);
		ArrayList<Double> list4 = new ArrayList<Double>(100);
					/**
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter the number of elements in the list: ");
					int num = sc.nextInt();
					int[] arrayA = new int[num];

					for(int i = 0; i < num; i++)
					{
						System.out.println("Enter the characters you want to evaluate " + (i + 1) + ": ");
						arrayA[i] = sc.nextInt();

					}
					for(int i = 0; i < num; i++)
					{
						System.out.print(arrayA[i]);
					}
					**/

		double initialA = 0.6;
		double initialB = 0.5;
		int count = 1;
		int cnt = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Factorial # ? ");
		int number = sc.nextInt();

		String answer = "";

		do
		{
			System.out.println();
			System.out.println("#################### " + cnt + " ITERATION ###################");
			cnt++;

			for(int i = 0; i < 5; i++)
			{
				System.out.println("Enter the number of Heads: ");
				int head = sc.nextInt();
				System.out.println("Enter the number of tails: ");
				int tail = sc.nextInt();

				//From here, we will implement the factorial of (10 choose 5)
				int num1 = 1;
				int num2 = 1;
				int num3 = 1;
				int fact1 = 1;
				int fact2 = 1;
				int fact3 = 1;
				while(num1 <= number)
				{
					fact1 = fact1* num1;
					num1++;
				}
				while(num2 <= (number - head))
				{
					fact2 = fact2 * num2;
					num2++;
				}
				while(num3 <= (number - tail))
				{
					fact3 = fact3 * num3;
					num3++;
				}
														//From here, we calculate each piece of the equation of likelihood
				int factorial = fact1/(fact2 * fact3);
				//This basically reads-- 10!/(10 - 5)!*5!

				double power1 = Math.pow(initialA, head);
				double power4 = Math.pow(initialB, tail);
				double can = 1 - initialA;
				double canAgain2 = number - head;
				double canAgain = number - tail;
				double can1 = 1 - initialB;
				double power2 = Math.pow(can, canAgain2);
				double power3 = Math.pow(can1, canAgain);
														//Now we have all of the pieces, calculate likelihoodA and likelihoodB
				double likelihoodA = factorial * power1 * power2;
				double likelihoodB = factorial * power4 * power3;

														//Now we calculate the normalization of the probability
				double coinA = likelihoodA / (likelihoodA + likelihoodB);
				double coinB = likelihoodB / (likelihoodA + likelihoodB);


				double headsA = coinA * head;
				double tailsA = coinA * tail;
				System.out.println("Recurrence #" + count + ": ");
				System.out.println("(A) "  + "Heads: " + headsA + ", " + "Tails: " + tailsA);
				list1.add(headsA); //The reason for the arrayList is to sum up all of the heads calculated
				list2.add(tailsA); //Vice versa all of the tails calculated

														//Here we estimate heads and tails for each coin
				double headsB = coinB * head;
				double tailsB = coinB * tail;
				System.out.println("(B) " + "Heads: " +headsB + ", " + "Tails: " + tailsB);
				list3.add(headsB);
				list4.add(tailsB);

				count++;
				System.out.println();
			}
					System.out.println("Probability of Heads for set A: " + list1);
					double sum1 = 0;
					for(int i = 0; i < list1.size(); i++)
					{
						sum1 = sum1 + list1.get(i);
					}System.out.println("Sum ==> " + sum1); System.out.println();

					System.out.println("Probability of Tails for set A: " + list2);
					double sum2 = 0;
					for(int i = 0; i < list2.size(); i++)
					{
						sum2 = sum2 + list2.get(i);
					}System.out.println("Sum ==> " + sum2); System.out.println();

					System.out.println("Probability of Heads for set B: " + list3);
					double sum3 = 0;
					for(int i = 0; i < list3.size(); i++)
					{
						sum3 = sum3 + list3.get(i);
					}System.out.println("Sum ==> " + sum3); System.out.println();

					System.out.println("Probability of Tails for set B: " + list4);
					double sum4 = 0;
					for(int i = 0; i < list4.size(); i++)
					{
						sum4 = sum4 + list4.get(i);
					}System.out.println("Sum ==> " + sum4); System.out.println();

						double initial = sum1 / (sum1 + sum2);
						double initial2 = sum3 / (sum3 + sum4);

						System.out.println("==============================These are the new INITIALS==============================\n");
						System.out.println(initial);
						System.out.println(initial2);

						list1.clear();
						list2.clear();
						list3.clear();
						list4.clear();
						initialA = initial;
						initialB = initial2;


		}while(cnt <= number);
		System.out.println();
		System.out.println("FINAL ANSWER");
		System.out.println();
		//double finalA = initialA;
		//double finalB = initialB;

		/**
		===============INPUT===============
		HEADS: 5	TAILS: 5
		HEADS: 9	TAILS: 1
		HEADS: 8	TAILS: 2
		HEADS: 4	TAILS: 6
		HEADS: 7	TAILS: 3
		**/


	}
}