package com.derf.ei.command;

import java.util.ArrayList;
import java.util.List;

import com.derf.ei.entity.EIEntityTNTPrimed;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CommandEI implements ICommand {

	private final List aliases;
	
	public CommandEI() {
		aliases = new ArrayList();
		aliases.add("ei");
	}
	
	@Override
	public int compareTo(ICommand command) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		World world = sender.getEntityWorld();
		
		if(!world.isRemote) {
			
			if(args.length == 0) {
				sender.addChatMessage(new TextComponentString("error: command needs to pass <name,void-exp,explode,...> as a parameter."));
				return;
			}
			
			if(args[0].equals("name")) {
				sender.addChatMessage(new TextComponentString("Your Name: "+sender.getName()));
			} else if(args[0].equals("void-exp")) {
				sender.addChatMessage(new TextComponentString("Voiding xp from " + sender.getName()));
				Entity entity = sender.getCommandSenderEntity();
				if(entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer)entity;
					player.experienceLevel = 0;
					player.experienceTotal = 0;
					player.experience = 0;
					server.updateTimeLightAndEntities();
				}
			} else if(args[0].equals("explode")) {
				Entity entity = sender.getCommandSenderEntity();
				
				world.spawnEntityInWorld(new EIEntityTNTPrimed(world, entity.posX, entity.posY, entity.posZ, (EntityLivingBase) entity, 0));
			}
		}
	}

	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "ei";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/ei <parameter[name(yourname), void-exp(void exp), explode, ...>";
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
