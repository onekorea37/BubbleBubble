package bubble.game.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import bubble.game.component.Enemy;

public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;

// 플레이어 버블 
	public BackgroundEnemyService(Enemy enemy) {
			this.enemy = enemy;
			try {
				image = ImageIO.read(new File("image/backgroundMapService.png"));
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
			
	}
	
	@Override
	public void run() {
		while(enemy.getState() == 0) {
				
			// 2 벽 충돌 체크 
			Color leftcolor = new Color(image.getRGB(enemy.getX() -10, enemy.getY() +25 ));
			Color rightcolor = new Color(image.getRGB(enemy.getX() +50 + 15 , enemy.getY() +25));	
			int bottomColor = image.getRGB(enemy.getX() + 10, enemy.getY() + 50 + 5)
											+ image.getRGB(enemy.getX() + 50, enemy.getY() + 50 + 5);
			// 바닥 충돌 확인 
			if (bottomColor != -2) {
			//	System.out.println("바텀 컬러:" +bottomColor);
			//	System.out.println("바닥에 충돌함");
				enemy.setDown(false);
			} else {
				if (!enemy.isUp() && !enemy.isDown()) {
				//	System.out.println("다운 실행됨");
					enemy.down();					
				}
			}
			
			// 외벽 충돌 확인 
			if(leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0 ) {
			//	System.out.println("왼쪽 벽에 충돌함")
				enemy.setLeft(false);
				if(!enemy.isRight()) {
					enemy.right();
				}
				
			} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0 ) {
			//	System.out.println("오른쪽 벽에 충돌함");
				enemy.setRight(false);
				if(!enemy.isLeft()) {
					enemy.left();
				}
				}

			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}

		}
	
	}