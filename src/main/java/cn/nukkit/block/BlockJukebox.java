package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityJukebox;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemRecord;
import cn.nukkit.math.BlockFace;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.ListTag;

public class BlockJukebox extends BlockSolid {

    public BlockJukebox() {
        this(0);
    }

    public BlockJukebox(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Jukebox";
    }

    @Override
    public int getId() {
        return JUKEBOX;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        BlockEntity blockEntity = this.getLevel().getBlockEntity(this);
        if (blockEntity == null || !(blockEntity instanceof BlockEntityJukebox)) {
            blockEntity = this.createBlockEntity();
        }

        BlockEntityJukebox jukebox = (BlockEntityJukebox) blockEntity;
        if (jukebox.getRecordItem().getId() != 0) {
            jukebox.dropItem();
        } else if (item instanceof ItemRecord) {
            jukebox.setRecordItem(item);
            jukebox.play();
        }

        return false;
    }

    @Override
    public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player) {
        if (super.place(item, block, target, face, fx, fy, fz, player)) {
            createBlockEntity();
            return true;
        }

        return false;
    }

    private BlockEntity createBlockEntity() {
        CompoundTag nbt = new CompoundTag()
                .putList(new ListTag<>("Items"))
                .putString("id", BlockEntity.JUKEBOX)
                .putInt("x", getFloorX())
                .putInt("y", getFloorY())
                .putInt("z", getFloorZ());

        return BlockEntity.createBlockEntity(BlockEntity.JUKEBOX, this.level.getChunk(getFloorX() >> 4, getFloorZ() >> 4), nbt);
    }
}