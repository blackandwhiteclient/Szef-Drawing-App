/*******************************************************************************
 *     Szef Paint App
 *     Copyright (C) 2017  MartonDev
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package tk.szef.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class SwingPaint {
 
  JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;
  DrawArea drawArea;
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      } else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }
    }
  };
 
  public static void main(String[] args) {
    new SwingPaint().show();
  }
 
  public void show() {
 
    JFrame frame = new JFrame("Széf Paint by Lederer Márton");
    Container content = frame.getContentPane();

    content.setLayout(new BorderLayout());
    
    drawArea = new DrawArea();
 
    content.add(drawArea, BorderLayout.CENTER);
 
    JPanel controls = new JPanel();
 
    clearBtn = new JButton("Töröl");
    clearBtn.addActionListener(actionListener);
    blackBtn = new JButton("Fekete");
    blackBtn.addActionListener(actionListener);
    blueBtn = new JButton("Kék");
    blueBtn.addActionListener(actionListener);
    greenBtn = new JButton("Zöld");
    greenBtn.addActionListener(actionListener);
    redBtn = new JButton("Piros");
    redBtn.addActionListener(actionListener);
    magentaBtn = new JButton("Lila");
    magentaBtn.addActionListener(actionListener);
 
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(clearBtn);
 

    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(600, 600);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setVisible(true);
    
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Paint.png")));
 
  }
 
}
