package com.company.ge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MyDoubleTest {

    private MyDouble objectForTest;

    @BeforeEach
    void setUp() {
        objectForTest = new MyDouble();
    }

    @Nested
    class BusinessLogicTest {

        @Test
        void parseToDoubleTest() {
            assertEquals(123.4534342, objectForTest.parseToDouble("123.4534342"));
        }

        @Test
        void parseToDoubleWithNegativeNumberTest() {
            assertEquals(-987.654, objectForTest.parseToDouble("-987.654"));
        }

        @Test
        void parseToDoubleWithZero() {
            assertEquals(0.0, objectForTest.parseToDouble("0"));
        }

        @Test
        void parseToDoubleNegativeWithZeroAndOneNumberAfterPoint() {
            assertEquals(-0.5, objectForTest.parseToDouble("-0.5"));
        }

        @Test
        void parseToDoubleWithFloatingPointTest() {
            double epsilon = 0.000001;
            double expected = 0.000001;
            assertTrue(Math.abs(expected-objectForTest.parseToDouble("0.000001")) < epsilon);
        }
    }

    @Nested
    class ExceptionsTest {

        @Test
        void parseToDoubleExceptionTwoPointTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble("3.14.159"))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("Wrong string, contains two points");
        }

        @Test
        void parseToDoubleExceptionPointFirstSymbolTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble(".000023"))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("Wrong string, the point is first symbol");

        }

        @Test
        void parseToDoubleExceptionTwoLastNegativeSymbolsTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble("--34.2"))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("Wrong negative format");
        }

        @Test
        void parseToDoubleExceptionLastNegativeSymbolTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble("445.223-"))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("Wrong negative format");
        }

        @Test
        void parseToDoubleExceptionEmptyStringTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble(""))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("This string is empty");
        }

        @Test
        void parseToDoubleExceptionInvalidCharactersTest() {
            assertThatThrownBy(() -> objectForTest.parseToDouble("10556.d34"))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining("Impossible to parse. The string contains wrong symbols");
        }
    }
}