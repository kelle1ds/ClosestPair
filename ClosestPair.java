package edu.cmich.cps542;

import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//import java.util.stream.Collectors;

public class ClosestPair {

	public static void main(String[] args) throws IOException {
	
		/* load data from points.txt here */
		float [] array = new float [700000];
		File file = new File("points.txt");

		FileReader inputFil = new FileReader(file);
		Scanner scanner = new Scanner(inputFil);
		
		int i = 0;
		while(scanner.hasNext()) {
			
			String token = scanner.next();
			String replaced = token.replaceAll("[()]", "");
			String replaced2 = replaced.replaceAll("[,]", "");
			String replaced3 = replaced2.replaceAll("[\n]", " ");
			String replaced4 = replaced3.replaceAll("\\r\\n|\\r|\\n", " ");
			float num = Float.parseFloat(replaced4);
		    array[i] = num;
		    i++;
		}
		
		scanner.close();
		
		printArray(array);

		    //out.writeFloat(floatarray[i]);
            

		/* use your sort method here */
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array, 0, array.length-1);
		
		printArray(array);
		
		/* call efficientClosestPair here */
		
	}
	
	/* A utility function to print array of size n */
	static void printArray(float arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
		System.out.println();
	}

	public static PointPair efficientClosestPair(ArrayList<Point> pointsXOrdered, ArrayList<Point> pointsYOrdered) {
		
		
			
		return null;
			
	}
	
	public static PointPair bruteClosestPair(ArrayList<Point> points) {
		

		return null;

	}
	
	
	public static ArrayList<Point> sort(ArrayList<Point> points) {
		
		/* No call to sort method here.  Implement something that is divide-
		 *  -and-conquer and O(n log n) */
		
		return null;
	}
	
	
	
}

/* Java program for Merge Sort */
class MergeSort
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(float arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		float L[] = new float[n1];
		float R[] = new float[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(float arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	

}


