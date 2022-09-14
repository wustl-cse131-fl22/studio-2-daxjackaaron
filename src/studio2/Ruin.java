package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Starting Amount of Money: ");
		int startAmount = scan.nextInt();
		
		System.out.println("Chance of winning: ");
		double winChance = scan.nextDouble();
		
		System.out.println("Win limit: ");
		int winLimit = scan.nextInt();
		
		double balance = startAmount;
		
		System.out.println("Days you play: ");
		int totalSimulation = scan.nextInt();
		
		int plays = 0;
		
		double ruins = 0;
		
		double a = (1 - winChance) / winChance;
		
		double expectedRuin = 0;
		if (winChance == 0.5)
		{
			expectedRuin = 1 - (startAmount / winLimit);
			
		}
		else
		{ 
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		for (int x = 1; x <= totalSimulation; x++)
		{
		balance = startAmount;
		for (int i = 1; balance > 0 && balance < winLimit; i++)
		{	
		if (Math.random() < winChance)
		{
			balance++;
		}
		else 
		{
			balance--;
		}
		plays = i;
		if (balance == 0)
		{
			ruins++;
		}
		}
		System.out.println("Day " + x);
		System.out.print(plays + " Plays, ");
		if (balance == 0)
		{
			System.out.println("Ruin");
		}
		else
		{
			System.out.println("Success");
		}
		}
		System.out.println("Ruin rate: " + ruins / totalSimulation * 100 + "%");
		System.out.print("Expected Ruin Rate: " + expectedRuin * 100 + "%");
	}

}
