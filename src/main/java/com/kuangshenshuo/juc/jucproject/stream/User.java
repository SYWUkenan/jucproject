package com.kuangshenshuo.juc.jucproject.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yswu
 * @date 2021-03-09 23:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Integer age;


}
