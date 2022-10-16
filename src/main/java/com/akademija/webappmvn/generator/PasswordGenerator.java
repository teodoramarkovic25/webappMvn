package com.akademija.webappmvn.generator;

import java.util.Random;

public class PasswordGenerator {
    public String generate(){
        String moguciKarakteri = "tzrewsklbvch148567";
        Random random = new Random();
        int duzinaLozinke = 5+random.nextInt(11);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<duzinaLozinke; i++){
            int slucajnaPozicija = random.nextInt(moguciKarakteri.length());
            char slucajanKarakter = moguciKarakteri.charAt(slucajnaPozicija);
            sb.append(slucajanKarakter);
        }
        return sb.toString();
    }
}
