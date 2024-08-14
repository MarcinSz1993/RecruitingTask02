package com.marcinsz.impl;

import com.marcinsz.model.Block;
import com.marcinsz.model.CompositeBlock;
import com.marcinsz.model.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return getAllBlocks(blocks).stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlockByMaterial(String material) {
        return getAllBlocks(blocks).stream()
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    @Override
    public int count() {
        return getAllBlocks(blocks).size();
    }

    private List<Block> getAllBlocks(List<Block> blocks) {
        List<Block> allBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block != null) {
                if (!(block instanceof CompositeBlock)) {
                    allBlocks.add(block);
                } else {
                    allBlocks.addAll(getAllBlocks(((CompositeBlock) block).getBlocks()));
                }
            }
        }
        return allBlocks;
    }
}
