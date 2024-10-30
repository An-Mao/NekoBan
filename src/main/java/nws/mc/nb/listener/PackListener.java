package nws.mc.nb.listener;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

public class PackListener extends SimplePreparableReloadListener {
    public static final Logger LOG = LogUtils.getLogger();
    private static final FileToIdConverter LISTER = new FileToIdConverter("function", ".mcfunction");
    public PackListener(){}
    @Override
    protected  Object prepare(ResourceManager pResourceManager, ProfilerFiller pProfiler) {
        LOG.debug("------------DATA PACK LIST------------");
        LOG.debug(LISTER.listMatchingResources(pResourceManager).toString());
        return null;
    }

    @Override
    protected void apply(Object pObject, ResourceManager pResourceManager, ProfilerFiller pProfiler) {
    }
}
