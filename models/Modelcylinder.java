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