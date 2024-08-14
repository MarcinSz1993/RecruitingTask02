package com.marcinsz;

import com.marcinsz.impl.ExampleBlock;
import com.marcinsz.impl.ExampleCompositeBlock;
import com.marcinsz.impl.Wall;
import com.marcinsz.model.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class WallTest {
    Wall wall;
    ExampleBlock block1;
    ExampleBlock block2;
    ExampleBlock block3;
    ExampleBlock block4;

    @BeforeEach
    void setUp() {
        List<Block> exampleBlocks = new ArrayList<>();
        block1 = new ExampleBlock("exampleColor", "exampleMaterial");
        block2 = new ExampleBlock("exampleColor2", "exampleMaterial2");
        block3 = new ExampleBlock("exampleColor3", "exampleMaterial3");
        block4 = new ExampleBlock("exampleColor4", "exampleMaterial4");

        List<Block> exampleCompositeBlocks = new ArrayList<>();
        exampleCompositeBlocks.add(block3);
        exampleCompositeBlocks.add(block4);
        ExampleCompositeBlock compositeBlocks = new ExampleCompositeBlock(exampleCompositeBlocks);

        exampleBlocks.add(block1);
        exampleBlocks.add(block2);
        exampleBlocks.add(compositeBlocks);

        wall = new Wall(exampleBlocks);
    }

    @Test
    public void shouldCorrectlyFindBlockByColorWhenBlockIsNotNested() {
        Optional<Block> actualBlock = wall.findBlockByColor("exampleColor");
        Assertions.assertTrue(actualBlock.isPresent());
        Assertions.assertEquals("exampleColor", actualBlock.get().getColor());
    }

    @Test
    public void shouldCorrectlyFindBlockByColorWhenBlockIsNested() {
        Optional<Block> actualBlock = wall.findBlockByColor("exampleColor4");
        Assertions.assertTrue(actualBlock.isPresent());
        Assertions.assertEquals("exampleColor4", actualBlock.get().getColor());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenColorOfBlockDoesNotExist() {
        Optional<Block> actualBlock = wall.findBlockByColor("notExistingColor");
        Assertions.assertFalse(actualBlock.isPresent());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenListOfBlocksIsEmpty(){
        Wall wall = new Wall(Collections.emptyList());
        Optional<Block> actualBlock = wall.findBlockByColor("exampleColor");
        Assertions.assertFalse(actualBlock.isPresent());
    }

    @Test
    public void shouldCorrectlyFindBlockByMaterialWhenBlockIsNotNested() {
        List<Block> actualBlock = wall.findBlockByMaterial("exampleMaterial");
        Assertions.assertEquals(1, actualBlock.size());
        Assertions.assertEquals("exampleMaterial", actualBlock.getFirst().getMaterial());
    }

    @Test
    public void shouldCorrectlyFindBlockByMaterialWhenBlockIsNested() {
        List<Block> actualBlock = wall.findBlockByMaterial("exampleMaterial4");
        Assertions.assertEquals(1, actualBlock.size());
        Assertions.assertEquals("exampleMaterial4", actualBlock.getFirst().getMaterial());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenMaterialOfBlockDoesNotExist() {
        Optional<Block> actualBlock = wall.findBlockByColor("notExistingMaterial");
        Assertions.assertFalse(actualBlock.isPresent());
    }

    @Test
    public void shouldCorrectlyCountAllElementsOfStructure(){
        int actualAmount = wall.count();
        Assertions.assertEquals(4, actualAmount);
    }

    @Test
    void shouldCountAllElementsCorrectly() {
        int actualCount = wall.count();
        Assertions.assertEquals(4, actualCount);
    }

    @Test
    void shouldCountReturnZeroWhenListIsEmpty(){
        Wall wall = new Wall(Collections.emptyList());
        int actualCount = wall.count();
        Assertions.assertEquals(0,actualCount);
    }
}


