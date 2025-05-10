package net.Mirik9724.playermonitor_ultra.commands

import net.Mirik9724.playermonitor_ultra.PlayerRecord

object Commands {

    // Получить UUID по нику
    fun getUuidFromName(name: String, players: Map<String, PlayerRecord>): String {
        val record = players[name] ?: return "Nick not found"
        val sorted = record.uuids.entries.sortedByDescending { it.value }
        return sorted.firstOrNull()?.key ?: "UUIDnot found"
    }

    // Получить IP по нику
    fun getIpFromName(name: String, players: Map<String, PlayerRecord>): String {
        val record = players[name] ?: return "Nick not found"
        val sorted = record.ips.entries.sortedByDescending { it.value }
        return sorted.firstOrNull()?.key ?: "IP not found"
    }

    // Получить ник по UUID
    fun getNameFromUuid(uuid: String, players: Map<String, PlayerRecord>): String {
        return players.entries.firstOrNull { it.value.uuids.containsKey(uuid) }?.key ?: "Nick not found"
    }

    // Получить ник по IP
    fun getNameFromIp(ip: String, players: Map<String, PlayerRecord>): String {
        return players.entries.firstOrNull { it.value.ips.containsKey(ip) }?.key ?: "Nick not found"
    }
}
