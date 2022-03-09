package com.alcano.outlaws.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Register<T> {

    private final Map<String, T> registries = new HashMap<>();

    public RegistryObject<T> register(String id, Supplier<T> sup) {
        this.registries.put(id, sup.get());
        return new RegistryObject<>(id, sup.get());
    }

    public RegistryObject<T> get(String id) {
        return new RegistryObject<>(id, this.registries.get(id));
    }

    public List<String> getIds() {
        return this.registries.keySet().stream().toList();
    }

    public List<T> getRegistries() {
        return this.registries.values().stream().toList();
    }
}
