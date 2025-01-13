package com.example.bsujavaexam.service;

import com.example.bsujavaexam.configuration.MessageConfiguration;
import com.example.bsujavaexam.entity.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IssueServiceTest {

    @Mock
    private MessageConfiguration message;

    @InjectMocks
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(message.getNoErrors()).thenReturn("No errors");
    }

    @Nested
    @DisplayName("Valid Expressions")
    class ValidExpressions {

        @Test
        @DisplayName("Simple addition")
        void testSimpleAddition() {
            Issue issue = new Issue("2+2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(4.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Simple subtraction")
        void testSimpleSubtraction() {
            Issue issue = new Issue("5-3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(2.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Simple multiplication")
        void testSimpleMultiplication() {
            Issue issue = new Issue("4*3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(12.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Simple division")
        void testSimpleDivision() {
            Issue issue = new Issue("10/2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(5.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with precedence")
        void testExpressionWithPrecedence() {
            Issue issue = new Issue("2+3*4");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(14.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with parentheses")
        void testExpressionWithParentheses() {
            Issue issue = new Issue("(2+3)*4");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(20.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with decimals")
        void testExpressionWithDecimals() {
            Issue issue = new Issue("3.5 + 2.1");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(5.6, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with negative numbers")
        void testExpressionWithNegativeNumbers() {
            Issue issue = new Issue("-2 + 3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(1.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with exponents")
        void testExpressionWithExponents() {
            Issue issue = new Issue("2^3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(8.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with functions")
        void testExpressionWithFunctions() {
            Issue issue = new Issue("sin(0)");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with multiple operators")
        void testExpressionWithMultipleOperators() {
            Issue issue = new Issue("2 + 3 - 1 * 5 / 2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(2 + 3 - 1 * 5 / 2.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with nested parentheses")
        void testExpressionWithNestedParentheses() {
            Issue issue = new Issue("((2 + 3) * (4 - 1))");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(15.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with scientific notation")
        void testExpressionWithScientificNotation() {
            Issue issue = new Issue("1e3 + 2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(1002.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("Invalid Expressions")
    class InvalidExpressions {

        @Test
        @DisplayName("Division by zero")
        void testDivisionByZero() {
            Issue issue = new Issue("10/0");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6); // По умолчанию 0.0
            assertTrue(result.getErrorMessage().contains("Division by zero"));
        }

        @Test
        @DisplayName("Malformed expression with double operators")
        void testMalformedExpressionDoubleOperators() {
            Issue issue = new Issue("2++2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(4.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Non-numeric characters in expression")
        void testNonNumericCharacters() {
            Issue issue = new Issue("abc");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Unknown function or variable"));
        }

        @Test
        @DisplayName("Empty expression")
        void testEmptyExpression() {
            Issue issue = new Issue("");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Expression can not be empty"));
        }

        @Test
        @DisplayName("Null expression")
        void testNullExpression() {
            Issue issue = new Issue(null);
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Expression can not be empty"));
        }

        @Test
        @DisplayName("Expression with multiple decimal points")
        void testMultipleDecimalPoints() {
            Issue issue = new Issue("2..2 + 3");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("multiple points"));
        }

        @Test
        @DisplayName("Expression with mismatched parentheses")
        void testMismatchedParentheses() {
            Issue issue = new Issue("(2 + 3");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Mismatched parentheses detected. Please check the expression"));
        }

        @Test
        @DisplayName("Expression with implicit multiplication (unsupported)")
        void testImplicitMultiplication() {
            Issue issue = new Issue("2(3+4)");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(14.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with unsupported function")
        void testUnsupportedFunction() {
            Issue issue = new Issue("unknownFunc(2)");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Unknown function or variable"));
        }

        @Test
        @DisplayName("Expression with modulus operator (if unsupported)")
        void testModulusOperator() {
            Issue issue = new Issue("10 % 3");
            Issue result = issueService.solve(issue);

            // Проверка зависит от того, поддерживается ли модуль
            // Предположим, что не поддерживается
            assertTrue(result.isCorrectCalculated());
            assertEquals(1.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {

        @Test
        @DisplayName("Very long expression")
        void testVeryLongExpression() {
            StringBuilder expr = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                expr.append("1+");
            }
            expr.append("1"); // Итоговое выражение: "1+1+1+...+1"

            Issue issue = new Issue(expr.toString());
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(1001.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression resulting in Infinity")
        void testExpressionResultingInInfinity() {
            Issue issue = new Issue("1e308 * 1e10"); // Примерно 1e318, что может быть Infinity
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Double.POSITIVE_INFINITY, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression resulting in NaN")
        void testExpressionResultingInNaN() {
            Issue issue = new Issue("0/0");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Division by zero!"));
        }

        @Test
        @DisplayName("Expression with spaces")
        void testExpressionWithSpaces() {
            Issue issue = new Issue(" 2 + 2 ");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(4.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with unary operators")
        void testExpressionWithUnaryOperators() {
            Issue issue = new Issue("-3 + 5");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(2.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with multiple nested parentheses")
        void testMultipleNestedParentheses() {
            Issue issue = new Issue("((2 + (3 * (4 + 5))) - 6) / 3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals((2 + (3 * (4 + 5)) - 6) / 3.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with multiple functions")
        void testExpressionWithMultipleFunctions() {
            Issue issue = new Issue("sin(0) + cos(0)");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(1.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with division resulting in negative number")
        void testDivisionResultingInNegativeNumber() {
            Issue issue = new Issue("10/-2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(-5.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with exponential and functions")
        void testExponentialAndFunctions() {
            Issue issue = new Issue("exp(1) + log(10)");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Math.exp(1) + Math.log(10), result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with multiple decimal operations")
        void testMultipleDecimalOperations() {
            Issue issue = new Issue("3.14 * 2.0 + 1.86");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(3.14 * 2.0 + 1.86, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("Special Cases")
    class SpecialCases {

        @Test
        @DisplayName("Expression with pi constant")
        void testExpressionWithPi() {
            Issue issue = new Issue("pi * 2");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Math.PI * 2, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with e constant")
        void testExpressionWithE() {
            Issue issue = new Issue("e + 1");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Math.E + 1, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with multiple variables (unsupported)")
        void testExpressionWithVariables() {
            Issue issue = new Issue("x + 2");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Unknown function or variable"));
        }

        @Test
        @DisplayName("Expression with implicit addition")
        void testImplicitAddition() {
            Issue issue = new Issue("2 2");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Unable to parse char '2' (Code:50) at [2]"));
        }

        @Test
        @DisplayName("Expression with mixed operators and functions")
        void testMixedOperatorsAndFunctions() {
            Issue issue = new Issue("sqrt(16) + 2^3");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Math.sqrt(16) + Math.pow(2, 3), result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with chained functions")
        void testChainedFunctions() {
            Issue issue = new Issue("sin(cos(0))");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(Math.sin(Math.cos(0)), result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with factorial (unsupported)")
        void testExpressionWithFactorial() {
            Issue issue = new Issue("5!");
            Issue result = issueService.solve(issue);

            // Предполагаем, что факториал не поддерживается
            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Operator is unknown for token."));
        }

        @Test
        @DisplayName("Expression with multiple decimal points in number")
        void testMultipleDecimalPointsInNumber() {
            Issue issue = new Issue("3.1.4 + 2");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("multiple points"));
        }

        @Test
        @DisplayName("Expression with whitespace and tabs")
        void testExpressionWithWhitespaceAndTabs() {
            Issue issue = new Issue(" \t 7 \n + \t 3 ");
            Issue result = issueService.solve(issue);

            assertTrue(result.isCorrectCalculated());
            assertEquals(10.0, result.getResult(), 1e-6);
            assertEquals("No errors", result.getErrorMessage());
        }

        @Test
        @DisplayName("Expression with empty parentheses")
        void testExpressionWithEmptyParentheses() {
            Issue issue = new Issue("2 + ()");
            Issue result = issueService.solve(issue);

            assertFalse(result.isCorrectCalculated());
            assertEquals(0.0, result.getResult(), 1e-6);
            assertTrue(result.getErrorMessage().contains("Invalid number of operands available for '+' operator"));
        }
    }
}
