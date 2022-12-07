package net.fabricmc.example;// Created 2023-23-01T16:52:15

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

/**
 * @author KJP12
 * @since ${version}
 **/
public interface ExampleInterface {
    BlockState example$getExampleState(BlockPos pos);

    void example$setExampleState(BlockPos pos, BlockState state);

    static ExampleInterface of() {
        return new ExampleInterface() {
            private BlockState backing = Blocks.AIR.getDefaultState();

            @Override
            public BlockState example$getExampleState(final BlockPos pos) {
                return backing;
            }

            @Override
            public void example$setExampleState(final BlockPos pos, final BlockState state) {
                this.backing = state;
            }
        };
    }
}
