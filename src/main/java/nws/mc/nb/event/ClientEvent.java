package nws.mc.nb.event;

import nws.mc.nb.NekoBan;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import nws.mc.nb.config.Configs;
import nws.mc.nb.listener.PackListener;

@EventBusSubscriber(modid = NekoBan.MOD_ID)
public class ClientEvent {
    @SubscribeEvent
    public static void onReloadListener(AddReloadListenerEvent event){
        if (Configs.I.getDatas().outputDataPack) event.addListener(new PackListener());
    }
}
