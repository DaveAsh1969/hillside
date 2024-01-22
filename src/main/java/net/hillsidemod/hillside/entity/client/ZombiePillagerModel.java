package net.hillsidemod.hillside.entity.client;

import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
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
public class ZombiePillagerModel extends GeoModel<ZombiePillagerEntity> {
	@Override
	public Identifier getModelResource(ZombiePillagerEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "geo/zombie_pillager.geo.json");
	}

	@Override
	public Identifier getTextureResource(ZombiePillagerEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "textures/entity/zombie_pillager.png");
	}

	@Override
	public Identifier getAnimationResource(ZombiePillagerEntity animatable) {
		return new Identifier(Hillside.MOD_ID, "animations/zombie_pillager.animation.json");
	}

	/*@Override
	public void setCustomAnimations(ZombiePillagerEntity animatable, long instanceId, AnimationState<ZombiePillagerEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
			head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
		}
	}*/
}