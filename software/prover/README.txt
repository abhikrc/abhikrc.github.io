
A transformation based prover for proving predicate implications
-------------------------------------------------------------------

1. You will need to download XSB from http://xsb.sourceforge.net
   XSB is a logic programming system which supports memoized or
   tabled evaluation.

2. After installing XSB, create a directory for the prover
   (henceforth assumed to be ./Prover)

3. Use the code-tar.gz and ex-tar.gz to create subdirectories
   ./Prover/Code and ./Prover/Examples in the usual way
            gunzip code-tar.gz
            tar -xvf code-tar

4. Make sure that the logic program whose predicate implications
   you want to prove is in the Examples subdirectory. Take any
   existing file in this subdirectory (e.g. mesi) to make the
   format of your program acceptable to the prover.

5. cd ./Prover/Code

6. Run XSB, and at the prompt load the "script" file
   ?- [script].

7. This will prompt you for a file name. You should enter the
   file containing the program whose predicate implication you want 
   to prove. Thus the interaction is as follows. Note that you
   should enclose the filename within quotes and end with a period.

   Enter the program file name

   'mesi'.

8. The example-file will now be dynamically loaded. You should now
   submit your proof obligation at the XSB prompt. This is as follows.
   Note that the arity of the predicates is explicitly mentioned. The
   system will now try to construct a proof and report yes/no. By
   default, the prover is in verbose mode, so it generates a description
   of the salient proof steps. You can always redirect the output.

   prove(bad_dest/2, bad_src/2).
   
9. Currently the system proves predicate implications in pure definite
   logic programs. Therefore, the above proof obligations proves that
            forall X,Y bad_dest(X, Y) => bad_src(X, Y)
   in the least Herbrand Model of the program under consideration.

10. Finally, this is a prototype system; so there (must be) plenty
    of bugs. Please send your bug reports to abhik@comp.nus.edu.sg
    with sufficient details (such as your example file). I will
    be happy to take a look whenever I get some free time.

Abhik Roychoudhury
National University of Singapore
abhik@comp.nus.edu.sg


Acknowledgements:  

A substantial part of the prover was developed in course of my 
Ph.D. work at SUNY Stony Brook. 
