package org.sevennb.ttt.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.utils.ListUtils;

public class NameTag {

    @SubscribeEvent
    public void updateName(TickEvent.PlayerTickEvent event)
    {
        event.player.refreshDisplayName();
    }

    @SubscribeEvent
    public void modifyName(PlayerEvent.NameFormat event)
    {
        if(TTTAddon.DEVELOPERS.contains(event.username)){
            event.displayname = "§3Advanced§4§lTTT §8| §4"+event.username + ListUtils.getRole(event.username);
        }else{
            event.displayname = event.username + ListUtils.getRole(event.username);
        }
    }

}
