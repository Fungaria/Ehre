package de.saufgenossen.ehre.chat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.Ehrung;

/**
 *
 * @author sreis
 */
public class EhrungWidget extends Table {

    private final Ehrung data;

    public EhrungWidget(Ehrung e) {
        this.data = e;

        Label name = new Label(data.name, new NameLabel());
        Label ehre = new Label("+5", new EhreLabel());
        Label date = new Label("12.05.1018", new DateLabel());

        Table group = new Table();
        name.setFontScale(0.3f);
        ehre.setFontScale(0.3f);
        date.setFontScale(0.2f);
        
        group.add(name).left();
        group.left();
        super.add(group).left();
        super.left();
        
//        super.add(ehre).padRight(30);
//        super.add(date).padRight(30);
        
        Texture texture = new Texture(Gdx.files.internal("chat\\rounded.png"));
        NinePatch ninePatch = new NinePatch(texture, 70, 70, 70, 70);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(ninePatch);
        
        ninePatch.scale(0.2f, 0.2f);
        
        super.setHeight(Gdx.graphics.getHeight()/10);
        super.background(ninePatchDrawable);
    }

    public static class NameLabel extends Label.LabelStyle {

        public NameLabel() {
            super.font = Ehrenvoll.assets.califat;
            super.fontColor = new Color(0.494f, 0.8235f, 0.945f, 1);
        }
    }

    private static class DateLabel extends Label.LabelStyle {

        public DateLabel() {
            super.font = Ehrenvoll.assets.cali;
            super.fontColor = Color.BLACK;
            super.fontColor = new Color(0, 0, 0, 0.6f);
        }
    }

    private static class EhreLabel extends Label.LabelStyle {

        public EhreLabel() {
            super.font = Ehrenvoll.assets.califat;
            super.fontColor = Color.BLACK;
            
            NinePatch bg = new NinePatch(new Texture(Gdx.files.internal("chat\\rounded.png")), 70, 70, 70, 70);
            bg.scale(0.1f, 0.1f);
            super.background = new NinePatchDrawable(bg);
            bg.setColor(Color.GREEN);
        }
    }
}
