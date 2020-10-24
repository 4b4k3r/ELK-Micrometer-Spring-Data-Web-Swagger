package com.jm.be.service;

import com.jm.be.model.Item;
import com.jm.be.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService
{
    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAll()
    {
        return (List<Item>) itemRepository.findAll();
    }

    public Item save(Item item)
    {
        return itemRepository.save(item);
    }

    public void deleteById(Long id)
    {
        itemRepository.deleteById(id);
    }

    public Item findById(Long id)
    {
        return itemRepository.findById(id).orElse(null);
    }
}
