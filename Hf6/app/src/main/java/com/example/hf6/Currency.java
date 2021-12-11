package com.example.hf6;

import java.io.Serializable;

public class Currency implements Serializable {
        private String currencyShort;
        private String currencyName;
        private double buy;
        private double sell;
        private int image;

        public Currency(String currencyShort, String currencyName, double buy, double sell, int image){
            this.currencyShort = currencyShort;
            this.currencyName = currencyName;
            this.buy = buy;
            this.sell = sell;
            this.image = image;
        }

        public String getCurrencyShort() {
            return currencyShort;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public double getBuy() {
            return buy;
        }

        public double getSell() {
            return sell;
        }

        public int getImage() {
            return image;
        }
}
