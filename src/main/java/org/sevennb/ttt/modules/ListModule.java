package org.sevennb.ttt.modules;

import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

public class ListModule extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "Tests ONE";
    }

    @Override
    public String getDisplayValue() {
        return ListUtils.getListAsString(TestLevel.ONE);
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
        return "Tester Liste 1";
    }

    @Override
    public String getDescription() {
        return "Zeigt alle Spieler an die im Tester waren 2";
    }

    @Override
    public int getSortingId() {
        return 2;
    }
}
