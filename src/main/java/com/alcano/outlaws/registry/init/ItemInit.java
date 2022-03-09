package com.alcano.outlaws.registry.init;

import com.alcano.outlaws.inventory.ItemBuilder;
import com.alcano.outlaws.registry.Register;
import com.alcano.outlaws.registry.RegistryObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemInit {

    public static final Register<ItemStack> ITEMS = new Register<>();

    public static final RegistryObject<ItemStack> TEST_ITEM = ITEMS.register("test_item",
            () -> new ItemBuilder(Material.ALLIUM).name("The holy allium").build());
    public static final RegistryObject<ItemStack> TEST_ITEM_2 = ITEMS.register("test_item_2",
            () -> new ItemBuilder(Material.ALLIUM).name("The holy allium").build());

}
