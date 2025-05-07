package net.Mirik9724.playermonitor_ultra

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class `PlayerMonitor-Ultra` : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(object : Listener {
            @EventHandler
            fun onJoin(event: PlayerJoinEvent) {
                Linking.handleJoin(event.player)
            }
        }, this)
        logger.info("PlayerMonitor-Ultra - ON")
    }

    override fun onDisable() {
        logger.info("PlayerMonitor-Ultra -  OFF.")
    }
}
