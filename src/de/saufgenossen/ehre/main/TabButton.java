package de.saufgenossen.ehre.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 *
 * @author sreis
 */
public class TabButton extends ImageButton{

    public TabButton(String up, String down) {
        super(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal(up+".png")))), new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal(down+".png")))), new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal(down+".png")))));
    }
}
