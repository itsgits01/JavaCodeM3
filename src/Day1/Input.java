package Day1;

import java.util.Scanner;

public class Input {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("enter arra elemnts");
        int[] arr= new int[5];

        for(int i=0;i< arr.length;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

//        System.out.print("Enter your name: ");
//        String name= sc.nextLine();
//
//        System.out.println("Hello "+name);
    }
}
