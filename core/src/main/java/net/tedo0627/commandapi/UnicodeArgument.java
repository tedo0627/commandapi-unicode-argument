package net.tedo0627.commandapi;

import dev.jorel.commandapi.arguments.CustomArgument;
import dev.jorel.commandapi.arguments.ScoreHolderArgument;

public class UnicodeArgument extends CustomArgument<String, String> {

    public UnicodeArgument(String nodeName) {
        super(new ScoreHolderArgument.Single(nodeName), CustomArgumentInfo::input);
    }
}
