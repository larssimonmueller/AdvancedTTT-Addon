package org.sevennb.ttt.modules;

import net.labymod.main.LabyMod;
import net.labymod.utils.DrawUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.sevennb.ttt.TTTAddon;

public class RolleOverlay {

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e){
        DrawUtils draw = LabyMod.getInstance().getDrawUtils();
        draw.drawCenteredString(TTTAddon.ACTIONBAR, draw.getWidth() / 2, draw.getHeight() - 60);
    }

}
