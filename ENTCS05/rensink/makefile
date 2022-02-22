MASTER = agt

# Subdirectories where figure and code files are stored
figdir = fig
codedir = java

# Lists of local LaTeX-related files
texfiles = $(wildcard *.tex)
bibfiles = $(wildcard *.bib)
styfiles = $(wildcard *.sty)

# List of local figure files
texfigfiles = $(wildcard $(figdir)/*.tex.fig)
epsfigfiles = $(wildcard $(figdir)/*.eps.fig)
giffiles = $(wildcard $(figdir)/*.gif) 

# List of local source code files
javafiles = $(wildcard $(codedir)/*.java)

# It should not be necessary to change the definitions below.
inclfiles = \
	$(javafiles:%.java=%.incl)
psgraphics = \
	$(texfigfiles:%.tex.fig=%.tex) $(texfigfiles:%.tex.fig=%.eps) \
	$(epsfigfiles:%.eps.fig=%.eps) $(giffiles:%.gif=%.eps)
pdfgraphics = \
	$(texfigfiles:%.tex.fig=%.tex) $(texfigfiles:%.tex.fig=%.pdf) \
	$(giffiles:%.gif=%.pdf) $(epsfigfiles:%.eps.fig=%.pdf)

%.incl : %.java
	./javaextract -incl $*.java

%.tex : %.tex.fig
	fig2dev -L pstex_t -p $* $*.tex.fig $@

%.eps : %.tex.fig
	fig2dev -L pstex $*.tex.fig $@

%.pdf : %.tex.fig
	fig2dev -L pdftex $*.tex.fig $@

%.eps : %.eps.fig
	fig2dev -L eps $*.eps.fig $@

%.pdf : %.eps
#	convert $*.eps $@
	fig2dev -L pdf $*.eps.fig $@

%.pdf : %.gif
	convert -crop 0x0 $*.gif $@

%.eps : %.gif
	convert -crop 0x0 $*.gif $@

%.pdf : $(MASTER).pdf
	cp $(MASTER).pdf $@

$(MASTER) : $(MASTER).ps

$(MASTER).ps : $(MASTER).dvi
	dvips -o $(MASTER).ps $(MASTER)

REPEAT_TEXT = 'Rerun to get cross-references right'

$(MASTER).dvi : $(texfiles) $(styfiles) $(psgraphics) $(javafiles) $(bibfiles)
	latex $(MASTER)
	while grep -s $(REPEAT_TEXT) $(MASTER).log ; do \
		latex $(MASTER) ; \
	done

$(MASTER).pdf : $(texfiles) $(styfiles) $(pdfgraphics) $(javafiles) $(bibfiles)
	pdflatex $(MASTER)
	while grep -s $(REPEAT_TEXT) $(MASTER).log ; do \
		pdflatex $(MASTER) ; \
	done

$(MASTER).bbl : $(bibfiles) $(texfiles)
	latex $(MASTER)
	bibtex $(MASTER)

clean :
	rm -f *.aux *.log *.blg *.dvi *.out $(MASTER).ps $(MASTER).pdf
	rm -f $(psgraphics)
	rm -f $(pdfgraphics)
	rm -f $(javadir)/*.class $(javadir)/*.incl 
	rm -rf auto
