package net.hillsidemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BrickOvenScreen extends HandledScreen<BrickOvenScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(Hillside.MOD_ID, "textures/gui/brick_oven_gui.png");

    public BrickOvenScreen(BrickOvenScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title))/2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);
        renderFuelFlame(matrices, x, y);
    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 80, y + 35, 176, 15, handler.getScaledProgress(),16);
        }
    }

    private void renderFuelFlame(MatrixStack matrices, int x, int y) {
        if(handler.hasFuel()) {
            Integer yVar = 14 - handler.getFuelProgress();
            drawTexture(matrices, x + 56, y + 36 + yVar, 176, yVar, 14, handler.getFuelProgress());
        }
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
