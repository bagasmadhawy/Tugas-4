package com.example.setelahgagal;

import java.util.ArrayList;

public class DataUlar {
    private static String[] snakeNames = {
            "C. rhodostoma",
            "Daboia siamensis",
            "Trimeresurus albolabris",
            "Trimeresurus gunaleni",
            "Trimeresurus insularis",
            "Trimeresurus malcolmi",
            "Tropidolaemus wagleri"
    };

    private static String[] snakeDetails = {
            "Ular Bandotan Tanah",
            "Ular Bandotan Puspa",
            "Ular Hijau Ekor Merah",
            "Ular Hijau Gunung",
            "Island Pit Viper",
            "Malcolm's Pit Viper",
            "Ular Bandotan Candi"
    };

    private static int[] snakeImages = {
            R.drawable.vrodostoma,
            R.drawable.vdhaboia,
            R.drawable.talbo,
            R.drawable.gunaleni,
            R.drawable.tinsularis,
            R.drawable.malcomli,
            R.drawable.vwagleri
    };

    public static ArrayList<ModelUlar> getUlarList() {
        ModelUlar modelUlar = null;
        ArrayList<ModelUlar> list = new ArrayList<>();

        for (int i = 0; i < snakeNames.length; i++) {
            modelUlar = new ModelUlar();
            modelUlar.setSnakeName(snakeNames[i]);
            modelUlar.setSnakeDetail(snakeDetails[i]);
            modelUlar.setSnakeImage(snakeImages[i]);

            list.add(modelUlar);
        }
        return list;
    }
}
