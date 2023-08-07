import gregtech.api.metatileentity.MetaTileEntity
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity
import gregtech.api.metatileentity.multiblock.IMultiblockPart
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController
import gregtech.api.pattern.BlockPattern
import gregtech.api.pattern.FactoryBlockPattern
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.builders.SimpleRecipeBuilder
import gregtech.client.renderer.ICubeRenderer

import gregtech.client.renderer.texture.Textures
import gregtech.common.blocks.BlockGlassCasing
import gregtech.common.blocks.BlockMachineCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.api.unification.material.Materials;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.metatileentity.multiblock.*

import net.minecraft.init.Blocks
import net.minecraft.util.ResourceLocation

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;

public class MetaTileEntityEnergyPacker extends RecipeMapMultiblockController {

    private static final RecipeMap<SimpleRecipeBuilder> EPACKER_RECIPES = new RecipeMap<>("energy_packer", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)


    public MetaTileEntityEnergyPacker(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPACKER_RECIPES)
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityEnergyPacker(metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  C  ", " GGG ", " GAG ", " GGG ", "  C  ")
                .aisle(" CCC ", "G###G", "G#F#G", "G###G", " CCC ")
                .aisle("CCCCC", "G#F#G", "AF#FA", "G#F#G", "CCCCC")
                .aisle(" CCC ", "G###G", "G#F#G", "G###G", " CCC ")
                .aisle("  C  ", " GGG ", " GSG ", " GGG ", "  C  ")
                .where('S' as char, selfPredicate())
                .where('G' as char, states(getCasingState2()))
                .where('C' as char, states(getCasingState()).or(abilities(MultiblockAbility.INPUT_ENERGY)).or(autoAbilities(false, true, true, true, false, false, false)))
                .where("A" as char, states(getCasingState()))
                .where('#' as char, air())
                .where('F' as char, frames(Materials.Europium))
                .build()
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCYMTextures.ATOMIC_CASING
        }
    private IBlockState getCasingState() {
      return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING)
        }
    private IBlockState getCasingState2() {
      return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS)
        }
}
