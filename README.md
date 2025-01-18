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

## Возможности приложения:
Приложение поддерживает следующие форматы файлов как для чтения так и для записи и скачивания пользователем:
* **.txt** 
* **.xml**
* **.json**
* **.yaml**

### Представление математическое выражения в файлах

В файлах формата **.txt** каждая строка воспринемается как отдельное математическое выражение 
В файлах форматов **.xml .json .yaml** для коррекной работы математические выражения должны соответствовать следующему классу:
```java
public class Issue {
    private String expression;
    private double result;
    private boolean correctCalculated;
    private String errorMessage;
}
```

** Для вычисления математических выражений используем библиотеку**
```
<dependency>
    <groupId>net.objecthunter</groupId>
    <artifactId>exp4j</artifactId>
    <version>0.4.8</version>
</dependency>
```

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

## Выводимые ошибки вычислений:
### Possible Errors in `exp4j` Expression Evaluation

#### 1. **ArithmeticException**
   - **Description:** This error occurs during division by zero or other invalid arithmetic operations.
   - **Russian:** Ошибка арифметики (например, деление на ноль или недопустимые операции).

#### 2. **IllegalArgumentException**
   - **Description:** Thrown when an invalid argument is passed, such as a null or malformed expression.
   - **Russian:** Недопустимый аргумент (например, null или некорректное выражение).

#### 3. **EmptyStackException**
   - **Description:** This occurs when there is a syntax error causing an empty stack during evaluation (e.g., missing operators or operands).
   - **Russian:** Ошибка пустого стека (например, отсутствие операторов или операндов).

#### 4. **UnsupportedOperationException**
   - **Description:** Thrown if the expression contains unsupported operations or functions.
   - **Russian:** Операция не поддерживается (например, использование неподдерживаемых функций).

#### 5. **NumberFormatException**
   - **Description:** Happens when a numeric value in the expression is improperly formatted (e.g., multiple decimal points).
   - **Russian:** Неправильный формат числа (например, несколько десятичных точек).

#### 6. **IllegalStateException**
   - **Description:** This error can occur if the expression evaluator is in an invalid state, such as being used after modification.
   - **Russian:** Некорректное состояние (например, использование после изменения).

#### 7. **ExpressionException**
   - **Description:** A generic error related to invalid expressions, such as mismatched parentheses or undefined variables.
   - **Russian:** Ошибка выражения (например, несогласованные скобки или неопределённые переменные).

#### 8. **StackOverflowError**
   - **Description:** Occurs if an expression has excessively deep recursion or nesting.
   - **Russian:** Переполнение стека (например, слишком глубокая рекурсия или вложенность).

#### 9. **UnknownFunctionOrVariableException**
   - **Description:** Raised when an expression references a function or variable that is not defined in the evaluator.
   - **Russian:** Неизвестная функция или переменная (например, использование неопределённых функций или переменных).

#### 10. **MathException**
   - **Description:** A mathematical error such as calculating the square root of a negative number or logarithm of a non-positive number.
   - **Russian:** Математическая ошибка (например, вычисление квадратного корня из отрицательного числа).

#### 11. **EvaluationException**
   - **Description:** Thrown during the evaluation process when the expression cannot be computed due to logical or mathematical constraints.
   - **Russian:** Ошибка вычисления (например, невозможность выполнения вычисления из-за ограничений).

#### 12. **PrecisionLossException**
   - **Description:** Indicates a loss of precision during computation due to limited floating-point accuracy.
   - **Russian:** Потеря точности (например, из-за ограничений числовой точности).

#### 13. **NullPointerException**
   - **Description:** Happens if a null reference is used where an expression or value is required.
   - **Russian:** Ошибка null-ссылки (например, использование null вместо выражения или значения).




## REST API

Реализован рест сервис со следующим API:

* Для подсчета одиночного выражения используем:
  * путь: localhost:8080/api/solve/one
  * с глаголом: POST
  * и телом запроса:
```
{
  "expression": "2 + 2 * 3"
}
```
* Для подсчета массива выражений используем:
  * путь: localhost:8080/api/solve/much
  * с глаголом: POST
  * и телом запроса:
```
[
  { "expression": "2 + 2 * 3" },
  { "expression": "(5 + 3) / 2" },
  { "expression": "10 / 0" },
  { "expression": "5!" }
]
```

* Для получения более подробной информации сделана документация с помощью springdoc
  * по пути localhost:8080/swagger-ui.html


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
