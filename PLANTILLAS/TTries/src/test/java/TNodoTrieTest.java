import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TNodoTrieTest {

    private TNodoTrie trie;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        trie = new TNodoTrie();
        TArbolTrie arbol = new TArbolTrie();
    }

    @org.junit.jupiter.api.Test
    void insertar() {
        LinkedList<Integer> pages = new LinkedList<>();
        pages.add(1);
        pages.add(2);
        pages.add(3);

        trie.insertar("word", pages);

        LinkedList<Integer> resultPages = trie.buscarPaginas("word");

        assertEquals(pages, resultPages, "The pages returned by buscarPaginas do not match the pages inserted");
    }


    @org.junit.jupiter.api.Test
    void imprimirIndice() {
        LinkedList<Integer> pages1 = new LinkedList<>();
        pages1.add(1);
        LinkedList<Integer> pages2 = new LinkedList<>();
        pages2.add(2);
        trie.insertar("word1", pages1);
        trie.insertar("word2", pages2);
        try {
            trie.imprimirIndice("", trie);
        } catch (Exception e) {
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void buscarPaginas() {
        LinkedList<Integer> pages1 = new LinkedList<>();
        pages1.add(1);
        LinkedList<Integer> pages2 = new LinkedList<>();
        pages2.add(2);
        trie.insertar("word1", pages1);
        trie.insertar("word2", pages2);
        LinkedList<Integer> resultPages1 = trie.buscarPaginas("word1");
        LinkedList<Integer> resultPages2 = trie.buscarPaginas("word2");
        assertTrue(resultPages1.containsAll(pages1));
        assertTrue(resultPages2.containsAll(pages2));
    }

    @org.junit.jupiter.api.Test
    void buscar() {
        LinkedList<Integer> pages1 = new LinkedList<>();
        pages1.add(1);
        LinkedList<Integer> pages2 = new LinkedList<>();
        pages2.add(2);
        trie.insertar("word1", pages1);
        trie.insertar("word2", pages2);
        assertNotNull(trie.buscar("word1"));
        assertNotNull(trie.buscar("word2"));
    }
}