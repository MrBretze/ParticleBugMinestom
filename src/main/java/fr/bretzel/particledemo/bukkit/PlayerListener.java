package fr.bretzel.particledemo.bukkit;


import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        for (int i = 0; i < 500; i++) {
            player.spawnParticle(Particle.REDSTONE, player.getLocation().getX(), player.getLocation().getY() + player.getEyeHeight() + (double) i * 0.1, player.getLocation().getZ(),
                    0,
                    0, 0, 0,
                    0,
                    new org.bukkit.Particle.DustOptions(Color.fromBGR(60, 55, 255), 0.1F));
        }
    }
}
