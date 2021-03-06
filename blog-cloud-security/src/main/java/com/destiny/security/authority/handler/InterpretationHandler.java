package com.destiny.security.authority.handler;

import com.destiny.security.authority.enums.Operation;
import com.destiny.security.authority.explanation.Explanation;
import com.destiny.security.authority.setting.ConstraintSetting;

import com.destiny.security.authority.explanation.Explanation;
import com.destiny.security.authority.setting.ConstraintSetting;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public interface InterpretationHandler {

    Explanation interpret(ConstraintSetting constraintSetting, StandardEvaluationContext context);

    Boolean supports(Operation operation);
}
