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

## Для вычисления математических выражений используем библиотеку
```
<dependency>
    <groupId>net.objecthunter</groupId>
    <artifactId>exp4j</artifactId>
    <version>0.4.8</version>
</dependency>
```

### Поддерживаемые математические операторы:
- **Сложение**: 2 + 2  
- **Вычитание**: 2 - 2  
- **Умножение**: 2 * 2  
- **Деление**: 2 / 2  
- **Возведение в степень**: 2 ^ 2  
- **Унарный минус и плюс (знаки)**: +2, -(-2)  
- **Остаток от деления**: 2 % 2  

### Поддерживаемые математические функции:
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

## Unit тесты
**Написаны следующие тесты:**
- **Valid Expressions** (Корректные выражения)
  - Simple addition (Простое сложение)
  - Simple subtraction (Простое вычитание)
  - Simple multiplication (Простое умножение)
  - Simple division (Простое деление)
  - Expression with precedence (Выражение с приоритетами)
  - Expression with parentheses (Выражение со скобками)
  - Expression with decimals (Выражение с десятичными числами)
  - Expression with negative numbers (Выражение с отрицательными числами)
  - Expression with exponents (Выражение со степенями)
  - Expression with functions (Выражение с функциями)
  - Expression with multiple operators (Выражение с несколькими операторами)
  - Expression with nested parentheses (Выражение с вложенными скобками)
  - Expression with scientific notation (Выражение в научной нотации)

- **Invalid Expressions** (Некорректные выражения)
  - Division by zero (Деление на ноль)
  - Malformed expression with double operators (Некорректное выражение с двойными операторами)
  - Non-numeric characters in expression (Некорректное выражение с недопустимыми символами)
  - Empty expression (Пустое выражение)
  - Null expression (Выражение со значением null)
  - Expression with multiple decimal points (Выражение с несколькими десятичными точками)
  - Expression with mismatched parentheses (Выражение с несогласованными скобками)
  - Expression with implicit multiplication (unsupported) (Выражение с неявным умножением — неподдерживается)
  - Expression with unsupported function (Выражение с неподдерживаемой функцией)
  - Expression with modulus operator (if unsupported) (Выражение с оператором остатка — если не поддерживается)

- **Edge Cases** (Граничные случаи)
  - Very long expression (Очень длинное выражение)
  - Expression resulting in Infinity (Выражение, приводящее к бесконечности)
  - Expression resulting in NaN (Выражение, приводящее к NaN)
  - Expression with spaces (Выражение с пробелами)
  - Expression with unary operators (Выражение с унарными операторами)
  - Expression with multiple nested parentheses (Выражение с несколькими уровнями вложенности скобок)
  - Expression with multiple functions (Выражение с несколькими функциями)
  - Expression with division resulting in negative number (Выражение с делением, приводящим к отрицательному числу)
  - Expression with exponential and functions (Выражение со степенями и функциями)
  - Expression with multiple decimal operations (Выражение с несколькими десятичными операциями)

- **Special Cases** (Особые случаи)
  - Expression with pi constant (Выражение с константой pi)
  - Expression with e constant (Выражение с константой e)
  - Expression with multiple variables (unsupported) (Выражение с несколькими переменными — неподдерживается)
  - Expression with implicit addition (Выражение с неявным сложением)
  - Expression with mixed operators and functions (Выражение с смешанными операторами и функциями)
  - Expression with chained functions (Выражение с вложенными функциями)
  - Expression with factorial (unsupported) (Выражение с факториалом — неподдерживается)
  - Expression with multiple decimal points in number (Выражение с несколькими десятичными точками в числе)
  - Expression with whitespace and tabs (Выражение с пробелами и табуляцией)
  - Expression with empty parentheses (Выражение с пустыми скобками)


 

___
 
## Консоль
В качестве примера реализован простой консольный калькулятор, который запрашивает у пользователя математическое выражение и выводит результат.
![работа консоли]()
