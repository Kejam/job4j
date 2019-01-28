package ru.job4j.calculator;

/**
 * This class implements engineer calculator.
 * @author Prozorov Aleksey (kejamwork@mail.ru).
 *  @version 0.1
 */
public class EnginerCalculator extends InteractCalc {
    private  ActionsEng actionsEng = new ActionsEng();
    private final User user;
    private final Actions actions;
    /**
     * Defalut constructor.
     *
     * @param user
     * @param actions
     */
    public EnginerCalculator(User user, Actions actions) {
        super(user, actions);
        this.actions = actions;
        this.user = user;
    }

    /**
     *
     * @param firstValue
     * @param action
     * @return
     */
    @Override
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
            actionsEng.exponentiation(firstValue, secondValue);
            result = actionsEng.getResult();
        }
        return result;
    }
}
