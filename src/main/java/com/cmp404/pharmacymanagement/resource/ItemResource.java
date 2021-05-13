package com.cmp404.pharmacymanagement.resource;

import com.cmp404.pharmacymanagement.model.Item;
import com.cmp404.pharmacymanagement.model.Pharmacy;
import com.cmp404.pharmacymanagement.service.ItemService;
import com.cmp404.pharmacymanagement.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ItemResource {

    private final ItemService itemService;

    @Autowired
    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/api/item")
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(path = "/api/item/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable("itemId") Long id) {
        Item item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping(path = "/api/pharmacy/{pharmacyId}/item")
    public ResponseEntity<List<Item>> getItemsByPharmacyID(@PathVariable("pharmacyId") Long pharmacyId) {
        List<Item> items = itemService.getItemsByPharmacyId(pharmacyId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(path = "/api/pharmacy/{pharmacyId}/item")
    public ResponseEntity<Item> addItem(@PathVariable("pharmacyId") Long pharmacyId, @RequestBody Item i) {
        Item item = itemService.addItem(pharmacyId, i);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/pharmacy/{pharmacyId}/item/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable("pharmacyId") Long pharmacyId, @PathVariable("itemId") Long itemId ,@RequestBody Item i) {
        Item item = itemService.updateItem(pharmacyId, itemId, i);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/item/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
