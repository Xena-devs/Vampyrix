package dev.based.vampyrix.api.command;

import dev.based.vampyrix.impl.commands.CommandCoords;
import dev.based.vampyrix.api.util.Wrapper;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager implements Wrapper {
    private final ArrayList<Command> commands = new ArrayList<>();

    private String prefix = ":";

    public CommandManager(){
        this.getVampyrix().getEventBus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        commands.addAll(Arrays.asList(
                new CommandCoords()
        ));
    }

    @SubscribeEvent
    public void onChatSent(ClientChatEvent event) {
        String message = event.getMessage();

        if (message.startsWith(getPrefix())) {
            event.setCanceled(true);
            message = message.substring(getPrefix().length());

            if (message.split(" ").length > 0) {
                String name = message.split(" ")[0];
                boolean found = false;

                for (Command command : this.getCommands()) {
                    if (command.getAliases().contains(name.toLowerCase()) || command.getName().equalsIgnoreCase(name)) {
                        mc.ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
                        command.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("not found");
                }
            }
        }
    }

    public ArrayList<Command> getCommands(){
        return commands;
    }

    public String getPrefix(){
        return prefix;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }
}