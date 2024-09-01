package nyxana.doublearrows;

import java.util.logging.Level;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DoubleArrows extends JavaPlugin {
    public static final String TAG = "§8[§6Double Arrows§8] §f";

    public void onEnable() {
        getServer().getLogger().log(Level.INFO, DoubleArrows.TAG + "Double Arrows is now enabled");
        getServer().getPluginManager().registerEvents(new Listeners(), (Plugin)this);
        getCommand("doublearrows").setExecutor(new Commands());
    }

    public void onDisable() {
        getServer().getLogger().log(Level.INFO, DoubleArrows.TAG + "Double Arrows is now disabled");
    }

    public static Boolean isEnabled = Boolean.valueOf(false);
}

