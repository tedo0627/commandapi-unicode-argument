package net.tedo0627.commandapi.kotlindsl

import dev.jorel.commandapi.CommandAPICommand
import net.tedo0627.commandapi.UnicodeArgument

inline fun CommandAPICommand.unicodeArgument(nodeName: String, optional: Boolean = false, block: UnicodeArgument.() -> Unit = {}): CommandAPICommand {
    val argument = UnicodeArgument(nodeName)
    argument.setOptional(optional)
    argument.apply(block)
    return withArguments(argument)
}
