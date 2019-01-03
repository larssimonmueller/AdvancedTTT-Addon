package org.sevennb.ttt.modules;

import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class FalleModule extends SimpleModule {

    public static String falle = "-";

    @Override
    public String getDisplayName() {
        return "Falle aktiviert";
    }

    @Override
    public String getDisplayValue() {
        return falle;
    }

    @Override
    public String getDefaultValue() {
        return "Keine Runde";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.STICK);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Falle gedrückt";
    }

    @Override
    public String getDescription() {
        return "Zeigt an, ob die Falle gedrückt wurde";
    }

    @Override
    public int getSortingId() {
        return 2;
    }

}
