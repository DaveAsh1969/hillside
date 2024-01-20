package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.animation.ModAnimations;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DecayingZombieModel extends GeoModel<DecayingZombieEntity> {
	@Override
	public Identifier getModelResource(DecayingZombieEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "geo/decaying_zombie.geo.json");
	}

	@Override
	public Identifier getTextureResource(DecayingZombieEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "textures/entity/decaying_zombie.png");
	}

	@Override
	public Identifier getAnimationResource(DecayingZombieEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "animations/decaying_zombie.animation.json");
	}

	@Override
	public void setCustomAnimations(DecayingZombieEntity animatable, long instanceId, AnimationState<DecayingZombieEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
			head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);

		}
	}
}