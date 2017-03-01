# Code samples from my CorkDev talk on property-based testing

I gave a talk on property-based testing at CorkDev on the 28th of February,
2017. This repo contains the code samples I used during that talk.

## Requirements

- [Scala](http://www.scala-lang.org/)
- [sbt](http://www.scala-sbt.org/)

## Running tests

To execute all the tests, run

```
sbt test
```

To execute only one particular test suite, run

```
sbt "test-only <path-to-test-suite>"
```

## Partitioner example

This simple example demonstrates how property-based tests can detect bugs
in a naïve implementation that example-based tests would miss.

## Recently-Used-List example

A Recently Used List is an abstraction that Kevlin Henney often uses in his
talks and workshops. It's an interesting data structure in that it's a bit
like a set, a list, a stack, all rolled into one.

In this example, I fully specify my Recently Used List with property-based
tests, with emphasis on readability.

# Resources

- Slides: TBA
- Video: TBA
- [Meetup](https://www.meetup.com/corkdev-io/events/237848006/)
- [CorkDev](http://corkdev.io/)
- [Kevlin Henney's talk at ITT 2016](https://www.youtube.com/watch?v=ZsHMHukIlJY#t=5m15s)
