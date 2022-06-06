package de.dasphiller.test

import de.dasphiller.extensions.extensions.dropItem
import de.dasphiller.extensions.extensions.spawnEntity
import de.dasphiller.extensions.message.Message
import de.dasphiller.extensions.message.MessagePrefix
import net.axay.kspigot.event.listen
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.player.PlayerJoinEvent

val lis = listen<PlayerJoinEvent> {
    dropItem(it.player.location, Material.ACACIA_BOAT)
    Message(
        MessagePrefix.DEFAULT,
        "test"
    ).sendPlayerMessage(it.player)
}