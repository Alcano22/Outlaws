package com.alcano.outlaws.registry.init;

import com.alcano.outlaws.inventory.ItemBuilder;
import com.alcano.outlaws.registry.Register;
import com.alcano.outlaws.registry.RegistryObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemInit {

    public static final Register<ItemStack> ITEMS = new Register<>();

    public static final RegistryObject<ItemStack> REVOLVER = ITEMS.register("revolver",
            () -> new ItemBuilder(Material.CARROT_ON_A_STICK).name("Revolver").customModelData(1).build());

}
