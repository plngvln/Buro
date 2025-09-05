package net.p4pingvin4ik.buro.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Buro")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean isModEnabled = true;
}
