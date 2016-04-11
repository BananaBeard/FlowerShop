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
                    try {
                        ArrayList<Order> orders = new ArrayList<>();
                        System.out.println("How many different flowers you want to buy?");
                        int n = sc.nextInt();
                        for (int i = 0; i < n; i++) {
                            System.out.println("Tell the number of flower #" + (i+1));
                            int count = sc.nextInt();
                            System.out.println("Tell the name of flower #" + (i+1));
                            String name = br.readLine();
                            orders.add(new Order(name, count));
                        }
                        Bouquet bq = new Bouquet(orders,shop);
                        shop.bouquets.add(bq);
                        shop.flowers.removeAll(bq.content);
                        System.out.println("Your bouquet is ready");
                    } catch (RequestedFlowerNotInListException exception) {
                        exception.printStackTrace();
                        System.err.println("Sorry, but we have no flowers with this name." + "\n" +
                        "You can make   order request for our provider to buy this." + "\n" +
                        "Are you interested int that? ( y / n )");
                        String answ = br.readLine();
                        if (answ.equals("y")){

                        } else{

                        }
                    }
                    br.readLine();
                    System.out.println();
                    break;
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
