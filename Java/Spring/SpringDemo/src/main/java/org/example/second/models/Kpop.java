package org.example.second.models;

import org.example.second.interfaces.Music;

public class Kpop implements Music {
    @Override
    public String getSong() {
        return "itzy wannabe";
    }
}
