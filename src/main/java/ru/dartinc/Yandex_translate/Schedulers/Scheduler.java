package ru.dartinc.Yandex_translate.Schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.dartinc.Yandex_translate.model.Item;
import ru.dartinc.Yandex_translate.service.IItemService;
import ru.dartinc.Yandex_translate.service.TranslateQuery;

import java.util.List;

@Component
public class Scheduler {

    private final IItemService itemService;
    private final TranslateQuery translateQuery;
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    public Scheduler(IItemService itemService, TranslateQuery translateQuery) {
        this.itemService = itemService;
        this.translateQuery = translateQuery;
    }




    @Scheduled(fixedRate = 60000)
    public void refreshAndTranslate() {
        LOGGER.info("Scheduled running!!!");
        List<Item> items = itemService.getNonTranslateItems();
        for (Item item : items) {
            item.setResult(translateQuery.getTranslate(item.getText(), item.getTranslateFrom() + "-" + item.getTranslateTo()));
            if (item.getResult() != null) {
                itemService.updateItem(item);
            }
        }
    }

}
