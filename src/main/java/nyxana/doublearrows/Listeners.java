package nyxana.doublearrows;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.event.inventory.PrepareItemCraftEvent;


public class Listeners implements Listener {
    @EventHandler
    public void OnCraft(PrepareItemCraftEvent event) {
        if (DoubleArrows.isEnabled.booleanValue() == true)
            if (event.getRecipe().getResult().getType() == Material.ARROW)
                event.getInventory().getResult().setAmount(event.getInventory().getResult().getAmount() * 2);
    }
}
