
package net.mcreator.nokkraprops.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.nokkraprops.item.ItemLogo;
import net.mcreator.nokkraprops.ElementsNoKKrasProps;

@ElementsNoKKrasProps.ModElement.Tag
public class TabRatProps extends ElementsNoKKrasProps.ModElement {
	public TabRatProps(ElementsNoKKrasProps instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabratprops") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemLogo.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
