Let’s suppose we need to search across 100s of documents (search for words). One way to do it is to go one file at a time. But that will take too long. So write a multithreaded or multi-process program to run the search across 100s of files. Keep the number of threads/processes configurable.
Output - files which have the word being searched.
