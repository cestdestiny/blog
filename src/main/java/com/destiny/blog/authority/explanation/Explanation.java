package com.destiny.blog.authority.explanation;

import com.destiny.blog.authority.enums.Operation;
import lombok.Builder;
import lombok.Data;

/**
 * @Date 2020/2/20 14:01
 * @Version 1.0
 **/

@Data
@Builder
public class Explanation {

    private String kind;

    private Operation operation;

    private Object operands;

    private String sqlFragment;

}
