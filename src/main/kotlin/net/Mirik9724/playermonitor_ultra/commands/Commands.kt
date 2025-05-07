package net.Mirik9724.playermonitor_ultra.commands

object Commands{
    fun getUuidFromName(name: String): String {
        val record = players[name] ?: return "Ник не найден"
        val sorted = record.uuids.entries.sortedByDescending { it.value }
        return sorted.firstOrNull()?.key ?: "UUID не найден"
    }

    fun getIpFromName(name: String): String {
        val record = players[name] ?: return "Ник не найден"
        val sorted = record.ips.entries.sortedByDescending { it.value }
        return sorted.firstOrNull()?.key ?: "IP не найден"
    }

    fun getNameFromUuid(uuid: String): String {
        return players.entries.firstOrNull { it.value.uuids.containsKey(uuid) }?.key ?: "Ник не найден"
    }

    fun getNameFromIp(ip: String): String {
        return players.entries.firstOrNull { it.value.ips.containsKey(ip) }?.key ?: "Ник не найден"
    }
}