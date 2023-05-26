package com.example.demo.Game;
import com.example.demo.Player.Player;
import jakarta.persistence.*;
@Entity
@Table (name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPlayer1;
    private Long idPlayer2;
    private Long idWinner;

    public Game() {
    }

    public Game(Long id, Long idPlayer1, Long idPlayer2, Long idWinner) {
        this.id = id;
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.idWinner = idWinner;
    }

    public Game(Long idPlayer1, Long idPlayer2, Long idWinner) {
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.idWinner = idWinner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(Long idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public Long getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(Long idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    public Long getIdWinner() {
        return idWinner;
    }

    public void setIdWinner(Long idWinner) {
        this.idWinner = idWinner;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", idPlayer1=" + idPlayer1 +
                ", idPlayer2=" + idPlayer2 +
                ", idWinner=" + idWinner +
                '}';
    }
}
