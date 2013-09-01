package bms;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class EnumBMS {
	// EnumToolMaterials
	final static EnumToolMaterial TITANIUM = 			EnumHelper.addToolMaterial("TITANIUM", 3, 1561, 8.0F, 3.0F, 10);
	final static EnumToolMaterial ADAMANTIUM = 			EnumHelper.addToolMaterial("ADAMANTIUM", 4, 2500, 10.0F, 4.0F, 25);
	// syntax: (name, durability, reductionAmounts, enchantability)
	// DIAMOND (33, new int[]{3, 8, 6, 3}, 10)
	// CLOTH(5, new int[]{1, 3, 2, 1}, 15)
	// IRON(15, new int[]{2, 6, 5, 2}, 9)
	public static EnumArmorMaterial linenArmorMaterial = EnumHelper.addArmorMaterial("linenArmorMaterial", 33, new int[]{1, 3, 2, 1}, 100);
	public static EnumArmorMaterial reinforcedLeatherArmorMaterial = EnumHelper.addArmorMaterial("reinforcedLeatherArmorMaterial", 10, new int[]{2, 4, 3, 2}, 20);
	public static EnumArmorMaterial titaniumArmorMaterial = EnumHelper.addArmorMaterial("titaniumArmorMaterial", 33, new int[]{3, 8, 6, 3}, 20);
	public static EnumArmorMaterial adamantiumArmorMaterial = EnumHelper.addArmorMaterial("adamantiumArmorMaterial", 50, new int[]{5, 12, 9, 5}, 25);
}
