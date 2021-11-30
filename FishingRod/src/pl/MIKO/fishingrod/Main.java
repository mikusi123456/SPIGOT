package pl.MIKO.fishingrod;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
    public void onPlayerHitFishingRodEventThingyName(final PlayerFishEvent event) {
        final Player p = event.getPlayer();
        if (event.getCaught() instanceof Player) {
            Player c = (Player)event.getCaught();
            if (p.getItemInHand().getType() == Material.FISHING_ROD) {
                Vector direction = p.getLocation().toVector().subtract(c.getLocation().toVector()).normalize();
                c.setVelocity(new Vector(0, 2, 1));
                c.setVelocity(direction.multiply(0.75));
            }
        }
    }

}
