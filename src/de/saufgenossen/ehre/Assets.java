package de.saufgenossen.ehre;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 *
 * @author sreis
 */
public class Assets {

    public final BitmapFont comic;
    public final BitmapFont cali;
    public final BitmapFont califat;
    
    public Assets() {
        comic = new BitmapFont(Gdx.files.internal("fonts\\comic.fnt"));
        cali = new BitmapFont(Gdx.files.internal("fonts\\cali.fnt"));
        califat = new BitmapFont(Gdx.files.internal("fonts\\califat.fnt"));
    }
    
}
