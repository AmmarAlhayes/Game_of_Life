import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Game_Of_Life {

	private JFrame frame;
	private JButton[][] b = new JButton[30][30];
	private boolean[][] born = new boolean[30][30];
	private boolean[][] dead = new boolean[30][30];
	private boolean[][] alive = new boolean[30][30];
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_Of_Life window = new Game_Of_Life();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game_Of_Life() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Game Of Life");
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 610, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 574, 317);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(30, 30));

		///// to add the 30*30 Raster
		Random random = new Random();
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				b[i][j] = new JButton();
				panel.add(b[i][j]);
				b[i][j].setEnabled(false);
				
				/////////////  The first Generation   ////////////////////////
				
				alive[i][j] = random.nextBoolean();
				if(alive[i][j] == true)
				b[i][j].setBackground(Color.BLACK);
				
			}
		}

		
		///// to change the Generation
		
		JButton btnNewButton = new JButton("Press");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				////////  to look for the dead,alive and the born Cells
				
				for (int i = 0; i < b.length; i++) {
					for (int j = 0; j < b.length; j++) {
						
						////// to check the top left Cell
						if (i - 1 < 0 && j - 1 < 0) {

							if ((alive[i][j + 1] == true && born[i][j + 1] == false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if ((alive[i + 1][j] == true && born[i + 1][j] == false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							if ((alive[i + 1][j + 1] == true && born[i + 1][j + 1] == false)||(alive[i+1][j+1]==false && dead[i+1][j+1]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							} else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								
								///Reset the default Color of the Button
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count=0;

						}
						
						/////to check the top right Cell
						
						else if(i - 1 < 0 && j + 1 == b.length) {
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i+1][j-1]==true && born[i+1][j-1]==false)||(alive[i+1][j-1]==false && dead[i+1][j-1]==true))
								count++;
							if((alive[i+1][j]==true && born[i+1][j]==false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							} else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count=0;
						}
						
						//////////to check the top Side Cells except the top right Cell and the top left Cell
						
						else if(i - 1 < 0 ) {
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i+1][j-1]==true && born[i+1][j-1]==false)||(alive[i+1][j-1]==false && dead[i+1][j-1]==true))
								count++;
							if((alive[i][j+1]==true && born[i][j+1]==false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if((alive[i+1][j+1]==true && born[i+1][j+1]==false)||(alive[i+1][j+1]==false && dead[i+1][j+1]==true))
								count++;
							if((alive[i+1][j]==true && born[i+1][j]==false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							} else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count =0;
						}
						
						//////////to check the bottom left Cell
						
						else if (i + 1 == b.length && j - 1 < 0) {

							if ((alive[i][j + 1] == true && born[i][j + 1] == false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if ((alive[i - 1][j] == true && born[i - 1][j] == false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							if ((alive[i - 1][j + 1] == true && born[i - 1][j + 1] == false)||(alive[i-1][j+1]==false && dead[i-1][j+1]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							} else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							} else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count=0;

						}
						
						/////////////to check the Bottom Right Cell
						
						else if(i + 1 == b.length && j + 1 == b.length) {
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i-1][j-1]==true && born[i-1][j-1]==false)||(alive[i-1][j-1]==false && dead[i-1][j-1]==true))
								count++;
							if((alive[i-1][j]==true && born[i-1][j]==false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							} else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								} 
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count=0;
						}
						
						/////////////////to check the Bottom Side Cells except the Bottom Right Cell and the Bottom left Cell
						
						else if(i + 1 == b.length ) {
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i-1][j-1]==true && born[i-1][j-1]==false)||(alive[i-1][j-1]==false && dead[i-1][j-1]==true))
								count++;
							if((alive[i][j+1]==true && born[i][j+1]==false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if((alive[i-1][j+1]==true && born[i-1][j+1]==false)||(alive[i-1][j+1]==false && dead[i-1][j+1]==true))
								count++;
							if((alive[i-1][j]==true && born[i-1][j]==false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							}else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count =0;
						}
						
						/////////to check the left Side Cells except the Bottom left Cell and the top left Cell
						
						else if(j - 1 < 0 ) {
							if((alive[i+1][j]==true && born[i+1][j]==false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							if((alive[i+1][j+1]==true && born[i+1][j+1]==false)||(alive[i+1][j+1]==false && dead[i+1][j+1]==true))
								count++;
							if((alive[i][j+1]==true && born[i][j+1]==false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if((alive[i-1][j+1]==true && born[i-1][j+1]==false)||(alive[i-1][j+1]==false && dead[i-1][j+1]==true))
								count++;
							if((alive[i-1][j]==true && born[i-1][j]==false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							}else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count =0;
						}
						
						//////////to check the Right Side Cells except the Bottom Right Cell and the top right Cell
						
						else if(j + 1 == b.length ) {
							if((alive[i+1][j]==true && born[i+1][j]==false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							if((alive[i+1][j-1]==true && born[i+1][j-1]==false)||(alive[i+1][j-1]==false && dead[i+1][j-1]==true))
								count++;
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i-1][j-1]==true && born[i-1][j-1]==false)||(alive[i-1][j-1]==false && dead[i-1][j-1]==true))
								count++;
							if((alive[i-1][j]==true && born[i-1][j]==false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							}else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
								}
							else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count =0;
						}
						
						//////////to check the Other Cells
						
						else {
							if((alive[i+1][j]==true && born[i+1][j]==false)||(alive[i+1][j]==false && dead[i+1][j]==true))
								count++;
							if((alive[i+1][j-1]==true && born[i+1][j-1]==false)||(alive[i+1][j-1]==false && dead[i+1][j-1]==true))
								count++;
							if((alive[i][j-1]==true && born[i][j-1]==false)||(alive[i][j-1]==false && dead[i][j-1]==true))
								count++;
							if((alive[i-1][j-1]==true && born[i-1][j-1]==false)||(alive[i-1][j-1]==false && dead[i-1][j-1]==true))
								count++;
							if((alive[i-1][j]==true && born[i-1][j]==false)||(alive[i-1][j]==false && dead[i-1][j]==true))
								count++;
							if((alive[i+1][j+1]==true && born[i+1][j+1]==false)||(alive[i+1][j+1]==false && dead[i+1][j+1]==true))
								count++;
							if((alive[i][j+1]==true && born[i][j+1]==false)||(alive[i][j+1]==false && dead[i][j+1]==true))
								count++;
							if((alive[i-1][j+1]==true && born[i-1][j+1]==false)||(alive[i-1][j+1]==false && dead[i-1][j+1]==true))
								count++;
							
							if (count == 3 && alive[i][j] == false) {
								alive[i][j] = true;
								born[i][j] = true;
								b[i][j].setBackground(Color.BLACK);
							}else if ((count == 2 || count == 3) && alive[i][j] == true) {
								alive[i][j] = true;
							}else if(count==0) {
								alive[i][j] = false;
								b[i][j].setBackground(UIManager.getColor("control"));
							}else if (count < 2 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							} else if (count > 3 && alive[i][j] == true) {

								alive[i][j] = false;
								dead[i][j] = true;
								b[i][j].setBackground(UIManager.getColor("control"));

							}
							count =0;
						}
						
					}

				}
				
				born = new boolean[30][30];
				dead = new boolean[30][30];

			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(171, 366, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		////////////back to the first Generation
		
		JButton btnNewButton_1 = new JButton("Restart");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 30; i++) {
					for (int j = 0; j < 30; j++) {
						
						alive[i][j] = random.nextBoolean();
						if(alive[i][j] == true)
						    b[i][j].setBackground(Color.BLACK);
						else
							b[i][j].setBackground(UIManager.getColor("control"));	
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(341, 366, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Press to change the Generation");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(217, 341, 197, 14);
		frame.getContentPane().add(lblNewLabel);

	}
}
