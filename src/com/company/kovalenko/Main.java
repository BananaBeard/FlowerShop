package com.company.kovalenko;

import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Random rnd = new Random(System.currentTimeMillis());
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String[]> shopStock = new ArrayList<>();

        Shop shop = new Shop();
        boolean exit = false;

        for (String s: getData()) {
            shopStock.add(s.split(" "));
        }

        shop.flowers.addAll(stockToShop(shopStock));

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
                    System.out.println("Tell the numbers of each flower type(1 - thorns, 2 - no thorns)");
                    int t = sc.nextInt();
                    int n = sc.nextInt();
                    Bouquet bq = new Bouquet(t, n, shop.flowers);
                    shop.bouquets.add(bq);
                    shop.flowers.removeAll(bq.content);
                    System.out.println("Your bouquet is ready.");
                    br.readLine();
                    System.out.println();
                    break;
                case 4:
                    for (Flower f : shop.bouquets.get(0).content) {
                        System.out.println(f);
                    }
                    br.readLine();
                    System.out.println();
                    break;
                case 5:
                    shop.flowers.addAll(shop.restock());
                    System.out.println("Shop is restocked.");
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

    public static List<String> getData() throws IOException {
        File file = new File("FlowerShopStock.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        List<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = br.readLine()) != null){
            lines.add(line);
        }

        return lines;
    }

    public static ArrayList<Flower> stockToShop(ArrayList<String[]> a){

        ArrayList<Flower> result = new ArrayList<>();

        for (String[] s: a) {
            if(Shop.pot.contains(s[1])) {
                for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                    result.add(new PotFlower(Integer.parseInt(s[2]), s[1]));
                }
            }
            else if(Shop.thorn.contains(s[1])) {
                for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                    result.add(new ThornsFlower(Integer.parseInt(s[2]), s[1]));
                }
            }
            else if(Shop.nothorn.contains(s[1])) {
                for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                    result.add(new NoThornsFlower(Integer.parseInt(s[2]), s[1]));
                }
            }
        }
        return result;
    }
}
