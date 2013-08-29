package bms;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlocksTent extends Block {

	public BlocksTent(int id, Material material, String name) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        
        // Add Solid Block Texture
        func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	int dir = getDirection(Math.abs((int)par5EntityPlayer.rotationYaw));
        	if(checkTent(par1World, x, y, z, dir))
        		buildTent(par1World, x, y, z, dir);
        	
	        return false;
        }
    }
	
	public int getDirection(int direction)
	{
		return Math.round((float)(((direction + 45) % 360) / 90));
	}
	
	public boolean checkTent(World world, int x, int y, int z, int direction)
	{
		boolean check = true;
		switch(direction)
		{
			case 0: // South
				for(int i = x - 3, a = 0; i < x + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = z, c = 0; k < z + 5; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2 || a == 3 || a == 4)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a != 0 & a != 6)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(!checkBlock(world, i, j, k))
								{
									check = false;
									break;
								}
							}
						}
					}
				}
			break;
			case 1: // East
				for(int i = z - 3, a = 0; i < z + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = x - 4, c = 0; k <= x; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2 || a == 3 || a == 4)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a != 0 || a != 6)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(!checkBlock(world, k, j, i))
								{
									check = false;
									break;
								}
							}
						}
					}
				}
			break;
			case 2: // North
				for(int i = x - 3, a = 0; i < x + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = z - 4, c = 0; k <= z; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2 || a == 3 || a == 4)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a != 0 || a != 6)
								{
									if(!checkBlock(world, i, j, k))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(!checkBlock(world, i, j, k))
								{
									check = false;
									break;
								}
							}
						}
					}
				}
			break;
			case 3: // West
				for(int i = z - 3, a = 0; i < z + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = x, c = 0; k < x + 5; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2 || a == 3 || a == 4)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a != 0 || a != 6)
								{
									if(!checkBlock(world, k, j, i))
									{
										check = false;
										break;
									}
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(!checkBlock(world, k, j, i))
								{
									check = false;
									break;
								}
							}
						}
					}
				}
			System.out.println("Check West: " + check);
			break;
			default:
			break;
		}
		return check;
	}
	
	public boolean checkBlock(World world, int x, int y, int z)
	{
		boolean value = true;
			if(world.getBlockId(x, y, z) != 0 &&	// Air
			   world.getBlockId(x, y, z) != 6 &&	// Sapling
			   world.getBlockId(x, y, z) != 31 &&	// Tall Grass
			   world.getBlockId(x, y, z) != 32 &&	// Dead Bush
			   world.getBlockId(x, y, z) != 37 &&	// Red Flower
			   world.getBlockId(x, y, z) != 38 &&	// Yellow Flower
			   world.getBlockId(x, y, z) != 39 &&	// Brown Mushroom
			   world.getBlockId(x, y, z) != 40 &&	// Red Mushroom
			   world.getBlockId(x, y, z) != 78 &&	// Snow
			   world.getBlockId(x, y, z) != 115 &&	// Nether Stalk
			   world.getBlockId(x, y, z) != 2033 &&	// Tent Block
			   world.getBlockId(x, y, z) != 2034	// Tent Cloth
			   )
				value = false;
		return value;
	}
	
	public void buildTent(World world, int x, int y, int z, int direction)
	{
		switch(direction)
		{
			case 0: // South
				for(int i = x - 3, a = 0; i < x + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = z, c = 0; k < z + 5; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 4)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 3)
								{
									if(c == 0 || c == 4)
									{
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a == 1)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 5)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 0)
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(a != 3)
										if(c == 4)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 0)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 6)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else
								{
									if(a != 3)
									{
										if(c == 0)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
										if(c == 4)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
							}
						}
					}
				}
			break;
			case 1: // West
				for(int i = z - 3, a = 0; i < z + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = x - 4, c = 0; k <= x; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 4)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 3)
								{
									if(c == 0 || c == 4)
									{
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a == 1)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 5)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 4)
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(a != 3)
										if(c == 0)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 0)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 6)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else
								{
									if(a != 3)
									{
										if(c == 0)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
										if(c == 4)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
							}
						}
					}
				}
			break;
			case 2: // North
				for(int i = x - 3, a = 0; i < x + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = z - 4, c = 0; k <= z; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 4)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 3)
								{
									if(c == 0 || c == 4)
									{
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a == 1)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 5)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 4)
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(a != 3)
										if(c == 0)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 0)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 6)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else
								{
									if(a != 3)
									{
										if(c == 0)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
										if(c == 4)
											world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
							}
						}
					}
				}
			break;
			case 3: // East
				for(int i = z - 3, a = 0; i < z + 4; i++, a++)
				{
					for(int j = y, b = 0; j < y + 4; j++, b++)
					{
						for(int k = x, c = 0; k < x + 5; k++, c++)
						{
							if(b == 3)
							{
								if(a == 3)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a == 2)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 4)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 3)
								{
									if(c == 0 || c == 4)
									{
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a == 1)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 5)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 0)
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(a != 3)
										if(c == 4)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									else
										continue;
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 0)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 2, 2);
								}
								if(a == 6)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else
								{
									if(a != 3)
									{
										if(c == 0)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
										if(c == 4)
											world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									}
									else
										continue;
								}
							}
						}
					}
				}
			break;
			default:
			break;
		}
	}

}
