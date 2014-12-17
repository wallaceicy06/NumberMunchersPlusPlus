package com.seanharger.numbermunchers.application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Component;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JButton;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.IMunchersLevel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationView extends JFrame {

  private static final long serialVersionUID = 1902245636356481077L;

  private IApplicationViewToModelAdapter _model;

  private final JPanel _contentPane = new JPanel();
  private final JPanel _panelControls = new JPanel();
  private final JPanel _panelGameType = new JPanel();
  private final JLabel _lblGameType = new JLabel("Game type");
  private final JPanel _panelLevel = new JPanel();
  private final JLabel _lblLevel = new JLabel("Level");
  private final JComboBox<IMunchersGameType> _cmbBoxGameType = new JComboBox<IMunchersGameType>();
  private final JComboBox<IMunchersLevel> _cmbBoxLevel = new JComboBox<IMunchersLevel>();
  private final Component _horizontalStrut = Box.createHorizontalStrut(10);
  private final Component _horizontalStrut_1 = Box.createHorizontalStrut(20);
  private final JButton _btnPlay = new JButton("Play");

  public ApplicationView(IApplicationViewToModelAdapter model) {
    _model = model;
    initialize();
  }

  public void setSupportedGameTypes(List<IMunchersGameType> gameTypes) {
    _cmbBoxGameType.removeAllItems();
    for (IMunchersGameType g : gameTypes) {
      _cmbBoxGameType.addItem(g);
    }
  }

  public void start() {
    this.setVisible(true);
  }

  private void initialize() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    _contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(_contentPane);
    _contentPane.setLayout(new BorderLayout(0, 0));

    _contentPane.add(_panelControls, BorderLayout.SOUTH);

    _panelControls.add(_panelGameType);
    _panelGameType.setLayout(new BoxLayout(_panelGameType, BoxLayout.Y_AXIS));

    _lblGameType.setAlignmentX(Component.CENTER_ALIGNMENT);
    _panelGameType.add(_lblGameType);
    _cmbBoxGameType.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        _cmbBoxLevel.removeAllItems();

        if (_cmbBoxGameType.getSelectedItem() == null) {
          return;
        }

        for (IMunchersLevel l : _cmbBoxGameType.getItemAt(_cmbBoxGameType.getSelectedIndex())
            .getLevelOptions()) {
          _cmbBoxLevel.addItem(l);
        }

      }
    });

    _panelGameType.add(_cmbBoxGameType);

    _panelControls.add(_horizontalStrut);

    _panelControls.add(_panelLevel);
    _panelLevel.setLayout(new BoxLayout(_panelLevel, BoxLayout.Y_AXIS));

    _lblLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
    _panelLevel.add(_lblLevel);

    _panelLevel.add(_cmbBoxLevel);

    _panelControls.add(_horizontalStrut_1);

    _panelControls.add(_btnPlay);
  }

}
