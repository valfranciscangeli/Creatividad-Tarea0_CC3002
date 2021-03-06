/**
 * Trabajo realizado por Valeria Vallejos Franciscangeli
 * Tarea 0 - CC3002 Otoño 2022
 * Clase Comic/Historieta (Comic), subclase de Trabajo Literario (LiteraryWork)
 * Por cohesion se trabaja con nombres en inglés
 */

import java.util.Arrays;  // se trabajara con arreglos de string

public class Comic extends LiteraryWork{
    // parametros
    private String writer;
    private String[] cartoonists;

    // constructor con copyright
    public Comic(String aTitle, String anEditorial, String aWriter, String[] listCartoonists, String aCopyright){
        super(aTitle,anEditorial,aCopyright);
        this.writer = aWriter;
        this.cartoonists = listCartoonists;
    }

    // constructor sin copyright
    public Comic(String aTitle, String anEditorial, String aWriter, String[] listCartoonists){
       this(aTitle,anEditorial, aWriter, listCartoonists, null);
    }

    // metodos para recuperar informacion de los campos
    public String getWriter() {
        return writer;
    }
    public String[] getCartoonists() {
        return cartoonists;
    }

    // Metodo para pasar contenido de una Movie a un string que lo describa
    @Override
    public String toString() {
        String aux = super.toString();
        int len = aux.length();
        return "Comic{" + aux.substring(13, len-1)+
                ", writer='" + writer + '\'' +
                ", cartoonists=" + Arrays.toString(cartoonists) + '\'' +
                '}';
    }

    // Metodo equals para comparar si 2 Comics son iguales (en memoria y/o en contenido)
    @Override
    public boolean equals(Object otherComic) {
        //iguales si son exactamente el mismo dato en la memoria
        if (this == otherComic) return true;
        // no son iguales si el otro no es de clase Comic
        if (!(otherComic instanceof Comic)) return false;
        // si nunguno tiene copyright comparamos los titulos y editorial
        if (this.getCopyright()==null && ((Comic) otherComic).getCopyright()==null){
            return ((Comic) otherComic).getTitle().equals(this.getTitle()) &&
                    ((Comic)otherComic).getPublisher().equals(this.getPublisher()) &&
                    ((Comic)otherComic).writer.equals(this.writer) &&
                    Arrays.equals(((Comic) otherComic).cartoonists, this.cartoonists);
        }
        // comparamos titulos y copyright
        if (this.getCopyright()!=null && ((Comic) otherComic).getCopyright()!=null){
            return ((Comic) otherComic).getTitle().equals(this.getTitle()) &&
                    ((Comic)otherComic).getPublisher().equals(this.getPublisher()) &&
                    ((Comic)otherComic).writer.equals(this.writer) &&
                    Arrays.equals(((Comic) otherComic).cartoonists, this.cartoonists) &&
                    ((Comic)otherComic).getCopyright().equals(this.getCopyright());
        }
        // otro caso: no son iguales
        return false;
    }
}
