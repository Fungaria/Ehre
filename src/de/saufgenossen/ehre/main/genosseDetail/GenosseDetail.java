/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.main.genosseDetail;

import de.saufgenossen.ehre.main.genossenlist.GenosseButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.Genosse;
import de.saufgenossen.ehre.client.data.NetworkData.EhreRequest;
import java.util.ArrayList;

/**
 *
 * @author sreis
 */
public class GenosseDetail extends Table {
    private final ArrayList<GenosseButton> genossen = new ArrayList<GenosseButton>();
    
    private final Genosse genosse;

    public GenosseDetail(final Genosse genosse) {
        
        this.genosse = genosse;
        
        Table table = new Table();
        DetButton esc = new DetButton("escup", "escdown");
        DetButton plus = new DetButton("plusup", "plusdown");
        DetButton minus = new DetButton("minusup", "minusdown");

        super.center().top();
        super.add(esc).width(Gdx.graphics.getWidth()*0.5f).colspan(2);
        
        super.row();
        
        super.add(plus).width(Gdx.graphics.getWidth()/3f);
        super.add(minus).width(Gdx.graphics.getWidth()/3f);
        
        plus.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                addEhre(genosse.id, 2);
            }
        });
        minus.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                addEhre(genosse.id, -2);
            }
        });
        esc.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Ehrenvoll.MAIN_SCREEN.setTab(Ehrenvoll.MAIN_SCREEN.pane);
                Ehrenvoll.MAIN_SCREEN.pane.updateData();
            }
        });
        
        SpriteDrawable s = new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("genossen\\BG.png"))));
        s.setMinWidth(Gdx.graphics.getWidth());
        super.background(s);
    }
    
    public void addEhre(int id, int ehre){
        EhreRequest request = new EhreRequest();
        request.ehreChange = ehre;
        request.id = id;
        
        Ehrenvoll.client.sendTCP(request);
    }
}
