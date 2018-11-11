/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.chat;

import de.saufgenossen.ehre.main.genossenlist.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Scaling;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.Ehrung;
import de.saufgenossen.ehre.client.data.Genosse;
import java.util.ArrayList;

/**
 *
 * @author sreis
 */
public class Chat extends Table {

    private final ArrayList<EhrungWidget> ehrungen = new ArrayList<EhrungWidget>();

    private Table table;

    public Chat() {
        table = new Table();
        updateData();

        Image image = new Image(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("chat\\banner.png")))));
        image.setScaling(Scaling.fit);
        super.add(image).height(image.getHeight() * Gdx.graphics.getWidth() / image.getWidth()).top();
        super.top();
        super.row();

        ScrollPane pane = new ScrollPane(table);
        super.add(pane);
        
        SpriteDrawable s = new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("chat\\bg.png"))));
        s.setMinWidth(1);
        super.background(s);
        
        table.left();
    }

    private void addEhrung(Ehrung e) {
        EhrungWidget label = new EhrungWidget(e);
        ehrungen.add(label);
        
    }

    public void updateData() {
        ehrungen.clear();
        
        for (Ehrung ehrung : Ehrenvoll.data.root.ehrungen) {
            addEhrung(ehrung);
        }

        table.clear();
        
        for (EhrungWidget widget : ehrungen) {
            table.add(widget).padBottom(50).width(Gdx.graphics.getWidth() * 0.9f).height(widget.getHeight());
            table.row();
        }
    }
}
