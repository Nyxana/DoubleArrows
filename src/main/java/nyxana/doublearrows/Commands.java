package nyxana.doublearrows;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("doublearrows.*")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("on")) {
                    if (DoubleArrows.isEnabled.booleanValue() == true) {
                        sender.sendMessage(DoubleArrows.TAG + "Double Arrows is already §aenabled");
                        if (sender instanceof Player)
                            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.NOTE_PLING, 0.5F, 1.0F);
                    } else {
                        DoubleArrows.isEnabled = Boolean.valueOf(true);
                        Bukkit.broadcastMessage(DoubleArrows.TAG + "Double Arrows is now §aenabled");
                        if (sender instanceof Player)
                            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.NOTE_PLING, 0.5F, 1.0F);
                    }
                } else if (args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("off")) {
                    if (!DoubleArrows.isEnabled.booleanValue()) {
                        sender.sendMessage(DoubleArrows.TAG + "Double Arrows is already §cdisabled");
                        if (sender instanceof Player)
                            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.NOTE_BASS_DRUM, 0.5F, 1.0F);
                    } else {
                        DoubleArrows.isEnabled = Boolean.valueOf(false);
                        Bukkit.broadcastMessage(DoubleArrows.TAG + "Double Arrows is now §cdisabled");
                        for (Player p : Bukkit.getOnlinePlayers())
                            p.playSound(p.getLocation(), Sound.NOTE_PLING, 0.5F, 1.0F);
                    }
                } else if (args[0].equalsIgnoreCase("status") || args[0].equalsIgnoreCase("info")) {
                    if (DoubleArrows.isEnabled.booleanValue() == true) {
                        sender.sendMessage(DoubleArrows.TAG + "Double Arrows is currently §aenabled");
                    } else {
                        sender.sendMessage(DoubleArrows.TAG + "Double Arrows is currently §cdisabled");
                    }
                    if (sender instanceof Player)
                        ((Player)sender).playSound(((Player)sender).getLocation(), Sound.NOTE_PLING, 0.5F, 1.0F);
                } else {
                    sender.sendMessage(DoubleArrows.TAG + "Usage: §c/doublearrows <enable|disable|info>");
                }
            } else {
                sender.sendMessage(DoubleArrows.TAG + "Usage: §c/doublearrows <enable|disable|info>");
            }
        } else {
            sender.sendMessage(DoubleArrows.TAG + "§cYou do not have permission to do that");
        }
        return false;
    }
}
