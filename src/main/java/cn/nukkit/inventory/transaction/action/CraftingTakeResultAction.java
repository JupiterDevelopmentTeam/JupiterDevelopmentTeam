package cn.nukkit.inventory.transaction.action;

import cn.nukkit.Player;
import cn.nukkit.inventory.transaction.CraftingTransaction;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.item.Item;

public class CraftingTakeResultAction extends InventoryAction {

	public CraftingTakeResultAction(Item sourceItem, Item targetItem) {
		super(sourceItem, targetItem);
	}

	public void onAddToTransaction(InventoryTransaction transaction) {
		if (transaction instanceof CraftingTransaction) {
			((CraftingTransaction) transaction).setPrimaryOutput(this.sourceItem);
		}
	}

	@Override
	public boolean isValid(Player source) {
		return true;
	}

	@Override
	public boolean execute(Player source) {
		return true;
	}

	@Override
	public void onExecuteSuccess(Player source) {

	}

	@Override
	public void onExecuteFail(Player source) {

	}
}
