package org.sevennb.ttt;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ServerData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.MessageUtils;
import org.sevennb.ttt.utils.TextColor;

import java.util.HashMap;
import java.util.List;

public class TTTAddon extends LabyModAddon {

    public static boolean STATUS = true;
    public static HashMap<String, Integer> testlevel = new HashMap<String, Integer>();

    @Override
    public void onEnable() {
        this.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(String s, String message) {
                if((message != null) || (message != "")){
                    try {
                        MessageUtils.execute(message);
                    }catch (Exception e){System.out.println(TextColor.ANSI_RED+e+TextColor.ANSI_RESET);}
                }else{
                    System.out.println("Message ist null!");
                }
                return false;
            }
        });

        this.getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(String message) {
                if((message != null) || (message != "")){
                    try {
                        if (TTTAddon.STATUS) {
                            if (message.equalsIgnoreCase("-start")) {
                                for(EntityPlayerMP entityPlayerMP : MinecraftServer.getServer().getConfigurationManager().getPlayerList()){
                                    String name = entityPlayerMP.getName();
                                    System.out.println("Registriert: "+name);
                                    TTTAddon.testlevel.put(name, 0);
                                    ListUtils.tests.add(name);
                                }
                                return true;
                            }
                            if (message.equalsIgnoreCase("-stop")) {
                                TTTAddon.testlevel.clear();
                                ListUtils.tests.clear();
                                System.out.println("Liste geleert!");
                                return true;
                            }
                            if (message.equalsIgnoreCase("-list")) {
                                System.out.println(ListUtils.getListAsString());
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }catch (Exception e){System.out.println(TextColor.ANSI_RED+e+TextColor.ANSI_RESET);}
                }else{
                    System.out.println("Message ist null!");
                }
                return false;
            }
        });

        this.getApi().getEventManager().registerOnJoin(new Consumer<ServerData>(){

            @Override
            public void accept(ServerData serverData) {
                testlevel.clear();
                System.out.println(TextColor.ANSI_RED+"Leere die Liste!"+TextColor.ANSI_RESET);
            }
        });
        System.out.println(TextColor.ANSI_GREEN+"TTTAddon aktiviert!"+TextColor.ANSI_RESET);
    }

    @Override
    public void onDisable() {
        System.out.println(TextColor.ANSI_RED+"TTTAddon deaktiviert!"+TextColor.ANSI_RESET);
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(List<SettingsElement> subSettings) {
        subSettings.add( new BooleanElement( "Tester-Detect" /* Display name */, new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
            @Override
            public void accept( Boolean accepted ) {
                STATUS = accepted;
                System.out.println("Geänderte Eingabe: "+STATUS);
            }
        }, STATUS) );
    }
}
