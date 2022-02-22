
README file for the JMM Checker
-------------------------------------------

1. You will need to download XSB from http://xsb.sourceforge.net
   XSB is a logic programming system which supports memoized or
   tabled evaluation.

2. After installing XSB, use the jmm-tar.gz  to create 
   a directory for the checker.
            gunzip jmm-tar.gz
            tar -xvf jmm-tar 

3. Henceforth we assume that all files are in the directory
   ./JMM. Make sure that the multithreaded program which you will
   check/simulate is in the directory ./JMM. All such files
   come with the extension .eg ("eg" standing for example).

4. Take any existing example file (say  sparc1.eg) to make the
   format of your program acceptable to the checker.

5. cd ./JMM
   
   Run XSB, and at the prompt load the "script" file
   ?- [script].

7. This will prompt you for a file name. You should enter the
   file containing the multithreaded program you want to check.
   Thus the interaction is as follows. Note that you
   should enclose the filename within quotes and end with a period.

   ENTER the example filename (within single quotes)

   'sparc1.eg'.

8. The example-file will now be dynamically loaded, and its query 
   executed. Currently, each of the example files come with a 
   0-ary predicate called "query" which defines the checking/simulation 
   requested by the user. In the example files given with this distribution,
   there are two types of queries:

   a) a simple reachability query (whether a particular violating 
      state is reachable) leading to a yes-no answer.
   
   b) printing all final states. This can be further refined to 
      print all final states which satisfy a certain property. The
      output is, by convention written to a .beh file ("beh" stands
      for behaviors).
  
   Of course, you can write your own queries as logic 
   program predicates.
   

9. The current implementation only supports the core JMM as defined
   in the Java Language Specification of 1996. Volatile varaibles
   and prescient stores are not supported. The examples that come 
   with this distribution are:

   swap.eg 
       (from Java Language Specification 1996)
   dcheck.eg, write-buf.eg 
       (Double Checked Locking and an example 
        showing the role of write buffers.
        Both are taken from the original paper by Bill Pugh
        "Fixing the Java Memory Model", Java Grande 1999)
   sparc1.eg, sparc2.eg, sparc3, sparc4.eg
       (Taken from Appendix D (formal spec. of memory models)
        pages 262 - 265, Sparc Architecture Manual Version 9).
   

10. Finally, this is a prototype system; so there (must be) plenty
    of bugs. Please send your bug reports to abhik@comp.nus.edu.sg
    with sufficient details (such as your example file). I will
    be happy to take a look whenever I get some free time.

Abhik Roychoudhury
National University of Singapore
abhik@comp.nus.edu.sg

---------------------------------
Acknowledgements and References
---------------------------------
This checker is an implementation of joint research work 
with Tulika Mitra. The relevant reference is:

"Specifying Multithreaded Java Semantics for Program Verification"
        A. Roychoudhury and T. Mitra
        ACM SIGSOFT International Conference on Software Engineering (ICSE) 2002, 
        pages 489-499. 

