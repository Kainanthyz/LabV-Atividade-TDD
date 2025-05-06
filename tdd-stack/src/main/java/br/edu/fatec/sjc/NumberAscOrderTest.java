package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumberAscOrderTest {

    @Test
    void testSortWithSixNumbers() throws StackEmptyException {
        // Arrange
        CustomStack<Integer> mockStack = Mockito.mock(CustomStack.class);

        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop()).thenReturn(45, 12, 33, 7, 29, 18);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

        // Act
        List<Integer> sorted = sorter.sort();

        // Assert
        assertEquals(Arrays.asList(7, 12, 18, 29, 33, 45), sorted);
        verify(mockStack, times(7)).isEmpty();
        verify(mockStack, times(6)).pop();
    }

    @Test
    void testSortWithEmptyStack() throws StackEmptyException {
        // Arrange
        CustomStack<Integer> mockStack = Mockito.mock(CustomStack.class);
        when(mockStack.isEmpty()).thenReturn(true);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

        // Act
        List<Integer> sorted = sorter.sort();

        // Assert
        assertTrue(sorted.isEmpty());
        verify(mockStack, times(1)).isEmpty();
        verify(mockStack, never()).pop();
    }
}
