package com.lothrazar.cyclic.block.user;

import java.lang.ref.WeakReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.base.TileEntityBase;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileUser extends TileEntityBase implements ITickableTileEntity, INamedContainerProvider {

  public static enum Fields {
    REDSTONE, TIMER, TIMERDEL;
  }

  private LazyOptional<IItemHandler> inventory = LazyOptional.of(this::createHandler);
  private WeakReference<FakePlayer> fakePlayer;
  private int timerDelay = 20;

  public TileUser() {
    super(TileRegistry.user);
  }
  //  @Override
  //  public boolean hasFastRenderer() {
  //    return true;
  //  }

  @Override
  public void tick() {
    if (this.requiresRedstone() && !this.isPowered()) {
      return;
    }
    if (!(world instanceof ServerWorld)) {
      return;
    }
    if (timer > 0) {
      timer--;
      return;
    }
    //timer is zero so trigger
    timer = timerDelay;
    if (fakePlayer == null)
      fakePlayer = setupBeforeTrigger((ServerWorld) world, "user");
    try {
      TileEntityBase.tryEquipItem(inventory, fakePlayer, 0);
      ActionResultType result = TileEntityBase.rightClickBlock(fakePlayer, world,
          this.pos.offset(this.getCurrentFacing()));
      if (result == ActionResultType.SUCCESS) {
        //        ModCyclic.LOGGER.info("user result " + result);
        //        this.markDirty();
      }
    }
    catch (Exception e) {
      ModCyclic.LOGGER.error("User action item error", e);
    }
    tryDumpFakePlayerInvo(fakePlayer, false);
  }

  @Override
  public void setField(int field, int value) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        this.needsRedstone = value % 2;
      break;
      case TIMER:
        this.timer = value;
      break;
      case TIMERDEL:
        this.timerDelay = value;
      break;
      default:
      break;
    }
  }

  @Override
  public int getField(int field) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        return this.needsRedstone;
      case TIMER:
        return timer;
      case TIMERDEL:
        return this.timerDelay;
      default:
      break;
    }
    return 0;
  }

  private IItemHandler createHandler() {
    return new ItemStackHandler(1);
  }

  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return inventory.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void read(BlockState bs, CompoundNBT tag) {
    timerDelay = tag.getInt("delay");
    inventory.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(tag.getCompound("inv")));
    super.read(bs, tag);
  }

  @Override
  public CompoundNBT write(CompoundNBT tag) {
    tag.putInt("delay", timerDelay);
    inventory.ifPresent(h -> {
      CompoundNBT compound = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
      tag.put("inv", compound);
    });
    return super.write(tag);
  }

  @Override
  public ITextComponent getDisplayName() {
    return new StringTextComponent(getType().getRegistryName().getPath());
  }

  @Nullable
  @Override
  public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    return new ContainerUser(i, world, pos, playerInventory, playerEntity);
  }
}
