import org.junit.*;

public class StackTest {

    @Test
    public void testPushAndPopInteger() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Assert.assertEquals(Integer.valueOf(30), stack.pop());
        Assert.assertEquals(Integer.valueOf(20), stack.pop());
        Assert.assertEquals(Integer.valueOf(10), stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPopString() {
        MyStack<String> stack = new MyStack<>();
        stack.push("Hello");
        stack.push("World");

        Assert.assertEquals("World", stack.pop());
        Assert.assertEquals("Hello", stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        MyStack<Integer> intStack = new MyStack<>();
        Assert.assertEquals(0, intStack.size());
        intStack.push(1);
        intStack.push(2);
        Assert.assertEquals(2, intStack.size());
        intStack.pop();
        Assert.assertEquals(1, intStack.size());
    }

    @Test
    public void testStackWithObjects() {
        MyStack<Person> personStack = new MyStack<>();
        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 30);

        personStack.push(alice);
        personStack.push(bob);

        Assert.assertEquals(bob, personStack.pop());
        Assert.assertEquals(alice, personStack.pop());
        Assert.assertTrue(personStack.isEmpty());
    }
}
