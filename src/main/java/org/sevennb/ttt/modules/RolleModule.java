package org.sevennb.ttt.modules;

import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class RolleModule extends SimpleModule {

    public static String rolle = "-";

    @Override
    public String getDisplayName() {
        return "Rolle";
    }

    @Override
    public String getDisplayValue() {
        return rolle;
    }

    @Override
    public String getDefaultValue() {
        return "?";
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
        return "Rolle";
    }

    @Override
    public String getDescription() {
        return "Zeigt die aktuelle Rolle";
    }

    @Override
    public int getSortingId() {
        return 2;
    }
}
