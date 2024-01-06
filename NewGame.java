package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NewGame extends JFrame implements IFrame, INewGame {
	private INumber_Player number_Player;
	private IMenu menu;
	private JButton btOnePlayer;
	private JButton btTwoPlayer;
	private JButton btBack;

	/**
	 * Create the panel.
	 */
	public NewGame() {
        getContentPane().setBackground(Color.GREEN);
        setTitle("Ô Ăn Quan");
        setSize(WIDTHJF, HEIGHTJF);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComps();

        twoPlayer();
        back();
    }

    public void initComps() {
        getContentPane().setLayout(new BorderLayout(50, 50));
        JPanel panel_4 = new JPanel();
        panel_4.setOpaque(false);
        getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setOpaque(false);
        panel_4.add(panel_6);
        panel_6.setLayout(new GridLayout(1, 1, 0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setOpaque(false);
        panel_6.add(panel_8);
        panel_8.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Ô Ăn Quan ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 75));
        panel_8.add(lblNewLabel, BorderLayout.CENTER);

        JPanel panel_6_1 = new JPanel();
        panel_6_1.setOpaque(false);
        panel_4.add(panel_6_1);
        panel_6_1.setLayout(new GridBagLayout());

        btTwoPlayer = new JButton("2 Người chơi");
        btTwoPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        btTwoPlayer.setForeground(Color.RED);
        btTwoPlayer.setBackground(Color.CYAN);

        // Sử dụng GridBagLayout để quản lý vị trí của nút "2 Người chơi"
        GridBagConstraints gbc_btTwoPlayer = new GridBagConstraints();
        gbc_btTwoPlayer.insets = new Insets(0, 0, 20, 0); // Đặt khoảng cách dưới của nút
        gbc_btTwoPlayer.gridx = 0;
        gbc_btTwoPlayer.gridy = 0;
        panel_6_1.add(btTwoPlayer, gbc_btTwoPlayer);

        btBack = new JButton("Trở về");
        btBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                menu = new Menu();
                menu.setVisible(true);
            }
        });
        btBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        btBack.setForeground(Color.RED);
        btBack.setBackground(Color.CYAN);

        // Sử dụng GridBagLayout để quản lý vị trí của nút "Trở về"
        GridBagConstraints gbc_btBack = new GridBagConstraints();
        gbc_btBack.gridx = 0;
        gbc_btBack.gridy = 1;
        panel_6_1.add(btBack, gbc_btBack);
    }

    @Override
    public void twoPlayer() {
        btTwoPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNumber_Player_Game(Number_Player_Type.TWOPLAYER);
            }
        });
    }

    public void createNumber_Player_Game(Number_Player_Type numberType) {
        switch (numberType) {
            case TWOPLAYER:
                dispose();
                number_Player = new TwoPlayer();
                number_Player.setVisible(true);
                break;

            default:
                break;
        }
    }

	@Override
	public void back() {
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				menu = new Menu();
				menu.setVisible(true);
				;
			}
		});
	}
}
