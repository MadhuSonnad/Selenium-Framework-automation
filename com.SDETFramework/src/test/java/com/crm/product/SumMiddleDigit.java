package com.crm.product;

public class SumMiddleDigit {

	public static void mian(String[]args)
				{
	
		int[]arr={126,128,138,321,145};
		int sum=0;
		for (int i = 0; i < arr.length; i++) 
		{
		sum = sum+fetch(arr[i]);
		}
		System.out.println(sum);
		
	}

	 static int fetch(int no)
	 {
int y=(no%10)/10;
		return y;
	}
}
