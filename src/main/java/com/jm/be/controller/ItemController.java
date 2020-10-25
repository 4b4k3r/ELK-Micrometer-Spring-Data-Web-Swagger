package com.jm.be.controller;

import com.jm.be.model.Item;
import com.jm.be.service.ItemService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@Timed
public class ItemController
{
    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, path = "")
    public List<Item> findAll()
    {
        return itemService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public Item save(@RequestBody Item item)
    {
        return itemService.save(item);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "")
    public Item update(@RequestBody Item item)
    {
        return itemService.save(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteById(@PathVariable Long id)
    {
        itemService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Item findById(@PathVariable Long id)
    {
        return itemService.findById(id);
    }
}
