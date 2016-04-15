package com.company.kovalenko;

import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = null;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
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
                    boolean isNeeded = false;
                    ArrayList<Order> orders = new ArrayList<>();
                    ArrayList<String> notInStock = new ArrayList<>();
                    System.out.println("How many different flowers you want to buy?");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Tell the number of flower #" + (i + 1));
                        int count = sc.nextInt();
                        System.out.println("Tell the name of flower #" + (i + 1));
                        String name = br.readLine();

                        try {
                            orders.add(new Order(name, count));
                        } catch (RequestedFlowerNotInListException exception) {
                            notInStock.add(exception.getName());
                            isNeeded = true;
                        }
                    }
                    if (isNeeded)
                        makeNotInListOrder(notInStock);
                    else {
                        Bouquet bq = new Bouquet(orders, shop);
                        shop.bouquets.add(bq);
                        shop.flowers.removeAll(bq.content);
                        System.out.println("Your bouquet is ready");
                    }
                    System.out.println("Bye. Thanks for coming!");
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
                    System.out.println("Tell the name of pot flower you are interested in.");
                    String name = br.readLine();
                    System.out.println("Tell the number of pot flowers you need.");
                    int count = sc.nextInt();
                    try {
                        shop.buyPotFLowers(new Order(name,count));
                        System.out.println("Thanks for coming! Here is your flower.");
                    } catch (RequestedFlowerNotInListException exception){
                        exception.printStackTrace();
                        //keOrder(br, exception);
                    }
                    break;
                case 6:
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
                case 7:
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
        System.out.println("5. Buy pot flowers.");
        System.out.println("6. Restock flowers.");
        System.out.println("7. Exit.");

    }

    public static void makeNotInListOrder(ArrayList<String> toOrder) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        System.err.println("Sorry, but we have no flowers with these names:" + "\n");
        toOrder.forEach(System.out::println);
        System.out.println();
        System.out.println("You can make an order request for our provider to buy this." + "\n" +
                "Are you interested int that? ( y / n )");
        String answ = br.readLine();
        if (answ.equals("y")){
            boolean isOrdered = false;
            File file = null;
            while (!isOrdered){
                file = new File("NotFoundOrder"+ Shop.orderCount +".txt");
                if (!file.exists()) {
                    file.createNewFile();
                    isOrdered = true;
                }
                else
                    Shop.orderCount++;
            }
            FileWriter fr = new FileWriter(file);
            for (String s: toOrder) {
                fr.write("On " + new java.util.Date ().toString () + " customer ordered flower called " + s + "." + System.lineSeparator());
                fr.flush();
            }

            System.out.println("Thanks, your order will be processed soon!");
        }
    }
}
