package com.destiny.blog.authority.handler;

import com.destiny.blog.authority.enums.Operation;
import com.destiny.blog.authority.setting.ConstraintSetting;

/**
 * @Date 2020/2/20 16:19
 * @Version 1.0
 **/
public class NotEqualOperationHandler extends AbstractInterpretationHandler implements InterpretationHandler{
    @Override
    protected String handleSQLFramentGeneration(ConstraintSetting setting, Object operands) {
        return String.format(" %s != %s ",setting.getKind(),operands);
    }

    @Override
    protected OperandQuality getOperandQuality() {
        return OperandQuality.SINGLE;
    }

    @Override
    public Boolean supports(Operation operation) {
        return Operation.NOT_EQUAL == operation;
    }
}
