package nws.mc.nb;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import nws.dev.core.system._File;

@Mod(NekoBan.MOD_ID)
public class NekoBan
{
    public static final String MOD_ID = "nb";
    public static final String ConfigDir = _File.getFileFullPathWithRun("config/"+MOD_ID+"/");
    public NekoBan(IEventBus modEventBus, ModContainer modContainer)
    {
        _File.checkAndCreateDir(ConfigDir);
    }
}
