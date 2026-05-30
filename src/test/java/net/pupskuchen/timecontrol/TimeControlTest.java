package net.pupskuchen.timecontrol;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.File;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

public class TimeControlTest {
    private ServerMock server;

    static {
        System.setProperty("bstats.relocatecheck", "false");
    }

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    public void onEnable() {
        TimeControl plugin = MockBukkit.load(TimeControl.class);
        assertNotNull(plugin.getTCLogger(), "Logger should be initialised");
        assertNotNull(plugin.getConfigHandler(), "ConfigHandler should be initialised");
        assertNotNull(plugin.getConfigHandler().getWorlds(), "world list must not be null");
    }
}
