package bms;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;

public class BMSFlowerWorldGenerator implements IWorldGenerator {
	
	public WorldGenerator flaxGen;
	public BMSFlowerWorldGenerator() {
		this.flaxGen = new WorldGenFlowers(BlocksBMS.flax.blockID);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateSurface(World world, Random random, int chunk_X, int chunk_Z) {
        int k;
		int i1;
		int l;
		int flowersPerChunk = 2;

        boolean doGen = TerrainGen.decorate(world, random, chunk_X, chunk_Z, FLOWERS);
        for (int j = 0; doGen && j < flowersPerChunk; ++j)
        {
            k = chunk_X + random.nextInt(16) + 8;
            l = random.nextInt(128);
            i1 = chunk_Z + random.nextInt(16) + 8;
            this.flaxGen.generate(world, random, k, l, i1);
        }
	}
}
