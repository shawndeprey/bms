package bms;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BMSOreWorldGenerator implements IWorldGenerator{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		break;
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		for(int a = 0; a < 10; a++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(48);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.titaniumOre.blockID, 7)).generate(world, random, xCoord, yCoord, zCoord);
		}
		for(int b = 0; b < 10; b++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.adamantiumOre.blockID, 3)).generate(world, random, xCoord, yCoord, zCoord);
		}
		for(int c = 0; c < 10; c++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.rubyOre.blockID, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
		for(int d = 0; d < 10; d++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.sapphireOre.blockID, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
		for(int e = 0; e < 10; e++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.citrineOre.blockID, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
		for(int f = 0; f < 10; f++)
		{
			int xCoord = i + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = j + random.nextInt(16);
			(new WorldGenMinable(Bms.jadeiteOre.blockID, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
