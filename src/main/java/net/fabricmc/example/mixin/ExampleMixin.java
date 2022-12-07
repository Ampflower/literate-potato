package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleInterface;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		var self = BlockPos.ORIGIN;

		var example = ExampleInterface.of();

		var possiblyStone = example.example$getExampleState(self);

		if(possiblyStone.isOf(Blocks.STONE)) {
			example.example$setExampleState(self, Blocks.AIR.getDefaultState());
		}
	}
}
