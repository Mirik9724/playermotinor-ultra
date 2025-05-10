package net.Mirik9724.playermonitor_ultra

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import net.Mirik9724.playermotinor_ultra.commands.LinkingCommand

class PlayerMonitorUltra : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(object : Listener {
            @EventHandler
            fun onJoin(event: PlayerJoinEvent) {
                Linking.handleJoin(event.player)
            }
        }, this)

        getCommand("playermonitor-ultra")?.setExecutor(LinkingCommand())

        logger.info("PlayerMonitor-Ultra - ON")
    }

    override fun onDisable() {
        logger.info("PlayerMonitor-Ultra -  OFF.")
    }
}
