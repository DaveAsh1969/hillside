package net.hillsidemod.screen.slot;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.screen.BrickOvenScreenHandler;
import net.hillsidemod.screen.BrickOvenScreenHandler20;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BrickOvenScreen20 extends HandledScreen<BrickOvenScreenHandler20> {
    private static final Identifier TEXTURE =
            new Identifier(Hillside.MOD_ID, "textures/gui/brick_oven_gui.png");

    public BrickOvenScreen20(BrickOvenScreenHandler20 handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title))/2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        //drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context, x, y);
        renderFuelFlame(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE,x + 80, y + 35, 176, 15, handler.getScaledProgress(),16);
        }
    }

    private void renderFuelFlame(DrawContext context, int x, int y) {
        if(handler.hasFuel()) {
            Integer yVar = 14 - handler.getFuelProgress();
            context.drawTexture(TEXTURE, x + 56, y + 36 + yVar, 176, yVar, 14, handler.getFuelProgress());
        }
    }

    /*private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 80, y + 35, 176, 15, handler.getScaledProgress(),16);
        }
    }

    private void renderFuelFlame(MatrixStack matrices, int x, int y) {
        if(handler.hasFuel()) {
            Integer yVar = 14 - handler.getFuelProgress();
            drawTexture(matrices, x + 56, y + 36 + yVar, 176, yVar, 14, handler.getFuelProgress());
        }
    }*/

    /*@Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }*/

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
