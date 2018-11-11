/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import de.saufgenossen.ehre.Ehrenvoll;
import java.util.ArrayList;

/**
 *
 * @author sreis
 */
public class TabPane extends Table {

    private final ArrayList<TabButton> tabs = new ArrayList<TabButton>();

    public TabPane() {
        super();
        TabButton tab1 = new TabButton("tabup", "tabdown");
        TabButton tab2 = new TabButton("tabup", "tabdown");
        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(new TabButton("tabup", "tabdown"));
        tabs.add(new TabButton("tabup", "tabdown"));
        tabs.add(new TabButton("tabup", "tabdown"));
        
        tab2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Ehrenvoll.MAIN_SCREEN.setTab(Ehrenvoll.MAIN_SCREEN.chat);
            }
        });
        
        tab1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Ehrenvoll.MAIN_SCREEN.setTab(Ehrenvoll.MAIN_SCREEN.pane);
            }
        });
        
        ButtonGroup bg = new ButtonGroup();
        for (TabButton tab : tabs) {
            bg.add(tab);
            super.add(tab).width(Gdx.graphics.getWidth()/5).height(Gdx.graphics.getWidth()/5);
        }
    }

}
