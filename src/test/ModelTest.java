package test;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    static Book blueBible;
    static Author kirillov;
    static Editor me;
    static Information info;

    @BeforeEach
     void setUp() {
        blueBible = new Book();
        kirillov = new Author("Kirillov");
        me = new Editor("Sergey");
        info = new Information("Введение в микро-ЭВМ");
        kirillov.writeNew(blueBible, Genre.HORROR);
    }

    @Test
    void checkContaining() {
        Assertions.assertFalse(blueBible.containsInfo());
        blueBible.information = info;
        Assertions.assertTrue(blueBible.containsInfo());
    }

    @Test
    void checkCriticizing() {
        blueBible.isInteresting = true;
        me.criticizeBook(blueBible);
        Assertions.assertTrue(blueBible.isInteresting);
        kirillov.finishBook(blueBible);
        me.criticizeBook(blueBible);
        Assertions.assertFalse(blueBible.isInteresting);
    }

    @Test
    void checkLiking() {
        me.likeBook(blueBible);
        Assertions.assertFalse(blueBible.isInteresting);
        kirillov.finishBook(blueBible);
        blueBible.information = info;
        me.likeBook(blueBible);
        Assertions.assertTrue(blueBible.isInteresting);
    }
}