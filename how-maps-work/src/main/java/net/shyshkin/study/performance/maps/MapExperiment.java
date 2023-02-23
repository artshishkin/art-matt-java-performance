package net.shyshkin.study.performance.maps;

import net.shyshkin.study.performance.maps.model.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MapExperiment {

    public static final int BOOK_LIST_SIZE = 10;

    public void putToHashMapInitialCapacityLoadFactor() {
        Map<Integer, Book> books = new HashMap<>();
        IntStream.range(0, BOOK_LIST_SIZE)
                .map(i -> i * 16) //putting all in 1 bucket
                .mapToObj(this::mockBook)
                .forEach(b ->
                        books.put(b.getId(), b)
                );
    }

    private Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, ThreadLocalRandom.current().nextDouble());
    }

    public static void main(String[] args) {
        MapExperiment mapExperiment = new MapExperiment();
        mapExperiment.putToHashMapInitialCapacityLoadFactor();
    }

}
