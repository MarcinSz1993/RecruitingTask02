package com.marcinsz.impl;

import com.marcinsz.model.Block;

public class ExampleBlock implements Block {
    private final String color;
    private final String material;

    public ExampleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
