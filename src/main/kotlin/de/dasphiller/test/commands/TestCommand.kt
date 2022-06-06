package de.dasphiller.test

import de.dasphiller.extensions.extensions.*
import de.dasphiller.extensions.message.Message
import de.dasphiller.extensions.message.MessagePrefix
import net.axay.kspigot.commands.argument
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import org.bukkit.Material

val testCommand = command("testcommand") {
    literal("under") {
        runs {
            if (player.getUnderMaterial() == Material.GRASS_BLOCK) {
                INSTANCE.logger.info("test")
                Message(
                    MessagePrefix.DEFAULT,
                    "test"
                ).sendPlayerMessage(player = player)
            }
        }
    }
    literal("boost") {
        argument<Double>("high") {
            runs {
                player.boost(0.0, getArgument("high"), 0.0)
            }
        }
    }
}