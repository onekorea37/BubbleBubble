package bubble.game.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import bubble.game.component.Bubble;
import bubble.game.component.Player;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private List<Bubble> bubbleList;
	
	 
	public BackgroundPlayerService(Player player) {
			this.player = player;
			this.bubbleList = player.getBubbleList();
			try {
				image = ImageIO.read(new File("image/backgroundMapService.png"));
			} catch (Exception e) {
					System.out.println(e.getMessage());
			}
			
	}
	
	@Override
	public void run() {
		while(true) {
			// 1 버블 충돌 체크 
				for(int i=0; i < bubbleList.size(); i++) {
					Bubble bubble = bubbleList.get(i);
					if(bubble.getState() == 1) {
						if ((Math.abs(player.getX() - bubble.getX()) < 10)
								&& Math.abs(player.getY() - bubble.getY()) > 0 && Math.abs(player.getY() - bubble.getY()) < 50) {
								System.out.println("적군 사살 완료");
								bubble.clearBubbled();
								break;
						}
						
					}
				}
			
				
			// 2 벽 충돌 체크 
			Color leftcolor = new Color(image.getRGB(player.getX() -10, player.getY() +25 ));
			Color rightcolor = new Color(image.getRGB(player.getX() +50 + 15 , player.getY() +25));	
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
											+ image.getRGB(player.getX() + 50, player.getY() + 50 + 5);
			// 바닥 충돌 확인 
			if (bottomColor != -2) {
			//	System.out.println("바텀 컬러:" +bottomColor);
			//	System.out.println("바닥에 충돌함");
				player.setDown(false);
			} else {
				if (!player.isUp() && !player.isDown()) {
				//	System.out.println("다운 실행됨");
					player.down();					
				}
			}
			
			// 외벽 충돌 확인 
			if(leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0 ) {
			//	System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
				
			} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0 ) {
			//	System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);

			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}

		}
	
	}
	
}