package ru.dartinc.Yandex_translate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dartinc.Yandex_translate.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select item from Item item where result=null")
    List<Item> getNonTranslateItems();

}
