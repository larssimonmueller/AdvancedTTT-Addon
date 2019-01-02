package org.sevennb.ttt;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import org.sevennb.ttt.utils.TextColor;

import java.util.ArrayList;
import java.util.List;

public class TTTAddon extends LabyModAddon {

    public static boolean STATUS = true;
    public static List<String> tests = new ArrayList<String>();

    @Override
    public void onEnable() {
        this.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(String s, String message) {
                if(STATUS){
                    String[] args = message.split(" ");
                    String detectMessage = "";
                    if(args.length != 6){
                        return false;
                    }
                    for(int i = 2; i < 6; i++){
                        if(args[i].equals(null)){
                            return false;
                        }else{
                            detectMessage = detectMessage+args[i]+" ";
                        }
                    }
                    System.out.println(detectMessage);
                    if(detectMessage.equalsIgnoreCase("hat den Traitor-Tester betreten ")){
                        String playername = args[1];
                        System.out.println("Spieler im Tester: "+playername);
                        if(!tests.contains(playername)){
                            tests.add(playername);
                        }
                    }
                    return false;
                }
                return false;
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
