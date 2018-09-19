package com.codecool.krk.iterators;
import java.io.IOException;
import java.util.Iterator;
public interface IterableText{

    public Iterator<String> charIterator() throws IOException;
    public Iterator<String> wordIterator() throws IOException;
}