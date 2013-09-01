package bms;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTent extends Block {

	public BlockTent(int id, Material material, String name) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        
        // Add Solid Block Texture
        func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
	}
	
	public int getRenderType()
    {
        return 42;
    }

	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }

	public boolean getBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, ForgeDirection dir)
	{
		// Return true or false if block is next to this one, and if it is a tent block, or a tent cloth block
		int blockID = par1IBlockAccess.getBlockId(par2 + dir.offsetX, par3 + dir.offsetY, par4 + dir.offsetZ);
		if(blockID == BlocksBMS.tentClothBlock.blockID || blockID == BlocksBMS.tentBlockDoor.blockID)
			return true;
		return false;
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
        	int meta = par1World.getBlockMetadata(x, y, z);
        	switch(meta)
        	{
	        	case 0: // South
	        		par1World.setBlockMetadataWithNotify(x, y, z, 15, 2);
	        		destroyTent(par1World, x, y, z, 0);
	    		break;
	        	case 1: // West
	        		par1World.setBlockMetadataWithNotify(x, y, z, 15, 2);
	        		destroyTent(par1World, x, y, z, 1);
	    		break;
	        	case 2: // North
	        		par1World.setBlockMetadataWithNotify(x, y, z, 15, 2);
	        		destroyTent(par1World, x, y, z, 2);
	    		break;
	        	case 3: // East
	        		par1World.setBlockMetadataWithNotify(x, y, z, 15, 2);
	        		destroyTent(par1World, x, y, z, 3);
	    		break;
	        	case 15:
	        		int dir = getDirection((int)par5EntityPlayer.rotationYaw);
	        		if(dir < 0)
	        			dir = 3;
	        		if(dir > 3)
	        			dir = 0;
	            	if(checkTent(par1World, x, y, z, dir))
	            	{
	            		par1World.setBlockMetadataWithNotify(x, y, z, dir, 2);
	            		buildTent(par1World, x, y, z, dir);
	            	}
	    		break;
        	}
	        return false;
        }
    }
	
	public int getDirection(int direction)
	{
		int val = Math.round((float)((((direction) % 360) + 360) % 360)  / 90);
		return val;
	}
	
	private boolean checkTent(World world, int x, int y, int z, int direction)
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
			break;
			default:
			break;
		}
		return check;
	}
	
	private boolean checkBlock(World world, int x, int y, int z)
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
			   world.getBlockId(x, y, z) != 2033	// Tent Block
			   )
				value = false;
		return value;
	}
	
	private void buildTent(World world, int x, int y, int z, int direction)
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
								else if(a == 4)
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
								else if(a == 5)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 0)
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(c == 4)
										world.setBlock(i, j, k, BlocksBMS.tentBlockDoor.blockID, 8, 2);
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
								else if(a == 6)
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
									{
										if(c == 4)
											world.setBlock(i, j, k, BlocksBMS.tentBlockDoor.blockID, 0, 2);
									}
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
								else if(a == 4)
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
								else if(a == 5)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 4)
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(c == 0)
										world.setBlock(k, j, i, BlocksBMS.tentBlockDoor.blockID, 9, 2);
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
								else if(a == 6)
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
									{
										if(c == 0)
											world.setBlock(k, j, i, BlocksBMS.tentBlockDoor.blockID, 1, 2);
									}
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
								else if(a == 4)
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
								else if(a == 5)
								{
									world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 4)
										world.setBlock(i, j, k, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(c == 0)
										world.setBlock(i, j, k, BlocksBMS.tentBlockDoor.blockID, 8, 2);
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
								else if(a == 6)
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
									{
										if(c == 0)
											world.setBlock(i, j, k, BlocksBMS.tentBlockDoor.blockID, 2, 2);
									}
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
								else if(a == 4)
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
								else if(a == 5)
								{
									world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 1, 2);
								}
								else if(a == 2 || a == 3 || a == 4)
								{
									if(c == 0)
										world.setBlock(k, j, i, BlocksBMS.tentClothBlock.blockID, (direction * 4) + 3, 2);
									if(c == 4)
										world.setBlock(k, j, i, BlocksBMS.tentBlockDoor.blockID, 9, 2);
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
								else if(a == 6)
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
									{
										if(c == 4)
											world.setBlock(k, j, i, BlocksBMS.tentBlockDoor.blockID, 3, 2);
									}
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

	private void destroyTent(World world, int x, int y, int z, int direction)
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
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a >= 2 && a <= 4)
								{
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a >= 1 && a <= 5)
								{
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 3 && c == 0)
									continue;
								world.setBlock(i, j, k, 0, 0, 2);
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
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a >= 2 && a <= 4)
								{
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a >= 1 && a <= 5)
								{
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 3 && c == 4)
									continue;
								world.setBlock(k, j, i, 0, 0, 2);
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
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a >= 2 && a <= 4)
								{
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a >= 1 && a <= 5)
								{
									world.setBlock(i, j, k, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 3 && c == 4)
									continue;
								world.setBlock(i, j, k, 0, 0, 2);
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
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 2)
							{
								if(a >= 2 && a <= 4)
								{
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 1)
							{
								if(a >= 1 && a <= 5)
								{
									world.setBlock(k, j, i, 0, 0, 2);
								}
								else
									continue;
							}
							else if(b == 0)
							{
								if(a == 3 && c == 0)
									continue;
								world.setBlock(k, j, i, 0, 0, 2);
							}
						}
					}
				}
			break;
			default:
			break;
		}
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 15, 2);
        return par1World.getBlockMetadata(par2, par3, par4);
    }
}
