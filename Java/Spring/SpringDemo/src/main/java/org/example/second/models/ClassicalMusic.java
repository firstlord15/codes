package org.example.second.models;

import org.example.second.interfaces.Music;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Phapsody";
    }
}
