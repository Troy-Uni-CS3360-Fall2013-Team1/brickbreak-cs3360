package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import com.example.brickbreak.engine.AnimatedSprite;
import com.example.brickbreak.engine.Engine;
import com.example.brickbreak.engine.Rectangle;
import com.example.brickbreak.engine.TiledTextureRegion;


public class Ball extends AnimatedSprite {
	
	float velocity = 100;
    int i =0;
    private Engine mEngine;
    
    public Ball(float positionX, float positionY, TiledTextureRegion positionTextureRegion, Engine mEngine) {
            super(positionX, positionY, positionTextureRegion);
            this.mEngine = mEngine;
    }

    
    protected void onManagedUpdate(final float pSecondsElapsed) {
            if(this.mX < 0) {
                    this.setVelocityX(velocity);
            } else if(this.mX + this.getWidth() > Game.getCAMERA_WIDTH()) {
                    this.setVelocityX(-velocity);
            }

            if(this.mY < 0) {
                    this.setVelocityY(velocity);
            } else if(this.mY + this.getHeight() > Game.getCAMERA_HEIGHT()) {
                    this.setVelocityY(-velocity);
            }

            super.onManagedUpdate(pSecondsElapsed);
    }
    
    public void bounceWithRectangle(Rectangle rectangle){
//            float ballPositionX = this.getX();
//            float ballPositionY = this.getY();
//            float centerVertical = rectangle.getX();
//            float westWall = rectangle.getX() - rectangle.getWidth()/2 - this.getWidth()/2;
//            float eastWall = rectangle.getX() + rectangle.getWidth()/2 + this.getWidth()/2;
//            float centerHorozontal = rectangle.getY();
//            float northWall = rectangle.getY() - rectangle.getHeight()/2 - this.getHeight()/2;
//            float southWall = rectangle.getY() + rectangle.getHeight()/2 + this.getHeight()/2;
//            
//            if(ballPositionX >= westWall || ballPositionX <= eastWall) {
//                    this.setVelocityX(-this.getVelocityX());
//            }
//            else {
                    this.setVelocityY(-this.getVelocityY());
//            }
    }

}
