package com.grayMatter;

import java.util.Scanner;

public class DemoOnArray {
	
	public static boolean isPrime(int num) {
		
		boolean flag=true;
		if(num==0||num==1) {
			System.out.println("Not Prime");
			flag=false;
		}
		for(int i=0; i<=Math.sqrt(num); i++) {
			if(num%1==0) {
				System.out.println("Not Prime");
				flag=false;
			}
		}
		if(flag==true) {
			System.out.println("Is Prime");
		}
		return flag;
	}
	
	//find no.of duplicate for a given element
	public static int dupe(int num, int arr[]) {
		int count=0;
		for(int i:arr) {
			if(i==num) {
				count++;
			}
		}
		return count;
	}
	
	public static int[] ilp(int num, int arr[], int size) {
		if(arr.length!=size) {
			arr[arr.length]=num;
			return arr;
		}
		else {
			int arr1[]=new int[size+(size/2)];
			for(int i=0;i<size; i++) {
				arr1[i]=arr[i];
			}
			arr1[size]=num;
			size=size+(size/2);
			return arr1;
		}
	}
	
	public static void multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rowsA = firstMatrix.length;
        int colsA = firstMatrix[0].length;
        int colsB = secondMatrix[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		
		//find no.of duplicate for a given element
		//insert an element at the last position
		//insert an element at a given position
		//delete an element at a given position
		
//		Scanner sc = new Scanner(System.in);
//		int arr[] = new int[5];
//		
//		for(int i =0; i<5; i++) {
//			arr[i]=sc.nextInt()	;
//		}
//		
//		System.out.println("is prime: "+isPrime(arr[2]));
//		System.out.println("Count duplicate: "+dupe(2, arr));
//		System.out.println("Enter a number for insertion: ");
//		int num=sc.nextInt();
//		System.out.println(arr=ilp(num, arr, 5));
		
		int[][] matrix1 = { {1, 2, 3}, {4, 5, 6} };
        int[][] matrix2 = { {7, 8}, {9, 10}, {11, 12} };
        
        multiplyMatrices(matrix1, matrix2);

		
//		sc.close();
	}
}
