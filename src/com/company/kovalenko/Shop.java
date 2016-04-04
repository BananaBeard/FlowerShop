package com.company.kovalenko;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Shop {

    public ArrayList<Flower> flowers = new ArrayList<>();
    public ArrayList<Bouquet> bouquets = new ArrayList<>();


    //Базу цветов я перенес этот класс, чтобы в main'e все было не так запутанно(ну и так как это более логично)

    static String[] Pot = {"Azaleas", "Celosia", "Chamomile", "Diantus"};
    static ArrayList<String> pot = new ArrayList<>(Arrays.asList(Pot));
    static String[] Thorn = {"Rose", "Agave", "Silverthorn", "Cactus"};
    static ArrayList<String> thorn = new ArrayList<>(Arrays.asList(Thorn));
    static String[] NoThorn = {"Tulip", "Orchidea", "Camelia", "Daisy"};
    static ArrayList<String> nothorn = new ArrayList<>(Arrays.asList(NoThorn));

    /*
    * Стартовое заполнение магазина я перенес из main'a в конструктор. В остальном этот метод аналогичен методу
    * пополнения запасов, который описан дальше. Единственное отличие - в этом методе используется FileReader.*/
    public Shop() throws IOException {
        File file = new File("FlowerShopStock.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        while ((line = br.readLine()) != null){
            if(Shop.pot.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    flowers.add(new PotFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
            else if(Shop.thorn.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    flowers.add(new ThornsFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
            else if(Shop.nothorn.contains(line.split(" ")[1])) {
                for (int i = 0; i < Integer.parseInt(line.split(" ")[0]); i++) {
                    flowers.add(new NoThornsFlower(Integer.parseInt(line.split(" ")[2]), line.split(" ")[1]));
                }
            }
        }
    }

    public void sortFlowers() {
        Collections.sort(flowers, Collections.reverseOrder());
    }

    /*Этот метод аналогичен тому, которым я раньше заполнял магазин, но все перенесено в один метод и читается намного проще.
    Отделные элементы сроки просматриваются сразу при проверке условия, а не при помощи еще кучи массивов, как раньше.
    При выполнении условия нахождения имени в базе, мы вызваем конструктор столько раз, сколько цветов задано в файле,
    и с данными из того же файла.
    */
    public ArrayList<Flower> restock() throws IOException {
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
