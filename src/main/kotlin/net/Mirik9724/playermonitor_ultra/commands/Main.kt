package net.Mirik9724.playermotinor_ultra.commands

import net.Mirik9724.playermonitor_ultra.Linking
import net.Mirik9724.playermonitor_ultra.commands.Commands
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class LinkingCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size < 2) {
            sender.sendMessage("§cИспользование: /linking <subcommand> <value>")
            return true
        }

        val sub = args[0].lowercase()
        val value = args[1]

        val result = when (sub) {
            "uuid->name" -> Commands.getUuidFromName(value, Linking.players)
            "ip->name" -> Commands.getIpFromName(value, Linking.players)
            "name->uuid" -> Commands.getNameFromUuid(value, Linking.players)
            "name->ip" -> Commands.getNameFromIp(value, Linking.players)
            else -> "§cНеизвестная подкоманда."
        }

        sender.sendMessage("§aРезультат: §f$result")
        return true
    }
}
