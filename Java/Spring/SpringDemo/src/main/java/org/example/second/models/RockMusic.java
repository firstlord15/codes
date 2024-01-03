package org.example.second.models;

import org.example.second.interfaces.Music;

public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
