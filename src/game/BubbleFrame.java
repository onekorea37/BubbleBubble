package bubble.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bubble.game.component.Enemy;
import bubble.game.component.Player;
import bubble.game.music.BGM;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BubbleFrame extends JFrame {

	private BubbleFrame mContext = this;
	private JLabel backgroundMap;
	private Player player;
	private Enemy enemy;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	public void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backImage.png"));
		setContentPane(backgroundMap);
		player = new Player(mContext);
		add(player);
		enemy = new Enemy(mContext);
		add(enemy);
		new BGM();
	}

	public void initSetting() {
		setSize(1000, 640); // JFrame 크기 설정
		getContentPane().setLayout(null); // absolute 레이아웃
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 끌 때 JVM 같이 종료
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			
			// 키보드 클릭 이벤트
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyCode());
				
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if(!player.isLeft() && !player.isLeftWallCrash()) {
							player.left();
						}
						break;
					case KeyEvent.VK_RIGHT:
						if(!player.isRight() && !player.isRightWallCrash()) {
							player.right();
						}
						break;
					case KeyEvent.VK_UP:
						if(!player.isUp() && !player.isDown()) {
							player.up();						
						}
						break;
					case KeyEvent.VK_SPACE:
						player.attack();
						break;
				}				
			}
			
				// 키보드 해제 이벤트 핸들러
					@Override
					public void keyReleased(KeyEvent e) {
							switch(e.getKeyCode()) {
							case KeyEvent.VK_LEFT:
								player.setLeft(false);
								break;
							case KeyEvent.VK_RIGHT:
								player.setRight(false);
								break;
							}
					}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
