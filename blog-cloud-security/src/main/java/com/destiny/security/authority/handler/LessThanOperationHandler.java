package com.destiny.security.authority.handler;

import com.destiny.security.authority.enums.Operation;
import com.destiny.security.authority.setting.ConstraintSetting;
import com.destiny.security.authority.enums.Operation;
import com.destiny.security.authority.setting.ConstraintSetting;

/**
 * @Date 2020/2/20 15:59
 * @Version 1.0
 **/
public class LessThanOperationHandler extends AbstractInterpretationHandler implements InterpretationHandler {
    @Override
    protected String handleSQLFramentGeneration(ConstraintSetting setting, Object operands) {
        return String.format(" %s < %s ",setting.getKind(),operands);
    }

    @Override
    protected OperandQuality getOperandQuality() {
        return OperandQuality.SINGLE;
    }

    @Override
    public Boolean supports(Operation operation) {
        return Operation.LESS_THAN == operation;
    }
}
