package net.tedo0627.commandapi.example

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.ArgumentSuggestions
import dev.jorel.commandapi.kotlindsl.integerArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.jorel.commandapi.kotlindsl.subcommand
import net.tedo0627.commandapi.kotlindsl.unicodeArgument

class UnicodeCommand : CommandAPICommand("unicode-example") {

    companion object {
        val UNICODE = listOf(
            "←", "→", "⬆", "⬇", "★", "♠", "♥", "♦", "♣",
            "😊", "🚀", "🎉", "🔥", "🌍"
        )
    }

    init {
        subcommand("sub1") {
            unicodeArgument("unicode")
            playerExecutor { player, args ->
                val input = args.getOrDefault(0, "")
                player.sendMessage("your input is \"$input\"")
            }
        }

        subcommand("sub2") {
            unicodeArgument("unicode") {
                replaceSuggestions(ArgumentSuggestions.stringCollection { suggestion ->
                    val input = suggestion.currentArg
                    return@stringCollection UNICODE.map { input + it }
                })
            }
            playerExecutor { player, args ->
                val input = args.getOrDefault(0, "")
                player.sendMessage("your input is \"$input\"")
            }
        }

        subcommand("sub3") {
            integerArgument("int1")
            unicodeArgument("unicode")
            integerArgument("int2")
            playerExecutor { player, args ->
                val int1 = args.getOrDefault(0, 0)
                val input = args.getOrDefault(1, "")
                val int2 = args.getOrDefault(2, 0)
                player.sendMessage("your input is $int1, \"$input\", $int2")
            }
        }
    }
}