package com.yang.boot.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/04/11/19:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String name;
    private Integer age;
}
