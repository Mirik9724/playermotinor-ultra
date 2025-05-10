package net.Mirik9724.playermotinor_ultra.commands

import net.Mirik9724.playermonitor_ultra.Linking
import net.Mirik9724.playermonitor_ultra.commands.Commands
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class LinkingCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        // Проверка прав
        if (!sender.hasPermission("pmu.admin")) {
            sender.sendMessage("§cYou don`t have permissions for this command.")
            return true
        }


        if (args.size < 2) {
            sender.sendMessage("§cUsage /pmu <subcommand> <nick or uuid or ip>")
            return true
        }

        val sub = args[0].lowercase()
        val value = args[1]

        val result = when (sub) {
            "name->uuid" -> Commands.getUuidFromName(value, Linking.players)
            "name->ip" -> Commands.getIpFromName(value, Linking.players)
            "uuid->name" -> Commands.getNameFromUuid(value, Linking.players)
            "ip->name" -> Commands.getNameFromIp(value, Linking.players)
            else -> "§cUnderknow subcommnad."
        }

        sender.sendMessage("§aResult: §f$result")
        return true
    }
}
