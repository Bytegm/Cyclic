package com.lothrazar.cyclic.block.sprinkler;

import com.lothrazar.cyclic.base.FluidTankBase;
import com.lothrazar.cyclic.base.TileEntityBase;
import com.lothrazar.cyclic.block.terrasoil.TileTerraPreta;
import com.lothrazar.cyclic.registry.TileRegistry;
import com.lothrazar.cyclic.util.UtilShape;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class TileSprinkler extends TileEntityBase implements ITickableTileEntity {

  public static final int CAPACITY = FluidAttributes.BUCKET_VOLUME;
  private static final int TIMER_FULL = 40;
  private static final int WATERCOST = 50;
  private static final int RAD = 4;
  public FluidTankBase tank;
  private int shapeIndex = 0;

  public TileSprinkler() {
    super(TileRegistry.SPRINKLER.get());
    tank = new FluidTankBase(this, CAPACITY, p -> p.getFluid() == Fluids.WATER);
  }

  @Override
  public void tick() {
    timer--;
    if (timer > 0) {
      return;
    }
    timer = TIMER_FULL;
    this.grabWater();
    if (tank.isEmpty() || tank.getFluidAmount() < WATERCOST) {
      return;
    }
    if (tank.getFluidAmount() < WATERCOST) {
      return;
    }
    List<BlockPos> shape = UtilShape.squareHorizontalFull(pos, RAD);
    shapeIndex++;
    if (shapeIndex >= shape.size()) {
      shapeIndex = 0;
    }
    final double d = 0.001;
    if (TileTerraPreta.grow(world, shape.get(shapeIndex), d)) {
      tank.drain(WATERCOST, FluidAction.EXECUTE);
      //it worked
    }
  }

  private void grabWater() {
    //only drink from below. similar to but updated from 1.12.2
    BlockState down = world.getBlockState(pos.down());
    if (tank.isEmpty() && down.getBlock() == Blocks.WATER
        && down.getFluidState().isSource()) {
      tank.fill(new FluidStack(Fluids.WATER, CAPACITY), FluidAction.EXECUTE);
      world.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
    }
  }

  @Override
  public void read(BlockState bs, CompoundNBT tag) {
    CompoundNBT fluid = tag.getCompound("fluid");
    tank.readFromNBT(fluid);
    shapeIndex = tag.getInt("shapeIndex");
    super.read(bs, tag);
  }

  @Override
  public CompoundNBT write(CompoundNBT tag) {
    CompoundNBT fluid = new CompoundNBT();
    tank.writeToNBT(fluid);
    tag.put("fluid", fluid);
    tag.putInt("shapeIndex", shapeIndex);
    return super.write(tag);
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
      return LazyOptional.of(() -> tank).cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void setFluid(FluidStack fluid) {
    tank.setFluid(fluid);
  }

  @Override
  public void setField(int field, int value) {}

  @Override
  public int getField(int field) {
    return 0;
  }
}