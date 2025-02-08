Open Closed Principle - this principle states that software entities should be open for extension, but closed for modification. As a result, when the business requirements change then the entity can be extended, but not modified.
To implement this problem Interfaces is best way.

Open for extension → You should be able to add new functionality without modifying existing code.
Closed for modification → Once a class is written and tested, it should not be changed for new requirements.

First of all, we’ll define a top-level interface – CalculatorOperation:

`public interface CalculatorOperation {}`

Let’s define an Addition class, which would add two numbers and implement the CalculatorOperation:

public class Addition implements CalculatorOperation {
    private double left;
    private double right;
    private double result = 0.0;

    public Addition(double left, double right) {
        this.left = left;
        this.right = right;
    }

    // getters and setters

}

As of now, we only have one class Addition, so we need to define another class named Subtraction:

public class Subtraction implements CalculatorOperation {
    private double left;
    private double right;
    private double result = 0.0;

    public Subtraction(double left, double right) {
        this.left = left;
        this.right = right;
    }

    // getters and setters
}

Let’s now define our main class, which will perform our calculator operations:

public class Calculator {

    public void calculate(CalculatorOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("Can not perform operation");
        }

        if (operation instanceof Addition) {
            Addition addition = (Addition) operation;
            addition.setResult(addition.getLeft() + addition.getRight());
        } else if (operation instanceof Subtraction) {
            Subtraction subtraction = (Subtraction) operation;
            subtraction.setResult(subtraction.getLeft() - subtraction.getRight());
        }
    }
}

Although this may seem fine, it’s not a good example of the OCP. When a new requirement ofadding multiplication or divide functionality comes in, we’ve no way besides changing the calculate method of the Calculator class.

Hence, we can say this code is not OCP compliant.

2.2. OCP Compliant
As we’ve seen our calculator app is not yet OCP compliant. The code in the calculate method will change with every incoming new operation support request. So, we need to extract this code and put it in an abstraction layer.

One solution is to delegate each operation into their respective class:

`public interface CalculatorOperation {
  void perform();
}`

As a result, the Addition class could implement the logic of adding two numbers:

public class Addition implements CalculatorOperation {
    private double left;
    private double right;
    private double result;

    // constructor, getters and setters

    @Override
    public void perform() {
        result = left + right;
    }
}
Copy
Likewise, an updated Subtraction class would have similar logic. And similarly to Addition and Subtraction, as a new change request, we could implement the division logic:

public class Division implements CalculatorOperation {
    private double left;
    private double right;
    private double result;

    // constructor, getters and setters
    @Override
    public void perform() {
        if (right != 0) {
            result = left / right;
        }
    }
}
Copy
And finally, our Calculator class doesn’t need to implement new logic as we introduce new operators:

public class Calculator {

    public void calculate(CalculatorOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("Cannot perform operation");
        }
        operation.perform();
    }
}
Copy
That way the class is closed for modification but open for an extension.

