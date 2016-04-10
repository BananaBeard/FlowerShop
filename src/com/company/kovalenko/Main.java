package com.company.kovalenko;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Shop shop = null;

        try {
            shop = new Shop();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        boolean exit = false;

        while(!exit) {

            printMenu();
            int key = sc.nextInt();

            switch (key) {
                case 1:
                    shop.flowers.forEach(System.out::println);
                    br.readLine();
                    System.out.println();
                    break;
                case 2:
                    shop.sortFlowers();
                    System.out.println("Flowers are sorted");
                    br.readLine();
                    System.out.println();
                    break;
                case 3:
                    /*System.out.println("Tell the numbers of each flower type(1 - thorns, 2 - no thorns)");
                    int t = sc.nextInt();
                    int n = sc.nextInt();
                    try {
                        Bouquet bq = new Bouquet(t, n, shop.flowers);
                        shop.bouquets.add(bq);
                        shop.flowers.removeAll(bq.content);
                        System.out.println("Your bouquet is ready.");
                    } catch (IllegalArgumentException exception) {
                        exception.printStackTrace();
                    }
                    br.readLine();
                    System.out.println();
                    break;*/
                case 4:
                    try {
                        for (Flower f : shop.bouquets.get(0).content) {
                            System.out.println(f);
                        }
                    } catch (IndexOutOfBoundsException exception){
                        exception.printStackTrace();
                    }
                    br.readLine();
                    System.out.println();
                    break;
                case 5:
                    try {
                        shop.flowers.addAll(shop.restock());
                        System.out.println("Shop is restocked.");
                    }
                    catch (FileNotFoundException exception) {
                        System.err.println("Wrong file name!");
                        exception.printStackTrace();
                    }
                    br.readLine();
                    System.out.println();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice. Try again, please.");
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("1. Print all flowers.");
        System.out.println("2. Sort flowers.");
        System.out.println("3. Get bouquet.");
        System.out.println("4. Print bouquet.");
        System.out.println("5. Restock flowers.");
        System.out.println("6. Exit.");

    }
}
