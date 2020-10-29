package com.lothrazar.cyclic.event;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.data.BlockPosDim;
import com.lothrazar.cyclic.item.builder.BuildStyle;
import com.lothrazar.cyclic.item.builder.BuilderItem;
import com.lothrazar.cyclic.item.builder.PacketSwapBlock;
import com.lothrazar.cyclic.item.datacard.LocationGpsCard;
import com.lothrazar.cyclic.item.random.RandomizerItem;
import com.lothrazar.cyclic.util.UtilRender;
import com.lothrazar.cyclic.util.UtilWorld;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventRender {

  @SubscribeEvent
  public void overlay(RenderGameOverlayEvent.Post event) {
    Minecraft mc = Minecraft.getInstance();
    int width = mc.getMainWindow().getScaledWidth();
    int height = mc.getMainWindow().getScaledHeight();
    int posX = (int) mc.player.lastTickPosX;
    int posY = (int) mc.player.lastTickPosY;
    int posZ = (int) mc.player.lastTickPosZ;
    mc.fontRenderer.drawString(event.getMatrixStack(), "Hello world!", width / 2, height / 2, 0xFFFFFF);
  }
  //  @OnlyIn(Dist.CLIENT)
  //  @SubscribeEvent
  //  public void addCustomButtonToInventory(GuiScreenEvent.InitGuiEvent.Post event) {
  //    //
  //    if (event.getGui() instanceof HorseInventoryScreen
  //        && ModCyclic.proxy.getClientPlayer() != null
  //        && ModCyclic.proxy.getClientPlayer().getRidingEntity() != null) {
  //      Entity liv = ModCyclic.proxy.getClientPlayer().getRidingEntity();
  //      if (liv.getPersistentData().contains(ItemHorseEnder.NBT_KEYACTIVE)
  //          && liv.getPersistentData().getInt(ItemHorseEnder.NBT_KEYACTIVE) > 0) {
  //        //
  //        int ct = liv.getPersistentData().getInt(ItemHorseEnder.NBT_KEYACTIVE);
  //        ExtendedButton bt2 = new ExtendedButton(event.getGui().width / 2 + 68,
  //            event.getGui().height / 2 - 80,
  //            //cyclic.carrot_ender.charges
  //            18, 14, new StringTextComponent("" + ct), b -> {
  //              //              if(event.i)
  //              UtilChat.addChatMessage(ModCyclic.proxy.getClientPlayer(), "item.cyclic.carrot_ender.tooltip");
  //              //                  test);
  //            }) {};
  //        event.addWidget(bt2);
  //      }
  //    }
  //  }

  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public void renderOverlay(RenderWorldLastEvent evt) {
    PlayerEntity player = ModCyclic.proxy.getClientPlayer();
    if (player == null) {
      return;
    }
    World world = player.world;
    double range = 6F;
    float alpha = 0.125F * 2;
    Map<BlockPos, Color> mappos = new HashMap<>();
    // could refactor here, three cases
    ///////////////////// BuilderItem
    ItemStack stack = BuilderItem.getIfHeld(player);
    if (stack.getItem() instanceof BuilderItem) {
      BlockRayTraceResult lookingAt = (BlockRayTraceResult) player.pick(range, 0F, false);
      if (!world.isAirBlock(lookingAt.getPos())) {
        BlockPos pos = lookingAt.getPos();
        BuildStyle buildStyle = ((BuilderItem) stack.getItem()).style;
        if (buildStyle.isOffset() && lookingAt.getFace() != null) {
          pos = pos.offset(lookingAt.getFace());
        }
        //NORMAL is blue, REPLACE is yellow, OFFSET is green
        Color col = buildStyle.getColour();
        alpha = 0.4F;
        //now the item has a build area
        List<BlockPos> coordinates = PacketSwapBlock.getSelectedBlocks(world, pos, BuilderItem.getActionType(stack), lookingAt.getFace(), buildStyle);
        for (BlockPos coordinate : coordinates) {
          mappos.put(coordinate, col);
        }
      }
    }
    ///////////////////// RandomizerItem
    stack = RandomizerItem.getIfHeld(player);
    if (stack.getItem() instanceof RandomizerItem) {
      BlockRayTraceResult lookingAt = UtilRender.getLookingAt(player, (int) range);
      if (player.world.getBlockState(lookingAt.getPos()) == Blocks.AIR.getDefaultState()) {
        return;
      }
      List<BlockPos> coords = RandomizerItem.getPlaces(lookingAt.getPos(), lookingAt.getFace());
      for (BlockPos e : coords) {
        mappos.put(e, RandomizerItem.canMove(player.world.getBlockState(e), player.world, e) ? Color.GREEN : Color.RED);
      }
    }
    ///////////////////// LocationGpsItem
    stack = player.getHeldItemMainhand();
    if (stack.getItem() instanceof LocationGpsCard) {
      BlockPosDim loc = LocationGpsCard.getPosition(stack);
      if (loc != null) {
        if (loc.getDimension() == null ||
            loc.getDimension().equalsIgnoreCase(UtilWorld.dimensionToString(world)))
          //    TODO: null dimensions test.  but if its saved and equal then ok 
          mappos.put(loc.getPos(), Color.BLUE);
      }
    }
    // other items added here
    //
    //render the pos->colour map
    if (mappos.keySet().size() > 0) {
      UtilRender.renderColourCubes(evt, mappos, alpha);
    }
  }
}