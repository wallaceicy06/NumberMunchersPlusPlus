package com.seanharger.numbermunchers.game.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameView extends JFrame {

  private static final long serialVersionUID = 3834855183271066042L;

  private static final int BOARD_PADDING = 40;

  private static final int CELL_WIDTH = 100;
  private static final int CELL_HEIGHT = 60;

  private IGameViewToModelAdapter _model;

  private Dimension _boardDimensions;

  private final JPanel _paintCanvas = new JPanel() {

    private static final long serialVersionUID = -2302419587352491870L;

    {
      setOpaque(true);
      setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;

      super.paintComponent(g);

      g2.setColor(Color.GREEN);

      /* Draw the grid */

      g2.setStroke(new BasicStroke(2));
      for (int i = 0; i < _boardDimensions.width; i++) {
        for (int j = 0; j < _boardDimensions.height; j++) {
          g2.drawRect(BOARD_PADDING + i * CELL_WIDTH, BOARD_PADDING + j * CELL_HEIGHT, CELL_WIDTH,
              CELL_HEIGHT);
        }
      }

      g2.setColor(Color.RED);
      g2.setStroke(new BasicStroke(1));
      g2.drawLine(BOARD_PADDING, 0, BOARD_PADDING, 1000);
      g2.drawLine(BOARD_PADDING + CELL_WIDTH, 0, BOARD_PADDING + CELL_WIDTH, 1000);
      g2.drawLine(BOARD_PADDING + 2 * CELL_WIDTH, 0, BOARD_PADDING + 2 * CELL_WIDTH, 1000);


    }

  };

  public GameView(Dimension boardDimensions, IGameViewToModelAdapter model) {
    _model = model;
    _boardDimensions = boardDimensions;
    initialize(boardDimensions);
  }

  private void initialize(Dimension boardDimensions) {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    _paintCanvas.setPreferredSize(new Dimension(boardDimensions.width * CELL_WIDTH + 2
        * BOARD_PADDING, boardDimensions.height * CELL_HEIGHT + 2 * BOARD_PADDING));
    setContentPane(_paintCanvas);
    pack();
    setResizable(false);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        _model.stop();
        setVisible(false);
        dispose();
      }
    });

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            _model.onLeftKeyPress();
            break;
          case KeyEvent.VK_RIGHT:
            _model.onRightKeyPress();
            break;
          case KeyEvent.VK_UP:
            _model.onUpKeyPress();
            break;
          case KeyEvent.VK_DOWN:
            _model.onDownKeyPress();
            break;
          case KeyEvent.VK_SPACE:
            _model.onSpaceBarPress();
            break;
          default:
            break;
        }
      }
    });

  }

  public void start() {
    setVisible(true);
  }

}
