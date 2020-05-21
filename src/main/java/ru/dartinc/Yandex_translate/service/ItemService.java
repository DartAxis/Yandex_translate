package ru.dartinc.Yandex_translate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dartinc.Yandex_translate.model.Item;
import ru.dartinc.Yandex_translate.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService implements IItemService {
    private final ItemRepository itemRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getNonTranslateItems() {
        return itemRepository.getNonTranslateItems();
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }


}
