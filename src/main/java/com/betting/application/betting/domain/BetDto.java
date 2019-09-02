package com.betting.application.betting.domain;

import com.betting.application.betting.domain.utilities.Result;

import java.time.LocalDateTime;
import java.util.Objects;

public class BetDto {
    private Long userId;
    private Long matchId;
    private Long amount;
    private Result result;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime lastEdit;

    public BetDto(Long userId, Long matchId, Long amount, Result result, double odd_1, double odd_x, double odd_2, double amoutChangeAfterClosing, LocalDateTime open, LocalDateTime lastEdit) {
        this.userId = userId;
        this.matchId = matchId;
        this.amount = amount;
        this.result = result;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.amoutChangeAfterClosing = amoutChangeAfterClosing;
        this.open = open;
        this.lastEdit = lastEdit;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public Long getAmount() {
        return amount;
    }

    public Result getResult() {
        return result;
    }

    public double getOdd_1() {
        return odd_1;
    }

    public double getOdd_x() {
        return odd_x;
    }

    public double getOdd_2() {
        return odd_2;
    }

    public double getAmoutChangeAfterClosing() {
        return amoutChangeAfterClosing;
    }

    public LocalDateTime getOpen() {
        return open;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetDto)) return false;
        BetDto betDto = (BetDto) o;
        return Double.compare(betDto.odd_1, odd_1) == 0 &&
                Double.compare(betDto.odd_x, odd_x) == 0 &&
                Double.compare(betDto.odd_2, odd_2) == 0 &&
                Double.compare(betDto.amoutChangeAfterClosing, amoutChangeAfterClosing) == 0 &&
                userId.equals(betDto.userId) &&
                matchId.equals(betDto.matchId) &&
                amount.equals(betDto.amount) &&
                result == betDto.result &&
                open.equals(betDto.open) &&
                lastEdit.equals(betDto.lastEdit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, matchId, amount, result, odd_1, odd_x, odd_2, amoutChangeAfterClosing, open, lastEdit);
    }
}
