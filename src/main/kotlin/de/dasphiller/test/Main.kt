package de.dasphiller.test

import de.dasphiller.test.commands.createWorldCommand
import net.axay.kspigot.main.KSpigot

class Main : KSpigot() {

    override fun startup() {
        lis
        testCommand
        createWorldCommand
        logger.info("The Plugin was enabled!")
    }

    override fun shutdown() {
        logger.info("The Plugin was disabled!")
    }
}
