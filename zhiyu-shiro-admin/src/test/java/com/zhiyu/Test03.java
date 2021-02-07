package com.zhiyu;

/**
 * @author wengzhiyu
 * @date 2021/2/6
 */
public interface Test03 {


    void kill();

    default String keep() {
        return "jsons";
    }
}
