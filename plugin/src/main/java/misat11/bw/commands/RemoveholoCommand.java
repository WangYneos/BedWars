package misat11.bw.commands;

import static misat11.lib.lang.I18n.i18n;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import misat11.bw.Main;

public class RemoveholoCommand extends BaseCommand {
	
	public RemoveholoCommand() {
		super("removeholo", ADMIN_PERMISSION, false);
	}

	@Override
	public boolean execute(CommandSender sender, List<String> args) {
		Player player = (Player) sender;
		if (!Main.isHologramsEnabled()) {
			player.sendMessage(i18n("holo_not_enabled"));
		} else {
			player.setMetadata("bw-remove-holo", new FixedMetadataValue(Main.getInstance(), true));
			player.sendMessage(i18n("click_to_holo_for_remove"));
		}
		return true;
	}

	@Override
	public void completeTab(List<String> completion, CommandSender sender, List<String> args) {
		// TODO Auto-generated method stub
		
	}

}
