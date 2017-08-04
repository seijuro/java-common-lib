package com.github.seijuro.common.xml.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class TagStackTest {
    @Test
    public void testCreatAndUse1() {
        TagStack<Integer> intTagStack = new TagStack<>();

        assertNull(intTagStack.pop());
        assertNull(intTagStack.top());

        intTagStack.push(10);
        assertEquals(1, intTagStack.size());
        assertTrue(intTagStack.isTop(10));
        assertFalse(intTagStack.isTop(11));

        intTagStack.push(11);
        assertEquals(2, intTagStack.size());
        assertFalse(intTagStack.isTop(10));
        assertTrue(intTagStack.isTop(11));

        intTagStack.push(12);
        assertEquals(3, intTagStack.size());
        assertFalse(intTagStack.isTop(10));
        assertFalse(intTagStack.isTop(11));
        assertTrue(intTagStack.isTop(12));

        intTagStack.push(13);
        assertTrue(intTagStack.isTop(13));
        assertEquals(4, intTagStack.size());

        intTagStack.push(14);
        assertTrue(intTagStack.isTop(14));
        assertEquals(5, intTagStack.size());

        intTagStack.push(15);
        assertTrue(intTagStack.isTop(15));
        assertEquals(6, intTagStack.size());
        assertEquals(6, intTagStack.size());
        assertEquals(new Integer(15), intTagStack.top());
        assertEquals(6, intTagStack.size());
        assertEquals(new Integer(15), intTagStack.pop());
        assertEquals(5, intTagStack.size());
        assertEquals(new Integer(14), intTagStack.pop());
        assertEquals(4, intTagStack.size());
        assertEquals(new Integer(13), intTagStack.pop());
        assertEquals(3, intTagStack.size());
        assertEquals(new Integer(12), intTagStack.pop());
        assertEquals(2, intTagStack.size());
        assertEquals(new Integer(11), intTagStack.pop());
        assertEquals(1, intTagStack.size());
        assertEquals(new Integer(10), intTagStack.pop());
        assertEquals(0, intTagStack.size());
    }

    @Test
    public void testCreatAndUse2() {
        TagStack<String> tagStack = new TagStack<>();

        tagStack.push("1");
        assertEquals(1, tagStack.size());
        assertEquals("1", tagStack.top());

        tagStack.push("2");
        assertEquals(2, tagStack.size());
        assertEquals("2", tagStack.top());

        tagStack.push("3");
        assertEquals(3, tagStack.size());
        assertEquals("3", tagStack.top());

        assertEquals("3", tagStack.pop());
        assertEquals("2", tagStack.pop());
        assertEquals("1", tagStack.pop());
    }
}
