package com.marcinsz.model;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
