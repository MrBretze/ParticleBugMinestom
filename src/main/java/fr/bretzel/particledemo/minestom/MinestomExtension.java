package fr.bretzel.particledemo.minestom;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.extensions.Extension;
import net.minestom.server.network.packet.server.play.ParticlePacket;
import net.minestom.server.particle.Particle;
import net.minestom.server.particle.ParticleCreator;

public class MinestomExtension extends Extension {

    @Override
    public void initialize() {
        MinecraftServer.getGlobalEventHandler().addEventCallback(PlayerMoveEvent.class, event -> {
            final Player player = event.getPlayer();
            for (int i = 0; i < 500; i++) {
                ParticlePacket particlePacket = ParticleCreator.createParticlePacket(Particle.DUST, true,
                        player.getPosition().getX(), player.getPosition().getY() + player.getEyeHeight() + (double) i * 0.1, player.getPosition().getZ(), //Coordinate
                        0, 0, 0, 0, 0, binaryWriter -> {
                            binaryWriter.writeFloat((float) 255 / 255);//R
                            binaryWriter.writeFloat((float) 55 / 255);//G
                            binaryWriter.writeFloat((float) 60 / 255);//B
                            binaryWriter.writeFloat(0.1F);//Size
                        });

                player.getPlayerConnection().sendPacket(particlePacket);
            }
        });
    }

    @Override
    public void terminate() {

    }
}
