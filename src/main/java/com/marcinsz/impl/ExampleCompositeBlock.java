package com.marcinsz.impl;

import com.marcinsz.model.Block;
import com.marcinsz.model.CompositeBlock;

import java.util.List;

public class ExampleCompositeBlock implements CompositeBlock {
    private final List<Block> blocks;

    public ExampleCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public String getMaterial() {
        return "";
    }
}
