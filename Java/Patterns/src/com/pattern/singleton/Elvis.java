package com.pattern.singleton;

import java.util.Arrays;

public enum Elvis {
    INSTANCE;
    
    private final String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
