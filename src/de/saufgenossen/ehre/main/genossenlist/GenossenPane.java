/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.main.genossenlist;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Scaling;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.Genosse;
import java.util.ArrayList;

/**
 *
 * @author sreis
 */
public class GenossenPane extends Table {

    private final ArrayList<GenosseButton> genossen = new ArrayList<GenosseButton>();

    private Table table;

    public GenossenPane() {

        table = new Table();
        updateData();

        Image image = new Image(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("genossen\\banner.png")))));
        image.setScaling(Scaling.fit);
        super.add(image).height(image.getHeight() * Gdx.graphics.getWidth() / image.getWidth()).top();
        super.top();
        super.row();

        ScrollPane pane = new ScrollPane(table);
        super.add(pane);

        SpriteDrawable s = new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("genossen\\BG.png"))));
        s.setMinWidth(1);
        super.background(s);
    }

    private void addGenosse(Genosse genosse) {
        GenosseButton label = new GenosseButton(genosse);
        genossen.add(label);
    }

    public void updateData() {
        genossen.clear();
        for (Genosse genosse : Ehrenvoll.data.root.genossenListe) {
            addGenosse(genosse);
        }

        table.clear();
        
        for (GenosseButton label : genossen) {
            table.add(label).padBottom(50).width(Gdx.graphics.getWidth() * 0.9f).expandX();
            table.row();
        }

    }

}
