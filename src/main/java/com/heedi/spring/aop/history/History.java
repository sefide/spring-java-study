package com.heedi.spring.aop.history;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue
    private long idx;

    @Column
    private long userIdx;

    @Column
    private LocalDateTime updateDateTime;

    public History(long userIdx, LocalDateTime updateDateTime) {
        this.userIdx = userIdx;
        this.updateDateTime = updateDateTime;
    }

}
