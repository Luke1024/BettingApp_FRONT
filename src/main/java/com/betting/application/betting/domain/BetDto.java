package com.betting.application.betting.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class BetDto {
    private Long id;
    private Long match_id;
    private Long country_id;
    private Long league_id;
    private String country_name;
    private String league_name;
    private LocalDateTime match_date_time;
    private String match_hometeam_name;
    private String match_awayteam_name;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private String match_status;

    public BetDto() {}

    public BetDto(Long id, Long match_id, Long country_id, Long league_id, String country_name, String league_name, LocalDateTime match_date_time, String match_hometeam_name, String match_awayteam_name, double odd_1, double odd_x, double odd_2, String match_status) {
        this.id = id;
        this.match_id = match_id;
        this.country_id = country_id;
        this.league_id = league_id;
        this.country_name = country_name;
        this.league_name = league_name;
        this.match_date_time = match_date_time;
        this.match_hometeam_name = match_hometeam_name;
        this.match_awayteam_name = match_awayteam_name;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.match_status = match_status;
    }

    public Long getId() {
        return id;
    }

    public Long getMatch_id() {
        return match_id;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public Long getLeague_id() {
        return league_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public LocalDateTime getMatch_date_time() {
        return match_date_time;
    }

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
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

    public String getMatch_status() {
        return match_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetDto)) return false;
        BetDto betDto = (BetDto) o;
        return Double.compare(betDto.odd_1, odd_1) == 0 &&
                Double.compare(betDto.odd_x, odd_x) == 0 &&
                Double.compare(betDto.odd_2, odd_2) == 0 &&
                id.equals(betDto.id) &&
                match_id.equals(betDto.match_id) &&
                country_id.equals(betDto.country_id) &&
                league_id.equals(betDto.league_id) &&
                country_name.equals(betDto.country_name) &&
                league_name.equals(betDto.league_name) &&
                match_date_time.equals(betDto.match_date_time) &&
                match_hometeam_name.equals(betDto.match_hometeam_name) &&
                match_awayteam_name.equals(betDto.match_awayteam_name) &&
                match_status.equals(betDto.match_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match_id, country_id, league_id, country_name, league_name, match_date_time, match_hometeam_name, match_awayteam_name, odd_1, odd_x, odd_2, match_status);
    }

    @Override
    public String toString() {
        return "BetDto{" +
                "id=" + id +
                ", match_id=" + match_id +
                ", country_id=" + country_id +
                ", league_id=" + league_id +
                ", country_name='" + country_name + '\'' +
                ", league_name='" + league_name + '\'' +
                ", match_date_time=" + match_date_time +
                ", match_hometeam_name='" + match_hometeam_name + '\'' +
                ", match_awayteam_name='" + match_awayteam_name + '\'' +
                ", odd_1=" + odd_1 +
                ", odd_x=" + odd_x +
                ", odd_2=" + odd_2 +
                ", match_status='" + match_status + '\'' +
                '}';
    }
}
