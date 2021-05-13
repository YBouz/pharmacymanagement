package com.cmp404.pharmacymanagement.service;

import com.cmp404.pharmacymanagement.exception.ResourceNotFoundException;
import com.cmp404.pharmacymanagement.model.Item;
import com.cmp404.pharmacymanagement.model.Pharmacy;
import com.cmp404.pharmacymanagement.repository.ItemRepository;
import com.cmp404.pharmacymanagement.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, PharmacyRepository pharmacyRepository) {
        this.itemRepository = itemRepository;
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByPharmacyId(Long pharmacyId) {
        return itemRepository.findItemsByPharmacyId(pharmacyId);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item ID#" + id + " was not found."));
    }

    public Item addItem(Long pharmacyId, Item item) {
        return pharmacyRepository.findPharmacyById(pharmacyId).map(pharmacy -> {
            item.setPharmacy(pharmacy);
            return itemRepository.save(item);
        }).orElseThrow(() -> new ResourceNotFoundException("Pharmacy ID#" + pharmacyId + " was not found."));
    }

    public Item updateItem(Long pharmacyId, Long itemId, Item i) {
        boolean exists = pharmacyRepository.existsById(pharmacyId);
        if(!exists) {
            throw new ResourceNotFoundException("Pharmacy ID#" + pharmacyId + " was not found.");
        }

        return itemRepository.findById(itemId).map(item -> {
            item.setName(i.getName());
            item.setDescription(i.getDescription());
            item.setQuantity(i.getQuantity());
            return itemRepository.save(item);
        }).orElseThrow(() -> new ResourceNotFoundException("Item ID# " + itemId + " was not found."));
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if(!exists) {
            throw new IllegalStateException("Item ID#" + itemId + " does not exist.");
        }
        itemRepository.deleteById(itemId);
    }
}
