package com.xs.base;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: BaseReq
 * Package: com.xs.base
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/21 16:21
 * @Version 1.0
 */

@Data
public class BaseReq implements Serializable {

    private String uuid;
    private static final long serialVersionUID = 156015155330L;

}
