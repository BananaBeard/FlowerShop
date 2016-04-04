package com.company.kovalenko;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Shop {

    public ArrayList<Flower> flowers = new ArrayList<>();
    public ArrayList<Bouquet> bouquets = new ArrayList<>();

    static String[] Pot = {"Azaleas", "Celosia", "Chamomile", "Diantus"};
    static ArrayList<String> pot = new ArrayList<>(Arrays.asList(Pot));
    static String[] Thorn = {"Rose", "Agave", "Silverthorn", "Cactus"};
    static ArrayList<String> thorn = new ArrayList<>(Arrays.asList(Thorn));
    static String[] NoThorn = {"Tulip", "Orchidea", "Camelia", "Daisy"};
    static ArrayList<String> nothorn = new ArrayList<>(Arrays.asList(NoThorn));

    Random rnd = new Random(System.currentTimeMillis());

    public Shop() {

    }

    public void sortFlowers() {
        Collections.sort(flowers, Collections.reverseOrder());
    }

    public ArrayList<Flower> restock() throws FileNotFoundException, IOException {
        File file = new File("restock.txt");
        FileInputStream fs = new FileInputStream(file);
        BufferedInputStream bs = new BufferedInputStream(fs);
        BufferedReader br = new BufferedReader(new InputStreamReader(bs, StandardCharsets.UTF_8));
        ArrayList<Flower> restock = new ArrayList<>();

        String line = null;

        while ((line = br.readLine()) != null){
            if(Shop.pot.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    restock.add(new PotFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
            else if(Shop.thorn.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    restock.add(new ThornsFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
            else if(Shop.nothorn.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    restock.add(new NoThornsFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
        }

        return restock;
    }
}
