package demo9906.action;

import com.alibaba.fastjson2.JSON;
import org.apache.seata.saga.engine.expression.ELExpression;
import org.noear.solon.expression.snel.SnEL;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MySolonElExpression implements ELExpression {

    private String expression;

    public MySolonElExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Object getValue(Object elContext) {
        Map ctx = new HashMap();
        String realExpression = this.expression;
        if (elContext == null) {
            ctx.put("root", elContext);
            realExpression = expression.replaceAll("#root", "root");
        } else if (elContext instanceof Map) {
            ctx.putAll((Map) elContext);
        } else if (isPrimitive(elContext.getClass())) {
            ctx.put("root", elContext);
            realExpression = expression.replaceAll("#root", "root");
        } else {
            ctx.putAll(JSON.parseObject(JSON.toJSONString(elContext), Map.class));
        }
        // 提取所有 [] 包裹的变量
        if (this.expression.contains("[") && this.expression.contains("]")) {
            // 正则表达式匹配所有 [] 包裹的内容
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\[(.*?)\\]");
            java.util.regex.Matcher matcher = pattern.matcher(this.expression);

            // 创建新的表达式，替换所有 [] 包裹的内容
            StringBuilder newExpression = new StringBuilder(this.expression);
            int offset = 0;

            while (matcher.find()) {
                String varContent = matcher.group(1);
                String varName = "var" + matcher.start();

                // 将变量内容添加到上下文
                ctx.put(varName, SnEL.eval(varContent, ctx));

                // 替换原表达式中的 [内容] 为变量引用
                int startPos = matcher.start() + offset;
                int endPos = matcher.end() + offset;
                newExpression.replace(startPos, endPos, varName);

                // 调整偏移量
                offset += varName.length() - (matcher.end() - matcher.start());
            }

            realExpression = newExpression.toString();
        } else if (this.expression.startsWith("[") && this.expression.endsWith("]")) {
            // 保留原有逻辑，处理整个表达式被 [] 包裹的情况
            realExpression = this.expression.substring(1, this.expression.length() - 1);
        }

        try {
            Object result = SnEL.eval(realExpression, ctx);
            System.err.println("realExpression: " + realExpression);
            System.err.println("result: " + result);
            return result;
        } catch (Exception e) {
            System.err.println("realExpression: " + realExpression);
            throw new RuntimeException(e);
        }

    }

    protected boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() //
                || clazz == Boolean.class //
                || clazz == Character.class //
                || clazz == Byte.class //
                || clazz == Short.class //
                || clazz == Integer.class //
                || clazz == Long.class //
                || clazz == Float.class //
                || clazz == Double.class //
                || clazz == BigInteger.class //
                || clazz == BigDecimal.class //
                || clazz == String.class //
                || clazz == java.util.Date.class //
                || clazz == java.sql.Date.class //
                || clazz == java.sql.Time.class //
                || clazz == java.sql.Timestamp.class //
                || clazz.isEnum() //
                ;
    }

    @Override
    public void setValue(Object value, Object elContext) {

    }

    @Override
    public String getExpressionString() {
        return this.expression;
    }
}

