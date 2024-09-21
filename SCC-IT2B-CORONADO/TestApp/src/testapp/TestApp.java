package testapp;

import java.util.Arrays;
import java.util.Scanner;

public class TestApp {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //Implementor = holds
        //Execution = user input
        
        //Salary salary = new Salary();
        //salary.menu();
        
        
        
        /*
        int[] arr = new int[]{1,2,3,4,5};
        int[] arr_new = new int[arr.length-1];
        System.out.print("Enter NUM: ");
        int j=sc.nextInt();
        for(int i=0, k=0;i<arr.length;i++){
            if(i!=j-1){
                arr_new[k]=arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));
        */
        
        int [] array = new int [] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        
        System.out.print("Enter number to match: ");
        int num = sc.nextInt();
        
        for(int i = 0; i < array.length; i++){
            if(num == array[i]){
                System.out.println("Match!");
            }
            else{
                System.out.println("No match");
            }
        }
        
    }
    
}
