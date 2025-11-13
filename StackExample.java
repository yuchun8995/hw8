import java.util.ArrayDeque;
import java.util.Deque;

// 泛型 Stack，底層用 JCF 的 Deque（ArrayDeque 實作）
// 不使用 java.util.Stack
class MyStack<T> {

    // 使用 JCF 中的 Deque 來當作實際儲存的容器
    private Deque<T> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    // 放入一個元素到 Stack 頂端
    public void push(T item) {
        stack.addLast(item);  // 也可以用 stack.push(item);
    }

    // 取出並移除頂端元素
    public T pop() {
        if (stack.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        return stack.removeLast();
    }

    //（如果老師有需要，也可以多提供 peek）
    public T peek() {
        if (stack.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        return stack.peekLast();
    }

    // 檢查 Stack 是否為空
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // 回傳 Stack 中的元素數量
    public int size() {
        return stack.size();
    }
}

public class StackExample {
    public static void main(String[] args) {
        // 測試整數 Stack
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("size = " + intStack.size());  // 3
        System.out.println("pop  = " + intStack.pop());   // 30
        System.out.println("pop  = " + intStack.pop());   // 20
        System.out.println("isEmpty = " + intStack.isEmpty()); // false

        // 測試 Person 物件 Stack（Junit 會用到這個類型）
        MyStack<Person> personStack = new MyStack<>();
        personStack.push(new Person("Alice", 20));
        personStack.push(new Person("Bob", 25));

        System.out.println(personStack.pop()); // Person{name='Bob', age=25}
    }
}

// 我的 JUnit 測試會測這個 Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------
