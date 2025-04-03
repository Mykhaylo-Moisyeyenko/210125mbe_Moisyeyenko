package de.telran.dz_generic_20250311;

public class Singer implements Artist<Singer>{

    @Override
    public void perform(Singer singer) {
        System.out.println("I am Singer and i'm performing a song");
    }
}
