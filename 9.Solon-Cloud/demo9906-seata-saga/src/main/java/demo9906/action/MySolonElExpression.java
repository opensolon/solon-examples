package demo9906.action;

import org.apache.seata.saga.engine.expression.ELExpression;
import org.noear.solon.expression.context.StandardContext;
import org.noear.solon.expression.snel.SnEL;

public class MySolonElExpression implements ELExpression {

    private String expression;

    public MySolonElExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Object getValue(Object elContext) {
        String realExpression = expression.replaceAll("#root", "root");
        Object result = SnEL.eval(realExpression, new StandardContext(elContext));

        System.out.println("expression: " + expression);
        System.out.println("realExpression: " + realExpression);
        System.out.println("result: " + result);
        return result;
    }

    @Override
    public void setValue(Object value, Object elContext) {

    }

    @Override
    public String getExpressionString() {
        return this.expression;
    }

}

