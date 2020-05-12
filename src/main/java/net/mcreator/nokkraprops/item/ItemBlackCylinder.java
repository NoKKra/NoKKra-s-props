
package net.mcreator.nokkraprops.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBase;

import net.mcreator.nokkraprops.creativetab.TabRatProps;
import net.mcreator.nokkraprops.ElementsNoKKrasProps;

@ElementsNoKKrasProps.ModElement.Tag
public class ItemBlackCylinder extends ElementsNoKKrasProps.ModElement {
	@GameRegistry.ObjectHolder("nokkraprops:blackcylinderhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("nokkraprops:blackcylinderbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("nokkraprops:blackcylinderlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("nokkraprops:blackcylinderboots")
	public static final Item boots = null;
	public ItemBlackCylinder(ElementsNoKKrasProps instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BLACKCYLINDER", "nokkraprops:black_cylinder", 25, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			@SideOnly(Side.CLIENT)
			public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped defaultModel) {
				ModelBiped armorModel = new ModelBiped();
				armorModel.bipedHead = new Modelcylinder().Hat;
				armorModel.isSneak = living.isSneaking();
				armorModel.isRiding = living.isRiding();
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
				return "nokkraprops:textures/cylinder.png";
			}
		}.setUnlocalizedName("blackcylinderhelmet").setRegistryName("blackcylinderhelmet").setCreativeTab(TabRatProps.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("nokkraprops:blackcylinderhelmet", "inventory"));
	}
	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelcylinder extends ModelBase {
		private final ModelRenderer Hat;
		public Modelcylinder() {
			textureWidth = 128;
			textureHeight = 128;
			Hat = new ModelRenderer(this);
			Hat.setRotationPoint(0.0F, 1.0F, 0.0F);
			Hat.cubeList.add(new ModelBox(Hat, 90, 94, -4.7F, -12.0F, -4.75F, 10, 7, 9, 0.0F, false));
			Hat.cubeList.add(new ModelBox(Hat, 42, 115, -5.75F, -5.0F, -5.75F, 12, 1, 11, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Hat.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Hat.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Hat.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
