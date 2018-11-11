package de.saufgenossen.ehre.main.genossenlist;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.Genosse;
import de.saufgenossen.ehre.main.genosseDetail.GenosseDetail;

/**
 *
 * @author sreis
 */
public class GenosseButton extends Button {

    public final Genosse genosse;
    
    public GenosseButton(Genosse genosse) {
        super(new TS(genosse.name, genosse.ehre, genosse.rank, genosse.pb), new BStyle());
        this.genosse = genosse;
        super.left();
        super.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Ehrenvoll.MAIN_SCREEN.setTab(new GenosseDetail(GenosseButton.this.genosse));
            }
        });
    }

    private static class TS extends Table {
        public TS(String name, int ehre, int rank, String pb) {
            super();
            super.add(new Label(rank+".", new LStyle())).width(100);
            super.add(getImg(pb+".png")).width(100);
            super.add(new Label(name, new LStyle())).width(120);
            super.add(new Label("+"+ehre, new LStyle()));
            super.left();
        }
    }

    public static Table getImg(String name) {
        Texture texture = new Texture(Gdx.files.internal("files\\pbs\\"+name));
        int x, y, w, h;
        if (texture.getWidth() >= texture.getHeight()) {
            w = h = texture.getHeight();
            y = 0;
            x = (texture.getWidth() - texture.getHeight()) / 2;
        } else {
            w = h = texture.getWidth();
            x = 0;
            y = (texture.getHeight() - texture.getWidth()) / 2;
        }
        Image image = new Image(new SpriteDrawable(new Sprite(new TextureRegion(texture, 0, 0, 316, 316))));
        Table table = new Table();
        table.add(image).size(60, 60);
        return table;
    }

    private static class LStyle extends LabelStyle {
        public LStyle() {
            super(Ehrenvoll.assets.comic, Color.BLACK);
        }
    }

    private static class BStyle extends ButtonStyle{
        public BStyle() {
            super(new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("genossen\\genossebg.png")), 5, 5, 5, 5)), new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("genossen\\genossebgpressed.png")), 5, 5, 5, 5)), new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("genossen\\genossebg.png")), 5, 5, 5, 5)));
        }
    }
}
