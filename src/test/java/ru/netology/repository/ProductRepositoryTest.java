package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private final Product first = new Product(1, "first", 1);
    private final Product second = new Product(2, "second", 1);
    private final Book firstBook = new Book(3, "firstBook", 3, "Me", 100,2020);
    private final Book secondBook = new Book(4, "secondBook", 4, "You", 200,2021);
    private final TShirt firstTShirt = new TShirt("blue", "XL");
    private final TShirt secondTShirt = new TShirt("green", "XLL");

    @BeforeEach
    void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstTShirt);
        repository.save(secondTShirt);
    }

    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldFindById () {
        repository.removeById(3);
        Product[] expected = {first, second, secondBook, firstTShirt, secondTShirt};
        Product[] actual = repository.findAll();
                assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindByNotRightId () {
        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById (10));
    }

}