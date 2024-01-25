package com.bmhs.gdxintro.gfx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.assets.WorldTile;

public class TileHandler {

    public static TileHandler tileHandler = null;

    private int spriteOnSheetHeight, spriteOnSheetWidth;

    private String primaryColorSheetPath = "primaryColorSheet.png";

    private Array<WorldTile> worldTileArray;

    private TileHandler() {
        worldTileArray = new Array<>();

        spriteOnSheetHeight = Tile.ON_SCREEN_DEFAULT_HEIGHT;
        spriteOnSheetWidth = Tile.ON_SCREEN_DEFAULT_WIDTH;

        Texture tempTexture = new Texture(primaryColorSheetPath);

        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 4, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "black");
        worldTileArray.add(blackWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 6, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 1, "red");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 4, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile brownWorldTile = new WorldTile(tempRegion, 2, "brown");
        worldTileArray.add(brownWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 8, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile beigeWorldTile = new WorldTile(tempRegion, 3, "beige");
        worldTileArray.add(beigeWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 10, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile yellowWorldTile = new WorldTile(tempRegion, 4, "yellow");
        worldTileArray.add(yellowWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 12, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile greyWorldTile = new WorldTile(tempRegion, 5, "grey");
        worldTileArray.add(greyWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 14, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile darkGreyWorldTile = new WorldTile(tempRegion, 6, "dark Grey");
        worldTileArray.add(darkGreyWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 16, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blueWorldTile = new WorldTile(tempRegion, 7, "blue");
        worldTileArray.add(blueWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 18, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile greenWorldTile = new WorldTile(tempRegion, 8, "green");
        worldTileArray.add(greenWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile whiteWorldTile = new WorldTile(tempRegion, 9, "white");
        worldTileArray.add(whiteWorldTile);

    }



    public Array<WorldTile> getWorldTileArray() {
        return worldTileArray;
    }

    public static TileHandler getTileHandler() {
        if(tileHandler == null) {
            tileHandler = new TileHandler();
        }
        return tileHandler;
    }
}
