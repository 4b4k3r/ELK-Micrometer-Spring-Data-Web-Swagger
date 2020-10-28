package com.jm.be.service;

import com.jm.be.model.Item;
import com.jm.be.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
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
        try
        {
            itemRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException emptyResultDataAccessException)
        {
            log.warn("No deleted item with id {}, not exist", id);
        }
        catch (Exception e)
        {
            log.error("Unexpected error while deleting item with id {}", id);
        }
    }

    public Item findById(Long id)
    {
        return itemRepository.findById(id).orElse(null);
    }
}
