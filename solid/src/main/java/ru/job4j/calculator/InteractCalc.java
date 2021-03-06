package ru.job4j.calculator;

/**
 * This class implements simple calculator.
 * @author Prozorov Aleksey (kejamwork@mail.ru).
 * @version 0.1
 */
public class InteractCalc {
    private final User user;
    private final ActionsEng actions;

    /**
     * Defalut constructor.
     * @param user
     * @param actions
     */
    public InteractCalc(final User user, final ActionsEng actions) {
        this.user = user;
        this.actions = actions;
    }


    /**
     *  This method init calculator.
     */
    public void init() {
        System.out.println("This program implements calculator");
        double result = firstAction();
        repeatAction(result);
    }

    /**
     * First action calculator.
     * @return
     */
    private double firstAction() {
        System.out.println("Input action");
        double result = actionWithFirstParameter(user.input());
        System.out.println(String.format("Result = %f", result));
        return result;
    }

    /**
     * Repeat action calculator.
     * @param result
     */
    private void repeatAction(double result) {
        String action = "";
        while (!action.equals("exit")) {
            System.out.println("Do you want save result? ");
            if ("yes".equals(user.input())) {
                System.out.println("Input action");
                action = user.input();
                result = actionWithoutFirstParameter(action, result);
            } else {
                System.out.println("Input action");
                action = user.input();
                result = actionWithFirstParameter(action);
            }
            System.out.println(String.format("Result = %f", result));
            System.out.println("Continue?");
            action = user.input();
        }
    }

    /**
     * If we save result after action then we use this method.
     * This method use @firstValue;
     * @param action
     * @param firstValue
     * @return
     */
    private double actionWithoutFirstParameter(String action, double firstValue) {
        return action(firstValue, action);
    }

    /**
     * This method use for action without value.
     * @param action
     * @return
     */
    private double actionWithFirstParameter(String action) {
        System.out.println("Input first value");
        return action(Double.parseDouble(user.input()), action);
    }

    /**
     *  This method check action and do it. Return result action, if action not founds then return -1;
     * @param firstValue
     * @param action
     * @return
     */
    public double action(double firstValue, String action) {
        double result = -1;
        System.out.println("Input second value: ");
        double secondValue = Double.parseDouble(user.input());
        if ("add".equals(action.toLowerCase())) {
            actions.add(firstValue, secondValue);
            result = actions.getResult();
        }
        if ("div".equals(action.toLowerCase())) {
            actions.div(firstValue, secondValue);
            result = actions.getResult();
        }
        if ("multiple".equals(action.toLowerCase())) {
            actions.multiple(firstValue, secondValue);
            result = actions.getResult();
        }
        if ("subtract".equals(action.toLowerCase())) {
            actions.subtract(firstValue, secondValue);
            result = actions.getResult();
        }
        if ("ex".equals(action.toLowerCase())) {
            actions.exponentiation(firstValue, secondValue);
            result = actions.getResult();
        }
        return result;
    }

    /**
     * Start program.
     * @param args
     */
    public static void main(String[] args) {
        new InteractCalc(new User(), new ActionsEng()).init();
    }

}
