package de.dasphiller.test.commands

import de.dasphiller.extensions.extensions.createWorld
import net.axay.kspigot.commands.argument
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs
import net.axay.kspigot.commands.suggestListSuspending
import org.bukkit.World

val createWorldCommand = command("createworld") {
    argument<String>("world_name") {
        argument<World.Environment>("enviroment") {
            World.Environment.values().forEach { en ->
                suggestListSuspending { listOf(en.name) }
            }
            runs {
                createWorld(getArgument("world_name"), getArgument("enviroment"))
            }
        }
    }
}