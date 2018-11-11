package de.saufgenossen.ehre.main.genosseDetail;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 *
 * @author sreis
 */
public class DetButton extends ImageButton{
    public DetButton(String up, String down) {
        super(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("genossen\\"+up + ".png")))), new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("genossen\\"+down + ".png")))));
    }
}