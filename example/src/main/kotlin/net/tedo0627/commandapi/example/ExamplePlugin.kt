package net.tedo0627.commandapi.example

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import org.bukkit.plugin.java.JavaPlugin

class ExamplePlugin : JavaPlugin() {

    override fun onLoad() {
        CommandAPI.onLoad(CommandAPIBukkitConfig(this))
    }

    override fun onEnable() {
        CommandAPI.onEnable()

        UnicodeCommand().register()
    }
}