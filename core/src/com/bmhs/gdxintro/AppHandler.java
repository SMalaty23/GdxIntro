package com.bmhs.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;

	//delete me
	//Texture img;
	//TextureRegion subImg;

	int x, y;

	int[][] worldIntArray = {{0,0,0,0,0,0,0,0,0,0,0,9,9,9,2,2,2,2,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,2,2,2,2,2,2,2,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,9,1,2,1,1,1,1,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,9,1,1,8,1,1,1,1,1,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,9,1,1,4,1,1,1,1,1,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,9,1,1,1,7,1,1,1,1,1,1,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,9,2,2,3,3,0,3,3,3,3,3,0,3,3,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,9,2,2,3,3,3,0,3,3,3,3,3,0,3,3,3,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,9,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,9,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,2,2,3,3,3,2,2,3,2,2,3,3,3,2,2,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,2,2,6,3,2,3,3,3,3,3,2,3,6,2,2,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,2,9,6,6,9,2,3,2,3,2,9,6,6,9,2,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,6,9,9,2,3,2,9,9,6,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,6,9,9,8,3,4,9,9,6,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,6,9,9,2,3,2,9,9,6,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,6,9,9,9,9,9,9,9,6,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,6,9,9,9,9,9,9,9,6,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,6,9,9,9,9,9,9,9,9,9,6,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,9,2,2,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,2,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,9,2,3,3,3,1,1,1,1,1,1,1,1,1,3,3,3,2,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,9,3,3,9,6,6,6,6,6,6,6,6,6,1,3,3,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,9,9,9,6,6,6,6,6,6,6,6,6,1,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,6,6,6,5,5,5,6,6,6,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,6,6,6,6,5,6,6,6,6,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,6,6,6,6,5,6,6,6,6,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,6,6,6,6,5,6,6,6,6,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,9,9,9,9,9,9,9,9,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

	@Override
	public void create() {
		batch = new SpriteBatch();

		//delete me
		//img = new Texture("primaryColorSheet.png");
		//subImg = new TextureRegion(TileHandler.getTileHandler().getWorldTileArray().get(0).getTexture(), 64, 0, 128, 128);

		x = 0;
		y = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < worldIntArray.length; r++) {
			for(int c = 0; c < worldIntArray[r].length; c++){
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(worldIntArray[r][c]).getTexture(), c* Tile.ON_SCREEN_DEFAULT_WIDTH, Gdx.graphics.getHeight() - Tile.ON_SCREEN_DEFAULT_HEIGHT - (r*Tile.ON_SCREEN_DEFAULT_HEIGHT));
			}
		}
		/*
		for(int r = 0; r < Gdx.graphics.getHeight(); r+=64) {
			for(int c = 0; c < Gdx.graphics.getWidth(); c+=64) {
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(MathUtils.random(4)).getTexture(), c, r);
				if(x > 4) {
					x = 0;
				}
			}
		}
		*/

		batch.end();

		checkInput();
	}

	public void checkInput() {

      /*
      if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
         y += 10;
      }
      else if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
         y -= 10;
      }
      else if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
         x -= 10;
      }
      else if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
         x += 10;
      }


      System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());

      x = Gdx.input.getX() - img.getWidth()/2;
      y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2;


      if(x < (Gdx.input.getX() - img.getWidth()/2)) {
         x += 5;
      }
      if(x > (Gdx.input.getX() - img.getWidth()/2)) {
         x -= 5;
      }
      if(y < (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
         y += 5;
      }
      if(y > (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
         y -= 5;
      }
*/
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}