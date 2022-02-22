# MSc (Mathematics and the Foundations of Computer Science)
# Thesis
# Oxford University
#
# $Id$

TEXFILES=	stokely.tex
OUTPUT=		stokely.ps
BIBFILES=	stokely.bib
SECTIONS=	intro.tex parassign.tex results.tex conc.tex
#USE_PIC=1
LATEX=		latex
BIBTEX=		bibtex
DVIPS=		dvips
#LATEX=		/opt/local/bin/latex
#BIBTEX=	/opt/local/bin/bibtex
#DVIPS=		/opt/local/bin/dvips

stokely.ps: stokely.tex ${SECTIONS}
	${LATEX} stokely.tex
	${LATEX} stokely.tex
	${BIBTEX} stokely
	${LATEX} stokely.tex
	${LATEX} stokely.tex
	${DVIPS} -f -Ppdf < stokely.dvi > stokely.ps
