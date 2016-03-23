package com.derf.ei.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;
import com.derf.ei.crafting.EIInfuserRecipe;
import com.derf.ei.crafting.EIInfuserRecipeManager;

public class EIGuiOverlayElementalInfuserCraftingHandler {

	
	private boolean show = false;
	private EITileEntityElementalInfuser currentInfuser = null;
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Pre e) {	
	
	}
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post e) {
		/*
		if(show && currentInfuser != null) {
			EIInfuserRecipe recipe = EIInfuserRecipeManager.get(currentInfuser.getRecipe());
			
			ItemStack finished = recipe.getCraftedItem();
			
			this.renderIcon(finished, 32.0, 32.0, 32.0, 32.0);
		}
		*/
	}
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent e) {
	}
	
	
	public boolean isShown() {
		return show;
	}
	
	public void setShown(boolean show) {
		this.show = show;
	}
	
	public void setCurrentInfuser(EITileEntityElementalInfuser currentInfuser) {
		this.currentInfuser = currentInfuser;
	}
	
	private void renderIcon(ItemStack stack, double x, double y, double width, double height) {
		/*Minecraft mc = Minecraft.getMinecraft();
		
		IBakedModel model = mc.getRenderItem().getItemModelMesher().getItemModel(stack);
		TextureAtlasSprite sprite = model.getParticleTexture();
		
		mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
		
		Tessellator tess = Tessellator.getInstance();
		WorldRenderer wr = tess.getWorldRenderer();
		
		//wr.begin(7, DefaultVertexFormats.);
		*/
	}
}
