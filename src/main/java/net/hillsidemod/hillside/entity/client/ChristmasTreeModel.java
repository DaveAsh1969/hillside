package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.entity.custom.ChristmasTreeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ChristmasTreeModel<T extends ChristmasTreeEntity> extends SinglePartEntityModel<T> {
	private final ModelPart tree;
	private final ModelPart lights;
	private final ModelPart star;

	public ChristmasTreeModel(ModelPart root) {
		this.tree = root.getChild("tree");
		this.lights = root.getChild("lights");
		this.star = root.getChild("star");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData tree = modelPartData.addChild("tree", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData trunk = tree.addChild("trunk", ModelPartBuilder.create().uv(0, 41).cuboid(-1.0F, -48.0F, -1.0F, 2.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-1.0F, -32.0F, -1.0F, 2.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 33).cuboid(-1.0F, -16.0F, -1.0F, 2.0F, 16.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leaves = tree.addChild("leaves", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = leaves.addChild("cube_r1", ModelPartBuilder.create().uv(0, 5).cuboid(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.0041F, -43.7795F, 1.844F, -0.48F, 0.0F, 0.0F));

		ModelPartData cube_r2 = leaves.addChild("cube_r2", ModelPartBuilder.create().uv(0, 6).cuboid(-3.0F, -32.5282F, -5.9281F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-4.0F, -28.5282F, -3.9281F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(-5.0F, -24.5282F, -1.9281F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-6.0F, -19.5282F, 1.0719F, 12.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-7.0F, -14.5282F, 3.0719F, 14.0F, 1.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -7.5282F, 7.0719F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-0.0041F, -9.9718F, -9.0719F, -0.48F, 0.0F, 0.0F));

		ModelPartData cube_r3 = leaves.addChild("cube_r3", ModelPartBuilder.create().uv(0, 10).cuboid(-2.0F, -27.5282F, 20.0719F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-3.0F, -24.5282F, 16.0719F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-4.0F, -20.5282F, 12.0719F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-5.0F, -16.0282F, 8.0719F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-6.0F, -11.0282F, 3.0719F, 12.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(-8.0F, 0.9718F, -6.9281F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-6.0F, -6.0282F, -0.9281F, 14.0F, 1.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-0.0041F, -9.9718F, -9.0719F, 0.48F, 0.0F, 0.0F));

		ModelPartData cube_r4 = leaves.addChild("cube_r4", ModelPartBuilder.create().uv(0, 3).cuboid(19.0F, -28.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(16.0F, -25.5F, -3.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(11.0F, -21.5F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(8.0F, -16.5F, -5.0F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(3.0F, -11.5F, -6.0F, 12.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(-2.0F, -6.5F, -7.0F, 14.0F, 1.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-8.0F, -0.5F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-8.0685F, -9.6761F, 0.0F, 0.0F, 0.0F, -0.48F));

		ModelPartData cube_r5 = leaves.addChild("cube_r5", ModelPartBuilder.create().uv(0, 1).cuboid(-23.0F, -28.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(-21.0F, -25.5F, -3.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-18.0F, -21.5F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-16.0F, -16.5F, -5.0F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-15.0F, -11.5F, -6.0F, 12.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-12.0F, -7.5F, -7.0F, 14.0F, 1.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -0.5F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -9.5F, 0.0F, 0.0F, 0.0F, 0.48F));

		ModelPartData lights = modelPartData.addChild("lights", ModelPartBuilder.create().uv(44, 57).cuboid(9.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 56).cuboid(-14.0F, -7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 36).cuboid(-1.0F, -7.0F, -13.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(52, 41).cuboid(-1.0F, -7.0F, 11.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 56).cuboid(-1.0F, -15.0F, 9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(50, 41).cuboid(-1.0F, -22.0F, 8.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 53).cuboid(-1.0F, -28.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 41).cuboid(-1.0F, -34.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(45, 54).cuboid(-1.0F, -40.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 55).cuboid(-1.0F, -15.0F, -11.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 36).cuboid(-1.0F, -22.0F, -9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(47, 53).cuboid(-1.0F, -28.0F, -8.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(45, 40).cuboid(-1.0F, -35.0F, -6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(43, 54).cuboid(-1.0F, -40.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 36).cuboid(8.0F, -15.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 56).cuboid(7.0F, -21.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 37).cuboid(5.0F, -27.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(49, 51).cuboid(4.0F, -34.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 40).cuboid(2.0F, -40.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 38).cuboid(-11.0F, -15.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(47, 54).cuboid(-10.0F, -21.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(43, 38).cuboid(-9.0F, -28.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 53).cuboid(-7.0F, -35.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(43, 38).cuboid(-4.0F, -40.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData star = modelPartData.addChild("star", ModelPartBuilder.create().uv(49, 39).cuboid(-0.5F, -56.0F, -0.5F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r6 = star.addChild("cube_r6", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, -0.7854F, 0.0F, -0.7854F));

		ModelPartData cube_r7 = star.addChild("cube_r7", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, 0.7854F, 0.0F, -0.7854F));

		ModelPartData cube_r8 = star.addChild("cube_r8", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData cube_r9 = star.addChild("cube_r9", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, -0.7854F, 0.0F, 0.7854F));

		ModelPartData cube_r10 = star.addChild("cube_r10", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, -0.7854F, 0.0F, -1.5708F));

		ModelPartData cube_r11 = star.addChild("cube_r11", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, 0.7854F, 0.0F, 0.7854F));

		ModelPartData cube_r12 = star.addChild("cube_r12", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r13 = star.addChild("cube_r13", ModelPartBuilder.create().uv(49, 39).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, -1.5708F, 0.0F, 1.5708F));

		ModelPartData cube_r14 = star.addChild("cube_r14", ModelPartBuilder.create().uv(50, 51).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, -0.7854F, 0.0F, 1.5708F));

		ModelPartData cube_r15 = star.addChild("cube_r15", ModelPartBuilder.create().uv(49, 39).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(ChristmasTreeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		tree.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		lights.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		star.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return tree;
	}
}