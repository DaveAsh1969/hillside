package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.entity.animation.ModAnimations;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DecayingZombieModel <T extends DecayingZombieEntity> extends SinglePartEntityModel<T> {
	private final ModelPart decaying_zombie;
	private final ModelPart head;

	public DecayingZombieModel(ModelPart root) {
		this.decaying_zombie = root.getChild("decaying_zombie");
		this.head = decaying_zombie.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData decaying_zombie = modelPartData.addChild("decaying_zombie", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = decaying_zombie.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -6.0F, -5.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(3.0F, -5.0F, -5.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(38, 16).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftArm = body.addChild("leftArm", ModelPartBuilder.create().uv(36, 36).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

		ModelPartData rightArm = body.addChild("rightArm", ModelPartBuilder.create().uv(32, 0).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

		ModelPartData leftLeg = body.addChild("leftLeg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

		ModelPartData rightLeg = body.addChild("rightLeg", ModelPartBuilder.create().uv(24, 24).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		decaying_zombie.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return decaying_zombie;
	}

	@Override
	public void setAngles(DecayingZombieEntity entity, float limbAngle, float limbDistance,
						  float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.DECAYING_ZOMBIE_WALK, limbAngle,limbDistance,2.45f, 3f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.DECAYING_ZOMBIE_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.DECAYING_ZOMBIE_ATTACK, animationProgress, 1f);
	}


	private void setHeadAngles(float headYaw, float headPitch)
	{
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.017453292f;
		this.head.pitch = headPitch * 0.017453292f;
	}
}