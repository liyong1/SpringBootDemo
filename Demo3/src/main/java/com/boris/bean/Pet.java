package com.boris.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author liyong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
public class Pet {
    private String name;
    private int weight;
}
