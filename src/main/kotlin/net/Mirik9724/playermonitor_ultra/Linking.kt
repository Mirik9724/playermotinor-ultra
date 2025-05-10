package net.Mirik9724.playermonitor_ultra

import com.fasterxml.jackson.module.kotlin.*
import com.fasterxml.jackson.databind.*
import org.bukkit.entity.Player
import java.io.File

data class LastLogin(val uuid: String, val ip: String)
data class PlayerRecord(
    val uuids: MutableMap<String, Int> = mutableMapOf(),
    val ips: MutableMap<String, Int> = mutableMapOf(),
    var last_login: LastLogin = LastLogin("", "")
)

object Linking {

    private val dataFile = File("plugins/PlayerMonitor-Ultra/data.json")
    private val mapper: ObjectMapper = jacksonObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
    var players: MutableMap<String, PlayerRecord> = mutableMapOf()

    init {
        if (!dataFile.exists()) {
            dataFile.parentFile.mkdirs()
            dataFile.writeText("{}")
        }
        players = mapper.readValue(dataFile, mapper.typeFactory.constructMapType(
            MutableMap::class.java, String::class.java, PlayerRecord::class.java
        ))
    }

    fun handleJoin(player: Player) {
        val name = player.name
        val uuid = player.uniqueId.toString()
        val ip = player.address?.address?.hostAddress ?: "unknown"

        val record = players.getOrPut(name) { PlayerRecord() }

        record.uuids[uuid] = record.uuids.getOrDefault(uuid, 0) + 1
        record.ips[ip] = record.ips.getOrDefault(ip, 0) + 1
        record.last_login = LastLogin(uuid, ip)

        players[name] = record
        saveJson()

        println("Игрок $name вошёл с UUID: $uuid и IP: $ip [${record.uuids[uuid]} раз]")
    }

    private fun saveJson() {
        mapper.writeValue(dataFile, players)
    }
}
