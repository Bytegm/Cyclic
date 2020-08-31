package com.lothrazar.cyclic.registry;

import java.util.ArrayList;
import java.util.List;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.base.BlockBase;
import com.lothrazar.cyclic.block.BlockDarkGlass;
import com.lothrazar.cyclic.block.BlockLaunch;
import com.lothrazar.cyclic.block.BlockPeat;
import com.lothrazar.cyclic.block.BlockPeatFuel;
import com.lothrazar.cyclic.block.BlockSound;
import com.lothrazar.cyclic.block.BlockSpikes;
import com.lothrazar.cyclic.block.BlockSpikes.EnumSpikeType;
import com.lothrazar.cyclic.block.FlowerSimpleBlock;
import com.lothrazar.cyclic.block.anvil.BlockAnvilAuto;
import com.lothrazar.cyclic.block.anvil.ContainerAnvil;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.anvilmagma.BlockAnvilMagma;
import com.lothrazar.cyclic.block.anvilmagma.ContainerAnvilMagma;
import com.lothrazar.cyclic.block.anvilmagma.TileAnvilMagma;
import com.lothrazar.cyclic.block.battery.BlockBattery;
import com.lothrazar.cyclic.block.battery.ContainerBattery;
import com.lothrazar.cyclic.block.battery.TileBattery;
import com.lothrazar.cyclic.block.beaconpotion.BlockPotion;
import com.lothrazar.cyclic.block.beaconpotion.ContainerPotion;
import com.lothrazar.cyclic.block.beaconpotion.TilePotion;
import com.lothrazar.cyclic.block.breaker.BlockBreaker;
import com.lothrazar.cyclic.block.breaker.ContainerBreaker;
import com.lothrazar.cyclic.block.breaker.TileBreaker;
import com.lothrazar.cyclic.block.cable.energy.BlockCableEnergy;
import com.lothrazar.cyclic.block.cable.energy.TileCableEnergy;
import com.lothrazar.cyclic.block.cable.fluid.BlockCableFluid;
import com.lothrazar.cyclic.block.cable.fluid.TileCableFluid;
import com.lothrazar.cyclic.block.cable.item.BlockCableItem;
import com.lothrazar.cyclic.block.cable.item.TileCableItem;
import com.lothrazar.cyclic.block.clock.BlockRedstoneClock;
import com.lothrazar.cyclic.block.clock.ContainerClock;
import com.lothrazar.cyclic.block.clock.TileRedstoneClock;
import com.lothrazar.cyclic.block.collectfluid.BlockFluidCollect;
import com.lothrazar.cyclic.block.collectfluid.ContainerFluidCollect;
import com.lothrazar.cyclic.block.collectfluid.TileFluidCollect;
import com.lothrazar.cyclic.block.collectitem.BlockCollector;
import com.lothrazar.cyclic.block.collectitem.ContainerCollector;
import com.lothrazar.cyclic.block.collectitem.TileCollector;
import com.lothrazar.cyclic.block.crafter.BlockCrafter;
import com.lothrazar.cyclic.block.crafter.ContainerCrafter;
import com.lothrazar.cyclic.block.crafter.TileCrafter;
import com.lothrazar.cyclic.block.crate.BlockCrate;
import com.lothrazar.cyclic.block.crate.ContainerCrate;
import com.lothrazar.cyclic.block.crate.TileCrate;
import com.lothrazar.cyclic.block.creativebattery.BlockBatteryInfinite;
import com.lothrazar.cyclic.block.creativebattery.TileBatteryInfinite;
import com.lothrazar.cyclic.block.creativeitem.BlockItemInfinite;
import com.lothrazar.cyclic.block.creativeitem.TileItemInfinite;
import com.lothrazar.cyclic.block.detectorentity.BlockDetector;
import com.lothrazar.cyclic.block.detectorentity.ContainerDetector;
import com.lothrazar.cyclic.block.detectorentity.TileDetector;
import com.lothrazar.cyclic.block.detectoritem.BlockDetectorItem;
import com.lothrazar.cyclic.block.detectoritem.ContainerDetectorItem;
import com.lothrazar.cyclic.block.detectoritem.TileDetectorItem;
import com.lothrazar.cyclic.block.dice.BlockDice;
import com.lothrazar.cyclic.block.dice.TileDice;
import com.lothrazar.cyclic.block.disenchant.BlockDisenchant;
import com.lothrazar.cyclic.block.disenchant.ContainerDisenchant;
import com.lothrazar.cyclic.block.disenchant.TileDisenchant;
import com.lothrazar.cyclic.block.dropper.BlockDropper;
import com.lothrazar.cyclic.block.dropper.ContainerDropper;
import com.lothrazar.cyclic.block.dropper.TileDropper;
import com.lothrazar.cyclic.block.expcollect.BlockExpPylon;
import com.lothrazar.cyclic.block.expcollect.ContainerExpPylon;
import com.lothrazar.cyclic.block.expcollect.TileExpPylon;
import com.lothrazar.cyclic.block.fan.BlockFan;
import com.lothrazar.cyclic.block.fan.ContainerFan;
import com.lothrazar.cyclic.block.fan.TileFan;
import com.lothrazar.cyclic.block.fishing.BlockFisher;
import com.lothrazar.cyclic.block.fishing.TileFisher;
import com.lothrazar.cyclic.block.forester.BlockForester;
import com.lothrazar.cyclic.block.forester.ContainerForester;
import com.lothrazar.cyclic.block.forester.TileForester;
import com.lothrazar.cyclic.block.generator.BlockPeatGenerator;
import com.lothrazar.cyclic.block.generator.ContainerGenerator;
import com.lothrazar.cyclic.block.generator.TilePeatGenerator;
import com.lothrazar.cyclic.block.harvester.BlockHarvester;
import com.lothrazar.cyclic.block.harvester.ContainerHarvester;
import com.lothrazar.cyclic.block.harvester.TileHarvester;
import com.lothrazar.cyclic.block.magnet.BlockMagnet;
import com.lothrazar.cyclic.block.magnet.ContainerMagnet;
import com.lothrazar.cyclic.block.magnet.TileMagnet;
import com.lothrazar.cyclic.block.melter.BlockMelter;
import com.lothrazar.cyclic.block.melter.ContainerMelter;
import com.lothrazar.cyclic.block.melter.TileMelter;
import com.lothrazar.cyclic.block.miner.BlockMiner;
import com.lothrazar.cyclic.block.miner.ContainerMiner;
import com.lothrazar.cyclic.block.miner.TileMiner;
import com.lothrazar.cyclic.block.placer.BlockPlacer;
import com.lothrazar.cyclic.block.placer.ContainerPlacer;
import com.lothrazar.cyclic.block.placer.TilePlacer;
import com.lothrazar.cyclic.block.placerfluid.BlockPlacerFluid;
import com.lothrazar.cyclic.block.placerfluid.ContainerPlacerFluid;
import com.lothrazar.cyclic.block.placerfluid.TilePlacerFluid;
import com.lothrazar.cyclic.block.planter.BlockPlanter;
import com.lothrazar.cyclic.block.planter.ContainerPlanter;
import com.lothrazar.cyclic.block.planter.TilePlanter;
import com.lothrazar.cyclic.block.scaffolding.BlockScaffolding;
import com.lothrazar.cyclic.block.scaffolding.BlockScaffoldingReplace;
import com.lothrazar.cyclic.block.scaffolding.BlockScaffoldingResponsive;
import com.lothrazar.cyclic.block.screen.BlockScreentext;
import com.lothrazar.cyclic.block.screen.ContainerScreentext;
import com.lothrazar.cyclic.block.screen.TileScreentext;
import com.lothrazar.cyclic.block.shapebuilder.BlockStructure;
import com.lothrazar.cyclic.block.shapebuilder.ContainerStructure;
import com.lothrazar.cyclic.block.shapebuilder.TileStructure;
import com.lothrazar.cyclic.block.solidifier.BlockSolidifier;
import com.lothrazar.cyclic.block.solidifier.ContainerSolidifier;
import com.lothrazar.cyclic.block.solidifier.TileSolidifier;
import com.lothrazar.cyclic.block.tank.BlockFluidTank;
import com.lothrazar.cyclic.block.tank.TileTank;
import com.lothrazar.cyclic.block.tankcask.BlockCask;
import com.lothrazar.cyclic.block.tankcask.TileCask;
import com.lothrazar.cyclic.block.trash.BlockTrash;
import com.lothrazar.cyclic.block.trash.TileTrash;
import com.lothrazar.cyclic.block.uncrafter.BlockUncraft;
import com.lothrazar.cyclic.block.uncrafter.TileUncraft;
import com.lothrazar.cyclic.block.user.BlockUser;
import com.lothrazar.cyclic.block.user.ContainerUser;
import com.lothrazar.cyclic.block.user.TileUser;
import com.lothrazar.cyclic.block.wirelessredstone.BlockWirelessRec;
import com.lothrazar.cyclic.block.wirelessredstone.BlockWirelessTransmit;
import com.lothrazar.cyclic.block.wirelessredstone.ContainerTransmit;
import com.lothrazar.cyclic.block.wirelessredstone.TileWirelessRec;
import com.lothrazar.cyclic.block.wirelessredstone.TileWirelessTransmit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

  //not populated in the most ideal way 
  public static List<BlockBase> blocks = new ArrayList<>();
  @ObjectHolder(ModCyclic.MODID + ":solidifier")
  public static Block solidifier;
  @ObjectHolder(ModCyclic.MODID + ":melter")
  public static Block melter;
  @ObjectHolder(ModCyclic.MODID + ":structure")
  public static Block structure;
  @ObjectHolder(ModCyclic.MODID + ":anvil")
  public static Block anvil;
  @ObjectHolder(ModCyclic.MODID + ":anvil_magma")
  public static Block anvil_magma;
  @ObjectHolder(ModCyclic.MODID + ":tank")
  public static BlockFluidTank tank;
  @ObjectHolder(ModCyclic.MODID + ":scaffold_replace")
  public static BlockScaffolding scaffold_replace;
  @ObjectHolder(ModCyclic.MODID + ":scaffold_responsive")
  public static BlockScaffolding scaffold_responsive;
  @ObjectHolder(ModCyclic.MODID + ":scaffold_fragile")
  public static BlockScaffolding scaffold_fragile;
  @ObjectHolder(ModCyclic.MODID + ":harvester")
  public static BlockHarvester harvester;
  @ObjectHolder(ModCyclic.MODID + ":peat_generator")
  public static BlockPeatGenerator peat_generator;
  @ObjectHolder(ModCyclic.MODID + ":peat_unbaked")
  public static BlockPeat peat_unbaked;
  @ObjectHolder(ModCyclic.MODID + ":peat_baked")
  public static BlockPeatFuel peat_baked;
  @ObjectHolder(ModCyclic.MODID + ":breaker")
  public static Block breaker;
  @ObjectHolder(ModCyclic.MODID + ":fan")
  public static Block fan;
  @ObjectHolder(ModCyclic.MODID + ":soundproofing")
  public static Block soundproofing;
  @ObjectHolder(ModCyclic.MODID + ":dark_glass")
  public static BlockDarkGlass dark_glass;
  @ObjectHolder(ModCyclic.MODID + ":trash")
  public static BlockTrash trash;
  @ObjectHolder(ModCyclic.MODID + ":experience_pylon")
  public static BlockExpPylon experience_pylon;
  @ObjectHolder(ModCyclic.MODID + ":collector")
  public static BlockCollector collector;
  @ObjectHolder(ModCyclic.MODID + ":battery")
  public static Block battery;
  @ObjectHolder(ModCyclic.MODID + ":energy_pipe")
  public static Block energy_pipe;
  @ObjectHolder(ModCyclic.MODID + ":spikes_iron")
  public static Block spikes_iron;
  @ObjectHolder(ModCyclic.MODID + ":spikes_curse")
  public static Block spikes_curse;
  @ObjectHolder(ModCyclic.MODID + ":spikes_fire")
  public static Block spikes_fire;
  @ObjectHolder(ModCyclic.MODID + ":fluid_pipe")
  public static Block fluid_pipe;
  @ObjectHolder(ModCyclic.MODID + ":item_pipe")
  public static Block item_pipe;
  @ObjectHolder(ModCyclic.MODID + ":placer")
  public static Block placer;
  @ObjectHolder(ModCyclic.MODID + ":user")
  public static Block user;
  @ObjectHolder(ModCyclic.MODID + ":fisher")
  public static Block fisher;
  @ObjectHolder(ModCyclic.MODID + ":disenchanter")
  public static Block disenchanter;
  @ObjectHolder(ModCyclic.MODID + ":collector_fluid")
  public static Block collector_fluid;
  @ObjectHolder(ModCyclic.MODID + ":detector_entity")
  public static Block detector_entity;
  @ObjectHolder(ModCyclic.MODID + ":detector_item")
  public static Block detector_item;
  @ObjectHolder(ModCyclic.MODID + ":plate_launch")
  public static Block plate_launch;
  @ObjectHolder(ModCyclic.MODID + ":plate_launch_redstone")
  public static Block plate_launch_redstone;
  @ObjectHolder(ModCyclic.MODID + ":wireless_transmitter")
  public static Block wireless_transmitter;
  @ObjectHolder(ModCyclic.MODID + ":wireless_receiver")
  public static Block wireless_receiver;
  @ObjectHolder(ModCyclic.MODID + ":clock")
  public static Block clock;
  @ObjectHolder(ModCyclic.MODID + ":crate")
  public static Block crate;
  @ObjectHolder(ModCyclic.MODID + ":cask")
  public static Block cask;
  @ObjectHolder(ModCyclic.MODID + ":flower_cyan")
  public static Block flower_cyan;
  @ObjectHolder(ModCyclic.MODID + ":placer_fluid")
  public static Block placer_fluid;
  //
  @ObjectHolder(ModCyclic.MODID + ":beacon")
  public static Block beacon;
  @ObjectHolder(ModCyclic.MODID + ":crafter")
  public static Block crafter;
  @ObjectHolder(ModCyclic.MODID + ":battery_infinite")
  public static Block battery_infinite;
  @ObjectHolder(ModCyclic.MODID + ":item_infinite")
  public static Block item_infinite;
  @ObjectHolder(ModCyclic.MODID + ":dice")
  public static Block dice;
  @ObjectHolder(ModCyclic.MODID + ":dropper")
  public static Block dropper;
  @ObjectHolder(ModCyclic.MODID + ":planter")
  public static Block planter;
  @ObjectHolder(ModCyclic.MODID + ":forester")
  public static Block forester;
  @ObjectHolder(ModCyclic.MODID + ":magnet")
  public static Block magnet;
  @ObjectHolder(ModCyclic.MODID + ":miner")
  public static Block miner;
  @ObjectHolder(ModCyclic.MODID + ":screen")
  public static Block screen;
  @ObjectHolder(ModCyclic.MODID + ":uncrafter")
  public static Block uncrafter;
  @ObjectHolder(ModCyclic.MODID + ":mason_cobble")
  public static Block mason_cobble;
  @ObjectHolder(ModCyclic.MODID + ":mason_stone")
  public static Block mason_stone;
  @ObjectHolder(ModCyclic.MODID + ":mason_iron")
  public static Block mason_iron;
  @ObjectHolder(ModCyclic.MODID + ":mason_plate")
  public static Block mason_plate;
  @ObjectHolder(ModCyclic.MODID + ":mason_steel")
  public static Block mason_steel;

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    IForgeRegistry<Block> r = event.getRegistry();
    r.register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("mason_cobble"));
    r.register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("mason_stone"));
    r.register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("mason_iron"));
    r.register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("mason_plate"));
    r.register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("mason_steel"));
    r.register(new BlockAnvilMagma(Block.Properties.create(Material.IRON)).setRegistryName("anvil_magma"));
    r.register(new BlockPotion(Block.Properties.create(Material.IRON)).setRegistryName("beacon"));
    r.register(new BlockCrafter(Block.Properties.create(Material.IRON)).setRegistryName("crafter"));
    r.register(new BlockBatteryInfinite(Block.Properties.create(Material.IRON)).setRegistryName("battery_infinite"));
    r.register(new BlockItemInfinite(Block.Properties.create(Material.IRON)).setRegistryName("item_infinite"));
    r.register(new BlockDice(Block.Properties.create(Material.IRON)).setRegistryName("dice"));
    r.register(new BlockDropper(Block.Properties.create(Material.IRON)).setRegistryName("dropper"));
    r.register(new BlockForester(Block.Properties.create(Material.IRON)).setRegistryName("forester"));
    r.register(new BlockPlanter(Block.Properties.create(Material.IRON)).setRegistryName("planter"));
    r.register(new BlockMagnet(Block.Properties.create(Material.IRON)).setRegistryName("magnet"));
    r.register(new BlockMiner(Block.Properties.create(Material.IRON)).setRegistryName("miner"));
    r.register(new BlockScreentext(Block.Properties.create(Material.IRON)).setRegistryName("screen"));
    r.register(new BlockUncraft(Block.Properties.create(Material.IRON)).setRegistryName("uncrafter"));
    //
    r.register(new BlockPlacerFluid(Block.Properties.create(Material.IRON)).setRegistryName("placer_fluid"));
    r.register(new FlowerSimpleBlock(Block.Properties.create(Material.PLANTS)).setRegistryName("flower_cyan"));
    r.register(new BlockCask(Block.Properties.create(Material.ROCK)).setRegistryName("cask"));
    r.register(new BlockCrate(Block.Properties.create(Material.ROCK)).setRegistryName("crate"));
    r.register(new BlockRedstoneClock(Block.Properties.create(Material.ROCK)).setRegistryName("clock"));
    r.register(new BlockWirelessRec(Block.Properties.create(Material.ROCK)).setRegistryName("wireless_receiver"));
    r.register(new BlockWirelessTransmit(Block.Properties.create(Material.ROCK)).setRegistryName("wireless_transmitter"));
    r.register(new BlockLaunch(Block.Properties.create(Material.ROCK), false).setRegistryName("plate_launch"));
    r.register(new BlockLaunch(Block.Properties.create(Material.ROCK), true).setRegistryName("plate_launch_redstone"));
    r.register(new BlockDetectorItem(Block.Properties.create(Material.ROCK)).setRegistryName("detector_item"));
    r.register(new BlockDetector(Block.Properties.create(Material.ROCK)).setRegistryName("detector_entity"));
    r.register(new BlockUser(Block.Properties.create(Material.ROCK)).setRegistryName("user"));
    r.register(new BlockFisher(Block.Properties.create(Material.ROCK)).setRegistryName("fisher"));
    r.register(new BlockFluidCollect(Block.Properties.create(Material.ROCK)).setRegistryName("collector_fluid"));
    r.register(new BlockDisenchant(Block.Properties.create(Material.ROCK)).setRegistryName("disenchanter"));
    r.register(new BlockSolidifier(Block.Properties.create(Material.ROCK)).setRegistryName("solidifier"));
    r.register(new BlockMelter(Block.Properties.create(Material.ROCK)).setRegistryName("melter"));
    r.register(new BlockBreaker(Block.Properties.create(Material.ROCK)).setRegistryName("breaker"));
    r.register(new BlockScaffolding(Block.Properties.create(Material.WOOD), true).setRegistryName("scaffold_fragile"));
    r.register(new BlockScaffoldingResponsive(Block.Properties.create(Material.WOOD), false).setRegistryName("scaffold_responsive"));
    r.register(new BlockScaffoldingReplace(Block.Properties.create(Material.WOOD)).setRegistryName("scaffold_replace"));
    r.register(new BlockFluidTank(Block.Properties.create(Material.ROCK)).setRegistryName("tank"));
    r.register(new BlockCollector(Block.Properties.create(Material.ROCK)).setRegistryName("collector"));
    r.register(new BlockDarkGlass(Block.Properties.create(Material.EARTH)).setRegistryName("dark_glass"));
    r.register(new BlockExpPylon(Block.Properties.create(Material.ROCK)).setRegistryName("experience_pylon"));
    r.register(new BlockFan(Block.Properties.create(Material.ROCK)).setRegistryName("fan"));
    r.register(new BlockPeatGenerator(Block.Properties.create(Material.ROCK)).setRegistryName("peat_generator"));
    r.register(new BlockPeat(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND)).setRegistryName("peat_unbaked"));
    r.register(new BlockPeatFuel(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND)).setRegistryName("peat_baked"));
    r.register(new BlockSound(Block.Properties.create(Material.ROCK)).setRegistryName("soundproofing"));
    r.register(new BlockTrash(Block.Properties.create(Material.ROCK)).setRegistryName("trash"));
    r.register(new BlockBattery(Block.Properties.create(Material.ROCK)).setRegistryName("battery"));
    r.register(new BlockAnvilAuto(Block.Properties.create(Material.ANVIL)).setRegistryName("anvil"));
    r.register(new BlockCableEnergy(Block.Properties.create(Material.WOOL).sound(SoundType.STONE)).setRegistryName("energy_pipe"));
    r.register(new BlockCableItem(Block.Properties.create(Material.WOOL).sound(SoundType.STONE)).setRegistryName("item_pipe"));
    r.register(new BlockCableFluid(Block.Properties.create(Material.WOOL).sound(SoundType.STONE)).setRegistryName("fluid_pipe"));
    r.register(new BlockSpikes(Block.Properties.create(Material.ROCK), EnumSpikeType.PLAIN).setRegistryName("spikes_iron"));
    r.register(new BlockSpikes(Block.Properties.create(Material.ROCK), EnumSpikeType.FIRE).setRegistryName("spikes_fire"));
    r.register(new BlockSpikes(Block.Properties.create(Material.ROCK), EnumSpikeType.CURSE).setRegistryName("spikes_curse"));
    r.register(new BlockHarvester(Block.Properties.create(Material.ROCK)).setRegistryName("harvester"));
    r.register(new BlockPlacer(Block.Properties.create(Material.ROCK)).setRegistryName("placer"));
    r.register(new BlockStructure(Block.Properties.create(Material.ROCK)).setRegistryName("structure"));
  }

  @SubscribeEvent
  public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
    IForgeRegistry<TileEntityType<?>> r = event.getRegistry();
    //
    r.register(TileEntityType.Builder.create(TileAnvilMagma::new, BlockRegistry.anvil_magma).build(null).setRegistryName("anvil_magma"));
    r.register(TileEntityType.Builder.create(TilePotion::new, BlockRegistry.beacon).build(null).setRegistryName("beacon"));
    r.register(TileEntityType.Builder.create(TileCrafter::new, BlockRegistry.crafter).build(null).setRegistryName("crafter"));
    r.register(TileEntityType.Builder.create(TileBatteryInfinite::new, BlockRegistry.battery_infinite).build(null).setRegistryName("battery_infinite"));
    r.register(TileEntityType.Builder.create(TileItemInfinite::new, BlockRegistry.item_infinite).build(null).setRegistryName("item_infinite"));
    r.register(TileEntityType.Builder.create(TileDice::new, BlockRegistry.dice).build(null).setRegistryName("dice"));
    r.register(TileEntityType.Builder.create(TileDropper::new, BlockRegistry.dropper).build(null).setRegistryName("dropper"));
    r.register(TileEntityType.Builder.create(TileForester::new, BlockRegistry.forester).build(null).setRegistryName("forester"));
    r.register(TileEntityType.Builder.create(TilePlanter::new, BlockRegistry.planter).build(null).setRegistryName("planter"));
    r.register(TileEntityType.Builder.create(TileMagnet::new, BlockRegistry.magnet).build(null).setRegistryName("magnet"));
    r.register(TileEntityType.Builder.create(TileMiner::new, BlockRegistry.miner).build(null).setRegistryName("miner"));
    r.register(TileEntityType.Builder.create(TileScreentext::new, BlockRegistry.screen).build(null).setRegistryName("screen"));
    r.register(TileEntityType.Builder.create(TileUncraft::new, BlockRegistry.uncrafter).build(null).setRegistryName("uncrafter"));
    //
    r.register(TileEntityType.Builder.create(TilePlacerFluid::new, BlockRegistry.placer_fluid).build(null).setRegistryName("placer_fluid"));
    r.register(TileEntityType.Builder.create(TileCask::new, BlockRegistry.cask).build(null).setRegistryName("cask"));
    r.register(TileEntityType.Builder.create(TileCrate::new, BlockRegistry.crate).build(null).setRegistryName("crate"));
    r.register(TileEntityType.Builder.create(TileRedstoneClock::new, BlockRegistry.clock).build(null).setRegistryName("clock"));
    r.register(TileEntityType.Builder.create(TileWirelessRec::new, BlockRegistry.wireless_receiver).build(null).setRegistryName("wireless_receiver"));
    r.register(TileEntityType.Builder.create(TileWirelessTransmit::new, BlockRegistry.wireless_transmitter).build(null).setRegistryName("wireless_transmitter"));
    r.register(TileEntityType.Builder.create(TileFluidCollect::new, BlockRegistry.collector_fluid).build(null).setRegistryName("collector_fluid"));
    r.register(TileEntityType.Builder.create(TileDisenchant::new, BlockRegistry.disenchanter).build(null).setRegistryName("disenchanter"));
    r.register(TileEntityType.Builder.create(TileDetectorItem::new, BlockRegistry.detector_item).build(null).setRegistryName("detector_item"));
    r.register(TileEntityType.Builder.create(TileDetector::new, BlockRegistry.detector_entity).build(null).setRegistryName("detector_entity"));
    r.register(TileEntityType.Builder.create(TileSolidifier::new, BlockRegistry.solidifier).build(null).setRegistryName("solidifier"));
    r.register(TileEntityType.Builder.create(TileMelter::new, BlockRegistry.melter).build(null).setRegistryName("melter"));
    r.register(TileEntityType.Builder.create(TileTank::new, BlockRegistry.tank).build(null).setRegistryName("tank"));
    r.register(TileEntityType.Builder.create(TileBreaker::new, BlockRegistry.breaker).build(null).setRegistryName("breaker"));
    r.register(TileEntityType.Builder.create(TileCollector::new, BlockRegistry.collector).build(null).setRegistryName("collector"));
    r.register(TileEntityType.Builder.create(TileFan::new, BlockRegistry.fan).build(null).setRegistryName("fan"));
    r.register(TileEntityType.Builder.create(TileExpPylon::new, BlockRegistry.experience_pylon).build(null).setRegistryName("experience_pylon"));
    r.register(TileEntityType.Builder.create(TileTrash::new, BlockRegistry.trash).build(null).setRegistryName("trash"));
    r.register(TileEntityType.Builder.create(TilePeatGenerator::new, BlockRegistry.peat_generator).build(null).setRegistryName("peat_generator"));
    r.register(TileEntityType.Builder.create(TileBattery::new, BlockRegistry.battery).build(null).setRegistryName("battery"));
    r.register(TileEntityType.Builder.create(TileCableEnergy::new, BlockRegistry.energy_pipe).build(null).setRegistryName("energy_pipe"));
    r.register(TileEntityType.Builder.create(TileCableItem::new, BlockRegistry.item_pipe).build(null).setRegistryName("item_pipe"));
    r.register(TileEntityType.Builder.create(TileCableFluid::new, BlockRegistry.fluid_pipe).build(null).setRegistryName("fluid_pipe"));
    r.register(TileEntityType.Builder.create(TileHarvester::new, BlockRegistry.harvester).build(null).setRegistryName("harvester"));
    r.register(TileEntityType.Builder.create(TileAnvilAuto::new, BlockRegistry.anvil).build(null).setRegistryName("anvil"));
    r.register(TileEntityType.Builder.create(TilePlacer::new, BlockRegistry.placer).build(null).setRegistryName("placer"));
    r.register(TileEntityType.Builder.create(TileStructure::new, BlockRegistry.structure).build(null).setRegistryName("structure"));
    r.register(TileEntityType.Builder.create(TileFisher::new, BlockRegistry.fisher).build(null).setRegistryName("fisher"));
    r.register(TileEntityType.Builder.create(TileUser::new, BlockRegistry.user).build(null).setRegistryName("user"));
  }

  @SubscribeEvent
  public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
    IForgeRegistry<ContainerType<?>> r = event.getRegistry();
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerCollector(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("collector"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerGenerator(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("peat_generator"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerBattery(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("battery"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerHarvester(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("harvester"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerAnvil(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("anvil"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerPlacer(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("placer"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerStructure(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("structure"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerMelter(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("melter"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerSolidifier(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("solidifier"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerBreaker(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("breaker"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerExpPylon(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("experience_pylon"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerUser(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("user"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerDetector(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("detector_entity"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerDetectorItem(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("detector_item"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerDisenchant(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("disenchanter"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerTransmit(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("wireless_transmitter"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerClock(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("clock"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerCrate(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("crate"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerPlacerFluid(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("placer_fluid"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerFluidCollect(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("collector_fluid"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerFan(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("fan"));
    //
    //
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerPotion(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("beacon"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerCrafter(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("crafter"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerDropper(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("dropper"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerForester(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("forester"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerPlanter(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("planter"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerMagnet(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("magnet"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerMiner(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("miner"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerScreentext(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("screen"));
    r.register(IForgeContainerType.create((windowId, inv, data) -> {
      return new ContainerAnvilMagma(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    }).setRegistryName("anvil_magma"));
    //    r.register(IForgeContainerType.create((windowId, inv, data) -> {
    //      return new ContainerUncraft(windowId, ModCyclic.proxy.getClientWorld(), data.readBlockPos(), inv, ModCyclic.proxy.getClientPlayer());
    //    }).setRegistryName("uncrafter"));
  }
}