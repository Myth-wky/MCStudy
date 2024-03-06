package cn.iweekyi.util;

import cn.iweekyi.TestMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * ClassName ModTags
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 20:46
 * Version: 1.0
 */
public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> PROSPECTOR_LIST = createTags("prospector_list");
        private static TagKey<Block> createTags(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TestMod.MODID, name));
        }
    }
    public static class Items{

    }
}
