# Yandex_translate
Test task from SberBank

1 Общая информация
1.1 Описание реализуемого требования
Ниже описаны базовые (минимальные) требования к выполнению задачи.
Требуется разработать приложение, которое будет взаимодействовать с БД и переводить все записи поля TEXT таблицы 1 и записывать результат в поле RESULT. Для обеспечения работы функциональности должны быть заполнены обязательные поля.

             Таблица 1. Исходная таблица
           
№
Наименование поля
Описание поля
Обязательность
1
ID
Id записи, ключевое поле
Обязательное
2
TEXT
Исходный текст
Обязательное
3
TRANSLATE_FROM
Определение направления перевода, язык исходного текста
Обязательное
4
TRANSLATE_TO
Определение направления перевода, язык результирующего текста
Обязательное
5
RESULT
Результат, переведенный текст
Необязательное

Спецификации требований
1.2 Описание функциональности
Описание:
Перевод текста, который хранится в таблице базы данных
Предусловие:
Выполнение разработанной функциональности
Постусловие:
В поле RESULT исходной таблицы записывается переведенный текст
Основной поток:
Программа на Java должна регулярно получать необработанные данные из БД и выполнять запрос на перевод текста к YANDEX API TRANSLATE в соответствии с документацией Яндекс, используя XML интерфейс.
Входные данные берутся из поля TEXT.
Для определения направления перевода  используются поля  TRANSLATE_FROM, TRANSLATE_TO исходной таблицы.
В поле RESULT записывается переведенный текст.
Итоговая таблица для примера: 
ID
TEXT
TRANSLATE_FROM
TRANSLATE_TO
RESULT
1
Привет мир
RU
EN
Hello world

