package com.jm.be.repository;

import com.jm.be.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>
{
}
