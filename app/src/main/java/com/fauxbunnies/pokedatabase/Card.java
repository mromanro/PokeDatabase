package com.fauxbunnies.pokedatabase;

import android.media.Image;

/**
 * Created by MacAir on 9/6/15.
 */
public class Card extends ListItem{

    public String image;
    public String type;

    public Card(String title, String image) {
        super(null, title);
        this.image = image;
    }

    public Card(String title, String image, String type) {
        super(null, title);
        this.image = image;
        this.type = type;
        setTypeImage(type);
    }

    public Card(String title, String image, String type, String typeImage) {
        super(typeImage, title);
        this.image = image;
        this.type = type;
        setTypeImage(type);
    }

    public void setTypeImage(String type) {
        System.out.println("TYPE: " + type);

        if(type.equals("fire")) {
            this.imageSrc = "Pokemon/Fire-attack.png";
        }
        else if(type.equals("water")) {
            this.imageSrc = "Pokemon/Water-attack.png";
        }
        else if(type.equals("fighting")) {
            this.imageSrc = "Pokemon/Fighting-attack.png";
        }
        else if(type.equals("dark")) {
            this.imageSrc = "Pokemon/Darkness-attack.png";
        }
        else if(type.equals("fairy")) {
            this.imageSrc = "Pokemon/Fairy-attack.png";
        }
        else if(type.equals("psychic")) {
            this.imageSrc = "Pokemon/Psychic-attack.png";
        }
        else if(type.equals("grass")) {
            this.imageSrc = "Pokemon/Grass-attack.png";
        }
        else if(type.equals("steel")) {
            this.imageSrc = "Pokemon/Metal-attack.png";
        }
        else if(type.equals("lightning")) {
            this.imageSrc = "Pokemon/Lightning-attack.png";
        }
        else if(type.equals("colorless")) {
            this.imageSrc = "Pokemon/Colorless-attack.png";
        }
        else if(type.equals("dragon")) {
            this.imageSrc = "Pokemon/Dragon-attack.png";
        }

        System.out.println("CARDS IMAGE: " + this.imageSrc);
    }

    @Override
    public String toString() {
        return title;
    }
}
