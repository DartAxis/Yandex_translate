package ru.dartinc.Yandex_translate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.dartinc.Yandex_translate.model.Item;
import ru.dartinc.Yandex_translate.repository.ItemRepository;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Service
public class TranslateService implements ITranslateService {
    private final ItemRepository itemRepository;
    @Value("${api-key}")
    private String apikey;

    @Autowired
    public TranslateService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getNonTranslateItems() {
        return itemRepository.getNonTranslateItems();
    }

    @Scheduled(fixedRate = 60000)
    public void refreshAndTranslate() {
        System.out.println("Запуск по расписанию");
        List<Item> items = getNonTranslateItems();
        for (Item item : items) {
            System.out.println(item.toString());
            System.out.println("Делаем запрос в yandex");
            item.setResult(getTranslate(item.getText(),item.getTranslateFrom() + "-" + item.getTranslateTo()));
            if(item.getResult()!=null){
                itemRepository.save(item);
            }
        }
    }

    private String getTranslate(String text,String napr){
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("https://translate.yandex.net/api/v1.5/tr/translate?key=" + apikey + "&text=" + text + "&lang=" + napr);
            Node root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if(node.getNodeName().equals("text")){
                    return node.getTextContent();
                };
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }


}
