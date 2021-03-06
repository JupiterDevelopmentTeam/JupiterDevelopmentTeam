package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.utils.BlockColor;

/**
 * author: Angelic47
 * Nukkit Project
 */
public class BlockGlass extends BlockTransparent {

    public BlockGlass() {
        this(0);
    }

    public BlockGlass(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return GLASS;
    }

    @Override
    public String getName() {
        return "Glass";
    }

    @Override
    public double getResistance() {
        return 1.5;
    }

    @Override
    public BlockColor getColor(){
        return BlockColor.AIR_BLOCK_COLOR;
    }
    
    /* TODO 1.2 カラフルなガラス
    @Override
    public BlockColor getColor() {
        return DyeColor.getByDyedData(meta).getColor();
    }
     */

    @Override
    public double getHardness() {
        return 0.3;
    }

    @Override
    public Item[] getDrops(Item item) {
        return item.isSilkTouch() ? new Item[]{this.toItem()} : new Item[0];
    }
}
