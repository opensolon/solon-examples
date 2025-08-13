package demo9906.action;

import org.apache.seata.saga.engine.expression.Expression;
import org.apache.seata.saga.engine.expression.ExpressionFactory;

/**
 * 暴漏为bean,支持自定义表达式解析
 */
//@Managed
public class SolonExpressionFactory implements ExpressionFactory {
    @Override
    public Expression createExpression(String expression) {
        MySolonElExpression solonElExpression = new MySolonElExpression(expression);
        return solonElExpression;
    }
}
