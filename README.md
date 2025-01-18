# Описание проекта

В данном проекте я разработала веб-приложение простейшего калькулятора с использованием фрейворка Spring boot. 

## Описание работы приложения
По корневому пути: "/" пользователь попадает на главную страницу:
![главная страница](https://github.com/Kuznetsova-Sofiya/BSUJavaExam/blob/master/Pictures%20for%20Readme%20file/home.png)

Выбирая на главной странице кнопку "Посчитать файл", пользователь переходит на страницу загрузки файла с математическими выражениями.
![выбор файла](https://github.com/Kuznetsova-Sofiya/BSUJavaExam/blob/master/Pictures%20for%20Readme%20file/upload-file.png)

Выбрав файл и нажав кнопку "Рассчитать", пользователь попадает на страницу с результатами.
![результаты выражений в файле](https://github.com/Kuznetsova-Sofiya/BSUJavaExam/blob/master/Pictures%20for%20Readme%20file/fileCalk.png)

Далее пользователь может вернуться на главную страницу или, нажав кнопку "Скачать файл", перейти на страницу скачивания файла.
![страница скачивания файла](https://github.com/Kuznetsova-Sofiya/BSUJavaExam/blob/master/Pictures%20for%20Readme%20file/downoad-file.png)

При нажатии кнопки "Скачать файл", файл будет сохранен на компьютер пользователя с указанным форматом и именем.

Аналогично, нажав кнопку "Ввести вручную", пользователь попадает на страницу онлайн-расчетов, где может вводить выражения и получать их результаты. При этом сохраняется история расчетов до момента выхода со страницы.
![онлайн калькулятор](https://github.com/Kuznetsova-Sofiya/BSUJavaExam/blob/master/Pictures%20for%20Readme%20file/onCalk.png)

После того как пользователь завершит расчеты, он может скачать файл с введенными выражениями и вернуться на главную страницу с помощью соответствующих кнопок, описанных ранее.
___

## Возможности приложения:
Приложение поддерживает следующие форматы файлов как для чтения так и для записи и скачивания пользователем:
* .txt 
* .xml
* .json
* .yaml

### Математические операторы:
- **Сложение**: 2 + 2  
- **Вычитание**: 2 - 2  
- **Умножение**: 2 * 2  
- **Деление**: 2 / 2  
- **Возведение в степень**: 2 ^ 2  
- **Унарный минус и плюс (знаки)**: +2, -(-2)  
- **Остаток от деления**: 2 % 2  

### Математические функции:
- **abs**: абсолютное значение  
- **acos**: арккосинус  
- **asin**: арксинус  
- **atan**: арктангенс  
- **cbrt**: кубический корень  
- **ceil**: ближайшее большее целое число  
- **cos**: косинус  
- **cosh**: гиперболический косинус  
- **exp**: число Эйлера в степени \(e^x\)  
- **floor**: ближайшее меньшее целое число  
- **log**: натуральный логарифм (основание e)  
- **log10**: десятичный логарифм (основание 10)  
- **log2**: логарифм по основанию 2  
- **sin**: синус  
- **sinh**: гиперболический синус  
- **sqrt**: квадратный корень  
- **tan**: тангенс  
- **tanh**: гиперболический тангенс  
- **signum**: сигнум-функция (знак числа)  


Ниже приведен процесс работы данного приложения. 
0.5) Программа предусматривает следующие операции: +, -, *, /, sin(x), cos(x)
1) Считывание арифмитические выражения с консоли или из файлов следующих форматов: text, xml, json, yaml. В файле каждая новая строка яавляется новым арифметичесмким выражением. Что-то про объекты наших арифметич операций
1.5) Процесс вычисления выражений происходит с помощью следующей библиотеки - exp4j.
1.5.1) Обработка ошибок вычислений.
2) Результат вычислений выводится на консоль, а также добаваляется в историю операций.
3) По запросу пользователя можно получить результаты всех арифметических операций в виде файла любого из следующих форматов: text, xml, json, yaml. Также предусмотрен ввод имени файла результатов.
Осуществление вывода результата в файл:
  Если пользователь загружал файл, то в файле результата он получит сами выражения, результаты, а также сообщения об ошибках, если они есть.
  Если пользователь вводил выражения с консоли, то получит в файле выражения, результаты и сообщения об ошибках только для операций с консоли.

4) Для всех атомарных задач написаны Unit Test-ы



Необходимо реализовать консольное приложение, которое:
1)  Читает данные из входного файла;
2)  Обрабатывает полученную информацию;
3)  Записывает данные в выходной файл;
 
Входной и выходной файл могут быть следующих форматов: plain text, xml, json, yaml Так же входные и выходные файлы могут быть архивированы и зашифрованы, разными engines (только архивирован, только зашифрован, сперва архивирован, а потом зашифрован и наоборот).
 
«Тип» входного и выходного файла задаются параметрами консоли.
Приложение реализовать двумя способами: без использования Design Patterns и c использованием Design Patterns (Decorator и Builder … можно оформить Builder в виде Singleton-а), сравнить реализации.
 
Обработка информации на первом этапе: найти все арифметические операции во входном файле и заменить на результаты в выходном файле.
Реализовать фильтрацию двумя способами без использования регулярных выражений и с использованием регулярных выражений (а так же третьим :) найти библиотеку, которая все делает за вас, парсинг и калькуляцию, такие есть и не одна). Провести сравнительный анализ 2-х и более вариантов реализации.
 
Следующие шаги по нашей задаче:
1)  Добавить UI:
a.  консольный;
b.  использую любую графическую библиотеку Java на Ваш выбор;
c.  сравнить CLI и UI based реализации;
d.  поговорить с одногруппниками и сравнить различные графические Java библиотеки;
2)  Реализовать логику как Web Service:
a.  Rest, используя любой Java engine;
b.  SOAP, используя любой Java engine;
c.  Сравнить Rest и SOAP реализации;
d.  поговорить с одногруппниками и сравнить различные Rest \ Soap Java engines;
3)  Соединить все вместе UI и Web Service;
