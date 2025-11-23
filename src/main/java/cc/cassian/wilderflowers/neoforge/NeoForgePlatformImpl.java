package cc.cassian.wilderflowers.neoforge;

//? neoforge {
/*import cc.cassian.wilderflowers.Platform;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class NeoForgePlatformImpl implements Platform {

    @Override
    public boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    @Override
    public String loader() {
        return "neoforge";
    }

    @Override
    public Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

    @Override
    public boolean isDevelopment() {
        //? if <1.21.9 {
        return !FMLEnvironment.production;
        //?} else {
        /^return !FMLEnvironment.isProduction();
        ^///?}
    }

}
*///?}