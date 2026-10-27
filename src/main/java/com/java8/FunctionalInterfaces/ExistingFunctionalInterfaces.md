Java 8 introduced many built-in Functional Interfaces in the java.util.function package. A functional interface contains exactly one abstract method and can be implemented using lambda expressions.

1. Core Functional Interfaces
   Predicate
   Takes 1 input
   Returns boolean
   Predicate<Integer> isEven = n -> n % 2 == 0;
   System.out.println(isEven.test(10)); // true


Method:

boolean test(T t)

Function<T,R>
Takes 1 input
Returns 1 output
Function<String, Integer> length = str -> str.length();
System.out.println(length.apply("Java")); // 4


Method:

R apply(T t)

Consumer
Takes 1 input
Returns nothing
Consumer<String> print = s -> System.out.println(s);
print.accept("Hello");


Method:

void accept(T t)

Supplier
Takes no input
Produces a value
Supplier<String> supplier = () -> "Java 8";
System.out.println(supplier.get());


Method:

T get()

2. Bi-Functional Interfaces

These work with two inputs.

BiPredicate<T,U>
BiPredicate<String, Integer> check =
(name, age) -> age >= 18;

System.out.println(check.test("John", 20));


Method:

boolean test(T t, U u)

BiFunction<T,U,R>
BiFunction<Integer, Integer, Integer> add =
(a, b) -> a + b;

System.out.println(add.apply(10, 20));


Method:

R apply(T t, U u)

BiConsumer<T,U>
BiConsumer<String, Integer> display =
(name, age) ->
System.out.println(name + " : " + age);

display.accept("John", 25);


Method:

void accept(T t, U u)

3. Unary and Binary Operators

These are specialized forms of Function.

UnaryOperator

Input and output are the same type.

UnaryOperator<Integer> square = n -> n * n;

System.out.println(square.apply(5));


Method:

T apply(T t)

BinaryOperator

Takes two inputs of the same type and returns the same type.

BinaryOperator<Integer> max =
(a, b) -> a > b ? a : b;

System.out.println(max.apply(10, 20));


Method:

T apply(T t1, T t2)

4. Primitive Functional Interfaces

To avoid boxing and unboxing overhead.

IntPredicate
IntPredicate isPositive = n -> n > 0;

System.out.println(isPositive.test(10));

IntFunction
IntFunction<String> convert =
n -> "Number : " + n;

System.out.println(convert.apply(5));

IntConsumer
IntConsumer print = n -> System.out.println(n);

print.accept(100);

IntSupplier
IntSupplier number = () -> 10;

System.out.println(number.getAsInt());


Similarly:

LongPredicate
LongFunction
LongConsumer
LongSupplier

DoublePredicate
DoubleFunction
DoubleConsumer
DoubleSupplier

5. Common Functional Interfaces from Earlier Java Versions

Although not introduced in Java 8, they became functional interfaces and support lambdas.

Runnable
Runnable r = () -> System.out.println("Running");
new Thread(r).start();

Comparator
Comparator<Integer> comp =
(a, b) -> a - b;

System.out.println(comp.compare(5, 10));

Callable
Callable<String> call =
() -> "Hello";

System.out.println(call.call());

Interview Answer

If asked "What functional interfaces are provided by Java 8?", mention:

Main Interfaces
Predicate
Function<T,R>
Consumer
Supplier
Bi-Variants
BiPredicate<T,U>
BiFunction<T,U,R>
BiConsumer<T,U>
Operators
UnaryOperator
BinaryOperator
Primitive Variants
IntPredicate, LongPredicate, DoublePredicate
IntFunction, LongFunction, DoubleFunction
IntConsumer, LongConsumer, DoubleConsumer
IntSupplier, LongSupplier, DoubleSupplier
Existing Interfaces Supporting Lambdas
Runnable
Callable
Comparator

A common interview mnemonic is:

Predicate → Test
Function → Transform
Consumer → Consume
Supplier → Supply