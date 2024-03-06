package cn.iweekyi;

import cn.iweekyi.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

/**
 * ClassName TestModClient
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/26 2:23
 * Version: 1.0
 */
public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIAMOND_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIAMOND_TRAPDOOR, RenderLayer.getCutout());
    }
}
