package com.alcano.outlaws.registry;

public class RegistryObject<T> {

    private final String id;
    private final T object;

    public RegistryObject(String id, T object) {
        this.id = id;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public T get() {
        return object;
    }
}
