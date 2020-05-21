package ru.dartinc.Yandex_translate.service;

import ru.dartinc.Yandex_translate.model.Item;

import java.util.List;


public interface IItemService {

    public List<Item> getNonTranslateItems();

    public void updateItem(Item item);
}
