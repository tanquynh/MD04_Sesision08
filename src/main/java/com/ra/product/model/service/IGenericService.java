package com.ra.product.model.service;

import java.util.List;

public interface IGenericService <Entity, Id>{
    List<Entity> getAll();
    boolean save(Entity entity);
    Entity getById(Id id);
    boolean update(Entity entity, Id id);
    void delete(Id id);

}
