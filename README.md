# commandapi-unicode-argument

[日本語](README_ja.md)

This library adds a method for Unicode input in [CommandAPI](https://github.com/CommandAPI/CommandAPI).

The arguments in CommandAPI, due to [Brigadier](https://github.com/Mojang/brigadier)'s specifications, required Unicode input to be either enclosed in double quotes when using TextArgument or handled with GreedyStringArgument.

## image

![](images/unicode-argument.png)

## setup

`build.gradle.kts`
```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("dev.jorel:commandapi-bukkit-shade:10.0.0")
    implementation("dev.jorel:commandapi-bukkit-kotlin:10.0.0")
    implementation("com.github.tedo0627.commandapi-unicode-argument:core:1.0.0")
    implementation("com.github.tedo0627.commandapi-unicode-argument:kotlin:1.0.0")
}
```

## usage

`java`
```java
CommandAPICommand command = new CommandAPICommand("my-command");
command.withArguments(new UnicodeArgument("unicode"));
command.executesPlayer((player, args) -> {
    String input = args.getOrDefaultUnchecked(0, "");
    player.sendMessage("your input is " + input);
});
```

`kotlin`
```kotlin
val command = CommandAPICommand("my-command")
command.unicodeArgument("unicode")
command.playerExecutor { player, args ->
    val input = args.getOrDefaultUnchecked(0, "")
    player.sendMessage("your input is $input")
}
```