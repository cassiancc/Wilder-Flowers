package cc.cassian.wilderflowers;

//? fabric || unobf {
import cc.cassian.wilderflowers.fabric.FabricPlatformImpl;
//?}
//? neoforge {
/*import cc.cassian.wilderflowers.neoforge.NeoForgePlatformImpl;
*///?}
import java.nio.file.Path;

public interface Platform {

    //? fabric || unobf {
    Platform INSTANCE = new FabricPlatformImpl();
    //?}
    //? neoforge {
    /*Platform INSTANCE = new NeoForgePlatformImpl();
    *///?}


    boolean isModLoaded(String modid);
    String loader();
    Path getConfigDir();
    boolean isDevelopment();

}
