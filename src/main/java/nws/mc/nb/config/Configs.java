package nws.mc.nb.config;

import com.google.gson.reflect.TypeToken;
import nws.dev.core.json._JsonConfig;
import nws.mc.nb.NekoBan;

public class Configs extends _JsonConfig<ConfigsData> {
    public static final String file =  NekoBan.ConfigDir +"config.json";
    public static final Configs I = new Configs();
    public Configs() {
        super(file, """
                {
                    "outputDataPack": true,
                    "disableExecute": true
                }
                """, new TypeToken<>(){});
    }
}
