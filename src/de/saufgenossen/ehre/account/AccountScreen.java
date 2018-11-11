/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.account;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author sreis
 */
public class AccountScreen extends ScreenAdapter{

    private Stage stage;
    private Viewport viewport;
    
    @Override
    public void show() {
        super.show();
        
        createUI();
    }
    
    private void createUI(){
        this.viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        stage.setDebugAll(true);
        
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);
        
        root.add();
    }
    
    @Override
    public void dispose() {
        super.dispose();
        stage.clear();
        stage.dispose();
    }

    @Override
    public void hide() {
        super.hide();
        dispose();
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT| GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
    }
}
